package com.sia.animals;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CricketTest {

	public Cricket cricket1 = null;
	
	@Before
	public void initializeBeforeMethodCalls(){
		cricket1 = new Cricket();
	}
	
	@After
	public void teardownAfterMethodCalls(){
		cricket1 = null;
	}
	
	@Test
	public void testReadAndSing_WordInVocabulary() {
		String word = cricket1.getWordsInVocabulary().iterator().next();
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
		try {
			cricket1.readAndSing(word);
		} catch (WordNotInVocabularyException e) {
			fail("Exception should not have been thrown.");
		}
		String expected = "Cricket is singing: " + word + "\n";
		String actual = outContent.toString();
		assertEquals("Could not read and sing the word", expected, actual);
	}

	@Test
	public void testReadAndSing_WordNotInVocabulary() {
		boolean WordNotInVocabularyExceptionIsThrown = false;
		String word = "678";
		try {
			cricket1.readAndSing(word);
		} catch (WordNotInVocabularyException e) {
			WordNotInVocabularyExceptionIsThrown = true;
		}
		assertTrue("WordNotInVocabularyException should have been thrown.", 
										WordNotInVocabularyExceptionIsThrown);
	}
	
	@Test
	public void testSingTheWord() {
		String word = "AAA";
		String expected = "Cricket is singing: " + word + "\n";
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
		cricket1.singTheWord(word);
		String actual = outContent.toString();
		assertEquals("Could not sing the word", expected, actual);
	}

	@Test
	public void testWordExistsInVocabulary_ForWordThatIsInVocabulary() {
		String word = cricket1.getWordsInVocabulary().iterator().next();
		boolean actual = cricket1.wordExistsInVocabulary(word);
		assertTrue("Failed to recognize word that is in the vocabulary", actual);
	}

	@Test
	public void testWordExistsInVocabulary_ForWordThatIsNOTInVocabulary() {
		String word = "12345";
		boolean actual = cricket1.wordExistsInVocabulary(word);
		assertFalse("Recognized a word that is NOT in the vocabulary", actual);
	}
}
