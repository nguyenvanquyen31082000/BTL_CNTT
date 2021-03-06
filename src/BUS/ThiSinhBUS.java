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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Audd
 */
public class ThiSinhBUS {

    public static void getAllThiSinhs(JTable jTable) throws SQLException {
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

    public static ArrayList<ThiSinh> getAllThiSinhsBaoCao() throws SQLException {
        String query = "{ call get_all_thisinh()}";
        ArrayList<ThiSinh> li = DAL.ThiSinhDAL.getAllThiSinhs(query);
        return li;
    }

    public static void insertThiSinh(ThiSinh a) {
        String query = "{ call insert_thisinh(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        DAL.ThiSinhDAL.actionThiSinh(a, query);
    }

    public static void updateThiSinh(ThiSinh a) {
        String query = "{ call update_thisinh(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        DAL.ThiSinhDAL.actionThiSinh(a, query);
    }

    public static void deleteThiSinh(ThiSinh a) throws Exception{
        String query = "{ call delete_thisinh(?)}";
        DAL.ThiSinhDAL.deleteThiSinh(a, query);
    }

    public static void getThiSinh(JTable jTable, String id, JPanel jPanel) {
        String query = "{ call get_thisinh(?)}";
        ThiSinh a = DAL.ThiSinhDAL.getThiSinh(id, query);
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        if (a != null) {
            BUS.UtilityClass.clearRowJTable(jTable);
            String ngaySinh = a.getNgaySinh().substring(0, 11);
            model.addRow(new Object[]{
                a.getID(), a.getHoTen(), a.getDiaChi(), a.getNoiSinh(), a.getCmtnd(), a.getGioiTinh(), ngaySinh, a.getSoDienThoai(), a.getEmail(), a.getUuTien()
            });
        } else {
            JOptionPane.showMessageDialog(jPanel, "Th?? Sinh Kh??ng T???n T???i", "Th??ng B??o", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void searchThiSinh(JComboBox bGioiTinh, JComboBox bNoiSinh, JComboBox bUuTien, JTable jTable) {
        String query = "select * from thisinh where GioiTinh like concat(\"%\",?,\"%\") and NoiSinh like concat(\"%\",?,\"%\") and UuTien_ID like concat(\"%\",?,\"%\")  order by CAST(Id_thisinh AS UNSIGNED) asc";
        String gioiTinh = "";
        if (!bGioiTinh.getSelectedItem().toString().equals("<T???t C???>")) {
            gioiTinh = bGioiTinh.getSelectedItem().toString();
        }
        String noiSinh = "";
        if (!bNoiSinh.getSelectedItem().toString().equals("<T???t C???>")) {
            noiSinh = bNoiSinh.getSelectedItem().toString();
        }
        String uuTien = "";
        if (!bUuTien.getSelectedItem().toString().equals("<T???t C???>")) {
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

    public static ArrayList<ThiSinh> searchThiSinhBaoCao(JTextField jId, JComboBox bGioiTinh, JComboBox bNoiSinh, JComboBox bUuTien) {
        String query = "select * from thisinh where ID_ThiSinh like concat(\"%\",?,\"%\") and   GioiTinh like concat(\"%\",?,\"%\") and NoiSinh like concat(\"%\",?,\"%\") "
                + "and UuTien_ID like concat(\"%\",?,\"%\")  order by CAST(Id_thisinh AS UNSIGNED) asc";
        String gioiTinh = "";
        if (!bGioiTinh.getSelectedItem().toString().equals("<T???t C???>")) {
            gioiTinh = bGioiTinh.getSelectedItem().toString();
        }
        String noiSinh = "";
        if (!bNoiSinh.getSelectedItem().toString().equals("<T???t C???>")) {
            noiSinh = bNoiSinh.getSelectedItem().toString();
        }
        String uuTien = "";
        if (!bUuTien.getSelectedItem().toString().equals("<T???t C???>")) {
            uuTien = bUuTien.getSelectedItem().toString();
        }
        String id = "";
        if (jId.getText() != null && !"".equals(jId.getText())) {
            id = jId.getText().trim();
        }
        ArrayList<ThiSinh> li = DAL.ThiSinhDAL.searchThiSinhsBaoCao(id, gioiTinh, noiSinh, uuTien, query);
        return li;
    }

    public static ThiSinh findById(String id) {
        String query = "{ call get_thisinh(?)}";
        return DAL.ThiSinhDAL.getThiSinh(id, query);
    }

    public static ThiSinh getAThiSinh(String id) {
        String query = "{ call get_a_thisinh(?)}";
        return DAL.ThiSinhDAL.getThiSinh(id, query);
    }

    public static String getSeqThiSinh() {
        String query = "  SELECT auto_increment as Id FROM information_schema.tables WHERE table_name='thisinh_seq';";
        return DAL.ThiSinhDAL.getSeqThiSinh(query);
    }
}
