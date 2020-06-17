package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Wishlist;

public class WishlistDAOImple implements WishlistDAO {

    @Override
    public void addWishlist(Wishlist w) {
        Connection con = DBConnect.getConnect();
        String sql = "INSERT INTO WISHLIST(ma_nguoi_dung, ma_san_pham) VALUES (?,?);";
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, w.getMa_nguoi_dung());
            ps.setInt(2, w.getMa_san_pham());
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
                e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        WishlistDAOImple wishListDAO = new WishlistDAOImple();
        Wishlist w = new Wishlist(1, 2, null);
        wishListDAO.addWishlist(w);
        //System.out.println(wishListDAO.countWishlist(1));
        //wishListDAO.removeWishList(2);
    }
    @Override
    public int countWishlist(int id) {
        int count = 0;
        Connection con = DBConnect.getConnect();
        String sql = "SELECT COUNT(id_wishlist) FROM WISHLIST WHERE(ma_nguoi_dung = '" + id + "');";
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
    public List<Wishlist> getWishlist(int id) {
        Connection con = DBConnect.getConnect();
        String sql = "SELECT id_wishlist, ma_nguoi_dung, WISHLIST.ma_san_pham, PRODUCT.ten_san_pham, PRODUCT.ten_san_pham FROM WISHLIST,PRODUCT WHERE((WISHLIST.ma_san_pham = PRODUCT.ma_san_pham) AND (ma_nguoi_dung = '" + id + "'));";
        List<Wishlist> list = new ArrayList<Wishlist>();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                    int id_wishlist = rs.getInt("id_wishlist");
                    int ma_nguoi_dung = rs.getInt("ma_nguoi_dung");
                    int ma_san_pham = rs.getInt("ma_san_pham");
                    String ten_san_pham = rs.getString("ten_san_pham");                    
                    list.add(new Wishlist(id_wishlist, ma_nguoi_dung, ma_san_pham, ten_san_pham));
                }
                con.close();
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return list;
    }

    @Override
    public void removeWishList(int id) {
        Connection con = DBConnect.getConnect();
        String sql = "DELETE FROM WISHLIST WHERE(id_wishlist = '" + id + "');";
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
                e.printStackTrace();
        }
    }
    
}
