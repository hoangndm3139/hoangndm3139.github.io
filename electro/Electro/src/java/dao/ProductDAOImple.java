package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;
import model.Review;

public class ProductDAOImple implements ProductDAO {

    @Override
    public List<Product> getListByCategory(int id, int tuy_chon) { 
        String sql = "";
        if(tuy_chon == 0) {
            sql = "SELECT * FROM PRODUCT WHERE ma_loai_san_pham='" + id + "'";
        }
        else if(tuy_chon == 1) {
            sql = "SELECT * FROM PRODUCT WHERE ma_loai_san_pham='" + id + "' ORDER BY ma_san_pham;";
        }
        else if(tuy_chon == 2) {
            sql = "SELECT * FROM PRODUCT WHERE ma_loai_san_pham='" + id + "' ORDER BY ten_san_pham;";
        }
        else if(tuy_chon == 3) {
            sql = "SELECT * FROM PRODUCT WHERE ma_loai_san_pham='" + id + "' ORDER BY gia_ban;";
        }
        Connection con = DBConnect.getConnect();
        List<Product> list = new ArrayList<Product>();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ma_san_pham = rs.getInt("ma_san_pham");
                int ma_loai_san_pham = rs.getInt("ma_loai_san_pham");
                String ten_san_pham = rs.getString("ten_san_pham");
                String hinh_anh_1 = rs.getString("hinh_anh_1");
                String hinh_anh_2 = rs.getString("hinh_anh_2");
                String hinh_anh_3 = rs.getString("hinh_anh_3");
                String hinh_anh_4 = rs.getString("hinh_anh_4");
                String hinh_anh_5 = rs.getString("hinh_anh_5");
                int gia_ban = rs.getInt("gia_ban");
                float sale = rs.getFloat("sale");
                list.add(new Product(ma_san_pham, ma_loai_san_pham, ten_san_pham, hinh_anh_1, hinh_anh_2, hinh_anh_3, hinh_anh_4, hinh_anh_5, gia_ban, sale));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Product getProduct(int id) {
        Connection con = DBConnect.getConnect();
        String sql = "SELECT * FROM PRODUCT WHERE ma_san_pham='" + id + "'";
        Product p = new Product();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ma_san_pham = rs.getInt("ma_san_pham");
                int ma_loai_san_pham = rs.getInt("ma_loai_san_pham");
                String ten_san_pham = rs.getString("ten_san_pham");
                String hinh_anh_1 = rs.getString("hinh_anh_1");
                String hinh_anh_2 = rs.getString("hinh_anh_2");
                String hinh_anh_3 = rs.getString("hinh_anh_3");
                String hinh_anh_4 = rs.getString("hinh_anh_4");
                String hinh_anh_5 = rs.getString("hinh_anh_5");
                int gia_ban = rs.getInt("gia_ban");
                float sale = rs.getFloat("sale");
                p = new Product(ma_san_pham, ma_loai_san_pham, ten_san_pham, hinh_anh_1, hinh_anh_2, hinh_anh_3, hinh_anh_4, hinh_anh_5, gia_ban, sale);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    public static void main(String[] args) {
        //Product p = new Product(1, "12", "da", "1232", "234", "23423", "31231",1000);
        //ProductDAOImple productDAO = new ProductDAOImple();
        //productDAO.addProduct(p);
        //productDAO.searchList(0, "123");
        //long millis = System.currentTimeMillis();  
        //java.sql.Date ngay_mua = new java.sql.Date(millis);
        //Review r = new Review(1,"mai", "kbsnet@gmail.com", "123", 4, ngay_mua);
        //System.out.print(productDAO.getListReviewProduct(27));
        //List<Product> list = productDAO.getList(1);
        //System.out.print(list);
        //System.out.println(productDAO.countProduct(1));
        //System.out.println(productDAO.getList(3));
    }


    @Override
    public void addProduct(Product p) {
        Connection con = DBConnect.getConnect();
        String sql = "INSERT INTO PRODUCT(ma_loai_san_pham, ten_san_pham, hinh_anh_1, hinh_anh_2, hinh_anh_3, hinh_anh_4, hinh_anh_5, gia_ban) VALUES (?,?,?,?,?,?,?,?);";
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, p.getMa_loai_san_pham());
            ps.setString(2, p.getTen_san_pham());
            ps.setString(3, p.getHinh_anh_1());
            ps.setString(4, p.getHinh_anh_2());
            ps.setString(5, p.getHinh_anh_3());
            ps.setString(6, p.getHinh_anh_4());
            ps.setString(7, p.getHinh_anh_5());
            ps.setInt(8, (int) p.getGia_ban());
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> getList() {
        Connection con = DBConnect.getConnect();
        String sql = "SELECT * FROM PRODUCT;";
        List<Product> list = new ArrayList<Product>();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ma_san_pham = rs.getInt("ma_san_pham");
                int ma_loai_san_pham = rs.getInt("ma_loai_san_pham");
                String ten_san_pham = rs.getString("ten_san_pham");
                String hinh_anh_1 = rs.getString("hinh_anh_1");
                String hinh_anh_2 = rs.getString("hinh_anh_2");
                String hinh_anh_3 = rs.getString("hinh_anh_3");
                String hinh_anh_4 = rs.getString("hinh_anh_4");
                String hinh_anh_5 = rs.getString("hinh_anh_5");
                int gia_ban = rs.getInt("gia_ban");
                float sale = rs.getFloat("sale");
                list.add(new Product(ma_san_pham, ma_loai_san_pham, ten_san_pham, hinh_anh_1, hinh_anh_2, hinh_anh_3, hinh_anh_4, hinh_anh_5, gia_ban, sale));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> searchList(int loai_san_pham, String keyword) {
        keyword = '%' + keyword + '%';
        String sql = "";
        Connection con = DBConnect.getConnect();
        if(loai_san_pham == 0){
            sql = "SELECT * FROM PRODUCT WHERE ten_san_pham LIKE '" + keyword + "';";
        }
        else if(loai_san_pham == 1){
            sql = "SELECT * FROM PRODUCT WHERE ma_loai_san_pham = 1 AND ten_san_pham LIKE '" + keyword + "';";
        }
        else if(loai_san_pham == 2){
            sql = "SELECT * FROM PRODUCT WHERE ma_loai_san_pham = 2 AND ten_san_pham LIKE '" + keyword + "';";
        }
        else if(loai_san_pham == 3){
            sql = "SELECT * FROM PRODUCT WHERE ma_loai_san_pham = 3 AND ten_san_pham LIKE '" + keyword + "';";
        }
        else if(loai_san_pham == 4){
            sql = "SELECT * FROM PRODUCT WHERE ma_loai_san_pham = 4 AND ten_san_pham LIKE '" + keyword + "';";
        }
        else {
            sql = "SELECT * FROM PRODUCT WHERE ma_loai_san_pham = 5 AND ten_san_pham LIKE '" + keyword + "';";
        }
        List<Product> list = new ArrayList<Product>();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ma_san_pham = rs.getInt("ma_san_pham");
                int ma_loai_san_pham = rs.getInt("ma_loai_san_pham");
                String ten_san_pham = rs.getString("ten_san_pham");
                String hinh_anh_1 = rs.getString("hinh_anh_1");
                String hinh_anh_2 = rs.getString("hinh_anh_2");
                String hinh_anh_3 = rs.getString("hinh_anh_3");
                String hinh_anh_4 = rs.getString("hinh_anh_4");
                String hinh_anh_5 = rs.getString("hinh_anh_5");
                int gia_ban = rs.getInt("gia_ban");
                float sale = rs.getFloat("sale");
                list.add(new Product(ma_san_pham, ma_loai_san_pham, ten_san_pham, hinh_anh_1, hinh_anh_2, hinh_anh_3, hinh_anh_4, hinh_anh_5, gia_ban, sale));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void removeProduct(int ma_san_pham) {     
        Connection con = DBConnect.getConnect();
        String sql = "DELETE FROM PRODUCT WHERE ma_san_pham='" + ma_san_pham + "';";
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
                e.printStackTrace();
        }
    }

    @Override
    public int countProduct(int id) {
        int count = 0;
        Connection con = DBConnect.getConnect();
        String sql = "SELECT COUNT(ma_san_pham) FROM PRODUCT WHERE(ma_loai_san_pham = '" + id + "');";
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString(1);
                count = Integer.parseInt(name);
            }
            con.close();
            return count;
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return count;
    }

    @Override
    public void addReviewProduct(Review r) {
        Connection con = DBConnect.getConnect();
        String sql = "INSERT INTO REVIEW(ma_san_pham, ten_nguoi_danh_gia, dia_chi_email, danh_gia, so_luong_sao, thoi_gian_danh_gia) VALUES (?,?,?,?,?,?);";
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, r.getMa_san_pham());
            ps.setString(2, r.getTen_nguoi_danh_gia());
            ps.setString(3, r.getDia_chi_email() );
            ps.setString(4, r.getDanh_gia());
            ps.setInt(5, r.getSo_luong_sao());
            ps.setDate(6, r.getThoi_gian());
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Review> getListReviewProduct(int ma_san_pham) {
        Connection con = DBConnect.getConnect();
        String sql = "SELECT * FROM REVIEW WHERE ma_san_pham='" + ma_san_pham + "';";
        List<Review> list = new ArrayList<Review>();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_review = rs.getInt("id_review");
                String ten_nguoi_danh_gia = rs.getString("ten_nguoi_danh_gia");
                String dia_chi_email = rs.getString("dia_chi_email");
                String danh_gia = rs.getString("danh_gia");
                int so_luong_sao = rs.getInt("so_luong_sao");
                Date thoi_gian_danh_gia = rs.getDate("thoi_gian_danh_gia");
                list.add(new Review(id_review, ma_san_pham, ten_nguoi_danh_gia, dia_chi_email, danh_gia, so_luong_sao, thoi_gian_danh_gia));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Review getReviewProduct(int ma_san_pham) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ratingAvgReviewProduct(int ma_san_pham) {
        ProductDAOImple productDAO = new ProductDAOImple();
        List<Review> list = productDAO.getListReviewProduct(ma_san_pham);
        int rating_avg = 0;
        int sum = 0;
        int rating[] = {0,0,0,0,0,0};
        if(list.size() != 0) { 
            for(int i=0; i<list.size(); i++) {
                if(list.get(i).getSo_luong_sao() == 0) rating[0]++;
                if(list.get(i).getSo_luong_sao() == 1) rating[1]++;
                if(list.get(i).getSo_luong_sao() == 2) rating[2]++;
                if(list.get(i).getSo_luong_sao() == 3) rating[3]++;
                if(list.get(i).getSo_luong_sao() == 4) rating[4]++;
                if(list.get(i).getSo_luong_sao() == 5) rating[5]++;
            }
            sum = rating[0] + rating[1] + rating[2] + rating[3] + rating[4] + rating[5];
        }
        if(sum != 0) { 
            rating_avg = (rating[0]*0 + rating[1]*1 + rating[2]*2 + rating[3]*3 + rating[4]*4 +rating[5]*5)/sum;
        }
        return rating_avg;
    }

    @Override
    public void editProduct(Product p) {
        Connection con = DBConnect.getConnect();
        String sql = "UPDATE PRODUCT SET ten_san_pham = '" + p.getTen_san_pham() + "', hinh_anh_1 = '" + p.getHinh_anh_1() + "', hinh_anh_2 = '" + p.getHinh_anh_2() + "', hinh_anh_3 = '" + p.getHinh_anh_3() + "', hinh_anh_4 = '" + p.getHinh_anh_4() + "', hinh_anh_5 = '" + p.getHinh_anh_5() + "', gia_ban = " + p.getGia_ban() + ", sale = " + p.getSale() + "  WHERE ma_san_pham='" + p.getMa_san_pham() + "';";
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
                e.printStackTrace();
        }
    }

    @Override
    public List<Product> getListByCategory(int ma_the_loai) {
        String sql = "SELECT * FROM PRODUCT WHERE ma_loai_san_pham='" + ma_the_loai + "'";
        Connection con = DBConnect.getConnect();
        List<Product> list = new ArrayList<Product>();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ma_san_pham = rs.getInt("ma_san_pham");
                int ma_loai_san_pham = rs.getInt("ma_loai_san_pham");
                String ten_san_pham = rs.getString("ten_san_pham");
                String hinh_anh_1 = rs.getString("hinh_anh_1");
                String hinh_anh_2 = rs.getString("hinh_anh_2");
                String hinh_anh_3 = rs.getString("hinh_anh_3");
                String hinh_anh_4 = rs.getString("hinh_anh_4");
                String hinh_anh_5 = rs.getString("hinh_anh_5");
                int gia_ban = rs.getInt("gia_ban");
                float sale = rs.getFloat("sale");
                list.add(new Product(ma_san_pham, ma_loai_san_pham, ten_san_pham, hinh_anh_1, hinh_anh_2, hinh_anh_3, hinh_anh_4, hinh_anh_5, gia_ban, sale));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> getList(int tuy_chon) {
        Connection con = DBConnect.getConnect();
        String sql = "";
        if(tuy_chon == 0) {
            sql = "SELECT * FROM PRODUCT;";
        }
        else if(tuy_chon == 1) {
            sql = "SELECT * FROM PRODUCT ORDER BY ma_san_pham;";
        }
        else if(tuy_chon == 2) {
            sql = "SELECT * FROM PRODUCT ORDER BY ten_san_pham;";
        }
        else if(tuy_chon == 3) {
            sql = "SELECT * FROM PRODUCT ORDER BY gia_ban";
        }
        
        List<Product> list = new ArrayList<Product>();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ma_san_pham = rs.getInt("ma_san_pham");
                int ma_loai_san_pham = rs.getInt("ma_loai_san_pham");
                String ten_san_pham = rs.getString("ten_san_pham");
                String hinh_anh_1 = rs.getString("hinh_anh_1");
                String hinh_anh_2 = rs.getString("hinh_anh_2");
                String hinh_anh_3 = rs.getString("hinh_anh_3");
                String hinh_anh_4 = rs.getString("hinh_anh_4");
                String hinh_anh_5 = rs.getString("hinh_anh_5");
                int gia_ban = rs.getInt("gia_ban");
                float sale = rs.getFloat("sale");
                list.add(new Product(ma_san_pham, ma_loai_san_pham, ten_san_pham, hinh_anh_1, hinh_anh_2, hinh_anh_3, hinh_anh_4, hinh_anh_5, gia_ban, sale));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

