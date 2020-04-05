package com.util;

import com.service.storage.dto.BookFileUploadMetadata;

public class FileUtil {

	private final static String SEPARATOR = "%!%";
	private final static String WINDOWS_SEPARATOR = "/";

	public static String generateFileName(BookFileUploadMetadata file){
		return file.getAuthorName()+ SEPARATOR + file.getAuthorSurName() + SEPARATOR + file.getAuthorBookName() + SEPARATOR + System.currentTimeMillis();
	}

	public static String[] parseFileNeme(String fileName){
		return fileName.split(SEPARATOR);
	}

	public static String getNameFromPath(String fullName) {
		String[] path = fullName.split(WINDOWS_SEPARATOR);
		return path[path.length-1];
	}
}
