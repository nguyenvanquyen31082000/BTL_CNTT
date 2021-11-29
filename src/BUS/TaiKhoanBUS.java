/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DTO.TaiKhoan;
import DTO.ThiSinh;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Audd
 */
public class TaiKhoanBUS {
    public static TaiKhoan a;
    public static boolean getLogin(String userName, String passWord) throws SQLException{
         String query = "{ call get_taikhoan(?, ?)}";
         a = DAL.TaiKhoanDAL.getLogin(userName, passWord, query);
         return a != null;
    }
    
    public static void getAllTaiKhoan(JTable jTable) throws SQLException{
        String query = "{ call get_all_thisinh()}";
        String query1 = "{ call get_a_taikhoan(?)}";
        ArrayList<ThiSinh> li = DAL.ThiSinhDAL.getAllThiSinhs(query);
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        BUS.UtilityClass.clearRowJTable(jTable);
        for (ThiSinh b : li) {
            if (DAL.TaiKhoanDAL.searchTaiKhoan(b.getCmtnd(), query1) == null){
                model.addRow(new Object[]{
                    b.getID(), b.getHoTen(), b.getCmtnd(), "Không"
                });
            } else {
                model.addRow(new Object[]{
                    b.getID(), b.getHoTen(), b.getCmtnd(), "Có"
                });
            }
        }
    }
    
    public static void insertTaiKhoan(String id){
        String query = "{ call insert_taikhoan(?,?,?)}";
        String pass = id + "aA@";
        String quyenHan = "USER";
        TaiKhoan b = new TaiKhoan(id, pass, quyenHan);
        DAL.TaiKhoanDAL.actionTaiKhoan(b, query);
    }
    
    public static void updateTaiKhoan(TaiKhoan b){
        String query = "{ call update_taikhoan(?,?,?)}";
        DAL.TaiKhoanDAL.actionTaiKhoan(b, query);
    }
    
    public static void searchTaiKhoan(JTable jTable, String id) throws SQLException{
        String query = "{ call get_a_thisinh(?)}";
        String query1 = "{ call get_a_taikhoan(?)}";
        ThiSinh b = DAL.ThiSinhDAL.getThiSinh(id, query);
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        BUS.UtilityClass.clearRowJTable(jTable);
        if(DAL.TaiKhoanDAL.searchTaiKhoan(b.getCmtnd(), query1) == null){
            model.addRow(new Object[]{
                b.getID(), b.getHoTen(), b.getCmtnd(), "Không"
            });
        } else {
            model.addRow(new Object[]{
                b.getID(), b.getHoTen(), b.getCmtnd(), "Có"
            });
        }

    }
    
    public static void deleteTaiKhoan(String id){
        String query = "{ call delete_taikhoan(?)}";
        DAL.TaiKhoanDAL.deleteTaiKhoan(id, query);
    }
    
    public static void searchTaiKhoan1(String id,JTextField uName, JTextField uPass){
        String query = "{ call get_a_taikhoan(?)}";
        TaiKhoan b = DAL.TaiKhoanDAL.searchTaiKhoan(id, query);
        uName.setText(b.getUserName());
        uPass.setText(b.getPassWord());
    }
    
    public static TaiKhoan findById(String id){
        String query = "{ call get_a_taikhoan(?)}";
        return DAL.TaiKhoanDAL.searchTaiKhoan(id, query);
    }
}
