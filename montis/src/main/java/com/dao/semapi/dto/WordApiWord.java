package com.dao.semapi.dto;

import com.dao.semapi.dto.definition.Definition;
import com.dao.semapi.dto.definition.WordMeaning;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.List;

@Getter
@Setter
@Builder
public class WordApiWord {


	private String word;
	private List<Definition> definitions;
	private double perMillion;
	private double diversity;
	private double zipf;
}
