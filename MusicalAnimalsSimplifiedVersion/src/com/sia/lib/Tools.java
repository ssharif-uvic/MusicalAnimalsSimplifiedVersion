package com.sia.lib;

public class Tools {

	/**
	 * 
	 * @param song - The part of the song that we need to sing.
	 * 					Assumption: This is a CSV text.
	 * @return - An array of the words to sing.
	 */
	public static String[] splitSongIntoWords(String song){
		song = song.trim();
		if (song.equals(""))
			return new String[]{};
		return song.split(", ");
	}
	
	/**
	 * 
	 * @param searchFor - This is the word to search for;  
	 * 						The part of the song after this word will be song.
	 * @param searchIn - The whole song. We search in this text for the word 
	 * 						that we need to find and then sing the part of the 
	 * 						song that follows this word.
	 * @return - The remainder of the song, after the word, that we need to sing.
	 */
	public static String FindAndReturnTheRemainder(String searchFor, String searchIn){
		if (searchFor.equals(""))
			return "";
		int starts = searchIn.indexOf(searchFor);
		if (starts == -1)
			return "";
		StringBuilder searchInSB = new StringBuilder(searchIn);
		String remains = searchInSB.substring(starts + searchFor.length());
		remains = remains.trim();
		remains = removeLeadingCammaAndSpace(remains);

		return remains;
	}

	/**
	 * 
	 * @param remains - The text that may contain a leading comma
	 * 					 and possible white spaces on both sides.
	 * @return - The text without the leading comma and white space.
	 * 				Assumption is that our CVS tokens are separated 
	 * 				by command and white space(, ) or just a comma(,).
	 */
	private static String removeLeadingCammaAndSpace(String remains) {
		StringBuilder remainsSB = new StringBuilder(remains);
		if (remains.startsWith(", "))
			remains = remainsSB.delete(0, 2).toString();
		else if (remains.startsWith(","))
			remains = remainsSB.deleteCharAt(0).toString();
		
		return remains;
	}
	
	
}
