package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import dao.UserDAOImple;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.text.html.HTML;

public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final UserDAOImple userDAO = new UserDAOImple();
        @Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		java.sql.Date ngaysinh= null;		
		try {
			ngaysinh = new java.sql.Date((new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"))).getTime());
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		String gioitinh = request.getParameter("sex");
		String email = request.getParameter("email");
		String sdt = request.getParameter("phone");
		String diachi = request.getParameter("address");

		String error = "";
		String url = "/signup.jsp";

		if (username.equals("") || password.equals("") || email.equals("") || diachi.equals("") || sdt.equals("")) {
                    error += "Vui lòng nhập đầy đủ thông tin!";
		} 
                else {
                    if (userDAO.checkUser(username, email) == true ) {
                        error += "Tên đăng nhập hoặc địa chỉ email đã tồn tại!";
                    }else{
                        final String email_check = "thabka99@gmail.com";
                        final String password_check = "0328512559";
                        
                        Properties prop = new Properties();
                        prop.put("mail.smtp.host", "smtp.gmail.com");
                        prop.put("mail.smtp.port", "587");
                        prop.put("mail.smtp.auth", "true");
                        prop.put("mail.smtp.starttls.enable", "true");

                        Session session = Session.getInstance(prop,
                            new javax.mail.Authenticator() {
                            @Override
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(email_check, password_check);
                            }
                        });

                        try {
                            Message message = new MimeMessage(session);
                            message.setHeader("Content-Type", "text/plain; charset=UTF-8");
                            message.setFrom(new InternetAddress("thabka99@gmail.com"));
                            message.setRecipients(
                                Message.RecipientType.TO,
                                InternetAddress.parse(email)
                            );               
                            message.setSubject("Register Successful!");
                            String text ="<i>Cám ơn bạn đăng ký tài khoản sử dụng dịch vụ chúng tôi!</i>"
                                    + "<br/>"
                                    + "Nhóm 1 Công Nghệ Phần Mềm!";  
                            message.setContent(text, "text/html; charset=utf-8");
                            
                            Transport.send(message);                  
                            System.out.println("Done!");

                        } catch (AddressException ex) {                          
                            error += "Địa chỉ email không tồn tại!";                          
                        } catch (MessagingException e) {
                            throw new RuntimeException(e);
                        }         
                    } 
		}
            
		if (error.length() > 0) {
			request.setAttribute("error", error);
		}

		try {
                    if (error.length() == 0) {
                        userDAO.addUser(new User(0, username, password, ngaysinh, gioitinh, email, sdt, diachi, 2, "Hoạt động"));
                        userDAO.loginUser(username, password);
                        Cookie loginCookie = new Cookie("username",username);
                        //setting cookie to expiry in 60 mins
                        loginCookie.setMaxAge(60*60);
                        response.addCookie(loginCookie);
                        response.sendRedirect("index.jsp");
                    } else {
                            url = "/signup.jsp";
                            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                            rd.forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/signup.jsp");
		}

	}

}
