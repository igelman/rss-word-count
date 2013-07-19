import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;


public class StopWords {
	// Create arraylist of words from fileName
	ArrayList<String> sw;
	
	// Constructor
	public StopWords() {
		
	}
	
	public InputStream inStopWords(String fileName){
		// Create InputStream from local file filename
		return this.getClass().getClassLoader().getResourceAsStream(fileName);
	}
	
	public ArrayList<String> getStopWords(String fileName) {
		// Create ArrayList of words lists in filename
		sw = new ArrayList<String>();
		InputStream in = inStopWords(fileName); // Create InputStream from filename
		Scanner s = new Scanner(in); // Scan the stream word by word
		while (s.hasNext()) {
			sw.add(s.next());
		}
		s.close();
		return sw; // Return arrayList of stopwords
	}
	
	public int removeStopWords(WordsMap wm) {
		// Aggregate count of stopwords and remove stopwords WordCounters from WordsMap
		int counter = 0;
		for (String stopword: sw) {
			System.out.println("inside the for loop for " + stopword);
			System.out.println("count of " + stopword + ": " + wm.getCount(stopword));
			int count = wm.getCount(stopword);
			if (count > 0) {
				System.out.println("inside the if for " + stopword);
				counter += count;
				wm.remove(stopword);
			}
		}
		return counter;
		
	}
}
