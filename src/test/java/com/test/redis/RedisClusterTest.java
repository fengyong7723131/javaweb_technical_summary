package com.test.redis;

import com.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.JedisCluster;

/**
 * 类描述:
 *
 * @author fengyong
 * @version 1.0
 * @since 1.0
 * Created by fengyong on 16/10/29 下午9:00.
 */
public class RedisClusterTest extends BaseTest {
    @Autowired
    private JedisCluster jedisCluster;
    @Autowired
    private JedisCluster jedisCluster1;

    @Test
    public void cluster(){
        jedisCluster.set("foo", "bar");
        jedisCluster1.set("","");
        String value = jedisCluster.get("foo");
        System.out.println(value);
    }
}
