package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	static String endpoint = "database-1.cl85pye4up69.ap-southeast-1.rds.amazonaws.com";
	static String port = "3306";
	static String DBIdentifier = "point-of-system";
	static String masterUsername = "sf_app_admin";
	static String masterPassword = "davePogi123";

	public static Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://" + endpoint + ":" + port + "/" + DBIdentifier;
		return DriverManager.getConnection(url, masterUsername, masterPassword);
	}
	
	public static void closeConnection(Connection currConnection) throws SQLException {
		if (currConnection != null && !currConnection.isClosed()) {
			currConnection.close();
		}
	}
}
