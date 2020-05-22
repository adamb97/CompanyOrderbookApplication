package ecommerceApp;

import java.sql.*;
import java.util.Scanner;


public class User {
	private String name;
	private String pw;
	private String email;
	private String role;
	private boolean loggedOn = false;
	

	static final String URL = "jdbc:mysql://localhost:3306/ecommerceapp";
	static final String userName = "root";
	static final  String DBPW = "pats4life";
	
	
	public User(String name, String email, String pw) {
		this.email = email;
		this.name = name;
		this.pw = pw;
		this.role = "Employee";
		connect();
	
	}
	
	public void connect() {
		 //entering the data
		
		String sql = "insert into users (first_name, email, password) values(\"" +this.name + "\", \"" + this.email + "\", \"" + this.pw + "\");";
		 Connection con = null;
		 try {
			con = DriverManager.getConnection(URL, userName, DBPW);
			Statement st = con.createStatement();
			int m = st.executeUpdate(sql);
			if(m==1) {
				System.out.println("Inserted successfully, " + sql);
				con.close();
			} else {
				System.out.println("insertion failed");
				con.close();
			}
		 } catch(Exception e) {
			 System.err.println(e);
		 }

	}
	
	public void logIn() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter email: ");
		String enteredEmail = sc.next();
		System.out.println("Enter Password: ");
		String enteredPw = sc.next();
		
		
		String sql = "select * from users where email = \"" + enteredEmail + "\";";
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL,  userName,  DBPW);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String retrievedPW = rs.getString("password");
				
				
				if(retrievedPW.equals(enteredPw)) {
					System.out.println("Logged On successfully");
					this.loggedOn = true;
					con.close();
				} else {
					System.out.println("Log in failed, incorrect password");
					con.close();
				}
			}
			
		} catch (Exception e) {
			System.out.println("Log in failed ");
			e.printStackTrace();
		}
		
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPw() {
		return pw;
	}



	



	public String getEmail() {
		return email;
	}



	


	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}
	
	
}
		
		

	
