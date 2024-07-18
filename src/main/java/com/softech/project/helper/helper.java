/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.project.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class helper {
    public static Connection openConnection() throws ClassNotFoundException, SQLException {
        
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://DESKTOP-OVLNOKF:1433;databaseName=project;";
            String usersname="sa";
            String password="123123";
            
            Connection con = DriverManager.getConnection(url, usersname,password);
        
        return con;
    }
}
