import java.util.HashMap;


public class WordsMap {
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
}
