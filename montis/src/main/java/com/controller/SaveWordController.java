package com.controller;

import com.service.WordService;
import com.service.parser.CommaSeparetedParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

@Controller
public class SaveWordController {

	@Autowired
	WordService wordService;

//	@Autowired
//	HttpServletRequest request;

	@Autowired
	CommaSeparetedParser parser;

	@GetMapping(name = "saveWord")
	public String saveWord(){
		return "save_word";
	}

	@PostMapping(name = "saveWord", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String persistWordToDb(@RequestBody MultiValueMap<String, String> values, Model model) throws IOException {
		wordService.persistWords(parser.parse(Objects.requireNonNull(Objects.requireNonNull(values.getFirst("word")))));

//		model.addAttribute("saved", values.getFirst("word"));
		return "save_word";
	}
}
