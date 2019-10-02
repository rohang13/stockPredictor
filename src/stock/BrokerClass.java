package stock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
   
public class BrokerClass {
	private Scanner scan;
	public Connection connect;
	public PreparedStatement ps;
	public ResultSet rs; 
	public Statement smt;
	public BrokerClass(Scanner sc) {
		try {
			this.scan=sc;
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
		 connect=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","7373");  
			  		
		
		    
		ps=connect.prepareStatement("insert into  VENKAT.USER_DETAILS values(?,?,?,?)");
		  
		smt=connect.createStatement();
		  
		rs=smt.executeQuery("select * from VENKAT.STOCK_DETAILS");
					
			 
		}catch (SQLException sq) {
			// TODO Auto-generated catch block
			System.out.println("Error while Getting user Details");
			sq.printStackTrace();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error while Getting user Details");
			e.printStackTrace();
		}
		
	}
	public void viewStockDetails(){

		System.out.println("STOCK_ID  STOCK_EXCHANGE_TYPE  STOCKNAME  PRICE  NO_OF_STOCKS_BOUGHT STOCK_HOLDER_NAME   DATE_OF_CHANGE");
		try {
			while(rs.next())
			{
				System.out.print(rs.getInt(1));
				System.out.print("\t\t"+rs.getString(2));
				System.out.print("\t\t"+rs.getString(3));
				System.out.print("\t"+"  "+rs.getInt(4));
				System.out.print("\t\t"+rs.getInt(5));
				System.out.print("\t\t"+rs.getString(6));
				System.out.print("\t"+"  "+rs.getDate(7));
				System.out.println("");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
//package stock;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.Scanner;
//
//
//public class UserClass implements Runnable {
//	
//	private Scanner scan;
//	public Connection connect;
//	public PreparedStatement ps;
//	public static String currentUserName="";
//	public ResultSet rs; 
//	public Statement smt;
//	
//	private String enteredUserName=" ",enteredPassWord=" ",enteredName=" ",enteredEmail=" ";
//	UserClass(Scanner sc){
//		try {
//			this.scan=sc;
//			Class.forName("oracle.jdbc.driver.OracleDriver");  
//			  
//		Connection connect=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","7373");  
//			  		
//		
//		    
//		ps=connect.prepareStatement("insert into  VENKAT.USER_DETAILS values(?,?,?,?)");
//		  
//		smt=connect.createStatement();
//		  
//		rs=smt.executeQuery("select * from VENKAT.USER_DETAILS");
//					
//			 
//		}catch (SQLException sq) {
//			// TODO Auto-generated catch block
//			System.out.println("Error while Getting user Details");
//			sq.printStackTrace();
//		}
//		catch (Exception e) {
//			// TODO Auto-generated catch block
//			System.out.println("Error while Getting user Details");
//			e.printStackTrace();
//		}
//		
//	}
//
//	
//public void userLogin() {
//	
//	System.out.println("\t\t\t\t\t\t\tLogin");
//	scan.nextLine();
//	System.out.println("Enter Your User Name:");
//    enteredUserName=scan.nextLine();
//   System.out.println("Enter your Password:");
//    enteredPassWord=scan.nextLine();
//    try {
//		while(rs.next()) {
//		if(enteredUserName.equals(rs.getString(2))&&enteredPassWord.equals(rs.getString(3))) {
//			currentUserName=rs.getString(2);
//			System.out.println("\t\t\t\t\tLogin Successfull");
//			break; 
//		}
//		else {
//			System.out.println("\t\t\t\t\tInvaild USERNAME or PASSWORD\n Try Again:");
//			userLogin();
//		}
//		if(currentUserName!="") {
//			
//		}
//		}
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//    
//    
//} 
//public void userSignUp() {
//	System.out.println("\t\t\t\t\t\t\tSign Up");
//	System.out.println("Enter Your Name:");
//	scan.nextLine();
//    enteredName=scan.nextLine();
//	System.out.println("Enter your UserName:");
//    enteredUserName=scan.nextLine();
//	System.out.println("Enter your Password:");
//    enteredPassWord=scan.nextLine();
//	System.out.println("Enter your Email:");
//    enteredEmail=scan.nextLine();
//    try {
//		ps.setString(1,enteredName);
//		ps.setString(2,enteredUserName);
//		ps.setString(3,enteredPassWord);
//		ps.setString(4,enteredEmail);
//		int status= ps.executeUpdate();
//		if (status==1) {
//		System.out.println("\t\t\t\tYou Signed Up Successfully");	
//		} else {
//			System.out.println("Plese Enter Details Correctly:-");
//			userSignUp();
//		}
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
//
//	
//}
//	
//
//
//
//}
//
