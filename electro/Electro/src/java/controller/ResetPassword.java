package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import dao.UserDAOImple;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class ResetPassword extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final UserDAOImple userDAO = new UserDAOImple();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        String username = request.getParameter("username");
        
        String error = "";
        String messager = "";
        if (username.equals("")) {
            error += "Vui lòng nhập đúng tên người dùng!";
        } 
        else {
            if (userDAO.checkResetPassword(username) == false) {
                error += "Tên người dùng không đúng!";
            }
            else {
                messager += "Mật khẩu mới đã được gửi đến địa chỉ email của bạn, vui lòng kiểm tra email!"; 
            }
        }
        if (error.length() > 0 || messager.length() > 0) {
            request.setAttribute("error", error);
            request.setAttribute("messager", messager);
        }
        
        String url = "/resetpassword.jsp";
        try {
            if (error.length() == 0) {
                User u = userDAO.getUser(username);
                User new_user = new User(u.getMa_nguoi_dung(), username, "resetpassword", u.getNgay_sinh(), u.getGioi_tinh(), u.getEmail(), u.getSdt(), u.getDia_chi(), u.getRo_le(), u.getTrang_thai());
                userDAO.updateUser(new_user);                                           
                
                final String email = "thabka99@gmail.com";
                final String password = "0328512559";

                Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
                prop.put("mail.smtp.port", "587");
                prop.put("mail.smtp.auth", "true");
                prop.put("mail.smtp.starttls.enable", "true");
        
                Session session = Session.getInstance(prop,
                    new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(email, password);
                    }
                });

                try {
                    Message message = new MimeMessage(session);
                    message.setHeader("Content-Type", "text/plain; charset=UTF-8");
                    message.setFrom(new InternetAddress("thabka99@gmail.com"));
                    message.setRecipients(
                        Message.RecipientType.TO,
                        InternetAddress.parse(u.getEmail())
                    );               
                    message.setSubject("ResetPassword");
                    String text ="<i>Khôi phục mật khẩu thành công!</i><br/>";
                    text+="<p>Mật khẩu mới: <strong>"; text+="resetpassword"; text+="</strong></p>";             
                    message.setContent(text, "text/html; charset=utf-8");
                    Transport.send(message);                  
                    System.out.println("Done");

                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }              
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request, response);
    } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/index.jsp");
        }
    }  
    
}
