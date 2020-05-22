package ecommerceApp;
import java.sql.*;
import java.util.Scanner;
public class Driver {

	static final String URL = "jdbc:mysql://localhost:3306/ecommerceapp";
	static final String userName = "root";
	static final  String pw = "pats4life";
	
	public static void renderOptions() {
		
	System.out.println("Options: ");
	System.out.println("---------------");
	System.out.println("Press 1 to log in");
	System.out.println("Press 2 to Register a User");
	System.out.println("Press 3 to place an order");
	System.out.println("Press 4 to view previous Orers");
		
		
		
	}
	
	public static void renderAdminOptions() {
		System.out.println("Options");
		System.out.println();
		System.out.println("Press 1 to view all users");
		System.out.println("Press 2 to change a user's password");
	}
	public static void main(String[] args) throws Exception {
	
		// creating the connection
		 String URL = "jdbc:mysql://localhost:3306/ecommerceapp";
		 String userName = "root";
		 String pw = "pats4life";
	
		PriviledgedUser u1 = new PriviledgedUser("john", "john@email", "pw221");
		
		
		
		User u2 = new User("johnson", "raider@email", "pw333");
		
		
		
		
		u1.changePw(u2, "333444");

	}

}
