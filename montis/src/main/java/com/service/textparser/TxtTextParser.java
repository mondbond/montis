package com.service.textparser;

import com.service.textparser.dto.Paragraph;
import com.service.textparser.dto.TextSentence;
import com.service.textparser.dto.TextStructure;
import com.util.SemanticAPIUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TxtTextParser implements TextParser {

	@Override
	public TextStructure formStructure(String text) {
		TextStructure result = TextStructure.builder().paragraphs((ArrayList<Paragraph>) form(text)).build();

		return result;
	}

	private List<Paragraph> form(String text) {
		ArrayList<Paragraph> paragraphs = new ArrayList<>();
		paragraphs.add(Paragraph.builder().sentences((ArrayList<TextSentence>) formSentence(text)).build());
		return paragraphs;
	}

	private List<TextSentence> formSentence(String paragraph){
		ArrayList<TextSentence> result = new ArrayList<>();

		ArrayList<String> sentences = (ArrayList<String>) Stream.of(paragraph.split("\\.")).collect(Collectors.toList());
		sentences.forEach(sentence -> {
			result.add(TextSentence.builder()
					.words(formWords(sentence))
					.build());
		});

		return result;
	}

	private List<TextWord> formWords(String sentence){
		ArrayList<TextWord> result = new ArrayList<>();


		char[] sentenceChar = sentence.toCharArray();

		StringBuilder word = new StringBuilder();

		for (int c = 0; c <= sentenceChar.length -1; c++) {
			if(sentenceChar[c] == ' ' || c == sentenceChar.length -1) {
				result.add(TextWord.builder()
						.word(word.toString())
						.build());
				word = new StringBuilder();
			}

			else if(SemanticAPIUtil.isSeparatedSign(String.valueOf(sentenceChar[c]))) {
				result.add(TextWord.builder().word(String.valueOf(sentenceChar[c])).isSeparatedSign(false).build());
			}

			else {
				word.append(sentenceChar[c]);
			}
		}

		return result;
	}

}
