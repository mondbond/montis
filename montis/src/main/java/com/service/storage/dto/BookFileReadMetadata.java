package com.service.storage.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookFileReadMetadata {

	private String authorName;
	private String authorSurName;
	private String authorBookName;
	private String text;
}
