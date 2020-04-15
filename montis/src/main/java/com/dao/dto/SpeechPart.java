package com.dao.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "speech_part")
public class SpeechPart {

	@Id
	@Column(name = "name")
	String name;

	public SpeechPart() {
	}

	public SpeechPart(String name) {
		this.name = name;
	}
}
