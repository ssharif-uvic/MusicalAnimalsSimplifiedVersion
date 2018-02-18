package com.sia.animals;

import java.util.Arrays;
import java.util.HashSet;

public class Dragonfly implements AnimalSinger  {
	
	private final HashSet<String> WORDS_IN_VOCABULARY =  
				new HashSet<>(Arrays.asList("fiu", "plop", "pep"));
	
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
