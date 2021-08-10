package JDBC;
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class jdbcassignment extends bank {
	
	public static void main(String args[])throws SQLException
	{
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ICICBANK","root","root");
		Statement s=c.createStatement();
		
		jdbcassignment obj=new jdbcassignment();
		obj.show();

		//String sql="create database SBIBANK" ;
		//s.executeUpdate(sql); 
		//String sql2 = "create table customer_details" +
			//	"(id int not null auto_increment primary key, name varchar(50), age int not null)";
		
		//s.executeUpdate(sql2); 
		}}
class bank
{
		void createbankaccount()throws SQLException
		{
			
	Scanner scanner = new Scanner(System.in);	
	System.out.println("Enter you name: ");
	String name = scanner.nextLine();
	System.out.println("Enter you age: ");
	int age = scanner.nextInt();
	if(age<18) {
		System.out.println("Not able to open account ");
	}
	else {
	String sql3 = "insert into customer_details (name, age) values " + "( '" + name + " ',"+ age + ")";
	Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ICICBANK","root","root");
	Statement s=c.createStatement();
	
    s.executeUpdate(sql3);

   System.out.println("records inserted IN database");
	
	}
		}
		void showtable()throws SQLException
		{ 
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ICICBANK","root","root");
		  Statement s=c.createStatement();
			ResultSet rs=s.executeQuery("select * from customer_details");  
			while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
		}
		//con.close();

		void show()throws SQLException
		{
		char option='\0'; //initializing char value
		Scanner scanner=new Scanner(System.in);
		System.out.println("WELCOME TO BANK ");
		
		System.out.println("\n");
		System.out.println("A. Create Account ");
		System.out.println("B.Show Details ");
		System.out.println("C.Exit ");
		

		do {
		System.out.println("*******************************************");
		System.out.println("Enter Your Option here!!!");
		System.out.println("*******************************************");
		option=scanner.next().charAt(0); //user input for option

		System.out.println("\n");
		switch(option) {

		case 'A':
		System.out.println("____________________________________________");
		createbankaccount();
		System.out.println("____________________________________________");
		System.out.println("\n");
		break;
		case 'B':
		System.out.println("____________________________________________");
		System.out.println("The DATA is Displayed ");
		System.out.println("____________________________________________");
		showtable();   
		System.out.println("\n");
		break;

		

		case 'C':
		System.out.println("__________________________________________________");
		break;

		default:
		System.out.println("Invalid Option!!! Please Enter Again!!!");
		}

		}

		while(option!='C')	;
		System.out.println("THANK YOU FOR USING OUR SERVICES!! VISIT AGAIN!!");
		}

	
		
	}
