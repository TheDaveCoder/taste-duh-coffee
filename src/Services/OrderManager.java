package Services;

import Models.Invoice;
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
                sqlStatement.setString(2, orders.get(i).getProductName());
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

    public static ArrayList<Invoice> getInvoiceAll() {
        try {
            Connection sqlConnection = DBManager.getConnection();
            PreparedStatement sqlStatement = sqlConnection.prepareStatement("SELECT Invoice.invoice_id, Invoice.invoice_date, Invoice.cashier_id, " +
                    "Cashier_Accounts.cashier_lname, Invoice.subtotal, Invoice.total_amount " +
                    "FROM Invoice " +
                    "INNER JOIN Cashier_Accounts " +
                    "ON Invoice.cashier_id = Cashier_Accounts.cashier_id;");
            ResultSet resultSet = sqlStatement.executeQuery();
            ArrayList<Invoice> invoices = new ArrayList<>();
            while(resultSet.next()) {
                invoices.add(new Invoice(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getString(4),
                        resultSet.getDouble(5),
                        resultSet.getDouble(6)));
            }
            return invoices;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Invoice getInvoiceLatest() {
        try {
            Connection sqlConnection = DBManager.getConnection();
            PreparedStatement sqlStatement = sqlConnection.prepareStatement("SELECT Invoice.invoice_id, Invoice.invoice_date, Invoice.cashier_id, " +
                    "Cashier_Accounts.cashier_lname, Invoice.subtotal, Invoice.total_amount " +
                    "FROM Invoice " +
                    "INNER JOIN Cashier_Accounts " +
                    "ON Invoice.cashier_id = Cashier_Accounts.cashier_id " +
                    "ORDER BY Invoice.invoice_id DESC LIMIT 1;");
            ResultSet resultSet = sqlStatement.executeQuery();
            resultSet.next();
            return new Invoice(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getString(4),
                    resultSet.getDouble(5),
                    resultSet.getDouble(6)
            );
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Invoice getInvoiceByID(int invoiceID) {
        try {
            Connection sqlConnection = DBManager.getConnection();
            PreparedStatement sqlStatement = sqlConnection.prepareStatement("SELECT Invoice.invoice_id, Invoice.invoice_date, Invoice.cashier_id, " +
                    "Cashier_Accounts.cashier_lname, Invoice.subtotal, Invoice.total_amount " +
                    "FROM Invoice " +
                    "INNER JOIN Cashier_Accounts " +
                    "ON Invoice.cashier_id = Cashier_Accounts.cashier_id " +
                    "WHERE Invoice.invoice_id = ?;");
            sqlStatement.setInt(1, invoiceID);
            ResultSet resultSet = sqlStatement.executeQuery();
            resultSet.next();
            return new Invoice(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getString(4),
                    resultSet.getDouble(5),
                    resultSet.getDouble(6));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static ArrayList<Sale> getSales(int invoiceID) {
        try {
            Connection sqlConnection = DBManager.getConnection();
            PreparedStatement sqlStatement = sqlConnection.prepareStatement("SELECT * FROM Sales WHERE invoice_id = ?;");
            sqlStatement.setInt(1, invoiceID);
            ResultSet resultSet = sqlStatement.executeQuery();
            ArrayList<Sale> sales = new ArrayList<>();
            while(resultSet.next()) {
                sales.add(new Sale(resultSet.getInt(1),
                        1,
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDouble(4),
                        resultSet.getInt(5),
                        resultSet.getDouble(6)
                        ));
            }
            return sales;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void deleteInvoice(int invoiceID) {
        try {
            Connection sqlConnection = DBManager.getConnection();
            PreparedStatement sqlStatement = sqlConnection.prepareStatement("DELETE FROM Invoice WHERE invoice_id = ?");
            sqlStatement.setInt(1, invoiceID);
            sqlStatement.execute();
            sqlConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

