import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestStringParser {
	private String paragraph;

	@Before
	public void setUp() throws Exception {
		paragraph = "word1 word2 word2 word3 word3 word3 word4 word4 word4 word4 a an and";
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCountAllUniques() {
		WordsMap wm = new WordsMap();
		StringParser sp = new StringParser(wm);
		
		sp.setString(paragraph);
		sp.countWords();
		
		int expectedWord1Count = 1;
		int expectedWord4Count = 4;
		int actualWord1Count = wm.getCount("word1");
		int actualWord4Count = wm.getCount("word4");

		// Test count of word1 (1)
		String countWord1Message = "\ntestCountAllUniques\nexpectedWord1Count: " + expectedWord1Count + " | actualWord1Count: " + actualWord1Count;
		System.out.println(countWord1Message);
		Assert.assertEquals(countWord1Message, expectedWord1Count, actualWord1Count);
		
		// Test count of word4 (4)
		String countWord4Message = "\ntestCountAllUniques\nexpectedWord4Count: " + expectedWord4Count + " | actualWord4Count: " + actualWord4Count;
		System.out.println(countWord4Message);
		Assert.assertEquals(countWord4Message, expectedWord4Count, actualWord4Count);
		
		// Test count of imnotaword (0)
		int expectedNotCount = 0;
		int actualNotCount = wm.getCount("imnotaword");
		String countNotMessage = "\ntestCountAllUniques\nexpectedNotCount: " + expectedNotCount + " | actualNotCount: " + actualNotCount;
		System.out.println(countNotMessage);
		Assert.assertEquals(countNotMessage, expectedNotCount, actualNotCount);
		
		System.out.println("Size of wm: " + wm.size());
	}

}