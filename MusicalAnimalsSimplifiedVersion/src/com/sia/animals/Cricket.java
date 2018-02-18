package com.sia.animals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Cricket implements AnimalSinger{

	/**
	 * Assumption: From the requirements, it seems all cickets make 
	 * the same sounds and they can't learn or forget sounds.
	 */
	private final HashSet<String> WORDS_IN_VOCABULARY =  
			new HashSet<>(Arrays.asList("cric-cric", "trri-trri", "bri-bri"));
	
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
