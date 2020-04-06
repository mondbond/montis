package com.controller;

import com.service.storage.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProcessStorageController {

	@Autowired
	TextService textService;

	@RequestMapping(method = RequestMethod.GET, value = "processStorage")
	public String processStorage() {
		return "upload_file";
	}

	@RequestMapping(method = RequestMethod.GET, value = "persistAll")
	public String persistAllFilesFromStorage() {
		textService.persistStorage();
		return "upload_file";
	}
}
