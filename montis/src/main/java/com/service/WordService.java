package com.service;

import com.dao.GeneralEntityManager;
import com.dao.dto.SpeechPart;
import com.dao.dto.Word;
import com.dao.semapi.WordsApiDaoImpl;
import com.dao.semapi.dto.WordApiWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class WordService {

	@Autowired
	WordsApiDaoImpl wordsApiDao;

	@Autowired
	GeneralEntityManager<Word> entityManager;

	private Function<WordApiWord, Word> mapper = wordApiWord -> {
		Word result = new Word();
		result.setDiversity(wordApiWord.getDiversity());
		result.setDoubleWord(false);
		result.setPerMillion(wordApiWord.getPerMillion());
		result.setWord(wordApiWord.getWord());
		result.setZipf(wordApiWord.getZipf());
		result.setSpeechParts(wordApiWord.getPartOfSpeech().stream().map(SpeechPart::new).collect(Collectors.toList()));
//		return Word.builder()
//				.word(wordApiWord.getWord())
//				.diversity(wordApiWord.getDiversity())
//				.perMillion(wordApiWord.getPerMillion())
//				.zipf(wordApiWord.getZipf())
//				.doubleWord(false)
//				.speechParts(wordApiWord.getPartOfSpeech().stream().map(SpeechPart::new).collect(Collectors.toList()))
//				.build();

		return result;
	};


	public void persistWord(String word) throws IOException {
		WordApiWord wordToPersist = wordsApiDao.getWord(word);
		entityManager.save(mapper.apply(wordToPersist));
	}

	public void persistWords(List<String> words) throws IOException {
		words.forEach(word -> {
			WordApiWord wordToPersist = null;
			try {
				wordToPersist = wordsApiDao.getWord(word);
			} catch (IOException e) {
				e.printStackTrace();
			}
			entityManager.save(mapper.apply(wordToPersist));
		});

	}



}
