/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.ThiSinh;
import javax.swing.JOptionPane;

/**
 *
 * @author Audd
 */
public class ThongTinPanel extends javax.swing.JPanel {
    private ThiSinh a = BUS.ThiSinhBUS.getAThiSinh(BUS.TaiKhoanBUS.a.getUserName());
    /**
     * Creates new form ThongTinPanel
     */
    public ThongTinPanel() {
        initComponents();
        eror1.setVisible(false);
        eror2.setVisible(false);
        eror3.setVisible(false);
        eror3.setVisible(false);
        eror4.setVisible(false);
        eror5.setVisible(false);
        autoFillInfo();
    }

    private void autoFillInfo(){
        String[] date = a.getNgaySinh().split("-");
        cbbNamSinh.getModel().setSelectedItem(date[0]);
        cbbThangSinh.getModel().setSelectedItem(date[1]);
        cbbNgaySinh.getModel().setSelectedItem(date[2].substring(0, 2));
        txtHoTen.setText(a.getHoTen());
        txtEmail.setText(a.getEmail());
        txtDiaChi.setText(a.getDiaChi());
        txtSoDienThoai.setText(a.getSoDienThoai());
        if (a.getGioiTinh().equals("Nam")){
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
        cbbNoiSinh.getModel().setSelectedItem(a.getNoiSinh());
        cbbUuTien.getModel().setSelectedItem(a.getUuTien());
        txtCmtnd.setText(a.getCmtnd());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        cbbNgaySinh = new javax.swing.JComboBox<>();
        rdoNam = new javax.swing.JRadioButton();
        cbbNoiSinh = new javax.swing.JComboBox<>();
        txtDiaChi = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        cbbUuTien = new javax.swing.JComboBox<>();
        cbbThangSinh = new javax.swing.JComboBox<>();
        cbbNamSinh = new javax.swing.JComboBox<>();
        rdoNu = new javax.swing.JRadioButton();
        btnXacNhan = new javax.swing.JButton();
        btnDong = new javax.swing.JButton();
        eror1 = new javax.swing.JLabel();
        eror2 = new javax.swing.JLabel();
        eror3 = new javax.swing.JLabel();
        eror4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCmtnd = new javax.swing.JTextField();
        eror5 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thông Tin Cá Nhân");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Họ Tên:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Ngày Sinh:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Giới Tính:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Nơi Sinh:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Địa Chỉ:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Số Điện Thoại:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Email:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Mức Ưu Tiên:");

        txtHoTen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        cbbNgaySinh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbbNgaySinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        buttonGroup1.add(rdoNam);
        rdoNam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdoNam.setSelected(true);
        rdoNam.setText("Nam");

        cbbNoiSinh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbbNoiSinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hà Nội", "Hà Tây", "Hải Dương", "Bắc Ninh", "Hà Giang", "Hà Nam", "Lạng Sơn" }));

        txtDiaChi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtSoDienThoai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        cbbUuTien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbbUuTien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "UT1", "UT2", "KV1", "KV2-NT", "KV2", "KV3" }));

        cbbThangSinh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbbThangSinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        cbbNamSinh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbbNamSinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015" }));

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");

        btnXacNhan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnXacNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-check-mark-16.png"))); // NOI18N
        btnXacNhan.setText("Xác Nhận");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        btnDong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-close-16.png"))); // NOI18N
        btnDong.setText("Đóng");
        btnDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongActionPerformed(evt);
            }
        });

        eror1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        eror1.setForeground(new java.awt.Color(255, 0, 0));
        eror1.setText("Chỉ chứa kí tự chữ, không chứa số và kí tự đặc biệt");

        eror2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        eror2.setForeground(new java.awt.Color(255, 0, 0));
        eror2.setText("Ngày sinh ko hợp lệ");

        eror3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        eror3.setForeground(new java.awt.Color(255, 0, 0));
        eror3.setText("Chỉ chứa số");

        eror4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        eror4.setForeground(new java.awt.Color(255, 0, 0));
        eror4.setText("Sai định dạng (ex: abc@gmail.com,...)");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("CMTND:");

        txtCmtnd.setEditable(false);
        txtCmtnd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        eror5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        eror5.setForeground(new java.awt.Color(255, 0, 51));
        eror5.setText("Không được để trống");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel10))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(cbbNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cbbThangSinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cbbNamSinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(rdoNam)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(rdoNu)))
                                        .addGap(75, 75, 75)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(eror1)
                                            .addComponent(eror2)))
                                    .addComponent(txtCmtnd, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnXacNhan)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnDong))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9))
                                        .addGap(20, 20, 20)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbbNoiSinh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtDiaChi)
                                            .addComponent(txtSoDienThoai)
                                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbbUuTien, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(75, 75, 75)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(eror3)
                                    .addComponent(eror4)
                                    .addComponent(eror5))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eror1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbbNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbThangSinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbNamSinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eror2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rdoNam)
                    .addComponent(rdoNu))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtCmtnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbbNoiSinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eror5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eror3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eror4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbbUuTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXacNhan)
                    .addComponent(btnDong))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed
        ThongTinPanel.this.getParent().remove(ThongTinPanel.this);
        MainFormUser.check = 0;      
    }//GEN-LAST:event_btnDongActionPerformed

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        
        if(!BUS.UtilityClass.validDate(cbbNgaySinh, cbbThangSinh, cbbNamSinh)){
            eror2.setVisible(true);
        } else {
            eror2.setVisible(false);
            String ngaySinh = cbbNamSinh.getSelectedItem().toString() + "-" + cbbThangSinh.getSelectedItem().toString() + "-" + cbbNgaySinh.getSelectedItem().toString();
            a.setNgaySinh(ngaySinh);
        }
        String gioiTinh;
        if (rdoNam.isSelected()){
            gioiTinh = "Nam";
        } else {
            gioiTinh = "Nữ";
        }
        a.setGioiTinh(gioiTinh);
        a.setNoiSinh(cbbNoiSinh.getSelectedItem().toString());
        if(txtDiaChi.getText().equals("")){
            eror5.setVisible(true);
        } else {
            eror5.setVisible(false);
            a.setDiaChi(txtDiaChi.getText());
        }
        if(!BUS.UtilityClass.validNumberPhone(txtSoDienThoai.getText())){
            eror3.setVisible(true);
        } else {
            eror3.setVisible(false);
            a.setSoDienThoai(txtSoDienThoai.getText());
        }     
        a.setUuTien(cbbUuTien.getSelectedItem().toString());
        if(!BUS.UtilityClass.validFullName(txtHoTen.getText())){
            eror1.setVisible(true);
        } else {
            eror1.setVisible(false);
            a.setHoTen(BUS.UtilityClass.chuanHoa(txtHoTen.getText()));
        }
        if(!BUS.UtilityClass.validEmail(txtEmail.getText())){
            eror4.setVisible(true);
        } else {
            eror4.setVisible(false);
            a.setEmail(txtEmail.getText());
        }
        
        if(BUS.UtilityClass.validDate(cbbNgaySinh, cbbThangSinh, cbbNamSinh) && !(txtDiaChi.getText().equals("")) && BUS.UtilityClass.validNumberPhone(txtSoDienThoai.getText()) 
                && BUS.UtilityClass.validFullName(txtHoTen.getText()) && BUS.UtilityClass.validEmail(txtEmail.getText())){
            BUS.ThiSinhBUS.updateThiSinh(a);
            JOptionPane.showMessageDialog(this, "Đổi thông tin thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }      
    }//GEN-LAST:event_btnXacNhanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDong;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbNamSinh;
    private javax.swing.JComboBox<String> cbbNgaySinh;
    private javax.swing.JComboBox<String> cbbNoiSinh;
    private javax.swing.JComboBox<String> cbbThangSinh;
    private javax.swing.JComboBox<String> cbbUuTien;
    private javax.swing.JLabel eror1;
    private javax.swing.JLabel eror2;
    private javax.swing.JLabel eror3;
    private javax.swing.JLabel eror4;
    private javax.swing.JLabel eror5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTextField txtCmtnd;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtSoDienThoai;
    // End of variables declaration//GEN-END:variables
}