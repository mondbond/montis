package com.service.parser;

import javafx.util.Pair;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CommaSeparetedParser implements Parser {

	@Override
	public List<String> parse(String text) {
		return Arrays.asList(text.split(","));
	}
}
