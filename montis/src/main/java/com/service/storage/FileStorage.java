package com.service.storage;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileStorage {

	String persistFile(MultipartFile file) throws IOException;
}
