package com.test.hongbao;

/**
 * 类描述:
 *
 * @author fengyong
 * @version 1.0
 * @since 1.0
 * Created by fengyong on 16/12/8 下午4:14.
 */
public class DeadLockTest implements Runnable {

    private int flag;
    static Object o1 = new Object(), o2 = new Object();      //静态的对象，被DeadLockTest的所有实例对象所公用

    public void run() {

        System.out.println(flag);
        if (flag == 0) {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                }
            }
        }
        if (flag == 1) {
            synchronized (o2) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                }
            }
        }
    }

    public static void main(String[] args) {
        DeadLockTest test1 = new DeadLockTest();
        DeadLockTest test2 = new DeadLockTest();
        test1.flag = 1;
        test2.flag = 0;
        Thread thread1 = new Thread(test1);
        Thread thread2 = new Thread(test2);
        thread1.start();
        thread2.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println("22");
                }
            }
        }).start();
    }
}
