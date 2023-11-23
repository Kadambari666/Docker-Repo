package CoreJava;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling {
	
	public static void main(String args[]) {
		try {
			 File file = new File("Example.txt");
			 
			 FileWriter writer = new FileWriter(file);
			 writer.write("Hello, File Handling in Java!");
			 writer.close();
			 
			 System.out.println("File created successfully.");
		}catch(IOException e) {
			System.out.println("Error: "+e.getMessage());
		}
		
		System.out.println("Press Enter to exit");
		new Scanner(System.in).nextLine();
	}

}
