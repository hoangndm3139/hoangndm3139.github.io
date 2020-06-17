package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAOImple;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final UserDAOImple userDAO = new UserDAOImple();

    @Override
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
            
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String error = "";
            if (username.equals("") || password.equals("")) {
                    error += "Vui lòng nhập thông tin tài khoản của bạn!";
            } 
            else {
                if (userDAO.loginUser(username, password) == false) {
                    error += "Tên đăng nhập/mật khẩu sai! Hoặc tài khoản của bạn đã bị khoá!";
                }
            }

            if (error.length() > 0) {
                    request.setAttribute("error", error);
            }

            String url = "/signin.jsp";
            try {
                if (error.length() == 0) {
                    HttpSession session = request.getSession();
                    session.setAttribute("username", username);
                    if(userDAO.loginUser(username, password)){
                        Cookie loginCookie = new Cookie("username", username);
                        //setting cookie to expiry in 60 mins
                        loginCookie.setMaxAge(60*60);
                        response.addCookie(loginCookie);
                        response.sendRedirect("index.jsp");
                        url = "/index.jsp";
                    }
                } 
                else {
                    url = "/signin.jsp";
                    RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                    rd.forward(request, response);
                }			
            } catch (IOException | ServletException e) {
                    response.sendRedirect("/signin.jsp");
        }
    }
}

