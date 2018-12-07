package com.test.redis;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

/**
 * 类描述:
 *
 * @author fengyong
 * @version 1.0
 * @since 1.0
 * Created by fengyong on 16/10/30 上午9:40.
 */
public class RedisCmdTest {

    @Test
    public void cmdStr6379() {
        String cmdStr6379 = "/Users/fengyong/Documents/usr/redis/Redis-Cluster/redis-server /Users/fengyong/Documents/usr/redis/Redis-Cluster/redis-3.2.4/redis.conf";
        try {
            String[] cmdA = {"/bin/sh", "-c", cmdStr6379};
            Process process = Runtime.getRuntime().exec(cmdA);
            printInfo(process);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void cmdStr7000() {
        String cmdStr7000 = "/Users/fengyong/Documents/usr/redis/Redis-Cluster/redis-server /Users/fengyong/Documents/usr/redis/Redis-Cluster/7000/redis.conf";
        try {
            String[] cmdA = {"/bin/sh", "-c", cmdStr7000};
            Process process = Runtime.getRuntime().exec(cmdA);
            printInfo(process);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void cmdStr7001() {
        String cmdStr7001 = "/Users/fengyong/Documents/usr/redis/Redis-Cluster/redis-server /Users/fengyong/Documents/usr/redis/Redis-Cluster/7001/redis.conf";
        try {
            String[] cmdA = {"/bin/sh", "-c", cmdStr7001};
            Process process = Runtime.getRuntime().exec(cmdA);
            printInfo(process);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void cmdStr7002() {
        String cmdStr7002 = "/Users/fengyong/Documents/usr/redis/Redis-Cluster/redis-server /Users/fengyong/Documents/usr/redis/Redis-Cluster/7002/redis.conf";
        try {
            String[] cmdA = {"/bin/sh", "-c", cmdStr7002};
            Process process = Runtime.getRuntime().exec(cmdA);
            printInfo(process);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void cmdStr7003() {
        String cmdStr7003 = "/Users/fengyong/Documents/usr/redis/Redis-Cluster/redis-server /Users/fengyong/Documents/usr/redis/Redis-Cluster/7003/redis.conf";
        try {
            String[] cmdA = {"/bin/sh", "-c", cmdStr7003};
            Process process = Runtime.getRuntime().exec(cmdA);
            printInfo(process);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void cmdStr7004() {
        String cmdStr7004 = "/Users/fengyong/Documents/usr/redis/Redis-Cluster/redis-server /Users/fengyong/Documents/usr/redis/Redis-Cluster/7004/redis.conf";
        try {
            String[] cmdA = {"/bin/sh", "-c", cmdStr7004};
            Process process = Runtime.getRuntime().exec(cmdA);
            printInfo(process);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void cmdStr7005() {
        String cmdStr7005 = "/Users/fengyong/Documents/usr/redis/Redis-Cluster/redis-server /Users/fengyong/Documents/usr/redis/Redis-Cluster/7005/redis.conf";
        try {
            String[] cmdA = {"/bin/sh", "-c", cmdStr7005};
            Process process = Runtime.getRuntime().exec(cmdA);
            printInfo(process);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void cmdStr7006() {
        String cmdStr7006 = "/Users/fengyong/Documents/usr/redis/Redis-Cluster/redis-server /Users/fengyong/Documents/usr/redis/Redis-Cluster/7006/redis.conf";
        try {
            String[] cmdA = {"/bin/sh", "-c", cmdStr7006};
            Process process = Runtime.getRuntime().exec(cmdA);
            printInfo(process);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void cmdStr7007() {
        String cmdStr7007 = "/Users/fengyong/Documents/usr/redis/Redis-Cluster/redis-server /Users/fengyong/Documents/usr/redis/Redis-Cluster/7007/redis.conf";
        try {
            String[] cmdA = {"/bin/sh", "-c", cmdStr7007};
            Process process = Runtime.getRuntime().exec(cmdA);
            printInfo(process);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    protected void printInfo(Process process) throws IOException {
        LineNumberReader br = new LineNumberReader(new InputStreamReader(
                process.getInputStream()));
        StringBuffer sb = new StringBuffer();
        String line;
        while ((line = br.readLine()) != null)   {
//                System.out.println(line);//打开之后输出所有的数据
            if (line.indexOf("Port") > 0)
                System.out.println("Port:" + line.split(":")[1]);
            if (line.indexOf("PID") > 0)
                System.out.println("PID:" + line.split(":")[1]);

            sb.append(line).append("\n");
        }
    }


}