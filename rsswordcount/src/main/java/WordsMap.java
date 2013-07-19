import java.util.HashMap;

/*
 * WordsMap represents lists of words and counts in json output:
 * [
 *      "foo": {
 *          "word": "foo",
 *          "count": 1000
 *      },
 *      "bar": {
 *          "word": "bar",
 *          "count": 500
 *      }
 *  ]
 *  
 *  Because the requirement excludes the key values ("foo" and "bar"),
 *   the output will use only the hashmap values.
 *  The values in the hashmap are objects of class WordCounter. 
 */

public class WordsMap extends HashMap<String, WordCounter> {
	HashMap<String, WordCounter> wm = new HashMap<String, WordCounter>();
	
	public void addWordCounter(WordCounter wc) {
		String wordKey = wc.getWord();
		wm.put(wordKey, wc);
	}
	
	public int getCount(String wordKey) {
		// Get the word's count.
		// If the word does not exist, return 0.
		int count = 0;
		if (wm.containsKey(wordKey)) {
			WordCounter wc = wm.get(wordKey);
			count = wc.getCount();
		}
		return count;
	}
	
	public int incrementCount(String wordKey) {
		// Increment the word's count.
		// If the word does not exist, return 0
		int newCount = 0;
		if (wm.containsKey(wordKey)) {
			WordCounter wc = wm.get(wordKey);
			newCount = wc.increment();
		}
		return newCount;
	}
	
	public boolean containsWord(String wordKey){
		boolean contains = false;
		if (wm.containsKey(wordKey)) {
			contains = true;
		}
		return contains;
	}
	
	public void removeWc(String wordKey) {
		System.out.println("called removeWc");
		if (this.containsWord(wordKey)) {
			System.out.println("removeWc() in the if this.containsKey for wordKey " + wordKey);
			this.remove(wordKey);
		}
	}
}
