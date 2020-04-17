package com.service.textparser.dto;

import lombok.Builder;

import java.util.ArrayList;

@Builder
public class Paragraph {

	ArrayList<TextSentence> sentences = new ArrayList<>();

	public void appendSentence(TextSentence textSentence) {
		sentences.add(textSentence);
	}
}
