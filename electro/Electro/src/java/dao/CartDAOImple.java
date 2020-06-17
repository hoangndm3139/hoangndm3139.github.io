package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cart;
import model.CartAdmin;

public class CartDAOImple implements CartDAO {
    @Override
    public void addCart(Cart c) {
        Connection con = DBConnect.getConnect();
        String sql = "INSERT INTO CART(ma_nguoi_dung, ma_san_pham, ngay_mua, so_luong, thanh_tien, trang_thai, sdt, dia_chi) VALUES (?,?,?,?,?,?,?,?);";
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, c.getMa_nguoi_dung());
            ps.setInt(2, c.getMa_san_pham());
            ps.setDate(3,c.getNgay_mua());
            ps.setInt(4, c.getSo_luong());
            ps.setInt(5, c.getThanh_tien());
            ps.setString(6, c.getTrang_thai());
            ps.setString(7, c.getSdt());
            ps.setString(8, c.getDia_chi());
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
                e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        //long millis = System.currentTimeMillis();  
        //java.sql.Date ngay_mua = new java.sql.Date(millis);
        //Cart c = new Cart(1, 12, "TV", ngay_mua , 2, 1000, "Đang xử lí");
        CartDAOImple cartDAO = new CartDAOImple();
        cartDAO.getListCartAdminCategory(1, 1);
        //cartDAO.getListCartAdminCategory(1);
        //cartDAO.countCartCategory(1);
        //cartDAO.getListCartAdminCategory(1);
        //cartDAO.addCart(c);
        //cartDAO.removeCart(6);      
        //System.out.println(cartDAO.countCart(3));
        //System.out.println(productDAO.getList());
        //System.out.println(productDAO.getListByCategory(5));
    }
    
    @Override
    public List<Cart> getListCart(int id) {
        Connection con = DBConnect.getConnect();
        String sql = "SELECT CART.id_cart, CART.ma_nguoi_dung, CART.ma_san_pham, PRODUCT.ten_san_pham, CART.ngay_mua, CART.so_luong, CART.thanh_tien, CART.trang_thai, CART.sdt, CART.dia_chi FROM CART, PRODUCT WHERE((CART.ma_san_pham = PRODUCT.ma_san_pham) AND (ma_nguoi_dung = '" + id + "'))"
                + "ORDER BY CART.trang_thai DESC;";
        List<Cart> list = new ArrayList<Cart>();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                    int id_cart = rs.getInt("id_cart");
                    int ma_nguoi_dung = rs.getInt("ma_nguoi_dung");
                    int ma_san_pham = rs.getInt("ma_san_pham");
                    String ten_san_pham = rs.getString("ten_san_pham");
                    Date ngay_mua = rs.getDate("ngay_mua");
                    int so_luong = rs.getInt("so_luong");
                    int thanh_tien = rs.getInt("thanh_tien");
                    String trang_thai = rs.getString("trang_thai");
                    String sdt = rs.getString("sdt");
                    String dia_chi = rs.getString("dia_chi");
                    list.add(new Cart(id_cart, ma_nguoi_dung, ma_san_pham, ten_san_pham, ngay_mua, so_luong, thanh_tien, trang_thai, sdt, dia_chi));
                }
                con.close();
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return list;
    }

    @Override
    public void removeCart(int id) {
        Connection con = DBConnect.getConnect();
        String sql = "DELETE FROM CART WHERE(id_cart = '" + id + "');";
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
    public int countCart(int id) {
        int count = 0;
        Connection con = DBConnect.getConnect();
        String sql = "SELECT COUNT(id_cart) FROM CART WHERE(ma_nguoi_dung = '" + id + "');";
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
    public List<CartAdmin> getListCartAdmin() {
        Connection con = DBConnect.getConnect();
        String sql = "SELECT CART.id_cart, CART.ma_san_pham, PRODUCT.ten_san_pham, PRODUCT.ma_loai_san_pham, CART.so_luong, PRODUCT.gia_ban, CART.thanh_tien, USER_ELECTRO.ma_nguoi_dung, USER_ELECTRO.user__name, CART.sdt, CART.dia_chi, CART.ngay_mua, CART.trang_thai  \n" +
                "FROM USER_ELECTRO, CART, PRODUCT\n" +
                "WHERE ((CART.ma_nguoi_dung = USER_ELECTRO.ma_nguoi_dung) AND (PRODUCT.ma_san_pham = CART.ma_san_pham));";
        List<CartAdmin> list = new ArrayList<CartAdmin>();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                    int id_cart = rs.getInt("id_cart");
                    int ma_san_pham = rs.getInt("ma_san_pham");
                    String ten_san_pham = rs.getString("ten_san_pham");
                    int ma_loai_san_pham = rs.getInt("ma_loai_san_pham");
                    int so_luong = rs.getInt("so_luong");
                    int gia_ban = rs.getInt("gia_ban");
                    int thanh_tien = rs.getInt("thanh_tien");
                    int ma_nguoi_dung = rs.getInt("ma_nguoi_dung");
                    String ten_nguoi_dung = rs.getString("user__name");
                    String sdt = rs.getString("sdt");
                    String dia_chi = rs.getString("dia_chi");
                    Date ngay_mua = rs.getDate("ngay_mua");
                    String trang_thai = rs.getString("trang_thai");
                    list.add(new CartAdmin(id_cart, ma_san_pham, ten_san_pham, ma_loai_san_pham, so_luong, gia_ban, thanh_tien, ma_nguoi_dung, ten_nguoi_dung, sdt, dia_chi, ngay_mua, trang_thai));
                }
                con.close();
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<CartAdmin> getListCartAdminCategory(int id) {
        Connection con = DBConnect.getConnect();
        String sql = "SELECT CART.id_cart, CART.ma_san_pham, PRODUCT.ten_san_pham, PRODUCT.ma_loai_san_pham, CART.so_luong, PRODUCT.gia_ban, CART.thanh_tien, USER_ELECTRO.ma_nguoi_dung, USER_ELECTRO.user__name, CART.sdt, CART.dia_chi, CART.ngay_mua, CART.trang_thai  \n" +
                "FROM USER_ELECTRO, CART, PRODUCT\n" +
                "WHERE ((CART.ma_nguoi_dung = USER_ELECTRO.ma_nguoi_dung) AND (PRODUCT.ma_san_pham = CART.ma_san_pham) AND ma_loai_san_pham = '" + id + "');";
        List<CartAdmin> list = new ArrayList<CartAdmin>();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                    int id_cart = rs.getInt("id_cart");
                    int ma_san_pham = rs.getInt("ma_san_pham");
                    String ten_san_pham = rs.getString("ten_san_pham");
                    int ma_loai_san_pham = rs.getInt("ma_loai_san_pham");
                    int so_luong = rs.getInt("so_luong");
                    int gia_ban = rs.getInt("gia_ban");
                    int thanh_tien = rs.getInt("thanh_tien");
                    int ma_nguoi_dung = rs.getInt("ma_nguoi_dung");
                    String ten_nguoi_dung = rs.getString("user__name");
                    String sdt = rs.getString("sdt");
                    String dia_chi = rs.getString("dia_chi");
                    Date ngay_mua = rs.getDate("ngay_mua");
                    String trang_thai = rs.getString("trang_thai");
                    list.add(new CartAdmin(id_cart, ma_san_pham, ten_san_pham, ma_loai_san_pham, so_luong, gia_ban, thanh_tien, ma_nguoi_dung, ten_nguoi_dung, sdt, dia_chi, ngay_mua, trang_thai));
                }
                con.close();
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return list;
    }

    @Override
    public void editCartAdmin(int id_cart, String trang_thai) {
        Connection con = DBConnect.getConnect();
        String sql = "UPDATE CART SET trang_thai=N'" + trang_thai + "' WHERE(id_cart = '" + id_cart + "');";
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
    public int countCartCategory(int id) {
        int count = 0;
        Connection con = DBConnect.getConnect();
        String sql = "SELECT COUNT(id_cart) FROM CART, PRODUCT, USER_ELECTRO WHERE((USER_ELECTRO.ma_nguoi_dung = CART.ma_nguoi_dung AND USER_ELECTRO.trang_thai = N'Hoạt động' AND CART.ma_san_pham = PRODUCT.ma_san_pham) AND (PRODUCT.ma_loai_san_pham = '" + id + "'));";
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
    public CartAdmin getCart(int id) {
        Connection con = DBConnect.getConnect();
        String sql = "SELECT CART.id_cart, CART.ma_san_pham, PRODUCT.ten_san_pham, PRODUCT.ma_loai_san_pham, CART.so_luong, PRODUCT.gia_ban, CART.thanh_tien, USER_ELECTRO.ma_nguoi_dung, USER_ELECTRO.user__name, CART.sdt, CART.dia_chi, CART.ngay_mua, CART.trang_thai  \n" +
                "FROM USER_ELECTRO, CART, PRODUCT\n" +
                "WHERE ((CART.ma_nguoi_dung = USER_ELECTRO.ma_nguoi_dung) AND (PRODUCT.ma_san_pham = CART.ma_san_pham) AND CART.id_cart = '" + id + "');";
        CartAdmin ca=null;
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                    int id_cart = rs.getInt("id_cart");
                    int ma_san_pham = rs.getInt("ma_san_pham");
                    String ten_san_pham = rs.getString("ten_san_pham");
                    int ma_loai_san_pham = rs.getInt("ma_loai_san_pham");
                    int so_luong = rs.getInt("so_luong");
                    int gia_ban = rs.getInt("gia_ban");
                    int thanh_tien = rs.getInt("thanh_tien");
                    int ma_nguoi_dung = rs.getInt("ma_nguoi_dung");
                    String ten_nguoi_dung = rs.getString("user__name");
                    String sdt = rs.getString("sdt");
                    String dia_chi = rs.getString("dia_chi");
                    Date ngay_mua = rs.getDate("ngay_mua");
                    String trang_thai = rs.getString("trang_thai");
                    ca = new CartAdmin(id_cart, ma_san_pham, ten_san_pham, ma_loai_san_pham, so_luong, gia_ban, thanh_tien, ma_nguoi_dung, ten_nguoi_dung, sdt, dia_chi, ngay_mua, trang_thai);
                }
                con.close();
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return ca;
    }

    @Override
    public List<CartAdmin> getListCartAdminCategory(int id, int tuy_chon) {
        Connection con = DBConnect.getConnect();
        String sql = "";
        if(tuy_chon == 0) {
            sql = "SELECT CART.id_cart, CART.ma_san_pham, PRODUCT.ten_san_pham, PRODUCT.ma_loai_san_pham, CART.so_luong, PRODUCT.gia_ban, CART.thanh_tien, USER_ELECTRO.ma_nguoi_dung, USER_ELECTRO.user__name, CART.sdt, CART.dia_chi, CART.ngay_mua, CART.trang_thai  \n" +
                    "FROM USER_ELECTRO, CART, PRODUCT\n" +
                    "WHERE ((CART.ma_nguoi_dung = USER_ELECTRO.ma_nguoi_dung) AND (PRODUCT.ma_san_pham = CART.ma_san_pham) AND PRODUCT.ma_loai_san_pham = '" + id + "' AND USER_ELECTRO.trang_thai = N'Hoạt động');";
        }
        if(tuy_chon == 1) {
            sql = "SELECT CART.id_cart, CART.ma_san_pham, PRODUCT.ten_san_pham, PRODUCT.ma_loai_san_pham, CART.so_luong, PRODUCT.gia_ban, CART.thanh_tien, USER_ELECTRO.ma_nguoi_dung, USER_ELECTRO.user__name, CART.sdt, CART.dia_chi, CART.ngay_mua, CART.trang_thai  \n" +
                    "FROM USER_ELECTRO, CART, PRODUCT\n" +
                    "WHERE ((CART.ma_nguoi_dung = USER_ELECTRO.ma_nguoi_dung) AND (PRODUCT.ma_san_pham = CART.ma_san_pham) AND PRODUCT.ma_loai_san_pham = '" + id + "' AND USER_ELECTRO.trang_thai = N'Hoạt động')"
                    + "ORDER BY PRODUCT.ten_san_pham;";
        }
        if(tuy_chon == 2) {
            sql = "SELECT CART.id_cart, CART.ma_san_pham, PRODUCT.ten_san_pham, PRODUCT.ma_loai_san_pham, CART.so_luong, PRODUCT.gia_ban, CART.thanh_tien, USER_ELECTRO.ma_nguoi_dung, USER_ELECTRO.user__name, CART.sdt, CART.dia_chi, CART.ngay_mua, CART.trang_thai  \n" +
                    "FROM USER_ELECTRO, CART, PRODUCT\n" +
                    "WHERE ((CART.ma_nguoi_dung = USER_ELECTRO.ma_nguoi_dung) AND (PRODUCT.ma_san_pham = CART.ma_san_pham) AND PRODUCT.ma_loai_san_pham = '" + id + "' AND USER_ELECTRO.trang_thai = N'Hoạt động')"
                    + "ORDER BY CART.thanh_tien;";
        }
        if(tuy_chon == 3) {
            sql = "SELECT CART.id_cart, CART.ma_san_pham, PRODUCT.ten_san_pham, PRODUCT.ma_loai_san_pham, CART.so_luong, PRODUCT.gia_ban, CART.thanh_tien, USER_ELECTRO.ma_nguoi_dung, USER_ELECTRO.user__name, CART.sdt, CART.dia_chi, CART.ngay_mua, CART.trang_thai  \n" +
                    "FROM USER_ELECTRO, CART, PRODUCT\n" +
                    "WHERE ((CART.ma_nguoi_dung = USER_ELECTRO.ma_nguoi_dung) AND (PRODUCT.ma_san_pham = CART.ma_san_pham) AND PRODUCT.ma_loai_san_pham = '" + id + "' AND USER_ELECTRO.trang_thai = N'Hoạt động')"
                    + "ORDER BY CART.ngay_mua;";
        }
        if(tuy_chon == 4) {
            sql = "SELECT CART.id_cart, CART.ma_san_pham, PRODUCT.ten_san_pham, PRODUCT.ma_loai_san_pham, CART.so_luong, PRODUCT.gia_ban, CART.thanh_tien, USER_ELECTRO.ma_nguoi_dung, USER_ELECTRO.user__name, CART.sdt, CART.dia_chi, CART.ngay_mua, CART.trang_thai  \n" +
                    "FROM USER_ELECTRO, CART, PRODUCT\n" +
                    "WHERE ((CART.ma_nguoi_dung = USER_ELECTRO.ma_nguoi_dung) AND (PRODUCT.ma_san_pham = CART.ma_san_pham) AND PRODUCT.ma_loai_san_pham = '" + id + "' AND USER_ELECTRO = N'Hoạt động')"
                    + "ORDER BY CART.trang_thai;";
        }
        
        List<CartAdmin> list = new ArrayList<CartAdmin>();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                    int id_cart = rs.getInt("id_cart");
                    int ma_san_pham = rs.getInt("ma_san_pham");
                    String ten_san_pham = rs.getString("ten_san_pham");
                    int ma_loai_san_pham = rs.getInt("ma_loai_san_pham");
                    int so_luong = rs.getInt("so_luong");
                    int gia_ban = rs.getInt("gia_ban");
                    int thanh_tien = rs.getInt("thanh_tien");
                    int ma_nguoi_dung = rs.getInt("ma_nguoi_dung");
                    String ten_nguoi_dung = rs.getString("user__name");
                    String sdt = rs.getString("sdt");
                    String dia_chi = rs.getString("dia_chi");
                    Date ngay_mua = rs.getDate("ngay_mua");
                    String trang_thai = rs.getString("trang_thai");
                    list.add(new CartAdmin(id_cart, ma_san_pham, ten_san_pham, ma_loai_san_pham, so_luong, gia_ban, thanh_tien, ma_nguoi_dung, ten_nguoi_dung, sdt, dia_chi, ngay_mua, trang_thai));
                }
                con.close();
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<CartAdmin> getListCartAdmin(int tuy_chon) {
        Connection con = DBConnect.getConnect();
        String sql = "";
        if(tuy_chon == 0) {
            sql = "SELECT CART.id_cart, CART.ma_san_pham, PRODUCT.ten_san_pham, PRODUCT.ma_loai_san_pham, CART.so_luong, PRODUCT.gia_ban, CART.thanh_tien, USER_ELECTRO.ma_nguoi_dung, USER_ELECTRO.user__name, CART.sdt, CART.dia_chi, CART.ngay_mua, CART.trang_thai  \n" +
                    "FROM USER_ELECTRO, CART, PRODUCT\n" +
                    "WHERE ((CART.ma_nguoi_dung = USER_ELECTRO.ma_nguoi_dung) AND (PRODUCT.ma_san_pham = CART.ma_san_pham) AND USER_ELECTRO.trang_thai = N'Hoạt động') ;";
        }
        if(tuy_chon == 1) {
            sql = "SELECT CART.id_cart, CART.ma_san_pham, PRODUCT.ten_san_pham, PRODUCT.ma_loai_san_pham, CART.so_luong, PRODUCT.gia_ban, CART.thanh_tien, USER_ELECTRO.ma_nguoi_dung, USER_ELECTRO.user__name, CART.sdt, CART.dia_chi, CART.ngay_mua, CART.trang_thai  \n" +
                    "FROM USER_ELECTRO, CART, PRODUCT\n" +
                    "WHERE ((CART.ma_nguoi_dung = USER_ELECTRO.ma_nguoi_dung) AND (PRODUCT.ma_san_pham = CART.ma_san_pham) AND USER_ELECTRO.trang_thai = N'Hoạt động')"
                    + "ORDER BY PRODUCT.ten_san_pham;";
        }
        if(tuy_chon == 2) {
            sql = "SELECT CART.id_cart, CART.ma_san_pham, PRODUCT.ten_san_pham, PRODUCT.ma_loai_san_pham, CART.so_luong, PRODUCT.gia_ban, CART.thanh_tien, USER_ELECTRO.ma_nguoi_dung, USER_ELECTRO.user__name, CART.sdt, CART.dia_chi, CART.ngay_mua, CART.trang_thai  \n" +
                    "FROM USER_ELECTRO, CART, PRODUCT\n" +
                    "WHERE ((CART.ma_nguoi_dung = USER_ELECTRO.ma_nguoi_dung) AND (PRODUCT.ma_san_pham = CART.ma_san_pham) AND USER_ELECTRO.trang_thai = N'Hoạt động')"
                    + "ORDER BY CART.thanh_tien;";
        }
        if(tuy_chon == 3) {
            sql = "SELECT CART.id_cart, CART.ma_san_pham, PRODUCT.ten_san_pham, PRODUCT.ma_loai_san_pham, CART.so_luong, PRODUCT.gia_ban, CART.thanh_tien, USER_ELECTRO.ma_nguoi_dung, USER_ELECTRO.user__name, CART.sdt, CART.dia_chi, CART.ngay_mua, CART.trang_thai  \n" +
                    "FROM USER_ELECTRO, CART, PRODUCT\n" +
                    "WHERE ((CART.ma_nguoi_dung = USER_ELECTRO.ma_nguoi_dung) AND (PRODUCT.ma_san_pham = CART.ma_san_pham) AND USER_ELECTRO.trang_thai = N'Hoạt động')"
                    + "ORDER BY CART.ngay_mua;";
        }
        if(tuy_chon == 4) {
            sql = "SELECT CART.id_cart, CART.ma_san_pham, PRODUCT.ten_san_pham, PRODUCT.ma_loai_san_pham, CART.so_luong, PRODUCT.gia_ban, CART.thanh_tien, USER_ELECTRO.ma_nguoi_dung, USER_ELECTRO.user__name, CART.sdt, CART.dia_chi, CART.ngay_mua, CART.trang_thai  \n" +
                    "FROM USER_ELECTRO, CART, PRODUCT\n" +
                    "WHERE ((CART.ma_nguoi_dung = USER_ELECTRO.ma_nguoi_dung) AND (PRODUCT.ma_san_pham = CART.ma_san_pham) AND USER_ELECTRO.trang_thai = N'Hoạt động')"
                    + "ORDER BY CART.trang_thai;";
        }
        List<CartAdmin> list = new ArrayList<CartAdmin>();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                    int id_cart = rs.getInt("id_cart");
                    int ma_san_pham = rs.getInt("ma_san_pham");
                    String ten_san_pham = rs.getString("ten_san_pham");
                    int ma_loai_san_pham = rs.getInt("ma_loai_san_pham");
                    int so_luong = rs.getInt("so_luong");
                    int gia_ban = rs.getInt("gia_ban");
                    int thanh_tien = rs.getInt("thanh_tien");
                    int ma_nguoi_dung = rs.getInt("ma_nguoi_dung");
                    String ten_nguoi_dung = rs.getString("user__name");
                    String sdt = rs.getString("sdt");
                    String dia_chi = rs.getString("dia_chi");
                    Date ngay_mua = rs.getDate("ngay_mua");
                    String trang_thai = rs.getString("trang_thai");
                    list.add(new CartAdmin(id_cart, ma_san_pham, ten_san_pham, ma_loai_san_pham, so_luong, gia_ban, thanh_tien, ma_nguoi_dung, ten_nguoi_dung, sdt, dia_chi, ngay_mua, trang_thai));
                }
                con.close();
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return list;
    }
}