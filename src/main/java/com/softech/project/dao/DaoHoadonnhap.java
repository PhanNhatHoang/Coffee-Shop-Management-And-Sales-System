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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class DaoHoadonnhap {

    public boolean insert(ModelLogin mdl) throws ClassNotFoundException, SQLException {
        String sql = "insert into HoaDontamthoi(Name, Sl, Gia) values(?,?,?)";

        try (
                 Connection con = helper.openConnection();  PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setString(1, mdl.getName());
            pstmt.setInt(2, mdl.getSl());
            pstmt.setInt(3, mdl.getGia());
            
            return pstmt.executeUpdate() > 0;
        }
    }

    

    public boolean delete(String Name) throws ClassNotFoundException, SQLException {
        String sql = "delete from HoaDontamthoi where Name = ? ";

        try (
                 Connection con = helper.openConnection();  PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1, Name);
            return pstmt.executeUpdate() > 0;
        }
    }

    public ModelLogin findName(String Name) throws SQLException, ClassNotFoundException {
        String sql = "select*from HoaDontamthoi where Name = ?";
        try (
                 Connection con = helper.openConnection();  PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1, Name);
            try ( ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    ModelLogin mdl = createMenu(rs);
                    return (mdl);
                }
            }
            return null;
        }
    }

    private ModelLogin createMenu1(final ResultSet rs) throws SQLException {
        ModelLogin mdl = new ModelLogin();
        
        mdl.setDrinkAndFood(rs.getString("Name"));
        mdl.setSizeM(rs.getInt("SL"));
        mdl.setSizeL(rs.getInt("Gia"));
        return mdl;
    }

    public List<ModelLogin> findAll1() throws SQLException, ClassNotFoundException {
        String sql = "select*from HoaDontamthoi";
        try (
                 Connection con = helper.openConnection();  PreparedStatement pstmt = con.prepareStatement(sql);) {

            try ( ResultSet rs = pstmt.executeQuery()) {
                List<ModelLogin> list = new ArrayList<>();
                while (rs.next()) {

                    ModelLogin mdl = createMenu(rs);
                    list.add(mdl);
                }
                return list;
            }

        }
    }

    private ModelLogin createMenu(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
