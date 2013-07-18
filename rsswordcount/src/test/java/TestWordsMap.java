import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
 *  json object maps to:
 *  HashMap output
 *  |_
 *  | HashMap wordsMap
 *  |                |_
 *  |                  Object wordCounter
 *  |                                   |_
 *  |                                   | property String word
 *  |                                   |_
 *  |_								      property Integer count
 *    Integer stopWordsIgnored
 */
public class TestWordsMap {

		String wordFoo;
		int countFoo;
		String wordBar;
		int countBar;
		int stopWordsIgnored;
		
	@Before
	public void setUp() throws Exception {
		wordFoo = "foo";
		countFoo = 1000;
		wordBar = "bar";
		countBar = 500;
		stopWordsIgnored = 10000;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testWordCounterGetters() {
		WordCounter wcFoo = new WordCounter();
		wcFoo.setWord(wordFoo);
		wcFoo.setCount(countFoo);
		
		// Test getWord
		String expectedFooWord = wordFoo;
		String actualFooWord = wcFoo.getWord();
		String fooWordMessage = "\ntestWordCounterGetters\nexpectedFooWord: " + expectedFooWord + " | actualFooWord: " + actualFooWord;
		System.out.println(fooWordMessage);
		Assert.assertEquals(fooWordMessage, expectedFooWord, actualFooWord);
		
		// Test getCount
		int expectedFooCount = countFoo;
		int actualFooCount = wcFoo.getCount();
		String fooCountMessage = "\ntestWordCounterGetters\nexpectedFooCount: " + expectedFooCount + " | actualFooCount: " + actualFooCount;
		System.out.println(fooCountMessage);
		Assert.assertEquals(fooCountMessage, expectedFooCount, actualFooCount);
		
		// Test getCount if none is set
		WordCounter wcNoCount = new WordCounter();
		wcNoCount.setWord("nocount");
		int expectedNoCount = 0;
		int actualNoCount = wcNoCount.getCount();
		String noCountMessage = "\ntestWordCounterGetters\nexpcetedNoCount: " + expectedNoCount + " | actualNoCount: " + actualNoCount;
		System.out.println(noCountMessage);
		Assert.assertEquals(noCountMessage, expectedNoCount, actualNoCount);
	}
	
	@Test
	public void testWordsMapGetters(){
		WordCounter wcFoo = new WordCounter();
		wcFoo.setWord(wordFoo);
		wcFoo.setCount(countFoo);
		
		WordsMap wm = new WordsMap();
		wm.addWordCounter(wcFoo);
		
		// Test on a word that we know we have
		int expectedFooCount = countFoo;
		int actualFooCount = wm.getCount(wordFoo);
		String fooCountMessage = "\ntestWordsMapGetters\nexpectedFooCount: " + expectedFooCount + " | actualFooCount: " + actualFooCount;
		System.out.println(fooCountMessage);
		Assert.assertEquals(fooCountMessage, expectedFooCount, actualFooCount);
		
		// Test on a word that I know we do NOT have
		int expectedMissingCount = 0;
		int actualMissingCount = wm.getCount("imnotarealword");
		String missingCountMessage = "\ntestWordsMapGetters\nexpectedMissingCount: " + expectedMissingCount + " | actualMissingCount: " + actualMissingCount;
		System.out.println(missingCountMessage);
		Assert.assertEquals(missingCountMessage, expectedMissingCount, actualMissingCount);
	}
	
	@Test
	public void testWordCounterIncrememt() {
		WordCounter wcFoo = new WordCounter();
		wcFoo.setWord(wordFoo);
		wcFoo.setCount(countFoo);
		
		int incrementReturn = wcFoo.increment();
		
		int expectedFooCount = countFoo + 1;
		int actualFooCount = wcFoo.getCount();
		String incrementCountMessage = "\ntestWordCounterIncrement\nexpectedFooCount: " + expectedFooCount + " | actualFooCount: " + actualFooCount + " | incrementReturn: " + incrementReturn;
		System.out.println(incrementCountMessage);
		Assert.assertEquals(incrementCountMessage, expectedFooCount, actualFooCount);
	}
	
	@Test
	public void testWordsMapIncrementCount(){
		WordCounter wcFoo = new WordCounter();
		wcFoo.setWord(wordFoo);
		wcFoo.setCount(countFoo);
		
		WordsMap wm = new WordsMap();
		wm.addWordCounter(wcFoo);

		// Test increment on a word that exists
		int incrementCountReturn = wm.incrementCount(wordFoo);
		
		int expectedFooCount = countFoo + 1;
		int actualFooCount = wcFoo.getCount();
		String incrementCountMessage = "\ntestWordsMapIncrementCount\nexpectedFooCount: " + expectedFooCount + " | actualFooCount: " + actualFooCount + " | incrementCountReturn: " + incrementCountReturn;
		System.out.println(incrementCountMessage);
		Assert.assertEquals(incrementCountMessage, expectedFooCount, actualFooCount);
		
		// Test increment on a word that does NOT exist
		int missingIncrementCountReturn = wm.incrementCount("imnotarealword"); // should be 0
		
		int expectedMissingIncrementCount = 0;
		int actualMissingIncrementCount = missingIncrementCountReturn;
		String missingIncrementCountMessage = "\ntestWordsMapIncrementCount\nexpectedMissingIncrementCount: " + expectedMissingIncrementCount + " | actualMissingIncrementCount: " + actualMissingIncrementCount + " | incrementCountReturn: " + missingIncrementCountReturn;
		System.out.println(missingIncrementCountMessage);
		Assert.assertEquals(missingIncrementCountMessage, expectedMissingIncrementCount, actualMissingIncrementCount);
	}
	
	

}

