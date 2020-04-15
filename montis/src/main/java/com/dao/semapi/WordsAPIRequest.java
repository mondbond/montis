package com.dao.semapi;

import lombok.Getter;

@Getter
public enum WordsAPIRequest {
	DEFINITION("definitions"), FREQUENCY("frequency");

	public String request;

	WordsAPIRequest(String request){
		this.request = request;
	}
}
