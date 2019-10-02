package stock;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class UserClass  {
	
	private Scanner scan;
	public Connection connect;
	public PreparedStatement ps;
	public static String currentUserName="";
	public ResultSet rs; 
	public Statement smt;
	boolean passWordAcceptance;
	PassWordValidator pwdobj;
	private String enteredUserName=" ",enteredPassWord=" ",enteredName=" ",enteredEmail=" ";
	UserClass(Scanner sc){
		try {
			this.scan=sc;
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
	 connect=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","7373");  
			  		
		
		    
		ps=connect.prepareStatement("insert into  VENKAT.USER_DETAILS values(?,?,?,?)");
		  
		smt=connect.createStatement();
		  
		rs=smt.executeQuery("select * from VENKAT.USER_DETAILS");
		 PassWordValidator pwdobj=new PassWordValidator();	
			 
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
UserClass(Connection con){
		
	
	}
	
public void userLogin() {
	
	System.out.println("\t\t\t\t\t\t\tLogin");

	System.out.println("Enter Your User Name:");

    scan.nextLine();
    enteredUserName=scan.nextLine();
   System.out.println("Enter your Password:");
    enteredPassWord=scan.nextLine();
    try {
		while(rs.next()) {
		if(enteredUserName.equals(rs.getString(2))&&enteredPassWord.equals(rs.getString(3))) {
			currentUserName=rs.getString(2);
			System.out.println("\t\t\t\t\tLogin Successfull");
			break; 
		}
		
		
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    
} 
public void userSignUp() {
	System.out.println("\t\t\t\t\t\t\tSign Up");
	System.out.println("Enter Your Name:");
	scan.nextLine();
    enteredName=scan.nextLine();
	System.out.println("Enter your UserName:");
    enteredUserName=scan.nextLine();
	do{System.out.println("Enter your Password:");
    enteredPassWord=scan.nextLine();
   
    passWordAcceptance=pwdobj.validate(enteredPassWord);
    }
	while(passWordAcceptance==false);
    System.out.println(passWordAcceptance);
	System.out.println("Enter your Email:");
    enteredEmail=scan.nextLine();
    try {
		ps.setString(1,enteredName);
		ps.setString(2,enteredUserName);
		ps.setString(3,enteredPassWord);
		ps.setString(4,enteredEmail);
		int status= ps.executeUpdate();
		if (status==1) {
		System.out.println("\t\t\t\tYou Signed Up Successfully");	
		} 
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
