package com.dao.fileUpload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;


@Getter
@Setter
@AllArgsConstructor
public class BookFileMetadata {

	private final static String SEPARATOR = "%!%";

	private String authorName;
	private String authorSurName;
	private String authorBookName;
	private MultipartFile file;

	public String generateFileName() {
		return authorName + SEPARATOR + authorSurName + SEPARATOR + authorBookName + SEPARATOR + System.currentTimeMillis();
	}
}
