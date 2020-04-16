package com.service;

import com.dao.GeneralEntityManager;
import com.dao.dto.Definition;
import com.dao.dto.DefinitionIdentity;
import com.dao.dto.Word;
import com.dao.semapi.WordsApiDaoImpl;
import com.dao.semapi.dto.WordApiWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class WordService {

	@Autowired
	WordsApiDaoImpl wordsApiDao;

	@Autowired
	GeneralEntityManager<Word> entityManager;

	private Function<WordApiWord, Word> mapper = wordApiWord -> {
		ArrayList<Definition> definitions = new ArrayList<>();

		for(int i = 0; i <= wordApiWord.getDefinitions().size() -1; i++){
			definitions.add(new Definition(new DefinitionIdentity(wordApiWord.getWord(), i), wordApiWord.getDefinitions().get(i).getDefinition(), wordApiWord.getDefinitions().get(i).getPartOfSpeech()));
		}

		Word result = new Word();
		result.setDiversity(wordApiWord.getDiversity());
		result.setDoubleWord(false);
		result.setPerMillion(wordApiWord.getPerMillion());
		result.setWord(wordApiWord.getWord());
		result.setZipf(wordApiWord.getZipf());
		result.setDefinitions(definitions);

		return result;
	};


	public void persistWord(String word) throws IOException {
		System.out.println("Persisting word ==== " + word);
		try {
			WordApiWord wordToPersist = wordsApiDao.getWord(word);
			entityManager.save(mapper.apply(wordToPersist));
		} catch (Exception e) {
			System.out.println("Persisted word 0000 " + word + " not persisted: " + e.getMessage());
		}
	}

	public void persistWords(List<String> words) throws IOException {
		ArrayList<Word> wordsToPersist = new ArrayList<>();

		words.forEach(word -> {
			System.out.println(word + " download :");
			WordApiWord apiData = null;
			try {
				apiData = wordsApiDao.getWord(word);
			} catch (Exception e) {
				System.out.println(word + " NOT DOWNLOADED: " + e.getMessage());
			}

			if(apiData != null) {
				wordsToPersist.add(mapper.apply(apiData));
			}
		});

		entityManager.saveAll(wordsToPersist);
//		wordsToPersist.forEach(word -> entityManager.save(word));
	}
}
