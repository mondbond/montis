package com.service.storage;

import com.dao.fileUpload.BookFileMetadata;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileStorage {

	String persistFile(BookFileMetadata file) throws IOException;
}
