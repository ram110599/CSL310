/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author abhi
 */
public class Lab {

    /**
     * @param args the command line arguments
     */
    private EntityManagerFactory emf = null;
    public Lab() {
        emf = Persistence.createEntityManagerFactory("labPU");
    }
    
    //For Query 1
    public List<Person> query1(double min, double max, String name) {
    	List<Person> list = null;
        EntityManager em;
        em = emf.createEntityManager();
        try {
            Query q = em.createNamedQuery("Person.findallByRole");
            q.setParameter("min", min);
            q.setParameter("max", max);
            q.setParameter("name", name);
            list = q.getResultList();
        } finally {
            em.clear();
            em.close();
        }
        return list;
    }
    //For Query 2

    /**
     *
     * @param name
     * @return
     */
    public List<Object[]> query2(String name) {
    	List<Object[]> list = null;
        EntityManager em;
        em = emf.createEntityManager();
        try {
            Query q = em.createNamedQuery("TeamMember.findAllByRolewise");
            q.setParameter("name", name);
            list = (List<Object[]>)q.getResultList();
        } finally {
            em.clear();
            em.close();
        }
        return list;
    }
    
    //For query 3

    /**
     *
     * @param name
     * @return
     */
    public List<Double> query3(String name) {
    	List<Double> list = null;
        EntityManager em;
        em = emf.createEntityManager();
        try {
            Query q = em.createNamedQuery("TeamMember.query3");
            q.setParameter("name", name);
            list = (List<Double>)q.getResultList();
        } finally {
            em.clear();
            em.close();
        }
        return list;
    }
    
