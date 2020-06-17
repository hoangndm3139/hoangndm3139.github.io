package controller;

import dao.ProductDAOImple;
import java.io.IOException;
import java.io.InputStream;
import java.io.*;
import java.nio.file.Paths;
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
public class AddProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");    
        String applicationPath = getServletContext().getRealPath("");
        String ten_san_pham = request.getParameter("ten_san_pham");
        String loai_san_pham = request.getParameter("loai_san_pham");
        int gia_tien = Integer.parseInt(request.getParameter("gia_ban"));
        int ma_loai_san_pham = 0;       
        if(null != loai_san_pham) switch (loai_san_pham) {
            case "Điện thoại":
                ma_loai_san_pham = 1;
                break;
            case "Tivi":
                ma_loai_san_pham = 2;
                break;
            case "Máy tính":
                ma_loai_san_pham = 3;
                break;
            case "Máy ảnh":
                ma_loai_san_pham = 4;
                break;
            case "Máy tính bảng":
                ma_loai_san_pham = 5;
                break;
        }       
        Part[] part = new Part[5];
        part[0] = request.getPart("hinh_anh_1");
        String fileName = Paths.get("hinh_anh_1").toString();
        part[1] = request.getPart("hinh_anh_2");
        part[2] = request.getPart("hinh_anh_3");
        part[3] = request.getPart("hinh_anh_4");
        part[4] = request.getPart("hinh_anh_5"); 
        
        String[] filename = new String[5];
        filename[0] = part[0].getSubmittedFileName();
        filename[1] = part[1].getSubmittedFileName();
        filename[2] = part[2].getSubmittedFileName();
        filename[3] = part[3].getSubmittedFileName();
        filename[4] = part[4].getSubmittedFileName();
              
        Product p;
        p = new Product(ma_loai_san_pham, ten_san_pham, fileName, filename[1], filename[2], filename[3], filename[4], gia_tien);
        ProductDAOImple productDAO = new ProductDAOImple();
        productDAO.addProduct(p);
        response.sendRedirect("addproductadmin.jsp");
    }  
}