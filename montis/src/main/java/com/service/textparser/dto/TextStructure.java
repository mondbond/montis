package com.service.textparser.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;

@Getter
@Builder
public class TextStructure {

	ArrayList<Paragraph> paragraphs = new ArrayList<>();


	public void appendParagraph(Paragraph paragraph){
		paragraphs.add(paragraph);
	}
}
