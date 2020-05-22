package ecommerceApp;
import java.sql.*;

public class PriviledgedUser extends User {

	public PriviledgedUser(String name, String email, String pw) {
		super(name, email, pw);
		this.setRole("Admin");
	}
	
	public void changePw(User u, String newPw) {
		//TODO add changing password functionality
		String email = u.getEmail();
		String sql = "update users set password = " + "\"" + newPw + "\" where email = " +  "\"" + email + "\";";
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, userName, DBPW);
			Statement st = con.createStatement();
			int m = st.executeUpdate(sql);
			if (m == 1) {
				System.out.println("Password Successfully Updated");
				con.close();
			} else {
				System.out.println("Password updated failed");
				con.close();
			}
		} catch(Exception e) {
			System.err.println(e);
		}
	}
}
