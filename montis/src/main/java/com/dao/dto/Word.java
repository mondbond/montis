package com.dao.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.pbkdf2.Strings;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

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

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "id.word", fetch = FetchType.EAGER)
	List<Definition> definitions;

	@Override
	public String toString() {
		return "Word{" +
				"word='" + word + '\'' +
				'}';
	}

	public String getSpeechPartOrNull() {
		if(definitions != null && definitions.get(0) != null){
			return StringUtils.isNotEmpty(definitions.get(0).getSpeechPart()) ? definitions.get(0).getSpeechPart() : null;
		}
		return null;
	}
}
