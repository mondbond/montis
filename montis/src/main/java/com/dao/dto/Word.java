package com.dao.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Setter
@Getter
//@Builder
@NoArgsConstructor
public class Word {

	@Id
	@Column
	String word;

	@Column
	double zipf;

	@Column
	double perMillion;

	@Column
	double diversity;

	@Column
	boolean doubleWord;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "speech_part_and_word",
		joinColumns = { @JoinColumn(name = "word") },
		inverseJoinColumns = { @JoinColumn(name = "name") })
	List<SpeechPart> speechParts;
}
