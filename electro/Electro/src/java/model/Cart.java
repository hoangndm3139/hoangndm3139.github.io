package model;

import java.sql.Date;

public class Cart {
    private int id_cart;
    private int ma_nguoi_dung;
    private int ma_san_pham;
    private String ten_san_pham;
    private Date ngay_mua;
    private int so_luong;
    private int thanh_tien;
    private String trang_thai;
    private String sdt;
    private String dia_chi;

    public Cart(int id_cart, int ma_nguoi_dung, int ma_san_pham, String ten_san_pham, Date ngay_mua, int so_luong, int thanh_tien, String trang_thai, String sdt, String dia_chi) {
        this.id_cart = id_cart;
        this.ma_nguoi_dung = ma_nguoi_dung;
        this.ma_san_pham = ma_san_pham;
        this.ten_san_pham = ten_san_pham;
        this.ngay_mua = ngay_mua;
        this.so_luong = so_luong;
        this.thanh_tien = thanh_tien;
        this.trang_thai = trang_thai;
        this.sdt = sdt;
        this.dia_chi = dia_chi;
    }
    
    public Cart(int id_cart, int ma_nguoi_dung, int ma_san_pham, String ten_san_pham, Date ngay_mua, int so_luong, int thanh_tien, String trang_thai){
        this.id_cart = id_cart;
        this.ma_nguoi_dung = ma_nguoi_dung;
        this.ma_san_pham = ma_san_pham;
        this.ten_san_pham = ten_san_pham;
        this.ngay_mua = ngay_mua;
        this.so_luong = so_luong;
        this.thanh_tien = thanh_tien;
        this.trang_thai = trang_thai;
    }
    
    public Cart(int ma_nguoi_dung, int ma_san_pham, String ten_san_pham, Date ngay_mua, int so_luong, int thanh_tien, String trang_thai, String sdt, String dia_chi){
        this.ma_nguoi_dung = ma_nguoi_dung;
        this.ma_san_pham = ma_san_pham;
        this.ten_san_pham = ten_san_pham;
        this.ngay_mua = ngay_mua;
        this.so_luong = so_luong;
        this.thanh_tien = thanh_tien;
        this.trang_thai = trang_thai;
        this.dia_chi = dia_chi;
        this.sdt = sdt;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    
    public void setTen_san_pham(String ten_san_pham) {
        this.ten_san_pham = ten_san_pham;
    }

    public String getTen_san_pham() {
        return ten_san_pham;
    }
    
    public String getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(String trang_thai) {
        this.trang_thai = trang_thai;
    }
    
    public int getId_cart() {
        return id_cart;
    }

    public int getMa_nguoi_dung() {
        return ma_nguoi_dung;
    }

    public int getMa_san_pham() {
        return ma_san_pham;
    }

    public Date getNgay_mua() {
        return ngay_mua;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setId_cart(int id_cart) {
        this.id_cart = id_cart;
    }

    public int getThanh_tien() {
        return thanh_tien;
    }

    public void setMa_nguoi_dung(int ma_nguoi_dung) {
        this.ma_nguoi_dung = ma_nguoi_dung;
    }

    public void setMa_san_pham(int ma_san_pham) {
        this.ma_san_pham = ma_san_pham;
    }

    public void setNgay_mua(Date ngay_mua) {
        this.ngay_mua = ngay_mua;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public void setThanh_tien(int thanh_tien) {
        this.thanh_tien = thanh_tien;
    }

}