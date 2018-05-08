import java.util.*;
import java.util.Random;
import java.io.*;


public class P4 {

	public void fillStringArray(ArrayList<String> Abc, String fileName){
		try{
	      	File file1 = new File(fileName);
	      	BufferedReader br = new BufferedReader(new FileReader(file1));
	      	String fname;
	      	while((fname = br.readLine()) !=null){
	      		Abc.add(fname);
	      	}
      	}
      	catch(Exception e){
			e.printStackTrace();
		}
		//return Abc;
	} 

	public void fillIntegerArray(ArrayList<Integer> Abc, String fileName){
		try{
	      	File file1 = new File(fileName);
	      	BufferedReader br = new BufferedReader(new FileReader(file1));
	      	String fname;
	      	while((fname = br.readLine()) !=null){
	      		Abc.add(Integer.parseInt(fname));
	      	}
      	}
      	catch(Exception e){
			e.printStackTrace();
		}
		//return Abc;
	} 

	public static void main(String[] args){
		P4 test = new P4();
		ArrayList<String> MobileNumber = new ArrayList<>();
		String fileName = "mobileName.txt";
		ArrayList<Integer> Postal = new ArrayList<>();
		test.fillStringArray(MobileNumber,fileName);
		test.fillIntegerArray(Postal, "Postal.txt");
		for(Integer numbers : Postal){
			System.out.println(numbers);
		}
	}
}
