package com.service.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStorageService implements FileStorage {

	@Autowired
	ServletContext context;

	public String persistFile(MultipartFile file) throws IOException {

		String path = context.getRealPath("/");

		byte[] bytes = file.getBytes();

		File storageDir = new File(path + "/storage");
		boolean dirCreated = storageDir.mkdir();

		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(
				new File(path + "/storage/" + file.getOriginalFilename())));
		stream.write(bytes);
		stream.flush();
		stream.close();

		return null;
	}
}
