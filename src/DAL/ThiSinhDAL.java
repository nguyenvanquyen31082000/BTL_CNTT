/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.ThiSinh;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Audd
 */
public class ThiSinhDAL {
    public static ArrayList<ThiSinh> getAllThiSinhs(String query){
        ArrayList<ThiSinh> li = new ArrayList<>();
        try (
                Connection conn = DAL.getConnection();
                CallableStatement pstmt = conn.prepareCall(query);
            ) {           
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ThiSinh a = new ThiSinh();
                a.setID(rs.getString("ID_ThiSinh"));
                a.setHoTen(rs.getString("HoTen"));
                a.setDiaChi(rs.getString("DiaChi"));
                a.setCmtnd(rs.getString("CMND"));
                a.setNoiSinh(rs.getString("NoiSinh"));
                a.setGioiTinh(rs.getString("GioiTinh"));
                a.setNgaySinh(rs.getString("NgaySinh"));
                a.setSoDienThoai(rs.getString("SoDienThoai"));
                a.setEmail(rs.getString("Email"));
                a.setUuTien(rs.getString("UuTien_ID"));
                li.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }           
        return li;
    }
    
    public static void actionThiSinh(ThiSinh a, String query){
        try (
                Connection conn = DAL.getConnection();
                CallableStatement pstmt = conn.prepareCall(query);
            ) {
            pstmt.setString(1, a.getID());
            pstmt.setString(2, a.getHoTen());
            pstmt.setString(3, a.getNoiSinh());
            pstmt.setString(4, a.getCmtnd());
            pstmt.setString(5, a.getDiaChi());
            pstmt.setString(6, a.getGioiTinh());
            pstmt.setString(7, a.getNgaySinh());
            pstmt.setString(8, a.getSoDienThoai());
            pstmt.setString(9, a.getEmail());
            pstmt.setString(10, a.getUuTien());
            
            pstmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ThiSinhDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void deleteThiSinh(ThiSinh a, String query){
        try (
                Connection conn = DAL.getConnection();
                CallableStatement pstmt = conn.prepareCall(query);
            ) {                  
            pstmt.setString(1, a.getID());          
            pstmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ThiSinhDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ThiSinh getThiSinh(String id, String query){
        try (
                Connection conn = DAL.getConnection();
                CallableStatement pstmt = conn.prepareCall(query);
            ){          
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                ThiSinh a = new ThiSinh();
                a.setID(rs.getString("ID_ThiSinh"));
                a.setHoTen(rs.getString("HoTen"));
                a.setDiaChi(rs.getString("DiaChi"));
                a.setNoiSinh(rs.getString("NoiSinh"));
                a.setCmtnd(rs.getString("CMND"));
                a.setGioiTinh(rs.getString("GioiTinh"));
                a.setNgaySinh(rs.getString("NgaySinh"));
                a.setSoDienThoai(rs.getString("SoDienThoai"));
                a.setEmail(rs.getString("Email"));
                a.setUuTien(rs.getString("UuTien_ID"));
                return a;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThiSinhDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static ArrayList<ThiSinh> searchThiSinhs(String gioiTinh, String noiSinh, String uuTien, String query){
        ArrayList<ThiSinh> li = new ArrayList<>();       
        try (
                Connection conn = DAL.getConnection();
                CallableStatement pstmt = conn.prepareCall(query);
            ) {           
            pstmt.setString(1, gioiTinh);
            pstmt.setString(2, noiSinh);
            pstmt.setString(3, uuTien);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ThiSinh a = new ThiSinh();
                a.setID(rs.getString("ID_ThiSinh"));
                a.setHoTen(rs.getString("HoTen"));
                a.setDiaChi(rs.getString("DiaChi"));
                a.setNoiSinh(rs.getString("NoiSinh"));
                a.setCmtnd(rs.getString("CMND"));
                a.setGioiTinh(rs.getString("GioiTinh"));
                a.setNgaySinh(rs.getString("NgaySinh"));
                a.setSoDienThoai(rs.getString("SoDienThoai"));
                a.setEmail(rs.getString("Email"));
                a.setUuTien(rs.getString("UuTien_ID"));
                li.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }           
        return li;
    }
    
}