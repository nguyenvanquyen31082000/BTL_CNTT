/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.TaiKhoan;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Audd
 */
public class TaiKhoanDAL {
    public static TaiKhoan getLogin(String userName, String passWord, String query) throws SQLException{
        try (
                Connection conn = DAL.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
        ){
            pstmt.setString(1, userName);
            pstmt.setString(2, passWord);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                TaiKhoan a = new TaiKhoan();
                a.setUserName(rs.getString("ID_TaiKhoan"));
                a.setPassWord(rs.getString("MatKhau"));
                a.setQuyenHan(rs.getString("QuyenHan"));
                return a;
            }
        }       
        return null;      
    }   
    
        public static TaiKhoan searchTaiKhoan(String id, String query){
        try (
                Connection conn = DAL.getConnection();
                CallableStatement pstmt = conn.prepareCall(query);
        ){
            pstmt.setString(1, id);
            
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                TaiKhoan a = new TaiKhoan();
                a.setUserName(rs.getString("ID_TaiKhoan"));
                a.setPassWord(rs.getString("MatKhau"));
                a.setQuyenHan(rs.getString("QuyenHan"));
                return a; 
            }           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }    
    
    public static void actionTaiKhoan(TaiKhoan a, String query){
        try (
                Connection conn = DAL.getConnection();
                CallableStatement pstmt = conn.prepareCall(query);
        ){
            pstmt.setString(1, a.getUserName());
            pstmt.setString(2, a.getPassWord());
            pstmt.setString(3, a.getQuyenHan());
            
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public static void deleteTaiKhoan(String id, String query){
        try (
                Connection conn = DAL.getConnection();
                CallableStatement pstmt = conn.prepareCall(query);
        ){
            pstmt.setString(1, id);
            
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
