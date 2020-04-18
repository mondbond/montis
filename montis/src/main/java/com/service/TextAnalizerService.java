package com.service;

import com.service.textparser.TextAalizer;
import com.service.textparser.TxtTextParser;
import com.service.textparser.dto.TextStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TextAnalizerService {

	@Autowired
	TxtTextParser txtTextParser;


	@Autowired
	TextAalizer textAalizer;

	public TextStructure process(String text) {
		TextStructure textStructure = txtTextParser.formStructure(text);
		textAalizer.analizeStructure(textStructure);

		return textStructure;
	}
}
