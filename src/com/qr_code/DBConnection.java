package com.qr_code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DBConnection {

    public Connection getConnection() {
        Connection connection = null;
        System.out.println("Connection called");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "chkdsk");
        } catch (ClassNotFoundException | SQLException e) {
        }
        return connection;
    }
}
