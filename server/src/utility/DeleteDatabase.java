package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteDatabase extends DatabaseController{

	private String username, password;

	public DeleteDatabase() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.username  = "root";
		this.password ="P@ssw0rd";
	}
	
	public void deleteDB(String dbName) {
		String query = "DELETE From " + dbName;
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db", username, password);
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}
	
	
}
