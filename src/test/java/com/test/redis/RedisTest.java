package com.test.redis;

import com.fengyong.base.beans.page.QueryBean;
import com.fengyong.base.rely.ResultPoBean;
import com.fengyong.core.logic.LogicException;
import com.product.po.user.base.BaseSysUserPo;
import com.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 类描述:
 *
 * @author fengyong
 * @version 1.0
 * @since 1.0
 * Created by fengyong on 16/10/26 下午4:31.
 */
public class RedisTest extends BaseTest {
    @Autowired
    private RedisTemplate redisTemplate;



    @Test
    public void map(){
        HashOperations opsMap = redisTemplate.opsForHash();
        opsMap.put("userid_car","123",99);
        Map<String,Integer> m = opsMap.entries("userid_car");

        if(m==null){
            Map<String,Integer> map = new HashMap<String,Integer>();
            map.put("123",2);
            map.put("666",4);
            opsMap.putAll("userid_car",map);

            m = opsMap.entries("userid_car");

        }
        System.out.println(m);
    }

    @Test
    public void list(){
        ListOperations opsList = redisTemplate.opsForList();

    }

    @Test
    public void set(){
        SetOperations opsSet = redisTemplate.opsForSet();
    }
    @Test
    public void zset(){
        ZSetOperations opsZset = redisTemplate.opsForZSet();
        opsZset.add("zset","1_id",10);
        opsZset.add("zset","2_id",2);
        opsZset.add("zset","3_id",18);
        Set a = opsZset.range("zset", 0, 10);
        Set b = opsZset.reverseRange("zset",0,10);
        System.out.println(a);
    }



    /**
     * 测试查询缓存
     * @throws LogicException
     */
    @Test
    public void userServiceTest() throws LogicException {
        Map<String,String> map = new HashMap<String, String>();
        BaseSysUserPo baseSysUserPo = new BaseSysUserPo();
        baseSysUserPo.setEmail("qq@163.com");
        baseSysUserPo.setUserName("fengyongl");
    }

    /**
     * 测试查询
     * @throws LogicException
     */
    @Test
    public void queryUser() throws LogicException {
        QueryBean queryBean = new QueryBean();
        queryBean.addF("tableName","T_SYS_USER");
        queryBean.setPageNo(1);
        queryBean.setPageRows(1);
    }





    /**
     * 请用Redis和任意语言实现一段恶意登录保护的代码，限制1小时内每用户Id最多只能登录5次。
     * 具体登录函数或功能用空函数即可，不用详细写出
     */
    @Test
    public void loginTest(){
        Object countObj = redisTemplate.execute(new RedisCallback() {
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.incr("用户id".getBytes());
            }
        });
        int count = Integer.parseInt(countObj.toString());
        //expire:设置key的时间,第三个参数是时间的单位,这里设置为"秒"
        if(count == 1)
            redisTemplate.expire("用户id",30, TimeUnit.SECONDS);
        if(count <= 5)
            System.out.println("第"+count+"次登录"+"================登陆成功");
        else
            System.out.println("第"+count+"次登录"+"================超过五次");
    }

    @Test
    public void loginTest2(){
        Set t = redisTemplate.opsForZSet().range("用户id",0,5);
        
    }
}
