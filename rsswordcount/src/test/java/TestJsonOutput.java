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

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
