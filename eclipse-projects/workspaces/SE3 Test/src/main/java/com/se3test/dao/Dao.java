package com.se3test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.se3test.exceptions.DaoException;

public class Dao {

    protected Connection getConnection() throws DaoException {

        //String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "";
        Connection con = null;
        
        try {
            //Class.forName(driver);
            con = DriverManager.getConnection(url, username, password); 
        } catch (SQLException ex) {
            System.out.println("Connection failed " + ex.getMessage());
            System.exit(2);
        }
        return con;
    }

    protected void freeConnection(Connection con) throws DaoException {
        try {
            if (con != null) {
                con.close();
                con = null;
            }
        } catch (SQLException e) {
            System.out.println("Failed to free connection: " + e.getMessage());
            System.exit(1);
        }
    }

    
}
