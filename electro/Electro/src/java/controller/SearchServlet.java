package controller;

import dao.ProductDAOImple;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;     
    public SearchServlet() {
        super();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma_loai_san_pham = request.getParameter("ma_loai_san_pham");
        String keyword = request.getParameter("keyword");
        
        HttpSession session = request.getSession();
        session.setAttribute("keyword", keyword);
        session.setAttribute("ma_loai_san_pham", ma_loai_san_pham);
        response.sendRedirect("search.jsp");
    }
}