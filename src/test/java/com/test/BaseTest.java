package com.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 类描述:测试父类
 *
 * @author fengyong
 * @version 1.0
 * @since 1.0
 * Created by fengyong on 16/7/27 下午1:42.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext-*.xml")
public class BaseTest{
}
