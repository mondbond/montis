package com.service.storage.impl;

import com.service.storage.dto.BookFileReadMetadata;
import com.service.storage.FileReaderService;
import com.util.Constants;
import com.util.ConverterUtil;
import com.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FileReaderServiceImpl implements FileReaderService {

	@Autowired
	ServletContext context;


	public List<BookFileReadMetadata> readAll() {
		List<BookFileReadMetadata> result = null;
		Function<File,BookFileReadMetadata> fileBookReeadMapper = (File file) -> {
			String[] metadataNames = FileUtil.parseFileNeme(file.getName());

			String text = "";
			try {
				text = ConverterUtil.fileToString(file);
			} catch (IOException e) {
				e.printStackTrace();
			}

			return new BookFileReadMetadata(metadataNames[0], metadataNames[1], metadataNames[2], text);
		};


		try (Stream<Path> walk = Files.walk(Paths.get(context.getRealPath("/") + Constants.STORAGE_FOLDER))) {
			result = walk.filter(Files::isRegularFile)
					.map(Path::toFile)
					.map(fileBookReeadMapper)
					.filter((book) -> !book.getText().equals(""))
					.collect(Collectors.toList());
			result.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}




}
