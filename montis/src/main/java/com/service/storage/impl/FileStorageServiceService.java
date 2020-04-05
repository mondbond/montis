package com.service.storage.impl;

import com.service.storage.dto.BookFileUploadMetadata;
import com.util.Constants;
import com.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class FileStorageServiceService implements com.service.storage.FileStorageService {

	@Autowired
	ServletContext context;

	public String persistFile(BookFileUploadMetadata bookFileUploadMetadata) throws IOException {

		String path = context.getRealPath("/");
		ensureStorageExist(path);

		persistFile(bookFileUploadMetadata, path);
		return null;
	}

	private void ensureStorageExist(String path){
		File storageDir = new File(path + "/" + Constants.STORAGE_FOLDER);
		storageDir.mkdir();
	}

	private void persistFile(BookFileUploadMetadata file, String path) throws IOException {
		byte[] bytes = file.getFile().getBytes();

		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(
				new File(path + "/" + Constants.STORAGE_FOLDER + "/" + FileUtil.generateFileName(file))));
		stream.write(bytes);
		stream.flush();
		stream.close();
	}
}
