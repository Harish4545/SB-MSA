package com.training.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@ResponseBody
	@RequestMapping(value = "/hello",method = RequestMethod.GET) //http://localhost:8080/SpringWebDemos/hello
	public String sayHello()
	{
		return "Spring Web App";
	}
			
	@RequestMapping("/") //http://localhost:8080/SpringWebDemos
	public String login()
	{
		return "index.jsp";
	}
	
	@RequestMapping("/home") //http://localhost:8080/SpringWebDemos
	public String home(@RequestParam("username")String username,@RequestParam("email")String email
			,ModelMap map)
	{
		map.addAttribute("username", username);
		map.addAttribute("email", email);
		return "home.jsp";
	}
	
}
