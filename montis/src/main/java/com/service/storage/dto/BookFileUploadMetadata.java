package com.service.storage.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
public class BookFileUploadMetadata {


	private String authorName;
	private String authorSurName;
	private String authorBookName;
	private MultipartFile file;

}
