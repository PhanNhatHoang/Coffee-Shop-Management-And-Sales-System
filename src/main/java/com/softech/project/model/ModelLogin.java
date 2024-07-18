/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.project.model;

/**
 *
 * @author ADMIN
 */
public class ModelLogin {
    private  String username , password, drinkAndFood, Name;
    private int sizeM, sizeL, Sl, Gia;
    private byte[]image ; 
    public ModelLogin() {
    }

    public ModelLogin(String Name, int Sl, int Gia) {
        this.Name = Name;
        this.Sl = Sl;
        this.Gia = Gia;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int Gia) {
        this.Gia = Gia;
    }

    public int getSl() {
        return Sl;
    }

    public void setSl(int Sl) {
        this.Sl = Sl;
    }

    public ModelLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ModelLogin(String drinkAndFood, int sizeL, byte[] image) {
        this.drinkAndFood = drinkAndFood;
        this.sizeL = sizeL;
        this.image = image;
    }

    public String getDrinkAndFood() {
        return drinkAndFood;
    }

    public void setDrinkAndFood(String drinkAndFood) {
        this.drinkAndFood = drinkAndFood;
    }

    public int getSizeM() {
        return sizeM;
    }

    public void setSizeM(int sizeM) {
        this.sizeM = sizeM;
    }

    public int getSizeL() {
        return sizeL;
    }

    public void setSizeL(int sizeL) {
        this.sizeL = sizeL;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
    
}
