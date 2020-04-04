package com.controller;

import com.dao.Word;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class HomeController {

	@Autowired
	SessionFactory sessionFactory;

	@GetMapping(value = "home")
	public String getHome(){

		Transaction transaction = sessionFactory.getCurrentSession().getTransaction();
		transaction.begin();
		sessionFactory.getCurrentSession().save(new Word(String.valueOf(System.currentTimeMillis()), "work"));
		transaction.commit();
		sessionFactory.getCurrentSession().close();

		return "menu";
	}
}
