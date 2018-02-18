package com.sia.animals;

public class WordNotInVocabularyException extends Exception {

	private static final long serialVersionUID = -3460532234556547787L;

	public WordNotInVocabularyException() {
		super();
	}
	
	public WordNotInVocabularyException(String message) {
		super(message);
	}
}
