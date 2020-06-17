package controller;

import dao.CartDAOImple;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCart extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        int id_cart = Integer.parseInt(request.getParameter("id_cart"));
        CartDAOImple cartDAO = new CartDAOImple();
        cartDAO.removeCart(id_cart);
        response.sendRedirect("yourcart.jsp");
    }
}