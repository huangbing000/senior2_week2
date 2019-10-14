/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: StreamTest.java 
 * @Prject: huangbing-senior2-week2
 * @Package: com.huangbing.senior2.week2.test 
 * @Description: TODO
 * @author: lenovo   
 * @date: 2019年10月14日 上午8:59:38 
 * @version: V1.0   
 */
package com.huangbing.senior2.week2.test;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huangbing.common.utils.FileUtil;
import com.huangbing.common.utils.StreamUtil;
import com.huangbing.common.utils.StringUtil;
import com.huangbing.senior2.week2.domain.Goods;
import com.sun.tools.corba.se.idl.Comment;

/** 
 * @ClassName: StreamTest 
 * @Description: TODO
 * @author: lenovo
 * @date: 2019年10月14日 上午8:59:38  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class StreamTest {

	@Autowired
	RedisTemplate redisTemplate;
	
	@SuppressWarnings("unchecked")
	/**
	 * list存储goods
	 * @Title: test1 
	 * @Description: TODO
	 * @throws Exception
	 * @throws Exception
	 * @return: void
	 */
	@Test
	public void test1() throws Exception, Exception {
		List<String> readFile = StreamUtil.readFile(new FileInputStream("C:\\Users\\lenovo\\Desktop\\comment.txt"));
		List<Goods> list = new ArrayList<Goods>();
		for (String string : readFile) {
			Goods goods = new Goods();
			String[] split = string.split("==");
			//ID值要使用isNumber()工具方法判断是不是数字。
			if (StringUtil.isNumber(split[0].indexOf(split[0]))) {
				//商品名称要使用hasText()方法判断有没有值
				if (StringUtil.hasText(split[1])) {
					//价格要使用hasText()方法判断有没有值，并使用isNumber()判断是不是数字
					if (StringUtil.hasText(split[2])) {
						if (!StringUtil.isNumber(split[2])) {
							//然后去掉“¥”符号，再转成数字。
							String replace = split[2].replace("¥", "");
							BigDecimal price = new BigDecimal(replace);
							if (StringUtil.hasText(split[3])) {
								//然后去掉“%”符号，再转成数字。
								String replace2 = split[3].replace("%", "");
								BigDecimal bigDecimal = new BigDecimal(replace2);
								double bfb = bigDecimal.intValue()*0.01 ;
								goods = new Goods(split[0], split[1], price, bfb);
							}
						}
					}
				}
				
			}
			//存入list集合
			list.add(goods);
			//使用list存入redis数据库
			redisTemplate.opsForList().leftPush("goods_list", list);
//			List range = redisTemplate.opsForList().range("goods_list", 0, -1);
//			System.out.println(range);
		}
	}
	
	/**
	 * zSet存储goods
	 * @Title: test1 
	 * @Description: TODO
	 * @throws Exception
	 * @throws Exception
	 * @return: void
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void test2() throws Exception, Exception {
		List<String> readFile = StreamUtil.readFile(new FileInputStream("C:\\Users\\lenovo\\Desktop\\comment.txt"));
		Set<Goods> set = new HashSet<Goods>();
		for (String string : readFile) {
			Goods goods = new Goods();
			String[] split = string.split("==");
			//ID值要使用isNumber()工具方法判断是不是数字。
			if (StringUtil.isNumber(split[0].indexOf(split[0]))) {
				//商品名称要使用hasText()方法判断有没有值
				if (StringUtil.hasText(split[1])) {
					//价格要使用hasText()方法判断有没有值，并使用isNumber()判断是不是数字
					if (StringUtil.hasText(split[2])) {
						if (!StringUtil.isNumber(split[2])) {
							//。然后去掉“¥”符号，再转成数字。
							String replace = split[2].replace("¥", "");
							BigDecimal price = new BigDecimal(replace);
							if (StringUtil.hasText(split[3])) {
								//然后去掉“%”符号，再转成数字
								String replace2 = split[3].replace("%", "");
								BigDecimal bigDecimal = new BigDecimal(replace2);
								double bfb = bigDecimal.intValue()*0.01 ;
								//创建goods对象
								goods = new Goods(split[0], split[1], price, bfb);
							}
						}
					}
				}
				
			}
			//存入set集合
			set.add(goods);
			//使用zset存到redis数据库
			redisTemplate.opsForZSet().add("goods_zset", set, goods.getBfb());
//			List range = redisTemplate.opsForList().range("goods_list", 0, -1);
//			System.out.println(range);
		}
	}
}
