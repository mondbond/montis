package com.service.textparser;

import com.service.textparser.dto.Paragraph;
import com.service.textparser.dto.TextSentence;
import com.service.textparser.dto.TextStructure;
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

		for (char c : sentenceChar) {
			if(c == ' '){
				result.add(TextWord.builder()
						.word(word.toString())
						.build());
				word = new StringBuilder();
			}

			else if(isSign(c)) {
				result.add(TextWord.builder().word(String.valueOf(c)).isWord(false).build());
			}

			else {
				word.append(c);
			}
		}

		return result;
	}

	private boolean isSign(char c){
		return (c == ',' || c == ':' || c==';');
	}
}
