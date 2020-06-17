package controller;

import dao.WishlistDAOImple;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Wishlist;

@SuppressWarnings("serial")

public class WishlistServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {       
        String ma_nguoi_dung = request.getParameter("ma_nguoi_dung");
        String ma_san_pham = request.getParameter("ma_san_pham");
        String ten_san_pham = request.getParameter("ten_san_pham");              
        Wishlist w = new Wishlist(Integer.parseInt(ma_nguoi_dung), Integer.parseInt(ma_san_pham), ten_san_pham);                
        WishlistDAOImple wishListDAO = new WishlistDAOImple();
        wishListDAO.addWishlist(w);       
        response.sendRedirect("yourwishlist.jsp");
    }
    @Override
    protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {      
        String ma_nguoi_dung = request.getParameter("ma_nguoi_dung");
        String ma_san_pham = request.getParameter("ma_san_pham");
        String ten_san_pham = request.getParameter("ten_san_pham");              
        Wishlist w = new Wishlist(Integer.parseInt(ma_nguoi_dung), Integer.parseInt(ma_san_pham), ten_san_pham);                
        WishlistDAOImple wishListDAO = new WishlistDAOImple();
        wishListDAO.addWishlist(w);       
        response.sendRedirect("yourwishlist.jsp");
    }
}
    