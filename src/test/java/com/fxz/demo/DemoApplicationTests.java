package com.fxz.demo;

import com.fxz.demo.dao.redis.RedisDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	public static Logger logger= LoggerFactory.getLogger(DemoApplicationTests.class);
	@Test
	public void contextLoads() {
	}

	@Autowired
	RedisDao redisDao;
	@Test
	public void testRedis(){
		redisDao.set("name","forezp");
		redisDao.set("age","11");
		logger.info(redisDao.get("name"));
		logger.info(redisDao.get("age"));
	}

}
