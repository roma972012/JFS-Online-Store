package application;

import java.sql.*;



public class Connectivity {
	public Connection connection;
	
	public Connection getConnection() {
		 String dbName = "register";
		 String userName = "root";
		 String password = "";
		 
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");	
		connection = DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,userName,password);	
		
		}catch (Exception e) {
			e.printStackTrace();
			}
		 return connection;
	}

}














































/*private static final String userName = "root";
private static final String password = "";
private static final String url = "jdbc:mysql://localhost/explorecalifornia";

public static Connection getConnection() {
		
Connection connec = null;

try {
	connec = DriverManager.getConnection(url,userName,password);

} catch (SQLException e) {
	System.err.println(e);
}

return connec;
}
*/





