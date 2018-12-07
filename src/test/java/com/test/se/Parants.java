package com.test.se;


import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 类描述:
 *
 * @author fengyong
 * @version 1.0
 * @since 1.0
 * Created by fengyong on 16/10/6 下午7:48.
 */
public class Parants implements Serializable{

    public  static String name="static";


    @Test
    public void printTest() {

        Parants m = new Parants();
        try {
            ObjectOutputStream o = new ObjectOutputStream(
                    new FileOutputStream("/Users/fengyong/Documents/usr/a.out"));
            o.writeObject(m);
            o.close();

            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream("/Users/fengyong/Documents/usr/a.out"));
            Parants logInfo = (Parants) in.readObject();
            System.out.println(logInfo.name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
