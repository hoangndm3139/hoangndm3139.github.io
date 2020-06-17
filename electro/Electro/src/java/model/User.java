
package model;

import java.sql.Date;

public class User {
    private int ma_nguoi_dung;
    private String user__name;
    private String pass_word;
    private Date ngay_sinh;
    private String gioi_tinh;
    private String email;
    private String sdt;
    private String dia_chi;
    private int ro_le;
    private String trang_thai;
    
    public User() {}

    public User(int ma_nguoi_dung, String user__name, String pass_word, Date ngay_sinh, String gioi_tinh, String email, String sdt, String dia_chi, int ro_le, String trang_thai) {
        this.ma_nguoi_dung = ma_nguoi_dung;
        this.user__name = user__name;
        this.pass_word = pass_word;
        this.ngay_sinh = ngay_sinh;
        this.gioi_tinh = gioi_tinh;
        this.email = email;
        this.sdt = sdt;
        this.dia_chi = dia_chi;
        this.ro_le = ro_le;
        this.trang_thai = trang_thai;
    }

    public void setTrang_thai(String trang_thai) {
        this.trang_thai = trang_thai;
    }

    public String getTrang_thai() {
        return trang_thai;
    }
    
    public String getDia_chi() {
        return dia_chi;
    }

    public String getEmail() {
        return email;
    }

    public String getGioi_tinh() {
        return gioi_tinh;
    }

    public int getMa_nguoi_dung() {
        return ma_nguoi_dung;
    }

    public Date getNgay_sinh() {
        return ngay_sinh;
    }

    public String getPass_word() {
        return pass_word;
    }

    public int getRo_le() {
        return ro_le;
    }

    public String getSdt() {
        return sdt;
    }

    public String getUser__name() {
        return user__name;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGioi_tinh(String gioi_tinh) {
        this.gioi_tinh = gioi_tinh;
    }

    public void setMa_nguoi_dung(int ma_nguoi_dung) {
        this.ma_nguoi_dung = ma_nguoi_dung;
    }

    public void setNgay_sinh(Date ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public void setPass_word(String pass_word) {
        this.pass_word = pass_word;
    }

    public void setRo_le(int ro_le) {
        this.ro_le = ro_le;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setUser__name(String user__name) {
        this.user__name = user__name;
    }
    
}