    //For saving Entity in database
    public <E> void saveEntity(E entity) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            em.close();
        } finally {
            em.close();
        }
    }
    
    //function for generating random index

    /**
     *
     * @param len
     * @return
     */
    public static int randomIndex(int len){
        Random rnd = new Random();
	int n = rnd.nextInt(len);
        return n;
    }
    
    //Function for random salary generating
    public static double randomSalary(){
        Random rnd = new Random();
	double maxBalance = 100000.00;
      	double currentBalance = maxBalance*(rnd.nextDouble());
        return currentBalance;
    }
    
    //Function for filling the Double ArrayList

    /**
     *
     * @param Abc
     * @param fileName
     */
    public void fillDoubleArray(ArrayList<Long> Abc, String fileName){
	try{
            File file1 = new File(fileName);
            BufferedReader br = new BufferedReader(new FileReader(file1));
            String fname;
            while((fname = br.readLine()) !=null){
                    Abc.add(Long.parseLong(fname));
            }
      	}
      	catch(IOException | NumberFormatException e){
            System.out.println("Error in file reading and writing.");
	}
	//return Abc;
    } 
    
    //Function for filling integerArray
    public void fillIntegerArray(ArrayList<Integer> Abc, String fileName){
		try{
	      	File file1 = new File(fileName);
	      	BufferedReader br = new BufferedReader(new FileReader(file1));
	      	String fname;
	      	while((fname = br.readLine()) !=null){
	      		Abc.add(Integer.parseInt(fname));
	      	}
      	}
      	catch(  IOException | NumberFormatException e){
            System.out.println("Error in file reading and writing.");
        }
		//return Abc;
	} 
    
    //Function for filling String ArrayList
    public void fillStringArray(ArrayList<String> Abc, String fileName){
	try{
            File file1 = new File(fileName);
            BufferedReader br = new BufferedReader(new FileReader(file1));
            String fname;
            while((fname = br.readLine()) !=null){
                    Abc.add(fname);
            }
      	}
      	catch(IOException e){
            System.out.println("Error in file reading and writing.");
        }
	//return Abc;
    } 
    
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        
        //Creating Object of Lab class
        Lab test = new Lab();
        
        //Creating ArrayList for storing a lot of informations
        ArrayList<String> StreetName = new ArrayList<>();
        ArrayList<String> StateName = new ArrayList<>();
        ArrayList<String> CityName = new ArrayList<>();
        ArrayList<Integer> Postal = new ArrayList<>();
        ArrayList<Long> PhoneNumber = new ArrayList<>();
        ArrayList<Long> MobileNumber = new ArrayList<>();
        ArrayList<String> Email = new ArrayList<>();
        ArrayList<String> FirstName = new ArrayList<>();
        ArrayList<String> LastName = new ArrayList<>();
        ArrayList<String> DoB = new ArrayList<>();
        ArrayList<String> CreationDate = new ArrayList<>();
        ArrayList<String> Status = new ArrayList<>();
        
        
        //Filling the Arraylist
        test.fillStringArray(StreetName, "Street.txt");
        test.fillStringArray(StateName, "States.txt");
        test.fillStringArray(CityName, "City.txt");
        test.fillDoubleArray(PhoneNumber, "Mobile.txt");
        test.fillDoubleArray(MobileNumber, "Phone.txt");
        test.fillStringArray(DoB, "DoB.txt");
        test.fillStringArray(FirstName, "FirstName.txt");
        test.fillStringArray(LastName, "LastName.txt");
        test.fillStringArray(CreationDate, "CreationDate.txt");
        test.fillIntegerArray(Postal, "Postal.txt");
        
        //Adding into status arraylist
        Status.add("Active");
        Status.add("Retired");
        
        //Adding into Email ArrayList
        for(int i=123345;i<123445;i++){
            String a = "abhi"+ i + "@gmail.com";
            Email.add(a);
        }
        //System.out.println(Email.size());
        //System.out.println(Postal.size());
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter i if you want to insert data into Database.");
        System.out.println("Enter q if you want to query on data in Database.");
        String input = sc.nextLine();
        
        switch (input) {
            case "i":
                //Adding the entity in database
                for(int i=0;i<20;i++){          //For 20 different team
                    
                    //Creating contact information for team
                    Contact p0 = new Contact();
                    
                    //Setting all the information in the contact field by using array element with the help of random function
                    p0.setStreetAddress(StreetName.get(randomIndex(StreetName.size())));
                    p0.setCity(CityName.get(randomIndex(CityName.size())));
                    p0.setState(StateName.get(randomIndex(StateName.size())));
                    p0.setCountry("India");
                    p0.setPincode(Postal.get(randomIndex(Postal.size())));
                    p0.setPhone(PhoneNumber.get(randomIndex(PhoneNumber.size())));
                    p0.setMobile(MobileNumber.get(randomIndex(MobileNumber.size())));
                    p0.setEmail(Email.get(randomIndex(Email.size())));
                    
                    //Putting the value in database
                    test.saveEntity(p0);
                    
                    //Creating the team object
                    Team p1 = new Team();
                    
                    //Team Name
                    String teamName;
                    teamName = "Team-" + String.valueOf(i+1);
                    //System.out.println(name);
                    
                    System.out.println("Saved contact information of team " + teamName);
                    
                    //Accessing the date from the array creationDate by using random function
                    String date = CreationDate.get(randomIndex(CreationDate.size()));
                    //System.out.println(date);
                    
                    //Converting string date into mysql date
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date parsed = format.parse(date);
                    java.sql.Date sql = new java.sql.Date(parsed.getTime());
                    //System.out.println(sql);
                    
                    //Setting the creation date of the team
                    p1.setCreationDate(sql);
                    p1.setStatus(Status.get(randomIndex(Status.size())));
                    p1.setName(teamName);
                    p1.setOfficeId(p0);
                    
                    //Putting the team information into database
                    test.saveEntity(p1);
                    System.out.println("Saved team information of team " + teamName);
                    int j1 = randomIndex(5);
                    for(int j=0;j<10 + j1;j++){      //For 10 - 15 different players
                        
                        //Setting the contact for team member
                        Contact p10 = new Contact();
                        
                        //Setting all the information in the contact field by using array element with the help of random function
                        p10.setStreetAddress(StreetName.get(randomIndex(StreetName.size())));
                        p10.setCity(CityName.get(randomIndex(CityName.size())));
                        p10.setState(StateName.get(randomIndex(StateName.size())));
                        p10.setCountry("India");
                        p10.setPincode(Postal.get(randomIndex(Postal.size())));
                        p10.setPhone(PhoneNumber.get(randomIndex(PhoneNumber.size())));
                        p10.setMobile(MobileNumber.get(randomIndex(MobileNumber.size())));
                        p10.setEmail(Email.get(randomIndex(Email.size())));
                        
                        //Putting the value in database
                        test.saveEntity(p10);
                        System.out.println("Contact of team has been added.");
                        
                        //Object of Person
                        Person p11 = new Person();
                        
                        //Converting dob into mysqlDate format
                        String date1;
                        date1 = DoB.get(randomIndex(DoB.size()));
                        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
                        Date parsed1 = format1.parse(date1);
                        java.sql.Date sql1 = new java.sql.Date(parsed1.getTime());
                        
                        //Setting all the information in Person field
                        p11.setFirstName(FirstName.get(randomIndex(FirstName.size())));
                        p11.setLastName(LastName.get(randomIndex(LastName.size())));
                        p11.setDob(sql1);
                        p11.setContactId(p10);
                        
                        //Putting the value in Database
                        test.saveEntity(p11);
                        System.out.println("Person of team has been added.");
                        
                        //For hire date in team member
                        String date2;
                        date2 = CreationDate.get(randomIndex(CreationDate.size()));
                        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
                        Date parsed2 = format2.parse(date2);
                        java.sql.Date sql2 = new java.sql.Date(parsed2.getTime());
                        
                        //For remark
                        String remark;
                        remark = "Remarks-" + randomIndex(1000);
                        //Adding the teamMember data in database
                        TeamMember p13 = new TeamMember();
                        
                        //Setting all the information of team Member
                        p13.setPersonId(p11);
                        p13.setTeamId(p1);
                        p13.setSalary(randomSalary());
                        p13.setHireDate(sql2);
                        p13.setRole("Player");
                        p13.setRemarks(remark);
                        
                        //Putting the value in database
                        test.saveEntity(p13);
                        System.out.println("Team Member of team has been added.");
                        
                    }
                    j1 = randomIndex(3);
                    for(int j=0;j<2 + j1;j++){           //Adding 2 - 5 managers
                        //Setting the contact for team member
                        Contact p10 = new Contact();
                        
                        //Setting all the information in the contact field by using array element with the help of random function
                        p10.setStreetAddress(StreetName.get(randomIndex(StreetName.size())));
                        p10.setCity(CityName.get(randomIndex(CityName.size())));
                        p10.setState(StateName.get(randomIndex(StateName.size())));
                        p10.setCountry("India");
                        p10.setPincode(Postal.get(randomIndex(Postal.size())));
                        p10.setPhone(PhoneNumber.get(randomIndex(PhoneNumber.size())));
                        p10.setMobile(MobileNumber.get(randomIndex(MobileNumber.size())));
                        p10.setEmail(Email.get(randomIndex(Email.size())));
                        
                        //Putting the value in database
                        test.saveEntity(p10);
                        System.out.println("Contact of team has been added.");
                        
                        //Object of Person
                        Person p11 = new Person();
                        
                        //Converting dob into mysqlDate format
                        String date1;
                        date1 = DoB.get(randomIndex(DoB.size()));
                        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
                        Date parsed1 = format1.parse(date1);
                        java.sql.Date sql1 = new java.sql.Date(parsed1.getTime());
                        
                        //Setting all the information in Person field
                        p11.setFirstName(FirstName.get(randomIndex(FirstName.size())));
                        p11.setLastName(LastName.get(randomIndex(LastName.size())));
                        p11.setDob(sql1);
                        p11.setContactId(p10);
                        
                        //Putting the value in Database
                        test.saveEntity(p11);
                        System.out.println("Person of team has been added.");
                        
                        //For hire date in team member
                        String date2;
                        date2 = CreationDate.get(randomIndex(CreationDate.size()));
                        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
                        Date parsed2 = format2.parse(date2);
                        java.sql.Date sql2 = new java.sql.Date(parsed2.getTime());
                        
                        //For remark
                        String remark;
                        remark = "Remarks-" + randomIndex(1000);
                        //Adding the teamMember data in database
                        TeamMember p13 = new TeamMember();
                        
                        //Setting all the information of team Member
                        p13.setPersonId(p11);
                        p13.setTeamId(p1);
                        p13.setSalary(randomSalary());
                        p13.setHireDate(sql2);
                        p13.setRole("Manager");
                        p13.setRemarks(remark);
                        
                        //Putting the value in database
                        test.saveEntity(p13);
                        System.out.println("Team Member of team has been added.");
                        
                    }
                    j1 = randomIndex(3);
                    for(int j=0;j< 2 + j1;j++){           //Adding 2 to 5 owners
                        //Setting the contact for team member
                        Contact p10 = new Contact();
                        
                        //Setting all the information in the contact field by using array element with the help of random function
                        p10.setStreetAddress(StreetName.get(randomIndex(StreetName.size())));
                        p10.setCity(CityName.get(randomIndex(CityName.size())));
                        p10.setState(StateName.get(randomIndex(StateName.size())));
                        p10.setCountry("India");
                        p10.setPincode(Postal.get(randomIndex(Postal.size())));
                        p10.setPhone(PhoneNumber.get(randomIndex(PhoneNumber.size())));
                        p10.setMobile(MobileNumber.get(randomIndex(MobileNumber.size())));
                        p10.setEmail(Email.get(randomIndex(Email.size())));
                        
                        //Putting the value in database
                        test.saveEntity(p10);
                        System.out.println("Contact of team has been added.");
                        
                        //Object of Person
                        Person p11 = new Person();
                        
                        //Converting dob into mysqlDate format
                        String date1;
                        date1 = DoB.get(randomIndex(DoB.size()));
                        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
                        Date parsed1 = format1.parse(date1);
                        java.sql.Date sql1 = new java.sql.Date(parsed1.getTime());
                        
                        //Setting all the information in Person field
                        p11.setFirstName(FirstName.get(randomIndex(FirstName.size())));
                        p11.setLastName(LastName.get(randomIndex(LastName.size())));
                        p11.setDob(sql1);
                        p11.setContactId(p10);
                        
                        //Putting the value in Database
                        test.saveEntity(p11);
                        System.out.println("Person of team has been added.");
                        
                        //For hire date in team member
                        String date2;
                        date2 = CreationDate.get(randomIndex(CreationDate.size()));
                        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
                        Date parsed2 = format2.parse(date2);
                        java.sql.Date sql2 = new java.sql.Date(parsed2.getTime());
                        
                        //For remark
                        String remark;
                        remark = "Remarks-" + randomIndex(1000);
                        //Adding the teamMember data in database
                        TeamMember p13 = new TeamMember();
                        
                        //Setting all the information of team Member
                        p13.setPersonId(p11);
                        p13.setTeamId(p1);
                        p13.setSalary(randomSalary());
                        p13.setHireDate(sql2);
                        p13.setRole("Owner");
                        p13.setRemarks(remark);
                        
                        //Putting the value in database
                        test.saveEntity(p13);
                        System.out.println("Team Member of team has been added.");
                        
                    }
                    j1 = randomIndex(5);
                    for(int j=0;j<=j1;j++){           //Adding 5 others
                        //Setting the contact for team member
                        Contact p10 = new Contact();
                        
                        //Setting all the information in the contact field by using array element with the help of random function
                        p10.setStreetAddress(StreetName.get(randomIndex(StreetName.size())));
                        p10.setCity(CityName.get(randomIndex(CityName.size())));
                        p10.setState(StateName.get(randomIndex(StateName.size())));
                        p10.setCountry("India");
                        p10.setPincode(Postal.get(randomIndex(Postal.size())));
                        p10.setPhone(PhoneNumber.get(randomIndex(PhoneNumber.size())));
                        p10.setMobile(MobileNumber.get(randomIndex(MobileNumber.size())));
                        p10.setEmail(Email.get(randomIndex(Email.size())));
                        
                        //Putting the value in database
                        test.saveEntity(p10);
                        System.out.println("Contact of team has been added.");
                        
                        //Object of Person
                        Person p11 = new Person();
                        
                        //Converting dob into mysqlDate format
                        String date1;
                        date1 = DoB.get(randomIndex(DoB.size()));
                        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
                        Date parsed1 = format1.parse(date1);
                        java.sql.Date sql1 = new java.sql.Date(parsed1.getTime());
                        
                        //Setting all the information in Person field
                        p11.setFirstName(FirstName.get(randomIndex(FirstName.size())));
                        p11.setLastName(LastName.get(randomIndex(LastName.size())));
                        p11.setDob(sql1);
                        p11.setContactId(p10);
                        
                        //Putting the value in Database
                        test.saveEntity(p11);
                        System.out.println("Person of team has been added.");
                        
                        //For hire date in team member
                        String date2;
                        date2 = CreationDate.get(randomIndex(CreationDate.size()));
                        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
                        Date parsed2 = format2.parse(date2);
                        java.sql.Date sql2 = new java.sql.Date(parsed2.getTime());
                        
                        //For remark
                        String remark;
                        remark = "Remarks-" + randomIndex(1000);
                        //Adding the teamMember data in database
                        TeamMember p13 = new TeamMember();
                        
                        //Setting all the information of team Member
                        p13.setPersonId(p11);
                        p13.setTeamId(p1);
                        p13.setSalary(randomSalary());
                        p13.setHireDate(sql2);
                        p13.setRole("Other");
                        p13.setRemarks(remark);
                        
                        //Putting the value in database
                        test.saveEntity(p13);
                        System.out.println("Team Member of team has been added.");
                        
                    }
                }   break;
            case "q":
                
                System.out.println("Type 1 for query 1.");
                System.out.println("Type 2 for query 2.");
                System.out.println("Type 3 for query 3.");
                
                //Storing the input 
                String type = sc.nextLine();
                switch (type) {
                    case "1":
                        System.out.println("In query 1.");
                        double min;
                        double max;
                        String teamName;
                        System.out.println("Enter the team name");
                        teamName = sc.nextLine();
                        System.out.println("Enter the minimum range of salary.");
                        min = sc.nextDouble();
                        System.out.println("Enter the maximum range of salary.");
                        max = sc.nextDouble();
                        
                        List<Person> list1;
                        list1 = test.query1(min, max, teamName);
                        System.out.println("PersonId  |  FirstName  |  LastName");
                        list1.forEach((p) -> {
                            System.out.println(p.getPersonId() + " | " + p.getFirstName() + " | " + p.getLastName());
                        });                       
                        break;
                    case "2":
                        System.out.println("In Query 2");
                        System.out.println("Enter Team Name of which you want to find rolewise Team Members.");
                        String name = sc.nextLine();
                        List<Object[]> list;
                        list = test.query2(name);
                        System.out.println("Role    | Number of members");
                        list.forEach((obj) -> {
                            System.out.println(obj[1] +" |" + "   " + obj[0]);
                        });
                        break;
                    case "3":
                        System.out.println("In query 3.");
                        String stateName;
                        System.out.println("Enter the name of the state.");
                        stateName = sc.nextLine();
                        List<Double> list3;
                        list3 = test.query3(stateName);
                        list3.forEach((Double p) -> {
                            System.out.println("The average salary is " + p);
                        });
                        
                        break;
                    default:
                        System.out.println("Please Enter a valid query.");
                        break;
                }
                break;
            default:
                System.out.println("Please give a valid input.");
                break;
        }
    }    
}
