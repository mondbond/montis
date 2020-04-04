package com.dao;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Word {

	@Id
	public String Id;

	@Column
	public String word;

	public Word(String id, String word) {
		this.Id = id;
		this.word = word;
	}

	public Word() {
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
}
