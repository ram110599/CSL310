import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class p3 {
	public static void main(String []argv){
		ArrayList<String> FirstName = new ArrayList<String>();
		try{
			File file1 = new File("firstName.txt");
      		BufferedReader br = new BufferedReader(new FileReader(file1));
      		String fname = "A";
      		while((fname = br.readLine()) !=null){
      			FirstName.add(fname);
      			System.out.println(fname);
      		}		
		}
		catch(Exception e){
			e.printStackTrace();
		}
      
      System.out.println(FirstName.size());
	}
}