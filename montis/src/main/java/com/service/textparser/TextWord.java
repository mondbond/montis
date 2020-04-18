package com.service.textparser;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class TextWord {

	private boolean doubleWord;
	private boolean isSeparatedSign;
	private boolean isKnown;
	private String word;
	private String speechPart;
	private int length;

}
