package Services;

import Models.Sale;

import java.sql.*;
import java.util.ArrayList;

public class OrderManager {
    public static void recordInvoice(String invoiceDate, int cashierID, double subtotal, double totalAmount) {
        try {
            Connection sqlConnection = DBManager.getConnection();
            PreparedStatement sqlStatement = sqlConnection.prepareStatement("INSERT INTO Invoice (invoice_date, cashier_id, subtotal, total_amount)" +
                    "VALUES (?, ?, ?, ?)");
            sqlStatement.setString(1, invoiceDate);
            sqlStatement.setInt(2, cashierID);
            sqlStatement.setDouble(3, subtotal);
            sqlStatement.setDouble(4, totalAmount);
            sqlStatement.execute();
            sqlConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void recordSale(ArrayList<Sale> orders) {
        try {
            Connection sqlConnection = DBManager.getConnection();
            PreparedStatement sqlStatement = sqlConnection.prepareStatement("INSERT INTO Sales VALUES (?, ?, ?, ?, ?, ?)");
            for(int i = 0; i < orders.size(); i ++) {
                sqlStatement.setInt(1, orders.get(i).getInvoiceID());
                sqlStatement.setInt(2, orders.get(i).getProductID());
                sqlStatement.setString(3, orders.get(i).getSizeName());
                sqlStatement.setDouble(4, orders.get(i).getUnitPrice());
                sqlStatement.setInt(5, orders.get(i).getQuantity());
                sqlStatement.setDouble(6, orders.get(i).getAmount());
                sqlStatement.addBatch();
            }
            sqlStatement.executeBatch();
            sqlConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
