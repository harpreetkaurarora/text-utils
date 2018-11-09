package com.checker;

import org.apache.log4j.Logger;

import com.model.Word;

/**
 * <h1>LongestWordFinder</h1> LongestWordFinder class provides a utility method
 * to find the longest word and its length for a given sentence.
 * <p>
 *
 * @author Harpreet Kaur
 * @version 1.0
 * @since 2018-11-09
 */
public class LongestWordFinder {

	// Logger for the class
	static Logger logger = Logger.getLogger(LongestWordFinder.class);

	/**
	 * Main is to bootstrap the application.
	 * 
	 * @param This method takes in the input sentence as an argument and prints the
	 *             longest word and its length
	 */
	public static void main(String[] args) {
		Word largestWord = null;

		if (args == null || args.length == 0) {
			logger.error("Input Sentence not provided. Please provide a valid input");
			return;
		}

		largestWord = lengthChecker(args[0]);
		logger.info("largest word is  " + largestWord.getWord() + " and its length is " + largestWord.getLength());

	}

	/**
	 * This method is used to find the longest word and its length for a given input
	 * sentence.
	 * 
	 * @param inputSentence This is input sentence to be parsed by this method
	 * @return Word This returns the longest word in the input sentence
	 */

	public static Word lengthChecker(String inputSentence) {
		// initialize the local variables
		int size = 0;
		String largestWordStr = null;
		String mySentence = null;
		String[] words = null;
		Word largestWord = null;

		logger.debug("Input Sentence is :" + inputSentence);
		// Return null if the input is null
		mySentence = inputSentence;
		if (mySentence == null || mySentence == "")
			return largestWord;

		/*
		 * Parse the input sentence into individual words with /s(space) as the regular
		 * expression.
		 * 
		 */
		words = mySentence.split("\\s");

		// Iterate through individual words to find the largest word
		for (int i = 0; i < words.length; i++) {
			if (words[i].length() > size) {
				largestWordStr = words[i];
				size = words[i].length();
			}
		}
		logger.debug(("length is " + size));
		logger.debug(("largest word is " + largestWordStr));

		// Populate the model with the largest word
		largestWord = new Word(largestWordStr);

		// Return the largest word
		return largestWord;

	}

}
