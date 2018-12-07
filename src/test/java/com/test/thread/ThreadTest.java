package com.test.thread;

import org.junit.Test;

/**
 * 类描述:
 *
 * @author fengyong
 * @version 1.0
 * @since 1.0
 * Created by fengyong on 16/11/24 下午4:00.
 */
public class ThreadTest {

    @Test
    public void threadDemo()  throws Exception{
        SyncObject syncObject = new SyncObject();
        MyThread myThread = new MyThread(syncObject);
        myThread.start();
        myThread.stop();
        System.out.println(syncObject.getName()+":"+syncObject.getPassword());

    }

    public void t(){
        MyThread myThread = new MyThread(null);
        Thread t1 = new Thread(myThread,"A");
        Thread t2 = new Thread(myThread,"B");
        Thread t3 = new Thread(myThread,"C");
        Thread t4 = new Thread(myThread,"D");
        Thread t5 = new Thread(myThread,"E");
        Thread t6 = new Thread(myThread,"F");
        Thread t7 = new Thread(myThread,"G");
        Thread t8 = new Thread(myThread,"H");
        Thread t9 = new Thread(myThread,"I");
        Thread t10 = new Thread(myThread,"J");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();

    }
}
