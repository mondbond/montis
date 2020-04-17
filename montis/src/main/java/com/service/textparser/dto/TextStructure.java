package com.service.textparser.dto;

import lombok.Builder;

import java.util.ArrayList;

@Builder
public class TextStructure {

	ArrayList<Paragraph> paragraphs = new ArrayList<>();


	public void appendParagraph(Paragraph paragraph){
		paragraphs.add(paragraph);
	}
}
