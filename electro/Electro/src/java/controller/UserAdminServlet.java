package controller;

import model.User;
import dao.UserDAOImple;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserAdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final UserDAOImple userDAO = new UserDAOImple();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String trang_thai = request.getParameter("trang_thai");              
        User u = userDAO.getUser(username);
        User new_user = new User(u.getMa_nguoi_dung(), u.getUser__name(), u.getPass_word(), u.getNgay_sinh(), u.getGioi_tinh(), u.getEmail(), u.getSdt(), u.getDia_chi(), u.getRo_le(), trang_thai);
        userDAO.updateUser(new_user);        
        response.sendRedirect("useradmin.jsp");
    }   
}