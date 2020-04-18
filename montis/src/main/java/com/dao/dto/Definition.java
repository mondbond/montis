package com.dao.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "definition")
@Entity
public class Definition {

	@EmbeddedId
	DefinitionIdentity id;

	@Column(name = "definition", columnDefinition = "VARCHAR(500)")
	String definition;

	@Column(name = "speech_part", columnDefinition = "VARCHAR(20)")
	String speechPart;

	public Definition() {
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "word", referencedColumnName = "word", insertable = false, updatable = false)
	com.dao.dto.Word definitionWord;

	public Definition(DefinitionIdentity id, String definition, String speechPart) {
		this.id = id;
		this.definition = definition;
		this.speechPart = speechPart;
	}
}
