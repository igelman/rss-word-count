
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
