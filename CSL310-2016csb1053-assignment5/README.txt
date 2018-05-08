---------------------------------------------------------------------------------------------------------------
Name 	 = Ram Krishna
Entry No = 2016csb1053
Course   = CSL310
---------------------------------------------------------------------------------------------------------------
For sql File

First of all make database of the schema. For this be in CSL310-2016csb1053-assignment5 directory on your laptop. For this you have to open the mysql in terminal in current directory.

	$mysql -u [user] -p
	$password

Enter the username of the database and password.

For loading the tables in the database run the following command.
	$source schema.sql

--------------------------------------------------------------------------------------------------------------
Before running java file change the username and password in the persistence.xml file in META-INF directory.

For Java File

Before compiling and running be in my directory i.e. in CSL310-2016csb1053-assignment5 directory. 

For Compiling:
	$javac -cp lib/*:. lab/Lab.java
For Running:
	$java -cp lib/*:. lab/Lab

---------------------------------------------------------------------------------------------------------------
About Schema

I have made the schema of the database in the "schema.sql" file. In the schema bascially i have used the style or format as specified by sir. I have created 4 tables namely "contact","person","team" and "team_member". Contact table stores the address and contact details of the table like phone no,mobile, street address etc. Similarly person table stores all the details of the person and also the contact_id as foriegn key.
Team table stores the information regarding the team it stores the contact_id as foreign key from contact table. Also the last table team_member stores the information regarding various salary,hiredate etc.

I have not commented the code in schema part because it gives syntax error. So i explained here.
--------------------------------------------------------------------------------------------------------------

About Java file

All my java code is in lab directory.

I have made the program in netBeans. Mainly I have made Lab.java file. I have stored all the informations in ArrayList like FirstName, LastName ,Address, PhoneNumber, MobileNumber, EmailID etc. I have taken it from file reading. There are a lot of files named with .txt extension. I have made 3 functions for reading files. Some objects are of String type some are long type for eg MobileNumber. some are integer type like postal and storing the data.

I have taken the function "saveEntity" for inserting the values in database from the sir code. He has sent us. Calling this function will insert the values in database. While inserting the value I have used the random index of these arraylist using randomIndex function I have made.

I have created 3 functions for 3 queries to execute. Users will be asked to run query 1, 2 or 3.
I have used basically jpi api for many works.

I have inserted 20 teams now in each team i used randomIndex function for generating the number of players, owners,others, managers as sir has suggested that players should be from 10 - 15 etc.

Team Name is "Team-1","Team-2","Team-3" and so on.
For stateName see the state.txt file. For any thing see in .txt file.
--------------------------------------------------------------------------------------------------------------
Assumptions:

1-Insert values only once for better result of query. Inserting multiple times will change the result of the query.

2-I have not taken from commandline input. You will be asked while running whether you want to enter data or run query.

3-Please change the username and password in the persistance.xml file in the META-INF directory. 

4- Team Name is of the format "Team-1","Team-2","Team-3",and so on.

--------------------------------------------------------------------------------------------------------------
Sample Output1:

Enter i if you want to insert data into Database.
Enter q if you want to query on data in Database.
q
Type 1 for query 1.
Type 2 for query 2.
Type 3 for query 3.
1
In query 1.
Enter the team name
Team-6
Enter the minimum range of salary.
10000
Enter the maximum range of salary.
30000
[EL Info]: 2018-04-21 15:55:12.045--ServerSession(148626113)--EclipseLink, version: Eclipse Persistence Services - 2.5.2.v20140319-9ad6abd
[EL Info]: connection: 2018-04-21 15:55:12.429--ServerSession(148626113)--file:/home/abhi/csl310/CSL310-2016csb1053-assignment5/_labPU login successful
PersonId  |  FirstName  |  LastName
151 | Pari | Parmar
153 | Meghana | Parmar
154 | Sapna | Masoor
---------------------------------------------------------------------------------------------------------------

Sample Output2:

Enter i if you want to insert data into Database.
Enter q if you want to query on data in Database.
q
Type 1 for query 1.
Type 2 for query 2.
Type 3 for query 3.
2
In Query 2
Enter Team Name of which you want to find rolewise Team Members.
Team-2
[EL Info]: 2018-04-21 15:56:10.774--ServerSession(148626113)--EclipseLink, version: Eclipse Persistence Services - 2.5.2.v20140319-9ad6abd
[EL Info]: connection: 2018-04-21 15:56:11.161--ServerSession(148626113)--file:/home/abhi/csl310/CSL310-2016csb1053-assignment5/_labPU login successful
Role    | Number of members
Manager |   5
Other |   5
Owner |   5
Player |   15
---------------------------------------------------------------------------------------------------------------

Sample Output3:

Enter i if you want to insert data into Database.
Enter q if you want to query on data in Database.
q
Type 1 for query 1.
Type 2 for query 2.
Type 3 for query 3.
3
In query 3.
Enter the name of the state.
Punjab
[EL Info]: 2018-04-21 16:01:57.61--ServerSession(148626113)--EclipseLink, version: Eclipse Persistence Services - 2.5.2.v20140319-9ad6abd
[EL Info]: connection: 2018-04-21 16:01:58.0--ServerSession(148626113)--file:/home/abhi/csl310/CSL310-2016csb1053-assignment5/_labPU login successful
The average salary is 61469.236667
---------------------------------------------------------------------------------------------------------------

