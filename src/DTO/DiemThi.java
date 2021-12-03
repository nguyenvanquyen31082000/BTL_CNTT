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
public class DiemThi {
    private String idThiSinh, idMonHoc, cumThi, namThi;
    private float diem;

    public DiemThi() {
    }

    public DiemThi(String idThiSinh, String idMonHoc, String cumThi, String namThi, float diem) {
        this.idThiSinh = idThiSinh;
        this.idMonHoc = idMonHoc;
        this.cumThi = cumThi;
        this.namThi = namThi;
        this.diem = diem;
    }

    public String getIdThiSinh() {
        return idThiSinh;
    }

    public void setIdThiSinh(String idThiSinh) {
        this.idThiSinh = idThiSinh;
    }

    public String getIdMonHoc() {
        return idMonHoc;
    }

    public void setIdMonHoc(String idMonHoc) {
        this.idMonHoc = idMonHoc;
    }

    public String getCumThi() {
        return cumThi;
    }

    public void setCumThi(String cumThi) {
        this.cumThi = cumThi;
    }

    public String getNamThi() {
        return namThi;
    }

    public void setNamThi(String namThi) {
        this.namThi = namThi;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }
    
    
}
