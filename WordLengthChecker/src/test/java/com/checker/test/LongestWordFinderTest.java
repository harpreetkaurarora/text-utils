package com.checker.test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.checker.LongestWordFinder;
import com.model.Word;

/**
 * <h1>LongestWordFinderTest</h1> LongestWordFinderTest  class tests
 * the LongestWordFinder class by providing valid and invalid inputs
 * <p>
 *
 * @author Harpreet Kaur
 * @version 1.0
 * @since 2018-11-09
 * 
 */

public class LongestWordFinderTest {
	// Logger for the class
	static Logger logger = Logger.getLogger(LongestWordFinderTest.class);

	/**
	 * This method is used to test the valid inputs
	 */
	@Test(dataProvider = "provideValidInput")
	public void testLongestWordWithValidInput(String inputValidSentenceStr, String expectedWordStr) {
		// Initialize local variables
		int expectedLength = 0;
		Word largestWord;

		expectedLength = expectedWordStr.length();
		largestWord = LongestWordFinder.lengthChecker(inputValidSentenceStr);
		Assert.assertTrue(expectedWordStr.equals(largestWord.getWord()));
		Assert.assertTrue(expectedLength == largestWord.getLength());
	}

	/**
	 * This method is used to test the invalid inputs
	 */
	@Test(dataProvider = "provideInvalidInput")
	public void testLongestWordWithInvalidInput(String invalidInputSentenceStr, String expectedWordStr) {
		// Intialize local variables
		Word largestWord;
		largestWord = LongestWordFinder.lengthChecker(invalidInputSentenceStr);
		Assert.assertNull(largestWord);
	}

	/**
	 * Data Provider for giving invalid input sentence. It is represented as a two dimensional array String. 
	 * First column in the array represents the invalid input String  
	 * Second Column in the array represents the expected value for match 
	 */
	@DataProvider(name = "provideInvalidInput")
	public Object[][] getInvalidData() {
		return new Object[][] { { null, null }, { "", "" } };

	}

	/**
	 * Data Provider for giving valid input sentence. It is represented as a two dimensional array String. 
	 * First column in the array represents the valid input String  
	 * Second Column in the array represents the expected value for match 
	 */
	@DataProvider(name = "provideValidInput")
	public Object[][] getValidData() {
		return new Object[][] { { "The fox jumped over the moon", "jumped" }, { "123hithere", "123hithere" },
				{ "The sky is blue.", "blue." }};
	}

}