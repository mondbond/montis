package com.controller;


import com.service.WordService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class HomeController {

//	@Autowired
//	SessionFactory sessionFactory;
//
	@Autowired
	HttpSession session;

//	@Autowired
//	WordsApiDaoImpl wordApi;

	@Autowired
	WordService wordService;

	@GetMapping(value = "home")
	public String getHome() throws IOException {
		session.setAttribute("name", "Ivan");
		return "menu";
	}
}
