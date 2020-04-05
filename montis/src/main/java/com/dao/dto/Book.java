package com.dao.dto;

import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	String id;

	String authorName;
	String authoeSurname;
	String bookName;

	@Type(type = "text")
	String text;


	public Book() {
	}

	public Book(String id, String authorName, String authoeSurname, String bookName, String text) {
		this.id = id;
		this.authorName = authorName;
		this.authoeSurname = authoeSurname;
		this.bookName = bookName;
		this.text = text;
	}
}
