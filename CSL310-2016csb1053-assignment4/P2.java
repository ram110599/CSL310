import java.util.Scanner;
import java.io.Console;
import java.io.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.*;
import java.util.Random;
import java.util.List;

public class P2	{
	public static void main(String[] args) {
		
		try {
        // Using Console so as to take password as input from console safely i.e. without showing
        Console console = System.console();
        if (console == null) {
            System.out.println("Couldn't get Console instance");
            System.exit(0);
        }

      //URL given through command line
      String url = args[0];

      //Using Scanner class for console input
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter DB user name ");
      String user = sc.nextLine();

      //Using console.readPassword for hiding password on the screen while typing
      char passwordArray[] = console.readPassword("Enter your secret DB password: ");
      
      //Converting passwordArray to string value password
      String password = String.valueOf(passwordArray);

      // For establishing connection 
      Connection conn = DriverManager.getConnection(url, user, password);
      System.out.println("Connection Established.");

      //For storing cityName
      ArrayList<String> cityName = new ArrayList<String>();

      //Storing data in the arraylist via file reading and writing
      try{
      	File file1 = new File("cityName.txt");
      	BufferedReader br = new BufferedReader(new FileReader(file1));
      	String fname = "A";
      	while((fname = br.readLine()) !=null){
      		cityName.add(fname);
      	}
      }
      catch(Exception e){
			e.printStackTrace();
		}

      //For storing the length of the arraylist of city
      int cityLength = cityName.size();

      //For storing State Name
      ArrayList<String> stateName = new ArrayList<String>();

      //Storing some state name
      stateName.add("Punjab");
      stateName.add("Bihar");
      stateName.add("Haryana");
      stateName.add("Delhi");
      stateName.add("Himachal Pradesh");
      stateName.add("Sikkim");
      stateName.add("Jammu and Kasmir");
      stateName.add("Tripura");

      //For storing the length of the arraylist of state name
      int stateLength = stateName.size();

      //For storing Country Name
      ArrayList<String> CountryName = new ArrayList<String>();
      
      //Storing some sample country name 
      CountryName.add("India");
      CountryName.add("France");
      CountryName.add("Russia");
      CountryName.add("Australia");
      CountryName.add("America");

      //For storing the length of the arraylsit Country
      int countryLength = CountryName.size();

      //For storing street address
      ArrayList<String> StreetName = new ArrayList<String>();
      for(int i=1000;i<2000;i++){
      	String a = "abc" + i;
      	StreetName.add(a);
      }

      //For storing the length of the array list Street
      int streetLength = StreetName.size();

      //For storing postal address
      ArrayList<Integer> Postal = new ArrayList<Integer>();
      for(int i=110011;i<110111;i++){
      		Postal.add(i);
      }
      //Storing length of the postal
      int postalLength = Postal.size();

      //for storing phone Number
      ArrayList<Long> PhoneNumber = new ArrayList<Long>();
      for(long i1=11241109341L;i1<11241109441L;i1++){
      	PhoneNumber.add(i1);
      }

      //Storing the length of the phoneNumber array
      int phoneLength = PhoneNumber.size();

      //For storing mobile number via looping
      ArrayList<Long> MobileNumber = new ArrayList<Long>();
      for(long i2=9471809341L;i2<9471809441L;i2++){
      	MobileNumber.add(i2);
      }
      //System.out.println("The size of mobile number is " + MobileNumber.size());
      //Storing the length of the mobile number
      int mobileLength = MobileNumber.size();

      //For storing email
      ArrayList<String> EmailId = new ArrayList<String>();
      for(int i=123345;i<123445;i++){
      	String a = "abhi"+ i + "@gmail.com";
      	EmailId.add(a);
      }

      int emailLength = EmailId.size();

      //For storing panNumber
      ArrayList<String> PanNum = new ArrayList<String>();
      for(int i=10000;i<20000;i++){
      	String a = "ABC"+ i + "BD";
      	PanNum.add(a);
      }

      int panLength = PanNum.size();

      //For storing first Name
      ArrayList<String> FirstName = new ArrayList<String>();
      try{
      	File file1 = new File("firstName.txt");
      	BufferedReader br = new BufferedReader(new FileReader(file1));
      	String fname = "A";
      	while((fname = br.readLine()) !=null){
      		FirstName.add(fname);
      	}
      }
      catch(Exception e){
			e.printStackTrace();
		}
      

      int firstLength = FirstName.size();
      //For storing Last Name
      ArrayList<String> LastName = new ArrayList<String>();
      try{
      	File file2 = new File("lastName.txt");
      	BufferedReader br = new BufferedReader(new FileReader(file2));
      	String fname = "X";
      	while((fname = br.readLine()) !=null){
      		LastName.add(fname);
      	}
      }
      catch(Exception e){
			e.printStackTrace();
		}

      int lastLength = LastName.size();

      //For storing date of birth
      ArrayList<String> DoB = new ArrayList<String>();
      for(int i=1;i<25;i++){
      	for(int j = 1950;j<1980;j++){
      		String a1 = String.valueOf(j);			//Converted into strings
      		String a20 = "01";
      		String a21 = "02";
      		String a22 = "03";
      		String a23 = "04";
      		String a24 = "05";
      		String a25 = "06";
      		String a26 = "07";
      		String a3 = "01";
      		if(i>9){								//Converted into String such that it fulfills the date format of sql
      			a3 = String.valueOf(i);
      		}
      		else{
      			a3 = "0" + String.valueOf(i);
      		}
      		
      		String dob1 = a1 + a20 + a3;
      		String dob2 = a1 + a21 + a3;
      		String dob3 = a1 + a22 + a3;
      		String dob4 = a1 + a23 + a3;
      		String dob5 = a1 + a24 + a3;
      		String dob6 = a1 + a25 + a3;
      		String dob7 = a1 + a26 + a3;
      		DoB.add(dob1);
      		DoB.add(dob2);
      		DoB.add(dob3);
      		DoB.add(dob4);
      		DoB.add(dob5);
      		DoB.add(dob6);
      		DoB.add(dob7);
      	}
      }

      int dobLength = DoB.size();

      //Storing random opening date such that it fullfills the date format of sql
      ArrayList<String> OpeningDate = new ArrayList<String>();
      for(int i=1;i<18;i++){
      	for(int j = 1990;j<2000;j++){
      		String a1 = String.valueOf(j);
      		String a20 = "01";
      		String a21 = "02";
      		String a22 = "03";
      		String a23 = "04";
      		String a24 = "05";
      		String a25 = "06";
      		String a26 = "07";
      		String a3 ="01";
      		if(i>=10){
      			a3 = String.valueOf(i);	
      		} 
      		else{
      			a3 = "0" + String.valueOf(i);
      		}
      		
      		String dob1 = a1 + "-" + a20 + "-" + a3;
      		String dob2 = a1 + "-" + a21 + "-" + a3;
      		String dob3 = a1 + "-" + a22 + "-" + a3;
      		String dob4 = a1 + "-" + a23 + "-" + a3;
      		String dob5 = a1 + "-" + a24 + "-" + a3;
      		String dob6 = a1 + "-" + a25 + "-" + a3;
      		String dob7 = a1 + "-" + a26 + "-" + a3;
      		OpeningDate.add(dob1);
      		OpeningDate.add(dob2);
      		OpeningDate.add(dob3);
      		OpeningDate.add(dob4);
      		OpeningDate.add(dob5);
      		OpeningDate.add(dob6);
      		OpeningDate.add(dob7);
      	}
      }

      int openingLength = OpeningDate.size();

      //For storing closing date of the bank account
      ArrayList<String> ClosingDate = new ArrayList<String>();
      for(int i=1;i<18;i++){
      	for(int j = 2001;j<2017;j++){
      		String a1 = String.valueOf(j);
      		String a20 = "01";
      		String a21 = "02";
      		String a22 = "03";
      		String a23 = "04";
      		String a24 = "05";
      		String a25 = "06";
      		String a26 = "07";
      		String a3 ="01";
      		if(i>=10){
      			a3 = String.valueOf(i);	
      		} 
      		else{
      			a3 = "0" + String.valueOf(i);
      		}
      		
      		String dob1 = a1 + "-" + a20 + "-" + a3;
      		String dob2 = a1 + "-" + a21 + "-" + a3;
      		String dob3 = a1 + "-" + a22 + "-" + a3;
      		String dob4 = a1 + "-" + a23 + "-" + a3;
      		String dob5 = a1 + "-" + a24 + "-" + a3;
      		String dob6 = a1 + "-" + a25 + "-" + a3;
      		String dob7 = a1 + "-" + a26 + "-" + a3;
      		ClosingDate.add(dob1);
      		ClosingDate.add(dob2);
      		ClosingDate.add(dob3);
      		ClosingDate.add(dob4);
      		ClosingDate.add(dob5);
      		ClosingDate.add(dob6);
      		ClosingDate.add(dob7);
      	}
      }
      	int closingLength = ClosingDate.size();

      	//For storing status of the account whether active or dormant
      	ArrayList<String> Status = new ArrayList<String>();
      	Status.add("Active");
      	Status.add("Dormant");

      	int statusLength = Status.size();
      //For storing account type of the bank
      	ArrayList<String> AccountType = new ArrayList<String>();
      	AccountType.add("Saving");
      	AccountType.add("Current");
      	AccountType.add("Fixed Deposit");

      	int accountLength = AccountType.size();

      //For storing transaction Type
      	ArrayList<String> TransactionType = new ArrayList<String>();
      	TransactionType.add("Credit");
      	TransactionType.add("Debit");

      	int transactionLength = TransactionType.size();
      
      	//For storing Category
      	ArrayList<String> Category = new ArrayList<String>();
      	Category.add("Tax");
      	Category.add("Salary");
      	Category.add("Grocery");
      	Category.add("Medical");
      	Category.add("Phone Bill");
      	Category.add("Dining");
      	Category.add("Entertainment");
      	Category.add("Money Transfer");

      	int categoryLength = Category.size();
      	
      	//For storing remarks
      	ArrayList<String> Remarks = new ArrayList<String>();
      	for(int i = 232211;i<233211;i++){
      		String a = "I am happy with transaction " + i + ".";
      		Remarks.add(a);
      	}

      	int remarksLength = Remarks.size();
      	//System.out.println("The size of the remark is " + Remarks.size());

      	//Variable for checking which mode is used whether insertion or querying
      	String mode = args[1];
      	
      	//Variable declared for unique panNumber handaling
      	int pan_id = 0;

		//Now for inserting data in database i.e. -i
      	if(mode.equals("-i")){
      		System.out.println("Inserting Data in database.");
      		for(int i=0;i<50;i++){
      			Random rand = new Random();
      			
      			//For storing contact details
      			String street_address = StreetName.get(rand.nextInt(streetLength));
      			String city = cityName.get(rand.nextInt(cityLength));
      			String state = stateName.get(rand.nextInt(stateLength));
      			String country = CountryName.get(rand.nextInt(countryLength));
      			int pincode = Postal.get(rand.nextInt(postalLength));
      			long phone = PhoneNumber.get(rand.nextInt(phoneLength));
      			long mobile1 = MobileNumber.get(rand.nextInt(mobileLength));
      			String email12 = EmailId.get(rand.nextInt(emailLength));
      			//Contact Primary Key
      			int conPK = setContactData(conn, street_address, city, state, country, pincode, phone, mobile1, email12);
      			//System.out.println("The contact primary key is " + conPK);


      			//For storing account part
      			String panNumber = PanNum.get(pan_id);
      			pan_id++;								//Incrementing pan_id so that it stores unique pan number
      			String firstName = FirstName.get(rand.nextInt(firstLength));
      			String lastName = LastName.get(rand.nextInt(lastLength));
      			String dob = DoB.get(rand.nextInt(dobLength));
      			//Person primary key
      			int perPK = setAccountData(conn, panNumber, firstName, lastName, dob, conPK);


      			//For storing bank account
      			String opening_date = OpeningDate.get(rand.nextInt(openingLength));
      			String closing_date = ClosingDate.get(rand.nextInt(closingLength));
      			String status = Status.get(rand.nextInt(statusLength));
      			String account_type = AccountType.get(rand.nextInt(accountLength));
      			double maxBalance = 10000000.00;
      			double current_balance = maxBalance*(rand.nextDouble());
      			//String last_transaction = Have to add
      			int accPK = setBankAccount(conn, opening_date, closing_date, status, perPK, account_type, current_balance);

      			//For storing transaction
      		}
      		for(int i=0;i<30;i++){
      			Random rand = new Random();
      			
      			//For storing contact details
      			String street_address = StreetName.get(rand.nextInt(streetLength));
      			String city = cityName.get(rand.nextInt(cityLength));
      			String state = stateName.get(rand.nextInt(stateLength));
      			String country = CountryName.get(rand.nextInt(countryLength));
      			int pincode = Postal.get(rand.nextInt(postalLength));
      			long phone = PhoneNumber.get(rand.nextInt(phoneLength));
      			long mobile1 = MobileNumber.get(rand.nextInt(mobileLength));
      			String email12 = EmailId.get(rand.nextInt(emailLength));
      			//Contact Primary Key
      			int conPK = setContactData(conn, street_address, city, state, country, pincode, phone, mobile1, email12);
      			//System.out.println("The contact primary key is " + conPK);


      			//For storing account part
      			String panNumber = PanNum.get(pan_id);
      			pan_id++;								//Incrementing pan_id so that it stores unique pan number
      			String firstName = FirstName.get(rand.nextInt(firstLength));
      			String lastName = LastName.get(rand.nextInt(lastLength));
      			String dob = DoB.get(rand.nextInt(dobLength));
      			//Person primary key
      			int perPK = setAccountData(conn, panNumber, firstName, lastName, dob, conPK);


      			//For storing bank account
      			String opening_date = OpeningDate.get(rand.nextInt(openingLength));
      			String closing_date = ClosingDate.get(rand.nextInt(closingLength));
      			String status = Status.get(rand.nextInt(statusLength));
      			String account_type = AccountType.get(rand.nextInt(accountLength));
      			double maxBalance = 10000000.00;
      			double current_balance = maxBalance*(rand.nextDouble());
      			//String last_transaction = Have to add
      			int accPK = setBankAccount(conn, opening_date, closing_date, status, perPK, account_type, current_balance);

      			//For storing transaction
      			if(status.equals("Active")){
      				String transaction_type = TransactionType.get(rand.nextInt(transactionLength));
      				double maxAmount = 100000.00;
      				double amount = maxAmount*(rand.nextDouble());
      				String category =  Category.get(rand.nextInt(categoryLength));
      				String remarks = Remarks.get(rand.nextInt(remarksLength));

      			int tranPK = setTransaction(conn, transaction_type, amount, accPK, category, remarks, opening_date, current_balance);	
      			}
      			
      		}

      	}
      	//If query has been inserted i.e. -q
      	else if(mode.equals("-q")){
      		System.out.println("Handling query part.");
      		
      		System.out.println("Which query do you want to execute: Type 1 for first, Type 2 for second, Type 3 for third query.");
      		Scanner sc0 = new Scanner(System.in);
      		int a = sc0.nextInt();

      		if(a==1){
      			Scanner sc1 = new Scanner(System.in);
	      		System.out.println("Please Enter the account id :");
	      		int account1 = sc1.nextInt();
	      		System.out.println("Enter the first date in YYYY-MM-DD format :");
	      		String startdate = sc1.next();
	      		System.out.println("Enter the second date in YYYY-MM-DD format :");
	      		String enddate = sc1.next();

	      		String query1 = "SELECT * FROM account_transaction WHERE account_id = "+ account1 + " AND (transaction_time BETWEEN '" + startdate +"' AND '" + enddate + "');";
	      		Statement stmt = null;
	      		try{
	      			stmt = conn.createStatement();
		        	ResultSet rs = stmt.executeQuery(query1);
		        	System.out.println("| transaction_id | transaction_type | transaction_time | amount   | account_id | category   | remarks                             |");
		        	while(rs.next()){
		        		int tn_id = rs.getInt("transaction_id");
		        		String type = rs.getString("transaction_type");
		        		String time = rs.getString("transaction_time");
		        		double am = rs.getDouble("amount");
		        		int acc_id = rs.getInt("account_id");
		        		String ctg = rs.getString("category");
		        		String rmk = rs.getString("remarks");
		        		System.out.print(tn_id + " |");
		        		System.out.print(type + " |");
		        		System.out.print(time + " |");
		        		System.out.print(am + " |");
		        		System.out.print(acc_id + " |");
		        		System.out.print(ctg + " |");
		        		System.out.print(rmk + " |");
		        		System.out.println();
		        	}
	      		}
	      		catch(SQLException e){
	      			e.printStackTrace();
	      		}
      		}

      		else if(a==2){
      			System.out.println("Doing query 2:");
      			System.out.println("Enter the month in MM format:");
      			String month = sc0.next();
      			System.out.println("Enter the person Id of the person:");
      			int per_id = sc0.nextInt();

      			String query2 = "select sum(amount),category from (select * from account_transaction where MONTH(transaction_time) = '"+ month +"' and account_id in (select account_id from bank_account where person_id in (select person_id from account_holder where person_id = '" + per_id +"')))as T group by category;";

      			Statement stmt = null;
      			try{
      				stmt = conn.createStatement();
		        	ResultSet rs = stmt.executeQuery(query2);
		        	System.out.println("| sum(amount) | category       |");
		        	while(rs.next()){
		        		double amt = rs.getDouble("sum(amount)");
		        		String ctg = rs.getString("category");
		        		System.out.print(amt + " |");
		        		System.out.print(ctg + " |");
		        		System.out.println();
		        	}
      			}
      			catch(SQLException e){
      				e.printStackTrace();
      			}
      		}
      		else if(a==3){
      			System.out.println("Doing query 3:");
      			System.out.println("Enter the month in MM format:");
      			String month = sc0.next();
      			System.out.println("Enter the city :"); 
      			String city = sc0.next();
      			String query3 = "select sum(amount),category from (select * from account_transaction where MONTH(transaction_time) = '"+ month +"' and account_id in (select account_id from bank_account where person_id in (select person_id from account_holder where contact_id in (select contact_id from contact where city = '"+ city +"'))))as T group by category;";

      			Statement stmt = null;
      			try{
      				stmt = conn.createStatement();
		        	ResultSet rs = stmt.executeQuery(query3);
		        	System.out.println("| sum(amount) | category       |");
		        	while(rs.next()){
		        		double amt = rs.getDouble("sum(amount)");
		        		String ctg = rs.getString("category");
		        		System.out.print(amt + " |");
		        		System.out.print(ctg + " |");
		        		System.out.println();
		        	}
      			}
      			catch(SQLException e){
      				e.printStackTrace();
      			}
      		}
      		

      	} 
      	//If something else is inserted by mistake
      	else{
      		System.out.println("Please enter either -i or -q.");
      	}

      //For closing connection
      conn.close();
      	
	}
	catch (ArrayIndexOutOfBoundsException a){   //For Handlining array index out of bound
      System.out.println("Please enter the -i or -q.");
    }
    catch (Exception ex) {
      ex.printStackTrace();
      //System.out.println("Hi");
    }
	}

