package model;

public class Product {
    private int ma_san_pham;
    private int ma_loai_san_pham;
    private String ten_san_pham;
    private String hinh_anh_1;
    private String hinh_anh_2;
    private String hinh_anh_3;
    private String hinh_anh_4;
    private String hinh_anh_5;
    private int gia_ban;
    private float sale;
    
    public Product() {}
    
    public Product(int ma_san_pham, int ma_loai_san_pham, String ten_san_pham, String hinh_anh_1, String hinh_anh_2, String hinh_anh_3, String hinh_anh_4, String hinh_anh_5, int gia_ban, float sale) {
        this.ma_san_pham = ma_san_pham;
        this.ma_loai_san_pham = ma_loai_san_pham;
        this.ten_san_pham = ten_san_pham;
        this.hinh_anh_1 = hinh_anh_1;
        this.hinh_anh_2 = hinh_anh_2;
        this.hinh_anh_3 = hinh_anh_3;
        this.hinh_anh_4 = hinh_anh_4;
        this.hinh_anh_5 = hinh_anh_5;
        this.gia_ban = gia_ban;
        this.sale = sale;
    }
    
    public Product(int ma_loai_san_pham, String ten_san_pham, String hinh_anh_1, String hinh_anh_2, String hinh_anh_3, String hinh_anh_4, String hinh_anh_5, int gia_ban, float sale) {
        this.ma_loai_san_pham = ma_loai_san_pham;
        this.ten_san_pham = ten_san_pham;
        this.hinh_anh_1 = hinh_anh_1;
        this.hinh_anh_2 = hinh_anh_2;
        this.hinh_anh_3 = hinh_anh_3;
        this.hinh_anh_4 = hinh_anh_4;
        this.hinh_anh_5 = hinh_anh_5;
        this.gia_ban = gia_ban;
        this.sale = sale;
    }
    
    public Product(int ma_loai_san_pham, String ten_san_pham, String hinh_anh_1, String hinh_anh_2, String hinh_anh_3, String hinh_anh_4, String hinh_anh_5, int gia_ban) {
        this.ma_loai_san_pham = ma_loai_san_pham;
        this.ten_san_pham = ten_san_pham;
        this.hinh_anh_1 = hinh_anh_1;
        this.hinh_anh_2 = hinh_anh_2;
        this.hinh_anh_3 = hinh_anh_3;
        this.hinh_anh_4 = hinh_anh_4;
        this.hinh_anh_5 = hinh_anh_5;
        this.gia_ban = gia_ban;
    }

    public void setSale(float sale) {
        this.sale = sale;
    }

    public float getSale() {
        return sale;
    }
    
    public float getGia_ban() {
        return gia_ban;
    }

    public String getHinh_anh_1() {
        return hinh_anh_1;
    }

    public String getHinh_anh_2() {
        return hinh_anh_2;
    }

    public String getHinh_anh_3() {
        return hinh_anh_3;
    }

    public String getHinh_anh_4() {
        return hinh_anh_4;
    }

    public String getHinh_anh_5() {
        return hinh_anh_5;
    }

    public int getMa_loai_san_pham() {
        return ma_loai_san_pham;
    }

    public int getMa_san_pham() {
        return ma_san_pham;
    }

    public String getTen_san_pham() {
        return ten_san_pham;
    }

    public void setGia_ban(int gia_ban) {
        this.gia_ban = gia_ban;
    }

    public void setHinh_anh_1(String hinh_anh_1) {
        this.hinh_anh_1 = hinh_anh_1;
    }

    public void setHinh_anh_2(String hinh_anh_2) {
        this.hinh_anh_2 = hinh_anh_2;
    }

    public void setHinh_anh_3(String hinh_anh_3) {
        this.hinh_anh_3 = hinh_anh_3;
    }

    public void setHinh_anh_4(String hinh_anh_4) {
        this.hinh_anh_4 = hinh_anh_4;
    }

    public void setHinh_anh_5(String hinh_anh_5) {
        this.hinh_anh_5 = hinh_anh_5;
    }

    public void setMa_loai_san_pham(int ma_loai_san_pham) {
        this.ma_loai_san_pham = ma_loai_san_pham;
    }

    public void setMa_san_pham(int ma_san_pham) {
        this.ma_san_pham = ma_san_pham;
    }

    public void setTen_san_pham(String ten_san_pham) {
        this.ten_san_pham = ten_san_pham;
    }
}

