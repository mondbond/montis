package com.service.textparser.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
@Builder
public class Paragraph {

	ArrayList<TextSentence> sentences = new ArrayList<>();


	private int sentenceCount;
	private int sentenceAvgLength;
	private int paragraphLength;

	public void appendSentence(TextSentence textSentence) {
		sentences.add(textSentence);
	}
}
