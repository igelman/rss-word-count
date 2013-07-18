/*
 * 	WordCounter class represents innermost part of json output:
 *      {
 *          "word": "foo",
 *          "count": 1000
 *      }
 */
public class WordCounter {
	String word;
	int count;
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public String getWord() {
		return word;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public int getCount() {
		return count;
	}
	
	public int increment() {
		this.count++;
		return this.count;
	}
}
