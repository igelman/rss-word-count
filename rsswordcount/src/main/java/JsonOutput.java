import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

// Converts Object obj to json.
// Based on demos at
//  http://www.mkyong.com/java/how-do-convert-java-object-to-from-json-format-gson-api/
//  http://www.mkyong.com/java/how-to-enable-pretty-print-json-output-gson/

public class JsonOutput {
	private Gson gson;
	private String json;
	
	// Constructor creates a new Gson from object obj
	JsonOutput(Object obj) {
		gson = new GsonBuilder().setPrettyPrinting().create();
		json = gson.toJson(obj);
	}
	
	public String getJson(){
		return json;
	}
}
