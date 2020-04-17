package com.service.textparser;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class TextWord {

	private boolean doubleWord;
	private boolean isWord = true;
	private boolean isKnown;
	private String word;
	private String speechPart;
	private int length;

}
