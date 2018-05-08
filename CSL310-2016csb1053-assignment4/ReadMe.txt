Name = Ram Krishna
Entry No = 2016csb1053
Course = CSL310
---------------------------------------------------------------------------------------------------------------------------
For compiling:
	$javac P2.java
For running:
	For inserting:
		$java -cp ./mysql-connector-java-5.1.46.jar:. P2 jdbc:mysql://localhost:3306/BANK -i
	For querying:
		$java -cp ./mysql-connector-java-5.1.46.jar:. P2 jdbc:mysql://localhost:3306/BANK -q
---------------------------------------------------------------------------------------------------------------------------
About Schema:

I have made the schema of the database in the "schema.sql" file. In the schema bascially i have used the style or format as specified by sir. I have created 4 tables namely "contact","account_holder","bank_account" and "account_transaction". Contact table stores the address and contact details of the table like phone no,mobile, street address etc. Similarly account_holder table stores all the details of the person and also the PanNumber is unique. Bank_account table stores the information regarding the bank account it stores the person id as foreign key from account_holder table. A person can hae a lot of accounts. Also the last table stores the transaction history of various user.

I have not commented the code in schema part because it gives syntax error. So i explained here.
---------------------------------------------------------------------------------------------------------------------------

About Java Code:

The main java code is in P2.java file.

In the code part I have commented a lot but I will explain what I have done. First It will ask the user to enter user of database and password then it will verify and make connection using DriverMAnager. After making connection I have created a lot of arraylist in java for storing various data in it like for storing cityName I have stored it into an arraylist by reading file named "cityName.txt". Similarly I have stored the firstname, lastName and approximately all the data in the arraylist. Some data I have read from file. Like firstName, LastName  etc. While others I have generated.

Like for opening Date and closing date I have stored it in arraylist via loopping such that opening date is always greater than closing date. Also I have created street adress,remarks via looping.

First I am inserting the first 3 tables like for 50 entries. After that I am inserting all the 4 tables data again via looping. I have selected everything such that it functions well. Since I have updated everything via program so I have taken some more general case. Which can be modified on large scale. I have used the random selector of index via java. For selecting anything whether name or data etc.

I have made functions which takes a lot of arguements which is used to store data in the table.

For bank transaction in my case opening date of all bank accounts are less than closing dates. But I have made a function which checks whether account1's opening date is less than the other or not.

---------------------------------------------------------------------------------------------------------------------------
Assumption:

1-In my program run -i command once because I have stored panNumber in a unique way by looping. So if you run it twice It will give you error like panNumber duplicate found etc.

2-I have stored the opening date such that it is always less than closing date.

3- I have inserted more than 50 items in the database also I have not kept saving accounts for all the user atleast once rather I have used random generator.

4- I have also taken city via files read and write. So I have not kept 10 account holder per city. All this thing is done randomly.

5- I have first stored 50 entries in 3 tables  after that i have started transaction for the next 30 entries. For each account created i have transactioned it by 10 different account if the status is active then transaction happens, otherwise not.

6- For city name See cityName.txt. If you want to add more cityname see cityNameLot.txt and add some name to it. I have changed the file after output so please check the database for accurate results.

---------------------------------------------------------------------------------------------------------------------------
Sample Output1:

Handling query part.
Please Enter the account id :
51
Enter the first date in YYYY-MM-DD format :
1990-03-04
Enter the second date in YYYY-MM-DD format :
2010-03-05
| transaction_id | transaction_type | transaction_time | amount   | account_id | category   | remarks                             |
1 |Debit |1997-07-09 |66036.84 |51 |Money Transfer |I am happy with transaction 233053. |
2 |Debit |1997-07-11 |66036.84 |51 |Money Transfer |I am happy with transaction 233053. |
3 |Debit |1997-07-14 |66036.84 |51 |Money Transfer |I am happy with transaction 233053. |
4 |Debit |1997-07-15 |66036.84 |51 |Money Transfer |I am happy with transaction 233053. |
5 |Debit |1997-07-16 |66036.84 |51 |Money Transfer |I am happy with transaction 233053. |
---------------------------------------------------------------------------------------------------------------------------
Sample Output2:

Which query do you want to execute: Type 1 for first, Type 2 for second, Type 3 for third query.
2
Doing query 2:
Enter the month in MM format:
07
Enter the person Id of the person:
51
| sum(amount) | category       |
330184.2 |Money Transfer |
---------------------------------------------------------------------------------------------------------------------------

Sample Output3:
Which query do you want to execute: Type 1 for first, Type 2 for second, Type 3 for third query.
3
Doing query 3:
Enter the month in MM format:
07
Enter the city :
Mysore
| sum(amount) | category       |
330184.2 |Money Transfer |
---------------------------------------------------------------------------------------------------------------------------
