/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.BaoCaoDiemDto;
import DTO.DiemThi;
import DTO.MonThi;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Audd
 */
public class DiemDAL {
    public static ArrayList<DiemThi> getAllDiems(String query){
        ArrayList<DiemThi> li = new ArrayList<>();
        try (
                Connection conn = DAL.getConnection();
                CallableStatement pstmt = conn.prepareCall(query);
        ){
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {                
                DiemThi a = new DiemThi();
                a.setIdThiSinh(rs.getString("ID_ThiSinh"));
                a.setIdMonHoc(rs.getString("ID_MonThi"));
                a.setDiem(rs.getFloat("Diem"));
                a.setCumThi(rs.getString("CumThi"));
                a.setNamThi(rs.getString("NamThi"));
                li.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return li;
    }
    
    public static void actionDiem(DiemThi a, String query){
        try (
                Connection conn = DAL.getConnection();
                CallableStatement pstmt = conn.prepareCall(query);
                
        ){
            pstmt.setString(1, a.getIdThiSinh());
            pstmt.setString(2, a.getIdMonHoc());
            pstmt.setFloat(3, a.getDiem());
            pstmt.setString(4, a.getCumThi());
            pstmt.setString(5, a.getNamThi());
            
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
       
    public static void deleteDiem(String id, String idMonHoc, String query){
        try (
                Connection conn = DAL.getConnection();
                CallableStatement pstmt = conn.prepareCall(query);
                
        ){
            pstmt.setString(1, id);
            pstmt.setString(2, idMonHoc);
            
            pstmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }
    
    public static ArrayList<DiemThi> searchDiem(String id, float diem, String namThi, String query){
        ArrayList<DiemThi> li = new ArrayList<>();
        try (
                Connection conn = DAL.getConnection();
                CallableStatement pstmt = conn.prepareCall(query);
        ){
            pstmt.setString(1, id);
            pstmt.setFloat(2, diem);
            pstmt.setString(3, namThi);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {                
                DiemThi a = new DiemThi();
                a.setIdThiSinh(rs.getString("ID_ThiSinh"));
                a.setIdMonHoc(rs.getString("ID_MonThi"));
                a.setDiem(rs.getFloat("Diem"));
                a.setCumThi(rs.getString("CumThi"));
                a.setNamThi(rs.getString("NamThi"));
                li.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return li;
    }
    
    public static ArrayList<DiemThi> getDiem(String id, String query){
        ArrayList<DiemThi> li = new ArrayList<>();
        try (
                Connection conn = DAL.getConnection();
                CallableStatement pstmt = conn.prepareCall(query);
        ){
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                DiemThi a = new DiemThi();
                a.setIdThiSinh(rs.getString("ID_ThiSinh"));
                a.setIdMonHoc(rs.getString("ID_MonThi"));
                a.setDiem(rs.getFloat("Diem"));
                a.setCumThi(rs.getString("CumThi"));
                a.setNamThi(rs.getString("NamThi"));
                li.add(a);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return li;
    }
    
    public static MonThi getMonThi(String id, String query){
        try (
                Connection conn = DAL.getConnection();
                CallableStatement pstmt = conn.prepareCall(query);
        ){
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                MonThi a = new MonThi();
                a.setId(rs.getString("ID_MonThi"));
                a.setTenMon(rs.getString("TenMon"));
                return a;
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    public static DiemThi findById(String id, String idMon, String query){
        try (
                Connection conn = DAL.getConnection();
                CallableStatement pstmt = conn.prepareCall(query);
        ){
            pstmt.setString(1, id);
            pstmt.setString(2, idMon);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                DiemThi a = new DiemThi();
                a.setIdThiSinh(rs.getString("ID_ThiSinh"));
                a.setIdMonHoc(rs.getString("ID_MonThi"));
                a.setDiem(rs.getFloat("Diem"));
                a.setCumThi(rs.getString("CumThi"));
                a.setNamThi(rs.getString("NamThi"));
                return a;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public static ArrayList<BaoCaoDiemDto> searchDiemBaoCao(String id, String monthi, String namThi,String type, String query){
        ArrayList<BaoCaoDiemDto> li = new ArrayList<>();
        try (
                Connection conn = DAL.getConnection();
                CallableStatement pstmt = conn.prepareCall(query);
        ){
            pstmt.setString(1, id);
            if("1".equals(type)){
                pstmt.setString(2, monthi);
                pstmt.setString(3, namThi);
            }
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {                
                BaoCaoDiemDto a = new BaoCaoDiemDto();
                a.setIdThiSinh(rs.getString(1));
                a.setHoten(rs.getString(2));
                a.setCmnd(rs.getString(3));
                a.setIdMonThi(rs.getString(4));
                a.setTenmon(rs.getString(5));
                a.setDiem(rs.getString(6));
                a.setCumThi(rs.getString(7));
                a.setNamThi(rs.getString(8));
                li.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return li;
    }
}
