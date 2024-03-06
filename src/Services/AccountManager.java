package Services;

import Models.Cashier;
import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class AccountManager {
	private static final String HASH_ALGORITHM = "SHA-256";
    public static Cashier getUserByUsername(String username) {
        try {
            Connection sqlConnection = DBManager.getConnection();
            PreparedStatement sqlStatement = sqlConnection.prepareStatement("SELECT * FROM Cashier_Accounts WHERE login_username = ?");
            sqlStatement.setString(1, username);
            ResultSet queryResults = sqlStatement.executeQuery();
            if (queryResults.next()) {
                return new Cashier(queryResults.getInt(1), queryResults.getString(2), queryResults.getString(3), queryResults.getString(4));
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static String getUsernameByID(int cashierID) {
        try {
            Connection sqlConnection = DBManager.getConnection();
            PreparedStatement sqlStatement = sqlConnection.prepareStatement("SELECT * FROM Cashier_Accounts WHERE cashier_id = ?;");
            sqlStatement.setInt(1, cashierID);
            ResultSet queryResults = sqlStatement.executeQuery();
            queryResults.next();
            return queryResults.getString(2);
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean checkForMatch(String username, String inputPassword) {
        try {
            Connection sqlConnection = DBManager.getConnection();
            PreparedStatement sqlStatement = sqlConnection.prepareStatement(
                   "SELECT login_password FROM `point-of-system`.Cashier_Accounts WHERE login_username = ?");
            sqlStatement.setString(1, username);

            ResultSet resultSet = sqlStatement.executeQuery();

            if (resultSet.next()) {
                // Retrieve the stored hashed password from the result set as a string
                String storedHashedPassword = resultSet.getString("login_password");

                // Debug statement to print the retrieved hashed password
                System.out.println("Retrieved Hashed Password: " + storedHashedPassword);

                // Verify the input password against the stored hashed password
                boolean passwordMatch = verifyPassword(inputPassword, storedHashedPassword);

                // Print information for testing
                System.out.println("Input Password: " + inputPassword);
                System.out.println("Stored Hashed Password: " + storedHashedPassword);
                System.out.println("Verification Result: " + passwordMatch);

                return passwordMatch;
            } else {
                // No matching username found
                System.out.println("No matching username found.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }



    private static boolean verifyPassword(String inputPassword, String storedHashedPassword) {
        try {
            MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
            byte[] encodedHash = digest.digest(inputPassword.getBytes());

            // Convert the byte array to a hex string for comparison
            StringBuilder hexStringBuilder = new StringBuilder(2 * encodedHash.length);
            for (byte b : encodedHash) {
                hexStringBuilder.append(String.format("%02x", b & 0xFF));
            }
            String inputHashedPassword = hexStringBuilder.toString();

            // Print details for testing
            System.out.println("Input Hashed Password: " + inputHashedPassword);
            System.out.println("Stored Hashed Password: " + storedHashedPassword);

            // Compare the input hashed password with the stored hashed password
            return inputHashedPassword.equals(storedHashedPassword);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void recordNewUser(String lname, String username, String password) {
        try {
            // Hash the password before storing it
            String hashedPassword = hashPassword(password);

            // Debug statement to print the hashed password
            System.out.println("Hashed Password: " + hashedPassword);

            Connection sqlConnection = DBManager.getConnection();
            PreparedStatement sqlStatement = sqlConnection.prepareStatement(
                    "INSERT INTO Cashier_Accounts (cashier_lname, login_username, login_password)" +
                            "VALUES (?, ?, ?)");
            sqlStatement.setString(1, lname);
            sqlStatement.setString(2, username);
            sqlStatement.setString(3, hashedPassword);  // Store the hashed password as a string
            sqlStatement.execute();
            sqlConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    private static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
            byte[] encodedHash = digest.digest(password.getBytes());

      
            StringBuilder hexStringBuilder = new StringBuilder(2 * encodedHash.length);
            for (byte b : encodedHash) {
                hexStringBuilder.append(String.format("%02x", b & 0xFF));
            }
            return hexStringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
