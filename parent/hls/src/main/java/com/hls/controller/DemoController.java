package com.hls.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.lawyer.bean.user.DrMember;
import com.lawyer.service.user.UserService;
import com.taskmq.service.message.MessageSendService;

@Controller
public class DemoController {
	@Autowired
	private UserService userService;
	@Autowired
	private MessageSendService messageSendService;

	@RequestMapping("test")
	@ResponseBody
	public String test(){
		DrMember member= userService.test();
//		return "index";
		return JSON.toJSONString(member);
	}
	
	@RequestMapping("index")
	public String index(){
		DrMember member= userService.test();
		return "index";
	}
	
	@RequestMapping("mq")
	public String mq(String text){
		messageSendService.sendMessageText(text);
		return "index";
	}
	
	@RequestMapping("mqQueue")
	public String mqQueue(String queueName){
		System.out.println("start");
		String text="this is a text";
		messageSendService.sendMessage(queueName, text);
		return "index";
	}
}
