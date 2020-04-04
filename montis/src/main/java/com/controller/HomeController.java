package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class HomeController {


	@RequestMapping(method = GET, value = "home")
	public String getHome(){
		return "home";
	}
}
