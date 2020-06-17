package model;

import java.sql.Date;

public class CartAdmin {
    private int id_cart;
    private int ma_san_pham;
    private String ten_san_pham;
    private int ma_loai_san_pham;
    private int so_luong;
    private int gia_ban;   
    private int thanh_tien;
    private int ma_khach_hang;
    private String ten_khach_hang;
    private String sdt;
    private String dia_chi;
    private Date ngay_mua;
    private String trang_thai;
    
    public CartAdmin(int id_cart, int ma_san_pham, String ten_san_pham, int ma_loai_san_pham, int so_luong, int gia_ban, int thanh_tien, int ma_khach_hang, String ten_khach_hang, String sdt, String dia_chi, Date ngay_mua, String trang_thai) {
        this.id_cart = id_cart;
        this.ma_san_pham = ma_san_pham;
        this.ten_san_pham = ten_san_pham;
        this.ma_loai_san_pham = ma_loai_san_pham;
        this.so_luong = so_luong;
        this.gia_ban = gia_ban;
        this.thanh_tien = thanh_tien;
        this.ma_khach_hang = ma_khach_hang;
        this.ten_khach_hang = ten_khach_hang;
        this.sdt = sdt;
        this.dia_chi = dia_chi;
        this.ngay_mua = ngay_mua;
        this.trang_thai = trang_thai;
    }

    public CartAdmin() {
    }
    

    public String getDia_chi() {
        return dia_chi;
    }

    public int getGia_ban() {
        return gia_ban;
    }

    public int getId_cart() {
        return id_cart;
    }

    public int getMa_khach_hang() {
        return ma_khach_hang;
    }

    public int getMa_san_pham() {
        return ma_san_pham;
    }

    public Date getNgay_mua() {
        return ngay_mua;
    }

    public String getSdt() {
        return sdt;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public String getTen_khach_hang() {
        return ten_khach_hang;
    }

    public String getTen_san_pham() {
        return ten_san_pham;
    }

    public int getThanh_tien() {
        return thanh_tien;
    }

    public String getTrang_thai() {
        return trang_thai;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }

    public void setGia_ban(int gia_ban) {
        this.gia_ban = gia_ban;
    }

    public void setId_cart(int id_cart) {
        this.id_cart = id_cart;
    }

    public void setMa_khach_hang(int ma_khach_hang) {
        this.ma_khach_hang = ma_khach_hang;
    }

    public void setMa_san_pham(int ma_san_pham) {
        this.ma_san_pham = ma_san_pham;
    }

    public void setNgay_mua(Date ngay_mua) {
        this.ngay_mua = ngay_mua;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public void setTen_khach_hang(String ten_khach_hang) {
        this.ten_khach_hang = ten_khach_hang;
    }

    public void setTen_san_pham(String ten_san_pham) {
        this.ten_san_pham = ten_san_pham;
    }

    public void setThanh_tien(int thanh_tien) {
        this.thanh_tien = thanh_tien;
    }

    public void setTrang_thai(String trang_thai) {
        this.trang_thai = trang_thai;
    }   

    public int getMa_loai_san_pham() {
        return ma_loai_san_pham;
    }

    public void setMa_loai_san_pham(int ma_loai_san_pham) {
        this.ma_loai_san_pham = ma_loai_san_pham;
    }
    
}