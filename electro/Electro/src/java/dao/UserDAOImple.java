package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cart;

import model.User;

public class UserDAOImple implements UserDAO {

    @Override
    public void addUser(User u) {
        Connection con = DBConnect.getConnect();
        String sql = "INSERT INTO USER_ELECTRO(user__name, pass_word, ngay_sinh, gioi_tinh, email, sdt, dia_chi, ro_le, trang_thai) VALUES (?,?,?,?,?,?,?,?,?);";
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, u.getUser__name());
            ps.setString(2, u.getPass_word());
            ps.setDate(3, u.getNgay_sinh());
            ps.setString(4, u.getGioi_tinh());
            ps.setString(5, u.getEmail());
            ps.setString(6, u.getSdt());
            ps.setString(7, u.getDia_chi());
            ps.setInt(8, u.getRo_le());
            ps.setString(9, u.getTrang_thai());
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean checkUser(String username, String email) {
        Connection con = DBConnect.getConnect();
        String sql = "SELECT * FROM USER_ELECTRO WHERE user__name='" + username + "' or email='" + email + "';";
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                    con.close();
                    return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public List<User> getListUser() {
        Connection con = DBConnect.getConnect();
        String sql = "SELECT * FROM USER_ELECTRO WHERE ro_le = 2;";
        List<User> list = new ArrayList<User>();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                    int ma_nguoi_dung = rs.getInt("ma_nguoi_dung");
                    String user__name = rs.getString("user__name");
                    String pass_word = rs.getString("pass_word");
                    Date ngay_sinh = rs.getDate("ngay_sinh");
                    String gioi_tinh = rs.getString("gioi_tinh");
                    String email = rs.getString("email");
                    String sdt = rs.getString("sdt");
                    String dia_chi = rs.getString("dia_chi");
                    String trang_thai = rs.getString("trang_thai");
                    list.add(new User(ma_nguoi_dung, user__name, pass_word, ngay_sinh, gioi_tinh, email, sdt, dia_chi, ma_nguoi_dung, trang_thai));
                }
                con.close();
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return list;   
    }
    public static void main(String[] args) {
            UserDAOImple dao = new UserDAOImple();
            //System.out.print(dao.countUser());
            long millis = System.currentTimeMillis();  
            java.sql.Date test = new java.sql.Date(millis);
            dao.addUser(new User(0, "1", "1", test, "1", "1", "1", "1", 1, "1"));
            //System.out.println(dao.checkUser("test1"));
            //System.out.println(dao.loginUser("test1", "test1"));
    }

    @Override
    public boolean loginUser(String username, String password) {
        Connection con = DBConnect.getConnect();
        String sql = "SELECT * FROM USER_ELECTRO WHERE user__name='" + username + "' AND pass_word='" + password + "' AND trang_thai = N'Hoạt động';";
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                    con.close();
                    return true;
            }
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return false;
    }
    
    @Override
    public void updateUser(User u) {
        Connection con = DBConnect.getConnect();
        String sql = "UPDATE USER_ELECTRO SET pass_word=?, ngay_sinh=?, gioi_tinh=?, email=?, sdt=?, dia_chi=?, ro_le=?, trang_thai=? WHERE user__name=?";
        try {
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
                ps.setString(1, u.getPass_word());
                ps.setDate(2, u.getNgay_sinh());
                ps.setString(3, u.getGioi_tinh());
                ps.setString(4, u.getEmail());
                ps.setString(5, u.getSdt());
                ps.setString(6, u.getDia_chi());
                ps.setInt(7, u.getRo_le());
                ps.setString(8, u.getTrang_thai());
                ps.setString(9, u.getUser__name());
                ps.executeUpdate();
                con.close();
        } catch (SQLException e) {
                e.printStackTrace();
        }
    }

    @Override
    public User getUser(String username) {
        Connection con = DBConnect.getConnect();
        String sql = "SELECT * FROM USER_ELECTRO WHERE user__name='" + username + "'";
        User u = new User();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ma_nguoi_dung= rs.getInt("ma_nguoi_dung");
                String user__name = rs.getString("user__name");
                String pass_word = rs.getString("pass_word");
                Date ngay_sinh = rs.getDate("ngay_sinh");
                String gioi_tinh = rs.getString("gioi_tinh");
                String email = rs.getString("email");
                String sdt = rs.getString("sdt");
                String dia_chi = rs.getString("dia_chi");
                int ro_le = rs.getInt("ro_le");
                String trang_thai = rs.getString("trang_thai");
                u = new User(ma_nguoi_dung, user__name, pass_word, ngay_sinh, gioi_tinh, email, sdt, dia_chi, ro_le, trang_thai);
                }
                con.close();
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return u;
    }

    @Override
    public boolean removeUser(int ma_nguoi_dung) {
        Connection con = DBConnect.getConnect();
        String sql = "DELETE FROM USER_ELECTRO WHERE ma_nguoi_dung='" + ma_nguoi_dung + "';";
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.executeUpdate();
            con.close();
            return true;
        } catch (SQLException e) {
                e.printStackTrace();
                return false;
        }
    }  

    @Override
    public int countUser() {
        int count = 0;
        Connection con = DBConnect.getConnect();
        String sql = "SELECT COUNT(ma_nguoi_dung) FROM USER_ELECTRO WHERE(ro_le = '" + 2 + "');";
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
    public boolean checkResetPassword(String username) {
        Connection con = DBConnect.getConnect();
        String sql = "SELECT * FROM USER_ELECTRO WHERE user__name='" + username + "';";
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                    con.close();
                    return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }  
}
