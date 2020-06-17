package model;

import java.sql.Date;

public class Review {
    private int id_review;
    private int ma_san_pham;
    private String ten_nguoi_danh_gia;
    private String dia_chi_email;
    private Date thoi_gian;
    private String danh_gia;
    private int so_luong_sao;

    public Review(int id_review, int ma_san_pham, String ten_nguoi_danh_gia, String dia_chi_email, String danh_gia, int so_luong_sao, Date thoi_gian) {
        this.id_review = id_review;
        this.ma_san_pham = ma_san_pham;
        this.ten_nguoi_danh_gia = ten_nguoi_danh_gia;
        this.dia_chi_email = dia_chi_email;
        this.thoi_gian = thoi_gian;
        this.danh_gia = danh_gia;
        this.so_luong_sao = so_luong_sao;
    }
    
    public Review(int ma_san_pham, String ten_nguoi_danh_gia, String dia_chi_email, String danh_gia, int so_luong_sao, Date thoi_gian) {
        this.ma_san_pham = ma_san_pham;
        this.ten_nguoi_danh_gia = ten_nguoi_danh_gia;
        this.dia_chi_email = dia_chi_email;
        this.thoi_gian = thoi_gian;
        this.danh_gia = danh_gia;
        this.so_luong_sao = so_luong_sao;
    }
    
    public String getDanh_gia() {
        return danh_gia;
    }

    public String getDia_chi_email() {
        return dia_chi_email;
    }

    public int getId_review() {
        return id_review;
    }

    public int getMa_san_pham() {
        return ma_san_pham;
    }

    public int getSo_luong_sao() {
        return so_luong_sao;
    }

    public String getTen_nguoi_danh_gia() {
        return ten_nguoi_danh_gia;
    }

    public void setDanh_gia(String danh_gia) {
        this.danh_gia = danh_gia;
    }

    public Date getThoi_gian() {
        return thoi_gian;
    }
    
    public void setDia_chi_email(String dia_chi_email) {
        this.dia_chi_email = dia_chi_email;
    }

    public void setId_review(int id_review) {
        this.id_review = id_review;
    }

    public void setMa_san_pham(int ma_san_pham) {
        this.ma_san_pham = ma_san_pham;
    }

    public void setSo_luong_sao(int so_luong_sao) {
        this.so_luong_sao = so_luong_sao;
    }

    public void setTen_nguoi_danh_gia(String ten_nguoi_danh_gia) {
        this.ten_nguoi_danh_gia = ten_nguoi_danh_gia;
    }

    public void setThoi_gian(Date thoi_gian) {
        this.thoi_gian = thoi_gian;
    }
}
 