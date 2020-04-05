package com.service.storage;

import com.service.storage.dto.BookFileReadMetadata;

import java.util.List;

public interface FileReaderService {

	List<BookFileReadMetadata> readAll();
}
