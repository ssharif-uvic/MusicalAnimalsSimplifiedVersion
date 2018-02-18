package com.sia.lib;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ToolsTest {

	private String searchFor = null;
	private String song1 = null, song2 = null, song3 = null;
	private final String repeatedSection = "cric-cric, brrah";
	private final String  song1part1 = "brr, fiu, ";  
	//private final String song3part1 = "bri-bri, plop, ";
	
	@Before
	public void before(){
		song1 =  song1part1 + repeatedSection; // "brr, fiu, cric-cric, brrah"
		//song2 = "pep, birip, trri-trri, croac";
		//song3 = song3part1 + repeatedSection;
	}
	
	@After
	public void after(){
		searchFor = null;
		song1 = null; 
		song2 = null; 
		song3 = null;
	}
	
	@Test
	public void testFindAndReturnTheRemainder_WordInTheMiddleOfPhrase() {
		searchFor = "fiu";
		String actual = Tools.FindAndReturnTheRemainder(searchFor, song1);
		String expected = "cric-cric, brrah";
		assertEquals("Did not find the word in the middle of the phrase.", 
														expected, actual);
	}
	
	@Test
	public void testFindAndReturnTheRemainder_WordNotInPhrase() {
		searchFor = "AAA";
		String actual = Tools.FindAndReturnTheRemainder(searchFor, song1);
		String expected = "";
		assertEquals("Found nonexistent word in phrase.", expected, actual);
	}
	
	@Test
	public void testFindAndReturnTheRemainder_WordAtTheBeginningOfPhrase() {
		searchFor = "brr";
		String actual = Tools.FindAndReturnTheRemainder(searchFor, song1);
		String expected = "fiu, cric-cric, brrah";
		assertEquals("Didn't find the word at the beginning of the phrase.", 
															expected, actual);
	}
	
	@Test
	public void testFindAndReturnTheRemainder_WordAtTheEndOfPhrase() {
		searchFor = "brrah";
		String actual = Tools.FindAndReturnTheRemainder(searchFor, song1);
		String expected = "";
		assertEquals("Didn't find the word at the end of the phrase", 
													expected, actual);
	}
	
	@Test
	public void testSplitSongIntoWords_WithNoWords() {
		String[] expected = {};
		 String[] actual = Tools.splitSongIntoWords("");
		assertArrayEquals("Split failed for phrase with no words.", 
																	expected, actual);
	}

	@Test
	public void testSplitSongIntoWords_WithOneWords() {
		String[] expected = { "brr"};
		 String[] actual = Tools.splitSongIntoWords("brr");
		assertArrayEquals("Split failed for phrase with one word.", 
																	expected, actual);
	}

	@Test
	public void testSplitSongIntoWords_WithMoreThankOneWords() {
		String[] expected = { "brr", "fiu", "cric-cric", "brrah"};
		 String[] actual = Tools.splitSongIntoWords(song1);
		assertArrayEquals("Split failed for phrase with more than one word.", 
																	expected, actual);
	}
}
