package com.dao.semapi;

import com.dao.semapi.dto.WordApiWord;
import com.dao.semapi.dto.definition.Definition;
import com.dao.semapi.dto.definition.WordMeaning;
import com.dao.semapi.dto.frequency.WordFrequency;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class WordsApiDaoImpl {

	private static final String BASE_URL = "https://wordsapiv1.p.rapidapi.com/words";
	private static final String KEY = "a0d102c08amsh2bdae0205506282p17e098jsne2b36cb0823d";

	private OkHttpClient client = new OkHttpClient();

//	move to enum class
	public static final String FREQUENCY_DATA_URL = "frequency";
	public static final String GENERAL = "";

	public WordApiWord getWord(String word) throws IOException {
//		todo: refactor with using several request. mby decorator pattern
		WordMeaning wordMeaning = getWordMeaning(word);
		WordFrequency wordFrequency = getWordFrequency(word);

		return WordApiWord.builder()
				.word(word)
				.definitions(wordMeaning.definitions)
				.diversity(wordFrequency.frequency.diversity)
				.perMillion(wordFrequency.frequency.perMillion)
				.zipf(wordFrequency.frequency.zipf)
				.build();
	}

	private WordMeaning getWordMeaning(String word) throws IOException {

		Request request = new Request.Builder()
				.url(BASE_URL + "/" + word + "/" + WordsAPIRequest.DEFINITION.getRequest())
				.get()
//				.addHeader("x-rapidapi-host", "wordsapiv1.p.rapidapi.com")
				.addHeader("x-rapidapi-key", KEY)
				.build();

		ObjectMapper objectMapper = new ObjectMapper();

		return objectMapper.readValue(client.newCall(request).execute().body().string(), WordMeaning.class);
	}

	private WordFrequency getWordFrequency(String word) throws IOException {
		Request request = new Request.Builder()
				.url(BASE_URL + "/" + word + "/" + WordsAPIRequest.FREQUENCY.getRequest())
				.get()
//				.addHeader("x-rapidapi-host", "wordsapiv1.p.rapidapi.com")
				.addHeader("x-rapidapi-key", KEY)
				.build();

		ObjectMapper objectMapper = new ObjectMapper();

		return objectMapper.readValue(client.newCall(request).execute().body().string(), WordFrequency.class);
	}
}
