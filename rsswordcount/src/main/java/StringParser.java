import java.util.Scanner;

public class StringParser {
	String paragraph;
	Scanner s;
	WordsMap wm;
	
	StringParser(WordsMap wm) {
		this.wm = wm;
	}
	
	public void setString(String paragraph){
		this.paragraph = paragraph;
	}
	
	public void countWords(){
		s = new Scanner(paragraph);
		while (s.hasNext()) {
			String currentWord = s.next();
			// increment or create WordCounter
			int currentCount = wm.getCount(currentWord);
			if (currentCount == 0) {
				// Create a new WordCounter for the new word (initializing count = 1)
				// Add the WordCounter to the WordsMap
				WordCounter wc = new WordCounter();
				wc.setWord(currentWord);
				wc.setCount(1);
				wm.addWordCounter(wc);
			} else {
				// If WordsMap already has the word,
				//  increment its count
				wm.incrementCount(currentWord);
			}
			
		}
		
	}
}
