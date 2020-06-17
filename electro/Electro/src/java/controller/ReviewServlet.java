package controller;

import dao.ProductDAOImple;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAOImple;
import java.sql.Date;
import model.Review;

public class ReviewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final UserDAOImple userDAO = new UserDAOImple();
    @Override
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String reviewtext = request.getParameter("reviewtext");
            int ma_san_pham = Integer.parseInt(request.getParameter("ma_san_pham"));
            
            int rating;
            if(request.getParameter("rating") == null) {
                rating = 0;
            }else{
                rating = Integer.parseInt(request.getParameter("rating"));
            }
                     
            long millis = System.currentTimeMillis();  
            java.sql.Date time = new java.sql.Date(millis);
            
            String error = "";
            if (name.equals("") || email.equals("") || reviewtext.equals("")) {
                    error += "Đánh giá không thành công!";
                    request.setAttribute("error", error);
            } 
            if (error.length() > 0) {
                    request.setAttribute("error", error);
            }

            String url = "/product.jsp?ma_san_pham=" + Integer.toString(ma_san_pham);
            try {
                if (error.length() == 0) {                
                    Review r = new Review(ma_san_pham, name, email, reviewtext, rating, time);
                    ProductDAOImple productDAO = new ProductDAOImple();
                    productDAO.addReviewProduct(r);
                    response.sendRedirect("product.jsp?ma_san_pham=" + Integer.toString(ma_san_pham));
                    url = "/product.jsp?ma_san_pham=" + Integer.toString(ma_san_pham);
                } 
                else {
                    url = "/product.jsp?ma_san_pham=" + Integer.toString(ma_san_pham);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                    rd.forward(request, response);
                }			
            } catch (IOException e) {
                    response.sendRedirect("/product.jsp?ma_san_pham=" + Integer.toString(ma_san_pham));
        }
    }
}

