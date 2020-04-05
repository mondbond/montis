package com.service.storage;

import com.dao.GeneralEntityManager;
import com.dao.dto.Book;
import com.service.storage.dto.BookFileReadMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class TextService {

	@Autowired
	FileReaderService readerService;

	@Autowired
	GeneralEntityManager<Book> entityManager;

	private static Function<BookFileReadMetadata, Book> bookFileBookMapper = (book)->
			new Book(String.valueOf(System.currentTimeMillis()), book.getAuthorName(), book.getAuthorSurName(), book.getAuthorBookName(), book.getText());

	public void persistStorage(){
		entityManager.saveAll(readerService.readAll().stream().map(bookFileBookMapper).collect(Collectors.toList()));
	}
}
