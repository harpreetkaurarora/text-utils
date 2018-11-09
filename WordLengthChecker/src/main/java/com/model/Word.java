package com.model;

public class Word {
	private final String word;
	private final int length;

	public String getWord() {
		return word;
	}

	public int getLength() {
		return length;
	}

	public Word(String largestWordStr) {
		word = largestWordStr;
		length = largestWordStr.length();
	}
}
