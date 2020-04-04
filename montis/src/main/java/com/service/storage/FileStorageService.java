package com.service.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class FileStorageService implements FileStorage {

	private final static String STORAGE_FOLDER = "storage";

	@Autowired
	ServletContext context;

	public String persistFile(MultipartFile file) throws IOException {

		String path = context.getRealPath("/");
		ensureStorageExist(path);

		persistFile(file, path);
		return null;
	}

	private void ensureStorageExist(String path){
		File storageDir = new File(path + "/" + STORAGE_FOLDER);
		storageDir.mkdir();
	}

	private void persistFile(MultipartFile file, String path) throws IOException {
		byte[] bytes = file.getBytes();

		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(
				new File(path + "/" + STORAGE_FOLDER + "/" + file.getOriginalFilename())));
		stream.write(bytes);
		stream.flush();
		stream.close();
	}
}
