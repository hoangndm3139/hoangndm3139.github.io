package dao;
import java.util.List;
import model.Wishlist;
public interface WishlistDAO {

    // thêm Wishlist
    public void addWishlist(Wishlist w);
    
    // đếm Wishlist
    public int countWishlist(int id);

    // hiển thị danh sách Wishlist
    public List<Wishlist> getWishlist(int ma_nguoi_dung);

    //xoa 1 Wishlist
    public void removeWishList(int id);	
}