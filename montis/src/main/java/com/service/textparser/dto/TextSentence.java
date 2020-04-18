package com.service.textparser.dto;

import com.service.textparser.TextWord;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Builder
public class TextSentence {

	List<TextWord> words = new ArrayList<>();

	private int wordsCount;
	private String sentenceType;
	private int sentenceLength;
	private int avgWordLength;
	private int commaCount;


}
