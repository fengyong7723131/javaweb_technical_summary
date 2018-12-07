package com.product.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 类描述:
 *
 * @author fengyong
 * @version 1.0
 * @since 1.0
 * Created by fengyong on 16/9/29 下午2:59.
 */
public class RedisCacheUtils<K, V> {
    @Autowired
    private RedisTemplate<K, V> redisTemplate;

    public boolean put(final K key, V value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<K, V> operations = redisTemplate
                    .opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean put(final K key, V value) {
        boolean result = false;
        try {
            ValueOperations<K, V> operations = redisTemplate
                    .opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    public V get(final K key) {
        V result = null;
        ValueOperations<K, V> operations = redisTemplate
                .opsForValue();
        result = operations.get(key);
        return result;
    }

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    public boolean exists(final K key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 删除对应的value
     *
     * @param key
     */
    public void remove(final K key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * 批量删除key
     *
     * @param pattern
     */
    public void removePattern(final K pattern) {
        Set<K> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0)
            redisTemplate.delete(keys);
    }

    /**
     * 批量删除对应的value
     *
     * @param keys
     */
    public void remove(final K... keys) {
        for (K key : keys) {
            remove(key);
        }
    }

    public boolean exists(final String key) {
        return (Boolean) redisTemplate.execute(new RedisCallback<Object>() {
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.exists(key.getBytes());
            }
        });
    }

    public boolean flush() {
        String result = (String) redisTemplate.execute(new RedisCallback<Object>() {
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                connection.flushDb();
                return "ok";
            }
        });
        return "ok".equals(result) ? true : false;
    }

    /**
     * 刷新缓存
     *
     * @param key
     *            关键字
     * @param value
     *            值
     */
    public boolean refresh (K key, V value) {
        if(exists((String)key)){
            remove(key);
            return put(key,value);
        }else{
            return put(key,value);
        }
    }

    public long getSize() {
        return (Long) redisTemplate.execute(new RedisCallback<Object>() {
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.dbSize();
            }
        });
    }

    public String ping() {
        return (String) redisTemplate.execute(new RedisCallback<Object>() {
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.ping();
            }
        });
    }

}
