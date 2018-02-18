package com.sia.animals;

import java.util.HashSet;

public interface AnimalSinger {


	/**
	 * 
	 * @return - The set of sounds that the animal makes.
	 */
	HashSet<String> getWordsInVocabulary();

	/**
	 * The animal is singing this word.
	 * The animal will sing this word.
	 * @param word - The word that the animal should sing.
	 */
	void singTheWord(String word);

	/**
	 * Checks to see if the incoming word is in the vocabulary of this animal. 
	 * @param word - The word to check.
	 * @return - Weather the word was found in the set of vocabulary words.
	 */
	boolean wordExistsInVocabulary(String word);

	/**
	 * The animal sees/reads the word.  The animal will only sing the word only 
	 * if it is in its vocabulary.
	 * @param word - The word that the animal sees/reads.
	 * @throws WordNotInVocabularyException 
	 */
	void readAndSing(String word) throws WordNotInVocabularyException;

}