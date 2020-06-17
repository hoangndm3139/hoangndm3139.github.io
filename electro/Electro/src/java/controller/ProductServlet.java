package controller;

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
import model.Product;

@MultipartConfig
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8"); 
        
        if(request.getParameter("update") != null) {
            String ten_san_pham = request.getParameter("ten_san_pham");
            int gia_ban = Integer.parseInt(request.getParameter("gia_ban"));
            float sale = Float.parseFloat(request.getParameter("sale"));                       
            ProductDAOImple productDAO = new ProductDAOImple();
            Product temp = productDAO.getProduct(Integer.parseInt(request.getParameter("ma_san_pham")));
            Product p = new Product(temp.getMa_san_pham(), temp.getMa_loai_san_pham(), temp.getTen_san_pham(), temp.getHinh_anh_1(), temp.getHinh_anh_2(), temp.getHinh_anh_3(), temp.getHinh_anh_4(), temp.getHinh_anh_5(), gia_ban, sale);        
            productDAO.editProduct(p);
            response.sendRedirect("productadmin.jsp?ma_san_pham=" + request.getParameter("ma_san_pham"));
        }
        
        if(request.getParameter("delete") != null) {
            ProductDAOImple productDAO = new ProductDAOImple();
            productDAO.removeProduct(Integer.parseInt(request.getParameter("ma_san_pham")));
            Product temp = productDAO.getProduct(Integer.parseInt(request.getParameter("ma_san_pham")));
            
            if(temp.getMa_loai_san_pham() == 1){
                response.sendRedirect("listproductadmin.jsp?ma_loai_san_pham=1");
            }
            if(temp.getMa_loai_san_pham() == 2){
                response.sendRedirect("listproductadmin.jsp?ma_loai_san_pham=2");
            }
            if(temp.getMa_loai_san_pham() == 3){
                response.sendRedirect("listproductadmin.jsp?ma_loai_san_pham=3");
            }
            if(temp.getMa_loai_san_pham() == 4){
                response.sendRedirect("listproductadmin.jsp?ma_loai_san_pham=4");
            }
            if(temp.getMa_loai_san_pham() == 5){
                response.sendRedirect("listproductadmin.jsp?ma_loai_san_pham=5");
            }
        }
    }
}
