import static org.junit.Assert.*;

import org.junit.After;
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
		StringParser sp = new StringParser();
		fail("Not yet implemented");
	}

}
