import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 *  json object maps to:
 *  HashMap output
 *  |_
 *  | HashMap wordsMap
 *  |                |_
 *  |                  Object wordCounter
 *  |                                    |_
 *  |                                    | property String word
 *  |                                    |_
 *  |_                                     property Integer count
 *    Integer stopWordsIgnored
 */
public class TestJsonOutput {
	private String paragraph;

	@Before
	public void setUp() throws Exception {
		paragraph = "word1 word2 word2 word3 word3 word3 word4 word4 word4 word4 a an and";
		int stopWordsIgnored = 10000;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		WordsMap wm = new WordsMap();
		StringParser sp = new StringParser(wm);
		
		sp.setString(paragraph);
		sp.countWords();
		
		JsonOutput gson = new JsonOutput(wm);
		String json = gson.getJson();
		System.out.println(json);
	}

}
