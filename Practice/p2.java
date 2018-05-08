import java.util.*;
import java.util.ArrayList;

public class p2 {
	public static void main(String []argv){
		String str = "geekss@for@geekss";
        String [] arrOfStr = str.split("@");
 
        for (String a : arrOfStr)
            System.out.println(a);
	}
}