	//Function for checking opening and closing date is valid or not
	public static boolean checkDate(String opening_date,String closing_date){
		String [] arrOfStr1 = opening_date.split("-");
		String [] arrOfStr2 = closing_date.split("-");
		int openingyear = 0;
		int closingyear = 0;
		int openingmonth = 0;
		int closingmonth = 0;
		int openingdate = 0;
		int closingdate = 0;
		boolean flag = false;				//Returns false
		try{
			openingyear = Integer.parseInt(arrOfStr1[0]);
			openingmonth = Integer.parseInt(arrOfStr1[1]);
			openingdate = Integer.parseInt(arrOfStr1[2]);
			closingyear = Integer.parseInt(arrOfStr2[0]);
			closingmonth = Integer.parseInt(arrOfStr2[1]);
			closingdate = Integer.parseInt(arrOfStr2[2]);
			if(closingyear > openingyear){
				flag =true;
			}
			if(openingyear == closingyear){
				if(openingmonth < closingmonth){
					flag = true;
				}
				else if(openingmonth == closingmonth){
					if(openingdate < closingdate){
						flag = true;
					}
					else{
						flag = false;
					}
				}
				else{
					flag = false;
				}
			}
			if(openingyear > closingyear){
				flag = false;
			}
		}
		catch(Exception e){
			flag = false;
		}
		return flag;					//Returning flag
	}	

