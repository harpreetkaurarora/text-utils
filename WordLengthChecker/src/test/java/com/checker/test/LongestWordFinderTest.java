package com.checker.test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.checker.LongestWordFinder;
import com.model.Word;

public class LongestWordFinderTest {

	static Logger logger = Logger.getLogger(LongestWordFinderTest.class);

	@Test(dataProvider = "provideInput")
	public void testLongestWord(String data, String expected) {
		int expectedLength = 0;
	    Word largestWord;
		
	    if (data != null && data.length() > 1) {
			expectedLength = expected.length();
			largestWord = LongestWordFinder.lengthChecker(data);
			Assert.assertTrue(expected.equals(largestWord.getWord()));
			Assert.assertTrue(expectedLength == largestWord.getLength());
		} else {
			largestWord = LongestWordFinder.lengthChecker(null);
			Assert.assertNull(largestWord);
		}

	}

	@DataProvider(name = "provideInput")
	public Object[][] getData() {
		return new Object[][] { { "This is Harpreet coding", "Harpreet" }, { "The fox jumped over the moon", "jumped" },
				{ "123hithere", "123hithere" }, { "", "" }, { "The sky is blue.", "blue." }, { null, null } };

	}
}
