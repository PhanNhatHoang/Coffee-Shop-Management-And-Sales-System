/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.project.dao;

import com.softech.project.helper.helper;
import com.softech.project.model.ModelLogin;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.rowset.serial.SerialBlob;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class DaoQl_Menu {

    public boolean insert(ModelLogin mdl) throws ClassNotFoundException, SQLException {
        String sql = "insert into menu(Drink_And_Food, sizeM, sizeL,image) values(?,?,?,?)";

        try (
                 Connection con = helper.openConnection();  PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setString(1, mdl.getDrinkAndFood());
            pstmt.setInt(2, mdl.getSizeM());
            pstmt.setInt(3, mdl.getSizeL());
            if (mdl.getImage() != null) {
                Blob image = new SerialBlob(mdl.getImage());
                pstmt.setBlob(4, image);
            } else {
                Blob image = null;
                pstmt.setBlob(4, image);
            }
            return pstmt.executeUpdate() > 0;
        }
    }

    public boolean update(ModelLogin mdl) throws ClassNotFoundException, SQLException {
        String sql = "update menu set sizeM = ?, sizeL = ?, image = ? "
                + "  where Drink_And_Food = ? ";
        try (
                 Connection con = helper.openConnection();  PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setString(4, mdl.getDrinkAndFood());
            pstmt.setInt(1, mdl.getSizeM());
            pstmt.setInt(2, mdl.getSizeL());
            if (mdl.getImage() != null) {
                Blob image = new SerialBlob(mdl.getImage());
                pstmt.setBlob(3, image);
            } else {
                Blob image = null;
                pstmt.setBlob(3, image);
            }
            return pstmt.executeUpdate() > 0;
        }
    }

    public boolean delete(String drinkAndFood) throws ClassNotFoundException, SQLException {
        String sql = "delete from menu where Drink_And_Food = ? ";

        try (
                 Connection con = helper.openConnection();  PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1, drinkAndFood);
            return pstmt.executeUpdate() > 0;
        }
    }

    public ModelLogin findDrinkAndFood(String DrinkAndFood) throws SQLException, ClassNotFoundException {
        String sql = "select*from menu where Drink_And_Food = ?";
        try (
                 Connection con = helper.openConnection();  PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1, DrinkAndFood);
            try ( ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    ModelLogin mdl = createMenu(rs);
                    return (mdl);
                }
            }
            return null;
        }
    }

    private ModelLogin createMenu(final ResultSet rs) throws SQLException {
        ModelLogin mdl = new ModelLogin();
        
        mdl.setDrinkAndFood(rs.getString("Drink_And_Food"));
        mdl.setSizeM(rs.getInt("sizeM"));
        mdl.setSizeL(rs.getInt("sizeL"));
        Blob blob = rs.getBlob("image");
        if (blob != null) 
        mdl.setImage(blob.getBytes(1, (int) blob.length())); 
        return mdl;
    }

    public List<ModelLogin> findAll() throws SQLException, ClassNotFoundException {
        String sql = "select*from menu";
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

}
