package com.dao.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class DefinitionIdentity implements Serializable {

	@Column
	String word;

	@Column(name = "definition_order")
	int definitionOrder;

	public DefinitionIdentity() {}

	public DefinitionIdentity(String word, int definitionOrder) {
		this.word = word;
		this.definitionOrder = definitionOrder;
	}
}
