/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DTO.ThiSinh;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Audd
 */
public class ThiSinhBUS {
    public static void getAllThiSinhs(JTable jTable) throws SQLException{        
        String query = "{ call get_all_thisinh()}";
        ArrayList<ThiSinh> li = DAL.ThiSinhDAL.getAllThiSinhs(query);
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        BUS.UtilityClass.clearRowJTable(jTable);
        for (ThiSinh a : li) {
            String ngaySinh = a.getNgaySinh().substring(0, 11);
            model.addRow(new Object[]{
                a.getID(), a.getHoTen(), a.getDiaChi(), a.getNoiSinh(), a.getCmtnd(), a.getGioiTinh(), ngaySinh, a.getSoDienThoai(), a.getEmail(), a.getUuTien()
            });
        }
    }

    public static void insertThiSinh(ThiSinh a){
        String query = "{ call insert_thisinh(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        DAL.ThiSinhDAL.actionThiSinh(a, query);
    }
    
    public static void updateThiSinh(ThiSinh a){
        String query = "{ call update_thisinh(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        DAL.ThiSinhDAL.actionThiSinh(a, query);
    }
    
    public static void deleteThiSinh(ThiSinh a){
        String query = "{ call delete_thisinh(?)}";
        DAL.ThiSinhDAL.deleteThiSinh(a, query);
    }
    
    public static void getThiSinh(JTable jTable, String id, JPanel jPanel){
        String query = "{ call get_thisinh(?)}";
        ThiSinh a = DAL.ThiSinhDAL.getThiSinh(id, query);
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        if (a != null){
            BUS.UtilityClass.clearRowJTable(jTable);
            String ngaySinh = a.getNgaySinh().substring(0, 11);
            model.addRow(new Object[]{
                a.getID(), a.getHoTen(), a.getDiaChi(), a.getNoiSinh(), a.getCmtnd(), a.getGioiTinh(), ngaySinh, a.getSoDienThoai(), a.getEmail(), a.getUuTien()
            });
        } else {
            JOptionPane.showMessageDialog(jPanel, "Thí Sinh Không Tồn Tại", "Thông Báo", JOptionPane.ERROR_MESSAGE);
        }      
    }
    
    public static void searchThiSinh(JComboBox bGioiTinh, JComboBox bNoiSinh, JComboBox bUuTien, JTable jTable){
        String query = "select * from thisinh where GioiTinh like concat(\"%\",?,\"%\") and NoiSinh like concat(\"%\",?,\"%\") and UuTien_ID like concat(\"%\",?,\"%\")";
        String gioiTinh = "";
        if(!bGioiTinh.getSelectedItem().toString().equals("<Tất Cả>")){
            gioiTinh = bGioiTinh.getSelectedItem().toString();
        }
        String noiSinh = "";
        if(!bNoiSinh.getSelectedItem().toString().equals("<Tất Cả>")){
            noiSinh = bNoiSinh.getSelectedItem().toString();
        }
        String uuTien = "";
        if(!bUuTien.getSelectedItem().toString().equals("<Tất Cả>")){
            uuTien = bUuTien.getSelectedItem().toString();
        }
        ArrayList<ThiSinh> li = DAL.ThiSinhDAL.searchThiSinhs(gioiTinh, noiSinh, uuTien, query);
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        BUS.UtilityClass.clearRowJTable(jTable);
        for (ThiSinh a : li) {
            String ngaySinh = a.getNgaySinh().substring(0, 11);
            model.addRow(new Object[]{
                a.getID(), a.getHoTen(), a.getDiaChi(), a.getNoiSinh(), a.getCmtnd(), a.getGioiTinh(), ngaySinh, a.getSoDienThoai(), a.getEmail(), a.getUuTien()
            });
        }
    }
    
    public static ThiSinh findById(String id){
        String query = "{ call get_thisinh(?)}";
        return DAL.ThiSinhDAL.getThiSinh(id, query);
    }
    
    public static ThiSinh getAThiSinh(String id){
        String query = "{ call get_a_thisinh(?)}";
        return DAL.ThiSinhDAL.getThiSinh(id, query);
    }
}
