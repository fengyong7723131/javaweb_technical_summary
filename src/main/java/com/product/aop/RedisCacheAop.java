package com.product.aop;

import com.fengyong.base.beans.Po;
import com.fengyong.base.beans.annotation.CacheKey;
import com.fengyong.base.beans.annotation.Cacheable;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.lang.annotation.Annotation;
import java.util.concurrent.TimeUnit;

/**
 * 类描述:
 *
 * @author fengyong
 * @version 1.0
 * @since 1.0
 * Created by fengyong on 16/10/1 上午8:48.
 */
public class RedisCacheAop {
    @Autowired
    private RedisTemplate redisTemplate;


    @Around("@annotation(cache)") // 可用配置代替pointcut="@annotation(cache))"
    public Object cached(final ProceedingJoinPoint pjp, Cacheable cache) throws Throwable {

        String key = getCacheKey(pjp, cache);
        ValueOperations<String, Object> valueOper = redisTemplate.opsForValue();
        Object value = valueOper.get(key);    //从缓存获取数据
        if (value != null) return value;       //如果有数据,则直接返回

        value = pjp.proceed();      //跳过缓存,到后端查询数据
        if (cache.expire() <= 0) {      //如果没有设置过期时间,则无限期缓存
            valueOper.set(key, value);
        } else {                    //否则设置缓存时间
            valueOper.set(key, value, cache.expire(), TimeUnit.SECONDS);
        }
        return value;
    }

    /**
     * 获取缓存的key值
     *
     * @param pjp
     * @param cache 注解
     * @return
     */
    private String getCacheKey(ProceedingJoinPoint pjp, Cacheable cache) throws Exception {

        StringBuilder buf = new StringBuilder();
        buf.append(pjp.getSignature().getDeclaringTypeName()).append(".").append(pjp.getSignature().getName());//获取包名,类名,方法名
        if (cache.key().length() > 0)
            buf.append(".").append(cache.key());//额外添加的key,,防止有重复的key

        Object[] args = pjp.getArgs();
        if (cache.keyMode() == Cacheable.KeyMode.CACHEKEY) {
            //Annotation[][] pas=((MethodSignature)pjp.getSignature()).getMethod().getParameterAnnotations(); //这里获取的可能是代理对象,所以拿不到注解对象
            Annotation[][] pas = pjp.getTarget().getClass().getMethod(pjp.getSignature().getName(),
                    ((MethodSignature) pjp.getSignature()).getParameterTypes()).getParameterAnnotations();
            for (int i = 0; i < pas.length; i++) {
                for (Annotation an : pas[i]) {
                    if (an instanceof CacheKey) {
                        getAllKey(buf, args[i]);
                        break;
                    }
                }
            }
        } else if (cache.keyMode() == Cacheable.KeyMode.BASIC) {
            for (Object arg : args)
                getBasicKey(buf, arg);
        } else if (cache.keyMode() == Cacheable.KeyMode.ALL) {
            for (Object arg : args)
                getAllKey(buf, arg);
        }
        return buf.toString();
    }

    /**
     * po实体类
     *
     * @param buf
     * @param arg
     * @throws IllegalAccessException
     */
    private void getAllKey(StringBuilder buf, Object arg) throws IllegalAccessException {
        if (arg instanceof Po)
            buf.append(".").append(((Po) arg).cacheString());
        else
            buf.append(".").append(arg.toString());
    }

    /**
     * 基本类型
     *
     * @param buf
     * @param arg
     */
    private void getBasicKey(StringBuilder buf, Object arg) {
        if (arg instanceof String) {
            buf.append(".").append(arg);
        } else if (arg instanceof Integer || arg instanceof Long || arg instanceof Short) {
            buf.append(".").append(arg.toString());
        } else if (arg instanceof Boolean) {
            buf.append(".").append(arg.toString());
        }
    }
}
