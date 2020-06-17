package dao;
import java.util.List;
import model.Product;
import model.Review;
public interface ProductDAO {

	// thêm sản phẩm mới
	public void addProduct(Product p);
        
        // sửa thông tin sản phẩm
        public void editProduct(Product p);

	// hiển thị danh sách sản phẩm
	public List<Product> getList();
        
        // hiển thị danh sách tất cả sản phẩm theo tuỳ chọn
        public List<Product> getList(int tuy_chon);
        
	// lấy danh sách sản phẩm dựa vào thể loại và tuỳ chọn
	public List<Product> getListByCategory(int ma_the_loai,int tuy_chon);
        
        // lấy danh sách sản phẩm dựa vào thể loại
        public List<Product> getListByCategory(int ma_the_loai);
	
        // lấy thông tin sản phẩm theo mã
	public Product getProduct(int ma_san_pham);
	
        // tìm kiếm danh sách sản phẩm theo tên sản phẩm dựa vào keyword
	public List<Product> searchList(int ma_loai_san_pham, String keyword);
        
        // xoá sản phẩm theo mã
        public void removeProduct(int ma_san_pham);
        
        // đếm số lượng sản phẩm dựa vào thể loại
        public int countProduct(int id);
        
        // thêm đánh giá
        public void addReviewProduct(Review r);
        
        // lấy danh sách đánh giá
        public List<Review> getListReviewProduct(int ma_san_pham);
        
        // lấy thông tin đánh giá tương ứng với mã sản phẩm
        public Review getReviewProduct(int ma_san_pham);
        
        // tính sao trung bình cho mỗi sản phẩm
        public int ratingAvgReviewProduct(int ma_san_pham);
}
