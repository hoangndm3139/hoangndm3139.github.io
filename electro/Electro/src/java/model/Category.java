package model;

public class Category {
   private int ma_loai_san_pham;
   private String ten_loai_san_pham;
   
   public Category() {}
   
   public Category(int ma_loai_san_pham, String ten_loai_san_pham){
       this.ma_loai_san_pham = ma_loai_san_pham;
       this.ten_loai_san_pham = ten_loai_san_pham;
   }

    public int getMa_loai_san_pham() {
        return ma_loai_san_pham;
    }

    public String getTen_loai_san_pham() {
        return ten_loai_san_pham;
    }

    public void setMa_loai_san_pham(int ma_loai_san_pham) {
        this.ma_loai_san_pham = ma_loai_san_pham;
    }

    public void setTen_loai_san_pham(String ten_loai_san_pham) {
        this.ten_loai_san_pham = ten_loai_san_pham;
    }
   
}
