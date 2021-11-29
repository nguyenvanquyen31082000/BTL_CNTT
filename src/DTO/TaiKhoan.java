/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Audd
 */
public class TaiKhoan {
    private String userName, passWord, quyenHan;

    public TaiKhoan(String userName, String passWord, String quyenHan) {
        this.userName = userName;
        this.passWord = passWord;
        this.quyenHan = quyenHan;
    }

    public TaiKhoan() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getQuyenHan() {
        return quyenHan;
    }

    public void setQuyenHan(String quyenHan) {
        this.quyenHan = quyenHan;
    }
    
}
