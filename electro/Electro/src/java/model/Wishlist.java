package model;

public class Wishlist {
    private int id_wishlist;
    private int ma_nguoi_dung;
    private int ma_san_pham;
    private String ten_san_pham;
    
    public Wishlist() {}
    
    public Wishlist(int id_wishlist, int ma_nguoi_dung, int ma_san_pham, String ten_san_pham) {
        this.id_wishlist = id_wishlist;
        this.ma_nguoi_dung = ma_nguoi_dung;
        this.ma_san_pham = ma_san_pham;
        this.ten_san_pham = ten_san_pham;
    }
    
    public Wishlist(int ma_nguoi_dung, int ma_san_pham, String ten_san_pham) {
        this.ma_nguoi_dung = ma_nguoi_dung;
        this.ma_san_pham = ma_san_pham;
        this.ten_san_pham = ten_san_pham;
    }
    
    public String getTen_san_pham() {
        return ten_san_pham;
    }

    public void setTen_san_pham(String ten_san_pham) {
        this.ten_san_pham = ten_san_pham;
    }
    
    public int getId_wishlist() {
        return id_wishlist;
    }

    public int getMa_nguoi_dung() {
        return ma_nguoi_dung;
    }

    public int getMa_san_pham() {
        return ma_san_pham;
    }

    public void setId_wishlist(int id_wishlist) {
        this.id_wishlist = id_wishlist;
    }

    public void setMa_nguoi_dung(int ma_nguoi_dung) {
        this.ma_nguoi_dung = ma_nguoi_dung;
    }

    public void setMa_san_pham(int ma_san_pham) {
        this.ma_san_pham = ma_san_pham;
    }
    
}
