package com.service.textparser;

import com.dao.GeneralEntityManager;
import com.dao.WordDAO;
import com.dao.dto.Word;
import com.service.WordService;
import com.service.textparser.dto.Paragraph;
import com.service.textparser.dto.TextSentence;
import com.service.textparser.dto.TextStructure;
import com.util.SemanticAPIUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TextAalizer {

	@Autowired
	GeneralEntityManager<Word> entityManager;

	@Autowired
	WordService wordDAO;



	public void analizeStructure(TextStructure textStructure) {
		textStructure.getParagraphs().forEach(paragraph -> {
			paragraph.getSentences().forEach(sentence -> {
				sentence.getWords().forEach(word -> {
					processWord(word);
				});

				processSentence(sentence);
			});
			processParagraph(paragraph);
		});
	}

	private void processWord(TextWord word){
		if(SemanticAPIUtil.isSeparatedSign(word.getWord())) {
//			todo: rewrite comma logic
			word.setLength(word.getWord().length());
			word.setDoubleWord(false);
//		word.setSeparatedSign();

		} else {

			Word wordDb = wordDAO.findWordOrPersist(word.getWord());
			word.setLength(word.getWord().length());
			word.setDoubleWord(false);
//		word.setSeparatedSign();

			if (Objects.nonNull(wordDb)) {
				word.setSpeechPart(wordDb.getSpeechPartOrNull());
				word.setKnown(true);
			}
		}
	}

	private void processSentence(TextSentence sentence){
		sentence.setWordsCount(sentence.getWords().size());
		sentence.setSentenceLength(sentence.getWords().stream().map(word -> word.getLength()).reduce((l, r) -> l + r).get().intValue());
		sentence.setAvgWordLength(sentence.getSentenceLength()/sentence.getWordsCount());
		sentence.setCommaCount(((int) sentence.getWords().stream().filter(word -> !word.isSeparatedSign()).count()));
	}

	private void processParagraph(Paragraph paragraph){
		paragraph.setSentenceCount(paragraph.getSentences().size());
		paragraph.setSentenceAvgLength(paragraph.getSentences().stream().map(sentence -> sentence.getWordsCount()).reduce((l, r) -> l + r).get()/paragraph.getSentences().size());
		paragraph.setParagraphLength(paragraph.getSentences().stream().map(sentence -> sentence.getSentenceLength()).reduce((l, r) -> l + r).get());
	}
}
