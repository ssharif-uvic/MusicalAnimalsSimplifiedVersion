package com.sia.animals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;

import com.sia.lib.Tools;

public class MainStart {
	private static final String repeatedSection = "cric-cric, brrah";
	private static final String  song1part1 = "brr, fiu, ";
	private static final String song3part1 = "bri-bri, plop, ";
	private static String song1 = song1part1 + repeatedSection;
	private static String song2 = "pep, birip, trri-trri, croac";
	private static String song3 = song3part1 + repeatedSection;
		

	public static void main(String[] args) {
		String searchFor1 = "fiu";
		String remainderOfThesong1 = Tools.FindAndReturnTheRemainder(searchFor1, song1);
		String[] wordsToBeSongByAnimals1 = Tools.splitSongIntoWords(remainderOfThesong1);

		String searchFor2 = "birip";
		String remainderOfThesong2 = Tools.FindAndReturnTheRemainder(searchFor2, song2);
		String[] wordsToBeSongByAnimals2 = Tools.splitSongIntoWords(remainderOfThesong2);

		String searchFor3 = "plop";
		String remainderOfThesong3 = Tools.FindAndReturnTheRemainder(searchFor3, song3);
		String[] wordsToBeSongByAnimals3 = Tools.splitSongIntoWords(remainderOfThesong3);
		
		String searchFor4 = "croac";
		String remainderOfThesong4 = Tools.FindAndReturnTheRemainder(searchFor4, song3);
		String[] wordsToBeSongByAnimals4 = Tools.splitSongIntoWords(remainderOfThesong4);
		
		String searchFor5 = "bri-bri";
		String remainderOfThesong5 = Tools.FindAndReturnTheRemainder(searchFor5, song3);
		String[] wordsToBeSongByAnimals5 = Tools.splitSongIntoWords(remainderOfThesong5);
		
		String searchFor6 = "";
		String remainderOfThesong6 = Tools.FindAndReturnTheRemainder(searchFor6, song3);
		String[] wordsToBeSongByAnimals6 = Tools.splitSongIntoWords(remainderOfThesong6);
		
		String searchFor7 = "ZZZZ";
		String remainderOfThesong7 = Tools.FindAndReturnTheRemainder(searchFor7, song3);
		String[] wordsToBeSongByAnimals7 = Tools.splitSongIntoWords(remainderOfThesong7);
		
		ArrayList<AnimalSinger> animalSingers =  new ArrayList<>();
		animalSingers.add(new Frog());
		animalSingers.add(new Cricket());
		animalSingers.add(new Dragonfly());
		
		System.out.println("Comprehensive demo run\nRun 1");
		animalsSingingWords(animalSingers, wordsToBeSongByAnimals1);
		
		System.out.println("Run 2");
		animalsSingingWords(animalSingers, wordsToBeSongByAnimals2);
		
		System.out.println("Run 3");
		animalsSingingWords(animalSingers, wordsToBeSongByAnimals3);
		
		System.out.println("Run 4");
		System.out.println("----Should not produce any output for run 4 ----");
		animalsSingingWords(animalSingers, wordsToBeSongByAnimals4);
		
		System.out.println("Run 5");
		animalsSingingWords(animalSingers, wordsToBeSongByAnimals5);
		
		System.out.println("Run 6");
		System.out.println("----Should not produce any output for run 6 ----");
		animalsSingingWords(animalSingers, wordsToBeSongByAnimals6);
		
		System.out.println("Run 7");
		System.out.println("----Should not produce any output for run 7 ----");
		animalsSingingWords(animalSingers, wordsToBeSongByAnimals7);
	}


	private static void animalsSingingWords(ArrayList<AnimalSinger> animalSingers,
			String[] wordsToBeSongByAnimals) {
		for(int i = 0; i < wordsToBeSongByAnimals.length; i++){
			for (AnimalSinger animalSinger : animalSingers) {
				try{
					animalSinger.readAndSing(wordsToBeSongByAnimals[i]);
				}catch(WordNotInVocabularyException e){
					//Do nothing. Animal sees the word but can't sing it,
					//so the animal simply ignores the word.
				}
			}
		}
	}

}
