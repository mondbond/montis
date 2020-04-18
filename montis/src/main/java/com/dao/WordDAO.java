package com.dao;

import com.dao.dto.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordDAO {

	@Autowired
	GeneralEntityManager<Word> entityManager;


	public Word findWordOrPersist(String word){
		return entityManager.getById(Word.class, word);
	}
}