	//Function for setting contact information in database
	public static int setContactData(Connection conn,String street_address, String city, String state, String country, int pincode, long phone,long mobile, String email){
		int contact_id = 0;
		try{
			PreparedStatement ps = conn.prepareStatement("INSERT INTO contact(street_address,city,state,country,pincode,phone,mobile,email) VALUES(?,?,?,?,?,?,?,?);",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, street_address);
            ps.setString(2, city);
            ps.setString(3, state);
            ps.setString(4, country);
            ps.setInt(5, pincode);
            ps.setLong(6, phone);
            ps.setLong(7, mobile);
            ps.setString(8, email);
            int rows = ps.executeUpdate();
            ResultSet pk = ps.getGeneratedKeys();
            while(pk.next()){
                //System.out.println(pk.getInt(1));
                contact_id = pk.getInt(1);
            }
		}
		catch(SQLException sql){
			sql.printStackTrace();
		}
		return contact_id;
	}

	//Function for setting account data in database
	public static int setAccountData(Connection conn, String panNumber, String firstName, String lastName, String dob, int contactId){
		int person_id = 0;
		try{
			PreparedStatement ps = conn.prepareStatement("INSERT INTO account_holder(pan_number,first_name,last_name,dob,contact_id) VALUES(?,?,?,?,?);",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, panNumber);
            ps.setString(2, firstName);
            ps.setString(3, lastName);
            ps.setString(4, dob);
            ps.setInt(5, contactId);
            int rows = ps.executeUpdate();
            ResultSet pk = ps.getGeneratedKeys();
            while(pk.next()){
                //System.out.println(pk.getInt(1));
                person_id = pk.getInt(1);
            }

		}
		catch(SQLException sql){
			sql.printStackTrace();
		}
		return person_id;
	}

