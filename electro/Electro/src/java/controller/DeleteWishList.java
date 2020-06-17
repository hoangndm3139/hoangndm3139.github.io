package controller;

import dao.CartDAOImple;
import dao.WishlistDAOImple;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteWishList extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        int id_wishlist = Integer.parseInt(request.getParameter("id_wishlist"));
        WishlistDAOImple wishlistDAO = new WishlistDAOImple();
        wishlistDAO.removeWishList(id_wishlist);
        response.sendRedirect("yourwishlist.jsp");
    }    
}
       