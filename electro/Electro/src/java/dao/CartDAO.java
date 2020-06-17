package dao;
import java.util.List;
import model.Cart;
import model.CartAdmin;
public interface CartDAO {

    // thêm Cart
    public void addCart(Cart c);
    
    // lấy Cart
    public CartAdmin getCart(int id_cart);
    
    // đếm Cart
    public int countCart(int id);

    // hiển thị danh sách Cart
    public List<Cart> getListCart(int ma_nguoi_dung);

    // xoá 1 cart
    public void removeCart(int id);
    
    // danh sách tất cả các đơn hàng
    public List<CartAdmin> getListCartAdmin();
    
    // danh sách tất cả các đơn hàng
    public List<CartAdmin> getListCartAdmin(int tuy_chon);
    
    // danh sách tất cả đơn hàng theo thể loại
    public List<CartAdmin> getListCartAdminCategory(int id);
    
    // danh sách tất cả đơn hàng theo thể loại và tuỳ chọn
    public List<CartAdmin> getListCartAdminCategory(int id, int tuy_chon);
    
    // thay đổi trạng thái đơn hàng
    public void editCartAdmin(int id_cart, String trang_thai);
    
    // đếm số đơn hàng theo thể loại
    public int countCartCategory(int id);
    
}