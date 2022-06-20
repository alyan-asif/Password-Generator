
//Contributed by Rohail Rasheed
//Contributed by Alyan Asif
//Contributed by Aarish Ahmed
//Contributed by Hussain Shams

package Exchange;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class textTest {

	@Test
	void test() {
		GUI obj = new GUI();
		File myObj = new File("Password.txt");
		try {
		      FileWriter myWriter = new FileWriter("Password.txt");
		      myWriter.write("Successfully wrote to the file.");
		      myWriter.close();
		      
		      Scanner myReader = new Scanner(myObj);
		      String output = myReader.nextLine();
		      System.out.println(output);
		      
		      assertEquals("Successfully wrote to the file.", output);
		      
}
		      
		      
	 catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
				
		
		
	        }

}
