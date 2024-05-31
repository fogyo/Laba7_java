package useful_staff;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.HashMap;

public class HashMapToJSON {
	
	
	public String writeFile(String key, String value) {
		String res = '"'+key+'"'+" "+":"+" "+'"'+value+'"'+"\n";
		return res;
		} 
	

}
	
