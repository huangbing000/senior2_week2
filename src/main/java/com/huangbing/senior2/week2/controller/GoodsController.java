/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: GoodsController.java 
 * @Prject: huangbing-senior2-week2
 * @Package: com.huangbing.senior2.week2.controller 
 * @Description: TODO
 * @author: lenovo   
 * @date: 2019年10月14日 上午10:29:22 
 * @version: V1.0   
 */
package com.huangbing.senior2.week2.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
 * @ClassName: GoodsController 
 * @Description: TODO
 * @author: lenovo
 * @date: 2019年10月14日 上午10:29:22  
 */

@Controller
public class GoodsController {

	@Autowired
	RedisTemplate redisTemplate;
	/**
	 * ;=list
	 * @Title: selestByList 
	 * @Description: TODO
	 * @param model
	 * @return
	 * @return: String
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("selectsByList")
	public String selestByList(Model model) {
		List list = redisTemplate.opsForList().range("goods_list", 0, -1);
		model.addAttribute("list",list);
		return "list";
	}
	/**
	 * zset
	 * @Title: selectsByZset 
	 * @Description: TODO
	 * @param model
	 * @return
	 * @return: String
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("selectByZset")
	public String selectsByZset(Model model) {
		Set set = redisTemplate.opsForZSet().rangeByScore("goods_zset", 0, -1);
		model.addAttribute("set",set);
		return "zset";
	}
}
