import java.util.Scanner;
import java.io.Console;
import java.util.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

public class p1 {

  public static void main(String[] args) throws Exception {
  
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

      // Get the MetaData
      DatabaseMetaData metaData = conn.getMetaData();
      
      // Get table information
      String table1[] = {"TABLE"};

      ArrayList <String>tableName = null;
      tableName = new ArrayList<String>();  //For storing tables name
      
      int no_tables = 0;            //For Counting No of tables in the database
      ResultSet tables = metaData.getTables(null, null, null, table1);
      while (tables.next()) {
        //Adding the table name in the arraylist tableName
        tableName.add(tables.getString("TABLE_NAME"));
        //System.out.println(tableName[no_tables]);
        no_tables++;

      }

      //System.out.println("Total number of tables are " + no_tables);

      //For storing columns
      int columnStore[] = new int[no_tables];         //For storing number of columns of each table
      int blob[] = new int[no_tables];                //For storing number of blob columns in each table
      int integer[] = new int[no_tables];             //For storing integers columns in each table
      int autoinc[] = new int[no_tables];             //For storing integers autoincreament columns in each table
      int index[] = new int[no_tables];               //For storing index in each table

      ResultSet rs = null;
      int v1 = 0;                                     //Variable for array index
      for(String name : tableName){                   //Looping over all the table in the datbase 
        //Method to find columns
        rs = metaData.getColumns(null, null, name, null);
        int col = 0;                                  //Variable to count no of columns in each table
        int auto_increament = 0;                      //Variable to count no of auto increament in each table
        int count_blob = 0;                           //Variable to count no of blob columns in each table
        int count_integer = 0;                        //Variable to count no of integer columns in each table
        while(rs.next()){           
            col++;                                    //Increamenting the column variable
            String n = rs.getString("TYPE_NAME");   
        //    System.out.println(n);
            String n12 = rs.getString("IS_AUTOINCREMENT");
            if(n.toUpperCase().equals("BLOB")){        //Counting the number of blob column in each table
              count_blob++;
            }

            if(n.toUpperCase().equals("INT")){         //Counting the number of integer column in each table
              count_integer++;
            }

            if(n12.toUpperCase().equals("YES")){       //Counting the number of autoIncreament column in each table
              auto_increament++;
            }
        }
        
        columnStore[v1] = col;                         //Storing the result in the array 
        blob[v1] = count_blob;
        integer[v1] = count_integer;
        autoinc[v1] = auto_increament;
        
        v1++;                                          //Incrementing the array index
      }
      
      int v4 = 0;                                      //Variable for array index
      Statement st1 = conn.createStatement();          //Statement for counting rows
      int row[] = new int[no_tables];                  //Array for storing number of rows in each table
      //System.out.println("Rows here ");
      for(String table : tableName){                   //Looping over each table
        int count = 0;                                 //Query written for counting rows
        ResultSet res = st1.executeQuery("SELECT COUNT(*) FROM "+table);  
        while (res.next()){
                  count = res.getInt(1);               //It will give the number of rows
              }  
              row[v4] = count;                         //Storing the number of rows
        //      System.out.println(table + " " + count);
              v4++;                                    //Incrementing the index of array
      }
      

      //counting Foreign Keys in each table
      int foreignKey[] = new int[no_tables];
      ResultSet fk = null;
      int v2 = 0;                                       //Variable
      for(String name : tableName){
        fk = metaData.getImportedKeys(conn.getCatalog(), null, name);     //Using getImportedKeys Method for fk
        //System.out.println(name);
        int forkey = 0;                                 //Counting foreign key
        while(fk.next()){
          //System.out.println(fk.getString("FK_NAME"));
          forkey++;
        }
        foreignKey[v2] = forkey;
        //System.out.println(name + " " + forkey);
        v2++;
      }
      //For counting index in each table
      v2 = 0;
      ResultSet rs1 = null;
      //System.out.println("index in table");
      for(String name : tableName){
        rs1 = metaData.getIndexInfo(null,null,name,false,false);
         int count_index = 0;
         while(rs1.next()){
          count_index++;
         }
        index[v2] = count_index;
        //System.out.println( name + " " + count_index);
        v2++;
      }
        int max[] = new int[7];
        int min[] = new int[7];
        double avg[] = new double[7];
        int sum[] = new int[7];
        max[0] = columnStore[0];
        min[0] = max[0];
        max[1] = row[0];
        min[1] = max[1];
        max[2] = foreignKey[0];
        min[2] = max[2];
        max[3] = index[0];
        min[3] = max[3];
        max[4] = autoinc[0];
        min[4] = max[4];
        max[5] = blob[0];
        min[5] = max[5];
        max[6] = integer[0];
        min[6] = max[6];
        for(int i=0;i<no_tables;i++){
            if(min[0] > columnStore[i]){
              min[0] = columnStore[i];                            //for calculating minimum
            }
            if(max[0] < columnStore[i]){
              max[0] = columnStore[i];                            //For calculating maximum
            }
            if(min[1] > row[i]){
              min[1] = row[i];                                    //for calculating minimum
            }
            if(max[1] < row[i]){
              max[1] = row[i];                                    //For calculating maximum
            }
            if(min[2] > foreignKey[i]){
              min[2] = foreignKey[i];                             //for calculating minimum
            }
            if(max[2] < foreignKey[i]){
              max[2] = foreignKey[i];                             //For calculating maximum
            }
            if(min[3] > index[i]){
              min[3] = index[i];                                  //for calculating minimum
            }
            if(max[3] < index[i]){
              max[3] = index[i];                                 //For calculating maximum
            }
            if(min[4] > autoinc[i]){
              min[4] = autoinc[i];                              //for calculating minimum
            }
            if(max[4] < autoinc[i]){
              max[4] = autoinc[i];                              //For calculating maximum
            }
            if(min[5] > blob[i]){
              min[5] = blob[i];                                 //for calculating minimum
            }
            if(max[5] < blob[i]){
              max[5] = blob[i];                                 //For calculating maximum
            }
            if(min[6] > integer[i]){
              min[6] = integer[i];
            }
            if(max[6] < integer[i]){
              max[6] = integer[i];
            }
            sum[0]+=columnStore[i];
            sum[1]+=row[i];
            sum[2]+=foreignKey[i];
            sum[3]+=index[i];
            sum[4]+=autoinc[i];
            sum[5]+=blob[i];
            sum[6]+=integer[i];
          }                                                                 //Calculating average of all the variables
        double s0 = (double) sum[0];
        avg[0] = s0/no_tables;
        s0 = (double) sum[1];
        avg[1] = s0/no_tables;
        s0 = (double) sum[2];
        avg[2] = s0/no_tables;
        s0 = (double) sum[3];
        avg[3] = s0/no_tables;
        s0 = (double) sum[4];
        avg[4] = s0/no_tables;
        s0 = (double) sum[5];
        avg[5] = s0/no_tables;
        s0 = (double) sum[6];
        avg[6] = s0/no_tables;
        System.out.println("=============================== INFORMATION FOR sakila DATABASE ============================");
        System.out.println("Total number of tables                                                      : " + no_tables);
        System.out.println("Min, Max, and Average number of columns per table                           : " + min[0] + ", " + max[0] + ", "+ avg[0]);
        System.out.println("Min, Max, and Average number of rows present per table                      : " + min[1] + ", " + max[1] + ", " + avg[1]);
        System.out.println("Min, Max, and Average number of FKs present per table                       : " + min[2] + ", " + max[2] + ", " + avg[2]);
        System.out.println("Min, Max, and Average number of indexes present per table                   : " + min[3] + ", " + max[3] + ", " + avg[3]);
        System.out.println("Min, Max, and Average number of auto incremented columns present per table  : " + min[4] + ", " + max[4] + ", " + avg[4]);
        System.out.println("Min, Max, and Average number of BLOB columns present per table              : " + min[5] + ", " + max[5] + ", " + avg[5]);
        System.out.println("Min, Max, and Average number of INTEGER columns present per table           : " + min[6] + ", " + max[6] + ", " + avg[6]);
        //Closing the connection
         conn.close();

    } 
      catch (ArrayIndexOutOfBoundsException a){   //For Handlining array index out of bound
      System.out.println("Please give the URL through the command line.");
    }
    catch (Exception ex) {
      ex.printStackTrace();
      //System.out.println("Hi");
    }

    
  }
}
