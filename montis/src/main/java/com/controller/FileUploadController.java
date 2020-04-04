package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import javax.servlet.ServletContext;
import java.awt.*;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
public class FileUploadController {






	@RequestMapping(method = RequestMethod.POST, value = "uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String uploadFileView(@RequestParam MultipartFile file) throws IOException {


		return "file_process";
	}

	@RequestMapping(method = RequestMethod.POST, value = "uploadText")
	public String uploadFileView(@RequestParam("text") String text) {
		return "file_process";
	}

//	@RequestMapping(method = RequestMethod.POST, value = "/uploadFile")
//	public String uploadFile() {
//
//		return "Hello";
//	}


//	@Bean
//	public StandardServletMultipartResolver multipartResolver() {
//		return new StandardServletMultipartResolver();
//	}
}
