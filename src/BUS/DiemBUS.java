/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DTO.DiemThi;
import DTO.MonThi;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Audd
 */
public class DiemBUS {
    public static void getAllDiems(JTable jTable){
        String query = "{ call get_all_diem()}";
        String query1 = "{ call get_mon(?)}";
        ArrayList<DiemThi> li = DAL.DiemDAL.getAllDiems(query);
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        BUS.UtilityClass.clearRowJTable(jTable);
        li.forEach((a) -> {
            MonThi b = DAL.DiemDAL.getMonThi(a.getIdMonHoc(), query1);
            model.addRow(new Object[]{
                a.getIdThiSinh(), b.getTenMon(), a.getDiem(), a.getCumThi(), a.getNamThi()
            });
        });
    }
    
    public static void insertDiem(DiemThi a){
         String query = "{ call insert_diem(?, ?, ?, ?, ?)}";
         DAL.DiemDAL.actionDiem(a, query);
    }
    
    public static void updateDiem(DiemThi a){
        String query = "{ call update_diem(?, ?, ?, ?, ?)}";
        DAL.DiemDAL.actionDiem(a, query);
    }
    
    public static void deleteDiem(String id, String idMonHoc){
        String query = "{ call delete_diem(?, ?)}";
        DAL.DiemDAL.deleteDiem(id, idMonHoc, query);
    }
    
    public static void search_Diems(JTable jTable, JComboBox cbbMonThi, JComboBox cbbDiem, JComboBox cbbNamThi){
        String query = "select * from diemthi where ID_MonThi like concat(\"%\",?,\"%\") and Diem <= ? and NamThi like concat(\"%\",?,\"%\");";
        String query1 = "{ call get_mon(?)}";
        String query2 = "{ call get_idmon(?)}";
        float diem = Float.parseFloat(cbbDiem.getSelectedItem().toString());
        String monThi = "", namThi = "";
        if (!cbbMonThi.getSelectedItem().equals("<Tất Cả>")){            
            monThi = cbbMonThi.getSelectedItem().toString();
        }
        if(!cbbNamThi.getSelectedItem().equals("<Tất Cả>")){
            namThi = cbbNamThi.getSelectedItem().toString();
        }
        ArrayList<DiemThi> li;
        MonThi b = DAL.DiemDAL.getMonThi(monThi, query2);
        if(b == null){
            li = DAL.DiemDAL.searchDiem(monThi, diem, namThi, query);
        } else{
            li = DAL.DiemDAL.searchDiem(b.getId(), diem, namThi, query);      
        }        
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        BUS.UtilityClass.clearRowJTable(jTable);
        li.forEach((a) -> {
            MonThi c = DAL.DiemDAL.getMonThi(a.getIdMonHoc(), query1);
            model.addRow(new Object[]{
                a.getIdThiSinh(), c.getTenMon(), a.getDiem(), a.getCumThi(), a.getNamThi()
            });
        });       
    }
    
    public static void getDiem(String id, JTable jTable){
        String query = "{ call get_diem(?)}";
        ArrayList<DiemThi> li = DAL.DiemDAL.getDiem(id, query);
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        BUS.UtilityClass.clearRowJTable(jTable);
        li.forEach((a) -> {
            model.addRow(new Object[]{
                a.getIdThiSinh(), a.getIdMonHoc(), a.getDiem(), a.getCumThi(), a.getNamThi()
            });
        });
    }
    
    public static void xemDiem(String id, JLabel jl){
        String st = "";
        String query = "{ call get_diem(?)}";
        String query1 = "{ call get_mon(?)}";
        ArrayList<DiemThi> li = DAL.DiemDAL.getDiem(id, query);
        for (DiemThi a : li) {
            MonThi b = DAL.DiemDAL.getMonThi(a.getIdMonHoc(), query1);
            st += b.getTenMon() +": "+a.getDiem() +"        ";
        }
        jl.setText(st);
    }
    
    public static MonThi getMonThi(String id){
        String query = "{ call get_idmon(?)}";
        return DAL.DiemDAL.getMonThi(id, query);
    }
    
    public static DiemThi findById(String id, String idMon){
        String query = "{ call check_diem(?, ?)}";
        return DAL.DiemDAL.findById(id, idMon, query);
    }
}
