package com.controller;

import com.dao.Word;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@Autowired
	SessionFactory sessionFactory;

	@GetMapping(value = "home")
	public String getHome(){
		return "menu";
	}
}
