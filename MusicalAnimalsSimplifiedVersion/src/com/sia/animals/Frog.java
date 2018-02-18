package com.sia.animals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Frog implements AnimalSinger{

	/**
	 * Assumption: From the requirements, it seems all frogs make 
	 * the same sounds and they can't learn or forget sounds.
	 */
	private final HashSet<String> WORDS_IN_VOCABULARY =  
			new HashSet<>(Arrays.asList("brr", "birip", "brrah", "croac"));
	
	@Override
	public HashSet<String> getWordsInVocabulary() {
		return WORDS_IN_VOCABULARY;
	}
	
	@Override
	public void singTheWord(String word) {
		System.out.print(this.getClass().getSimpleName() + 
								" is singing: " + word + "\n");
	}

	@Override
	public boolean wordExistsInVocabulary(String word) {
		return WORDS_IN_VOCABULARY.contains(word);
	}

	@Override
	public void readAndSing(String word) throws WordNotInVocabularyException {
		if (!wordExistsInVocabulary(word))
			throw new WordNotInVocabularyException();
		singTheWord(word);
	}
}
