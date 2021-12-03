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
public class MonThi {
    private String id, tenMon;

    public MonThi() {
    }

    public MonThi(String id, String tenMon) {
        this.id = id;
        this.tenMon = tenMon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }
    
    
}