	//Function for setting Bank Account information in database
	public static int setBankAccount(Connection conn, String opening_date, String closing_date, String status, int person_id, String account_type, double current_balance){
		int account_id = 0;
		try{
			PreparedStatement ps = conn.prepareStatement("INSERT INTO bank_account(opening_date,closing_date,status,person_id,account_type,current_balance) VALUES(?,?,?,?,?,?);",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, opening_date);
            if(closing_date == ""){
                ps.setNull(2, Types.INTEGER);   
            }
            else{
                ps.setString(2, closing_date);
            }
            ps.setString(3, status);
            ps.setInt(4, person_id);
            ps.setString(5, account_type);
            ps.setDouble(6, current_balance);
            //ps.setString(7, last_transaction);
            int rows = ps.executeUpdate();
            ResultSet pk = ps.getGeneratedKeys();
            while(pk.next()){
                //System.out.println(pk.getInt(1));
                account_id = pk.getInt(1);
            }

		}
		catch(SQLException sql){
			sql.printStackTrace();
		}
		return account_id;
	}

	//Function for setting Transaction data in database
	public static int setTransaction(Connection conn, String transaction_type, double amount, int account_id, String category, String remarks, String opening_date, double current_balance){
		int transaction_id = 0;
		try{
			//One account holder makes 10 transaction each 1 day after its opening day
			String [] arrOfStr1 = opening_date.split("-");
			int openingyear = 0;
			int openingmonth = 0;
			int openingdate = 0;
			openingyear = Integer.parseInt(arrOfStr1[0]);
			openingmonth = Integer.parseInt(arrOfStr1[1]);
			openingdate = Integer.parseInt(arrOfStr1[2]);
			for(int i=1;i<11;i++){
				int flag = 1;							//For checking the amount
				int flag1 = 1;							//For checking account id
				int flag2 = 1;							//for checking status
				openingdate += 1;
				
				Statement stmt = conn.createStatement();
				PreparedStatement statement = conn.prepareStatement("SELECT * FROM bank_account order by RAND() limit 1");
                ResultSet rs = statement.executeQuery();
                rs.next();
                int account_id1 = rs.getInt("account_id");
                String status1 = rs.getString("status");
                double current_balance1 = rs.getDouble("current_balance");
                if(account_id == account_id1){
                	flag1 = 0; //balance can't be transferred from same account
                }

                //Checking whether another account has active status or not
                if(status1.equals("Active")){
                	flag2 = 1;
                }
                else{
                	flag2 = 0;
                }

				//Passing the transaction time
				String transaction_time = null;
				if(openingdate>9){
					transaction_time =  String.valueOf(openingyear) + "-" + "0" + String.valueOf(openingmonth) + "-" + String.valueOf(openingdate);	
				}
				else{
					transaction_time =  String.valueOf(openingyear) + "-" + "0" + String.valueOf(openingmonth) + "-" + "0" + String.valueOf(openingdate);
				}

				//Checking the current balance is greater than the amount or not
				if(current_balance > amount){
					current_balance -= amount;
					current_balance1 += amount;
				}
				else{
					flag = 0;
				}

				//Can check more for opening and closing date by using the function

				if(flag==1 && flag2==1 && flag1==1){
					try{
						//Updating the transaction time of sender
						System.out.println("Transaction time is " + transaction_time);
						
						String query1 = "UPDATE bank_account SET current_balance="+current_balance+" WHERE account_id="+account_id+";";
						PreparedStatement ps1 = conn.prepareStatement(query1);
						
						int r1=ps1.executeUpdate(query1);

						String query3 = "UPDATE bank_account SET current_balance="+current_balance1+" WHERE account_id="+account_id+";";
						//Updating the current balance of sender
						PreparedStatement ps3 = conn.prepareStatement(query3);
						
						int r3=ps3.executeUpdate(query3);

						PreparedStatement ps = conn.prepareStatement("INSERT INTO account_transaction(transaction_type,amount,account_id,category,remarks,transaction_time) VALUES(?,?,?,?,?,?);",Statement.RETURN_GENERATED_KEYS);
			            ps.setString(1, transaction_type);
			            //
			            ps.setDouble(2, amount);
			            ps.setInt(3, account_id);
			            //ps.setString(4, account_type);
			            ps.setString(4, category);
			            ps.setString(5, remarks);
			            ps.setString(6, transaction_time);
			            int rows = ps.executeUpdate();
			            ResultSet pk = ps.getGeneratedKeys();
			            while(pk.next()){
			                //System.out.println(pk.getInt(1));
			                transaction_id = pk.getInt(1);
			            }
					}
					catch(SQLException sql){
						sql.printStackTrace();
					}		
				}
			}
		}
		catch(SQLException sql){
			sql.printStackTrace();
		}
		return transaction_id;
	}
}