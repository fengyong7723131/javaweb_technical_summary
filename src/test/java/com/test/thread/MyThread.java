package com.test.thread;

import java.util.Random;

/**
 * 类描述:
 *
 * @author fengyong
 * @version 1.0
 * @since 1.0
 * Created by fengyong on 16/11/25 上午10:46.
 */
public class MyThread extends Thread {
    SyncObject syncObject;

    MyThread(SyncObject syncObject){
        this.syncObject = syncObject;
    }

    public void run() {
        syncObject.print("b","bb");
    }

}
