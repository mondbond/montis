package com.controller;

import com.service.storage.dto.BookFileUploadMetadata;
import com.service.storage.impl.FileStorageServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class FileUploadController {

	@Autowired
	FileStorageServiceService fileStorageService;

	@RequestMapping(method = RequestMethod.POST, value = "uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String uploadFileView(@RequestParam(value = "file") MultipartFile file,
	                             @RequestParam(value = "authorName") String authorName,
	                             @RequestParam(value = "authorSurName") String authorSurName,
	                             @RequestParam(value = "authorBookName") String authorBookName) throws IOException {

		fileStorageService.persistFile(new BookFileUploadMetadata(authorName, authorSurName, authorBookName, file));
		return "file_process";
	}

	@RequestMapping(method = RequestMethod.GET, value = "getUpload")
	public String uploadFileView() {
		return "upload_file";
	}
}
