package CoreJava;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Readfilename {
	
	public static void main(String args[]) {
        try (BufferedReader reader = new BufferedReader(new FileReader("example.txt"))) {
			String line;
			while((line = reader.readLine())!=null) {
				System.out.println(line);
			}
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
 
			
			System.out.println("An error occurred: "+e.getMessage());
			
			
			
			
		}
	}

}
