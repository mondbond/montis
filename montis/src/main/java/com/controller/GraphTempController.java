package com.controller;

import com.service.TextAnalizerService;
import com.service.WriteImageType;
import com.service.textparser.TextAalizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletContext;

@Controller
public class GraphTempController {

	@Autowired
	WriteImageType writeImageType;

	@Autowired
	ServletContext context;

	@Autowired
	TextAalizer textAalizer;


	@Autowired
	TextAnalizerService textAnalizerService;

	@GetMapping(value = "draw")
	public void draw() throws Exception {
//		writeImageType.draw(textAnalizerService.process(), context.getRealPath("/"));
	}
}
