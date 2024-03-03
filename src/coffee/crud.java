/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffee;

import Models.*;
import Services.*;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author joshu
 */
public class crud {

    public static void main(String[] args) {
        DBManager DBManager = new DBManager();
        String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DBManager.getConnection();
            if (conn != null) {
                JOptionPane.showMessageDialog(null, "Database connected");
            }
        }
        catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error in connecting to the database:" + e);
        }
    }
 
    int addOrder() {
        return 0;
    }
    
    void getAllOrder() {
        
    }
    
    int deleteOrder() {
        return 0;
    }
 }


