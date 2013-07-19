import java.io.InputStream;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestStopwords {
	String paragraph;
	@Before
	public void setUp() throws Exception {
		paragraph = "word1 word2 word2 word3 word3 word3 word4 word4 word4 word4 a an and are as at be but";
	}
	
	// Test method to read from file
	@Test
	public void testStopwordsInputFromFile() {
		StopWords sw = new StopWords();
		InputStream in = sw.inStopWords("stopwords.txt");
		Assert.assertTrue(in instanceof InputStream);
	}
		
	// Test method to populate ArrayList with strings
	@Test
	public void testStopwordsHas35Elements(){
		StopWords sw = new StopWords();
		ArrayList<String> swA = sw.getStopWords("stopwords.txt");
		Assert.assertEquals(35, sw.getStopWords("stopwords.txt").size());
		System.out.println(swA);
	}
	
	@Test
	public void testRemoveStopwordsFromWordsMap(){
		// Read in the stopwords file
		StopWords sw = new StopWords();
		sw.getStopWords("stopwords.txt");
		
		// Instantiate the WordsMap and parse String paragraph
		WordsMap wm = new WordsMap();
		StringParser sp = new StringParser(wm);
		sp.setString(paragraph);
		sp.countWords();
		
		int sizeWmBefore = wm.size();
		int countWord4 = wm.getCount("word4");
		int countAnBefore = wm.getCount("an");

		int countStopwords = sw.removeStopWords(wm);
		
		int sizeWmAfter = wm.size();
		int countAnAfter = wm.getCount("an");
		
		System.out.println("wm size (before): " + sizeWmBefore);
		System.out.println("wm size (after): " + sizeWmAfter);
		System.out.println("word4 count: " + countWord4);
		System.out.println("an count (before): " + countAnBefore);
		System.out.println("an count (after): " + countAnAfter);
		System.out.println("countStopwords: " + countStopwords);
		
		
	}
}
