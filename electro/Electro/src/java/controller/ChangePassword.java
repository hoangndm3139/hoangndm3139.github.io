package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import dao.UserDAOImple;

public class ChangePassword extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final UserDAOImple userDAO = new UserDAOImple();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String newpassword = request.getParameter("newpassword");
        String renewpassword = request.getParameter("renewpassword");
        
        String error = "";
        String messager = "";
        if (password.equals("") || newpassword.equals("") || newpassword.equals("")) {
            error += "Vui lòng nhập đầy đủ thông tin!";
        } 
        else if(!newpassword.equals(renewpassword)){
            error += "Mật khẩu xác nhận không đúng";
        }
        else {
            User u = userDAO.getUser(username);
            if(!password.equals(u.getPass_word())) {
                error += "Mật khẩu cũ không chính xác!";
            }
            else {
                messager += "Thay đổi mật khẩu thành công!";
            }
        }
        
        if (error.length() > 0 || messager.length() > 0) {
            request.setAttribute("error", error);
            request.setAttribute("messager", messager);
        }
        
        String url = "/changepassword.jsp";
        try {
            if (error.length() == 0) {
                User u = userDAO.getUser(username);
                User new_user = new User(u.getMa_nguoi_dung(), username, newpassword, u.getNgay_sinh(), u.getGioi_tinh(), u.getEmail(), u.getSdt(), u.getDia_chi(), u.getRo_le(), u.getTrang_thai());
                userDAO.updateUser(new_user);                                                           
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
    } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/index.jsp");
        }
    }

}