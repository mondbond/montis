package com.dao.semapi;

public interface SemanticApiService {

	Word getWordByName(String name);

	Word getWordsByName(String[] names);
}
