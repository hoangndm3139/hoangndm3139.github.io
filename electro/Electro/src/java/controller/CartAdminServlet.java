package controller;

import dao.CartDAOImple;
import dao.ProductDAOImple;
import java.io.IOException;
import java.io.InputStream;
import java.io.*;
import javax.servlet.annotation.*;
import java.util.Collection;
import javax.servlet.ServletConfig;
import javax.servlet.http.Part;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.CartAdmin;
import model.Product;

@MultipartConfig
public class CartAdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8"); 
        
        if(request.getParameter("update") != null) {
            int id_cart = Integer.parseInt(request.getParameter("id_cart"));            
            String trang_thai = request.getParameter("trang_thai");                            
            CartDAOImple cartDAO = new CartDAOImple();
            cartDAO.editCartAdmin(id_cart, trang_thai);           
            response.sendRedirect("cartadmin.jsp?ma_loai_san_pham=" + request.getParameter("id_cart") + "&ma_san_pham=" + request.getParameter("ma_san_pham"));
        } 
        if(request.getParameter("delete") != null) {
            int id_cart = Integer.parseInt(request.getParameter("id_cart"));            
            String trang_thai = request.getParameter("trang_thai");  
            CartDAOImple cartDAO = new CartDAOImple();
            cartDAO.removeCart(id_cart);
            if(id_cart == 1){
                response.sendRedirect("listcartadmin.jsp?ma_loai_san_pham=1");
            }
            if(id_cart == 2){
                response.sendRedirect("listcartadmin.jsp?ma_loai_san_pham=2");
            }
            if(id_cart == 3){
                response.sendRedirect("listcartadmin.jsp?ma_loai_san_pham=3");
            }
            if(id_cart == 4){
                response.sendRedirect("listcartadmin.jsp?ma_loai_san_pham=4");
            }
            if(id_cart == 5){
                response.sendRedirect("listcartadmin.jsp?ma_loai_san_pham=5");
            }
        }
    }
}
