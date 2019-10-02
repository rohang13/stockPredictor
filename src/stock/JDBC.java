package stock;

import java.util.Scanner;
public class JDBC {



	public static void main(String[] args)  {

	 Scanner sc=new Scanner(System.in);
	 UserClass obj=new UserClass(sc);
	 BrokerClass br=new BrokerClass(sc);


			System.out.println("Stock Management System");
			System.out.println("\n \t1.Log in as User\n\t2.Login as Broker \n\t3. New User Signup");
			System.out.println("Choose your option");


			int welcomeOption=sc.nextInt();
	switch (welcomeOption) {
	case 1:
		obj.userLogin();
		break;
	case 2:
		br.viewStockDetails();
		break;
	case 3:obj.userSignUp();
		default:
	}

	}}


		// TODO Auto-generated method stub
