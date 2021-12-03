/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.ThiSinh;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 *
 * @author Audd
 */
public class BaoCaoHoSoPanel extends javax.swing.JPanel {

    static String userLogin = "";
    ArrayList<ThiSinh> li = new ArrayList<>();

    public BaoCaoHoSoPanel(String username) throws SQLException {
        userLogin = username;
        initComponents();
        li = new ArrayList<>();
        li = BUS.ThiSinhBUS.getAllThiSinhsBaoCao();
        if (li.isEmpty()) {
            btnExportExcel.setEnabled(false);
        } else {
            btnExportExcel.setEnabled(true);
        }
        DefaultTableModel model = (DefaultTableModel) tblHoSo.getModel();
        BUS.UtilityClass.clearRowJTable(tblHoSo);
        for (ThiSinh a : li) {
            String ngaySinh = a.getNgaySinh().substring(0, 11);
            model.addRow(new Object[]{
                a.getID(), a.getHoTen(), a.getDiaChi(), a.getNoiSinh(), a.getCmtnd(), a.getGioiTinh(), ngaySinh, a.getSoDienThoai(), a.getEmail(), a.getUuTien()
            });
        }
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtSoBaoDanhTK = new javax.swing.JTextField();
        cbbGioiTinhTK = new javax.swing.JComboBox<>();
        cbbNoiSinhTK = new javax.swing.JComboBox<>();
        cbbUuTienTK = new javax.swing.JComboBox<>();
        btnTimKiem = new javax.swing.JButton();
        btnDong = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        btnExportExcel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoSo = new javax.swing.JTable();

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel10.setText("Tìm Kiếm ");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Giới Tính:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Số Báo Danh:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Nơi Sinh:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Ưu Tiên:");

        txtSoBaoDanhTK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        cbbGioiTinhTK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbbGioiTinhTK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Tất Cả>", "Nam", "Nữ" }));

        cbbNoiSinhTK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbbNoiSinhTK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Tất Cả>", "Hà Nội", "Hà Tây", "Hải Dương", "Bắc Ninh", "Hà Giang", "Hà Nam", "Lạng Sơn" }));

        cbbUuTienTK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbbUuTienTK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Tất Cả>", "UT1", "UT2", "KV1", "KV2-NT", "KV2", "KV3" }));

        btnTimKiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-search-16.png"))); // NOI18N
        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
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

        btnExportExcel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnExportExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-export-excel-24.png"))); // NOI18N
        btnExportExcel.setText("Xuất Excel");
        btnExportExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel13)
                                        .addComponent(jLabel14))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtSoBaoDanhTK)
                                        .addComponent(cbbGioiTinhTK, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbbNoiSinhTK, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbbUuTienTK, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnTimKiem)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnExportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnDong))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtSoBaoDanhTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cbbGioiTinhTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cbbNoiSinhTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cbbUuTienTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTimKiem)
                    .addComponent(btnDong)
                    .addComponent(btnExportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(247, 247, 247))
        );

        tblHoSo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblHoSo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Họ Tên", "Địa Chỉ", "Nơi Sinh", "CMTND", "Giới Tính", "Ngày Sinh", "Số Điện Thoại", "Email", "Ưu Tiên"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoSo.getTableHeader().setReorderingAllowed(false);
        tblHoSo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoSoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoSo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 939, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblHoSoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoSoMouseClicked


    }//GEN-LAST:event_tblHoSoMouseClicked

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed
        BaoCaoHoSoPanel.this.getParent().remove(BaoCaoHoSoPanel.this);
        MainFormAdmin.check3 = 0;
    }//GEN-LAST:event_btnDongActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        li = new ArrayList<ThiSinh>();
        DefaultTableModel model = (DefaultTableModel) tblHoSo.getModel();
        BUS.UtilityClass.clearRowJTable(tblHoSo);
        li = BUS.ThiSinhBUS.searchThiSinhBaoCao(txtSoBaoDanhTK, cbbGioiTinhTK, cbbNoiSinhTK, cbbUuTienTK);
        if (li.isEmpty()) {
            btnExportExcel.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Không tìm thấy thông tin phù hợp!", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        btnExportExcel.setEnabled(true);
        for (ThiSinh a : li) {
            String ngaySinh = a.getNgaySinh().substring(0, 11);
            model.addRow(new Object[]{
                a.getID(), a.getHoTen(), a.getDiaChi(), a.getNoiSinh(), a.getCmtnd(), a.getGioiTinh(), ngaySinh, a.getSoDienThoai(), a.getEmail(), a.getUuTien()
            });
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnExportExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportExcelActionPerformed
        try {
            String exportPath = "";
            JFileChooser jf = new JFileChooser();
            FileFilter filter = new FileNameExtensionFilter("Files", ".xls");
            jf.addChoosableFileFilter(filter);
            jf.setAcceptAllFileFilterUsed(false);
            jf.setDialogTitle("Save Excel File");
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
            String strDate = formatter.format(date);
            jf.setSelectedFile(new File("Bao_cao_ho_so_" + strDate + ".xls"));
            int result = jf.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                exportPath = jf.getSelectedFile().getAbsolutePath();
                exportExcel(li, exportPath);
                JOptionPane.showMessageDialog(this, "Xuất báo cáo thành công!", "Thông Báo", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Thông Báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnExportExcelActionPerformed
    public void exportExcel(ArrayList<ThiSinh> list, String exportPath) throws IOException {
        HSSFWorkbook workbook = null;
        FileOutputStream outFile = null;
        try {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String strDate = formatter.format(date);
            workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("ThiSinh");
            int rownum = 0;
            Cell cell;
            Row row;
            HSSFCellStyle style = createStyleForTitle(workbook);
            style.setBorderBottom(BorderStyle.THIN);
            style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
            style.setBorderLeft(BorderStyle.THIN);
            style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
            style.setBorderRight(BorderStyle.THIN);
            style.setRightBorderColor(IndexedColors.BLACK.getIndex());
            style.setBorderTop(BorderStyle.THIN);
            style.setTopBorderColor(IndexedColors.BLACK.getIndex());
            style.setAlignment(HorizontalAlignment.CENTER);
            style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.index);
            // and solid fill pattern produces solid grey cell fill
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            HSSFCellStyle styleTitle = createStyleForTitle(workbook);
            styleTitle.setAlignment(HorizontalAlignment.CENTER);
            styleTitle.setVerticalAlignment(VerticalAlignment.CENTER);
            Font font = workbook.createFont();
            font.setFontHeightInPoints((short) 22);
            font.setBold(true);
            styleTitle.setFont(font);
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 9));
            sheet.addMergedRegion(new CellRangeAddress(1, 1, 1, 2));
            sheet.addMergedRegion(new CellRangeAddress(2, 2, 1, 2));
            row = sheet.createRow(rownum);
            row.setHeight((short) 700);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Báo cáo hồ sơ thí sinh");
            cell.setCellStyle(styleTitle);
            rownum++;
            HSSFCellStyle styleInfo = createStyleForTitle(workbook);
            Font fontInfo = workbook.createFont();
            fontInfo.setBold(true);
            styleInfo.setFont(fontInfo);
            row = sheet.createRow(rownum);
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Ngày xuất : " + strDate);
            cell.setCellStyle(styleInfo);
            rownum++;
            row = sheet.createRow(rownum);
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Người xuất : " + userLogin);
            cell.setCellStyle(styleInfo);
            rownum++;
            rownum++;
            row = sheet.createRow(rownum);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Mã thí sinh");
            cell.setCellStyle(style);
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Họ tên");
            cell.setCellStyle(style);
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Địa chỉ");
            cell.setCellStyle(style);
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Nơi sinh");
            cell.setCellStyle(style);
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("CMND");
            cell.setCellStyle(style);
            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Giới tính");
            cell.setCellStyle(style);
            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("Ngày sinh");
            cell.setCellStyle(style);
            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue("Số điện thoại");
            cell.setCellStyle(style);
            cell = row.createCell(8, CellType.STRING);
            cell.setCellValue("Email");
            cell.setCellStyle(style);
            cell = row.createCell(9, CellType.STRING);
            cell.setCellValue("Ưu tiên");
            cell.setCellStyle(style);
            sheet.setColumnWidth(0, 10 * 256);
            sheet.setColumnWidth(1, 22 * 256);
            sheet.setColumnWidth(2, 30 * 256);
            sheet.setColumnWidth(3, 15 * 256);
            sheet.setColumnWidth(4, 15 * 256);
            sheet.setColumnWidth(5, 10 * 256);
            sheet.setColumnWidth(6, 20 * 256);
            sheet.setColumnWidth(7, 15 * 256);
            sheet.setColumnWidth(8, 20 * 256);
            sheet.setColumnWidth(9, 10 * 256);
// Data
            for (ThiSinh emp : list) {
                rownum++;
                row = sheet.createRow(rownum);
                CellStyle styleData = workbook.createCellStyle();
                styleData.setBorderBottom(BorderStyle.THIN);
                styleData.setBottomBorderColor(IndexedColors.BLACK.getIndex());
                styleData.setBorderLeft(BorderStyle.THIN);
                styleData.setLeftBorderColor(IndexedColors.BLACK.getIndex());
                styleData.setBorderRight(BorderStyle.THIN);
                styleData.setRightBorderColor(IndexedColors.BLACK.getIndex());
                styleData.setBorderTop(BorderStyle.THIN);
                styleData.setTopBorderColor(IndexedColors.BLACK.getIndex());
                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue(emp.getID());
                cell.setCellStyle(styleData);
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(emp.getHoTen());
                cell.setCellStyle(styleData);
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(emp.getDiaChi());
                cell.setCellStyle(styleData);
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(emp.getNoiSinh());
                cell.setCellStyle(styleData);
                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(emp.getCmtnd());
                cell.setCellStyle(styleData);
                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(emp.getGioiTinh());
                cell.setCellStyle(styleData);
                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue(emp.getNgaySinh());
                cell.setCellStyle(styleData);
                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue(emp.getSoDienThoai());
                cell.setCellStyle(styleData);
                cell = row.createCell(8, CellType.STRING);
                cell.setCellValue(emp.getEmail());
                cell.setCellStyle(styleData);
                cell = row.createCell(9, CellType.STRING);
                cell.setCellValue(emp.getUuTien());
                cell.setCellStyle(styleData);
            }
            rownum++;
            rownum++;
            row = sheet.createRow(rownum);
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Tổng số : " + list.size());
            cell.setCellStyle(styleInfo);
            File file = new File(exportPath);
            file.getParentFile().mkdirs();
            outFile = new FileOutputStream(file);
            workbook.write(outFile);
        } catch (Exception e) {
        } finally {
            if (workbook != null) {
                workbook.close();
            }
            if (outFile != null) {
                outFile.close();
            }
        }

    }

    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDong;
    private javax.swing.JButton btnExportExcel;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbbGioiTinhTK;
    private javax.swing.JComboBox<String> cbbNoiSinhTK;
    private javax.swing.JComboBox<String> cbbUuTienTK;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable tblHoSo;
    private javax.swing.JTextField txtSoBaoDanhTK;
    // End of variables declaration//GEN-END:variables
}
