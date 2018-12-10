package mp;

import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;

public class User extends BaseModel {	
	private String firstname;
	private String lastname;
	private String username;
	private String password;
		
	private User(int id, String firstname, String lastname, String username) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
	}
	
	public static Boolean validateUsernamePassword(String username, String password) {
		Boolean exists = false;
		try {
			String query = "SELECT * FROM users WHERE username = ? AND password = ? LIMIT 1";
			PreparedStatement ps = db.conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet res = ps.executeQuery();
			
			/*System.out.println("====INPUT======");
			System.out.println(username);
			System.out.println(password);*/
			
			while(res.next()) {
				exists = true;
				Session.setSessionId(res.getInt("id"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println("^^^^^^^^^^^^^^^^^");
		//System.out.println(exists);
		//System.out.println("^^^^^^^^^^^^^^^^^");
		return exists;
		
	}
	
	public static ArrayList<User> getUsers() {
		ArrayList<User> users = new ArrayList<User>();
		
		try {
			ResultSet res = db.query("SELECT * FROM users");
			while(res.next()) {
				User user = new User(
						res.getInt("id"),
						res.getString("firstname"),
						res.getString("lastname"),
						res.getString("username")
				);
				System.out.println(user);
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	
	public String getFirstName() {
		return this.firstname;
	}
	
	public String getLastName() {
		return this.lastname;
	}
	
	public String getUserName() {
		return this.username;
	}
	
}
