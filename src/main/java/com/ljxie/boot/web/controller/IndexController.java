package com.ljxie.boot.web.controller;

import java.util.List;

import com.ljxie.boot.domain.model.User;
import com.ljxie.boot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	@Autowired
	private UserService userService;
	/**
	* @Title: tologin
	* @Description: 转到登录页面
	* @param @param model
	* @param @return
	* @return String
	* @throws
	*/
	@RequestMapping(value="/")
	public String tologin(Model model){
		return "redirect:login";
	}

	/**
	 * 登录首页
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/login")
	public String login(Model model){
		List<User> list=userService.findAllUser(1,2);
		model.addAttribute("user",list);
		return "login";
	}
}
