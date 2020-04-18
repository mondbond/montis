package com.controller;

import com.service.TextAnalizerService;
import com.service.WriteImageType;
import com.service.textparser.TextAalizer;
import com.service.textparser.TxtTextParser;
import com.service.textparser.dto.TextStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletContext;

@Controller
public class AnalizeController {


	@Autowired
	WriteImageType writeImageType;

	@Autowired
	ServletContext context;

	@Autowired
	TextAalizer textAalizer;

	@Autowired
	TextAnalizerService textAnalizerService;
//
	@RequestMapping(value = "analize", method = RequestMethod.GET)
	public String getAnalizePage() {
		return "analize_text";
	}

	@PostMapping(value = "analize")
	public String analizeTxt(@RequestBody MultiValueMap<String, String> values) {
		writeImageType.draw(textAnalizerService.process(values.getFirst("text")), context.getRealPath("/"));

		return "analize_text";
	}
}