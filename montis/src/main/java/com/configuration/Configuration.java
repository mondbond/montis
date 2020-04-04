package com.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartResolver;

@org.springframework.context.annotation.Configuration
public class Configuration {



	@Bean
	public MultipartResolver multipartResolver() {
		org.springframework.web.multipart.commons.CommonsMultipartResolver multipartResolver = new org.springframework.web.multipart.commons.CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(1000000);
		return multipartResolver;
	}

}
