package com.test.solr;

import org.junit.Test;

/**
 * Created by fengyong on 2017/1/14.
 */
public class AaTest {
    static int  j=0;
    public synchronized static int  getId(){
        return j++;
    }
    @Test
    public void asdf() {
        for (int i=0;i<100;i++){
            System.out.print(i);
        }
    }
}
