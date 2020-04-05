package com.service.storage;

import com.service.storage.dto.BookFileUploadMetadata;
import java.io.IOException;

public interface FileStorageService {

	String persistFile(BookFileUploadMetadata file) throws IOException;
}
