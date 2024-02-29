package Services;

import Models.Cashier;
import java.sql.*;

public class AccountManager {
    public static Cashier getUserByUsername(String username) {
        try {
            Connection sqlConnection = DBManager.getConnection();
            PreparedStatement sqlStatement = sqlConnection.prepareStatement("SELECT * FROM Cashier_Accounts WHERE login_username = ?");
            sqlStatement.setString(1, username);
            ResultSet queryResults = sqlStatement.executeQuery();
            if (queryResults.next()) {
                return new Cashier(queryResults.getInt(1), queryResults.getString(3), queryResults.getString(4));
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean checkForMatch(String lastName, String userName) {
        try {
            Connection sqlConnection = DBManager.getConnection();
            PreparedStatement sqlStatement = sqlConnection.prepareStatement("SELECT * FROM Cashier_Accounts WHERE cashier_lname = ? AND login_username = ?");
            sqlStatement.setString(1, lastName);
            sqlStatement.setString(2, userName);
            ResultSet resultSet = sqlStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void recordNewUser(String lname, String username, String password) {
        try {
            Connection sqlConnection = DBManager.getConnection();
            PreparedStatement sqlStatement = sqlConnection.prepareStatement(
                    "INSERT INTO Cashier_Accounts (cashier_lname, login_username, login_password)" +
                            "VALUES (?, ?, ?)");
            sqlStatement.setString(1, lname);
            sqlStatement.setString(2, username);
            sqlStatement.setString(3, password);
            sqlStatement.execute();
            sqlConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}