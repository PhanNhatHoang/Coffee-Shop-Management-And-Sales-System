/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.project.dao;

import com.softech.project.helper.helper;
import com.softech.project.model.ModelLogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DaoLogin {
     public ModelLogin findById(String username) throws ClassNotFoundException, SQLException {
        String sql = "select * from QL_DangNhap where username = ? ";

        try (
                 Connection con = helper.openConnection();  
                PreparedStatement pstmt = con.prepareStatement(sql);) 
        {
            
            pstmt.setString(1, username);
            
                
            try ( ResultSet rs = pstmt.executeQuery()) {
                
                if (rs.next()) {
                    ModelLogin ml = new ModelLogin();
                    ml.setUsername(rs.getString("username"));
                    ml.setPassword(rs.getString("password"));
                    return  ml;
                }
            }
            return null;
        }
        
    }
     public ModelLogin findByPassword(String password) throws ClassNotFoundException, SQLException {
        String sql = "select * from QL_DangNhap where password = ? ";

        try (
                 Connection con = helper.openConnection();  
                PreparedStatement pstmt = con.prepareStatement(sql);) 
        {
            
            pstmt.setString(1, password);
            
                
            try ( ResultSet rs = pstmt.executeQuery()) {
                
                if (rs.next()) {
                    ModelLogin ml = new ModelLogin();
                    ml.setPassword(rs.getString("password"));
                    return  ml;
                }
            }
            return null;
        }
        
    }
    public boolean update(ModelLogin mdl) throws ClassNotFoundException, SQLException{
        String sql = "update QL_DangNhap set password = ? ";
        try(
                 Connection con = helper.openConnection();  
                PreparedStatement pstmt = con.prepareStatement(sql);) 
                 {
            
            pstmt.setString(1, mdl.getPassword());
           
            
            return pstmt.executeUpdate()>0;
        } 
    }
}
