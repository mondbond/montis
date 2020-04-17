package com.controller;

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

@Controller
public class AnalizeController {

	@Autowired
	TxtTextParser txtTextParser;
//
	@RequestMapping(value = "analize", method = RequestMethod.GET)
	public String getAnalizePage() {
		return "analize_text";
	}

	@PostMapping(value = "analize")
	public String analizeTxt(@RequestBody MultiValueMap<String, String> values) {
		TextStructure textStructure = txtTextParser.formStructure(values.getFirst("text"));
		return "analize_text";
	}
}
