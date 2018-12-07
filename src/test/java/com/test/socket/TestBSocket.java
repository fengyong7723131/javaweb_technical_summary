package com.test.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.CountDownLatch;

/**
 * 类描述:
 *
 * @author fengyong
 * @version 1.0
 * @since 1.0
 * Created by fengyong on 16/11/30 上午9:42.
 */
public class TestBSocket {
    public void socketTest(){
        try {
            ServerSocket serverSocket = new ServerSocket(98);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
