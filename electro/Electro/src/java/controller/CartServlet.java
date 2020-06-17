package controller;

import dao.CartDAOImple;
import dao.UserDAOImple;
import java.io.IOException;
import java.sql.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cart;
import model.User;

public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public  CartServlet() {
        super();
    }
    @Override
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String ma_nguoi_dung = request.getParameter("ma_nguoi_dung");
        String username = request.getParameter("username");
        String ma_san_pham = request.getParameter("ma_san_pham");
        String ten_san_pham = request.getParameter("ten_san_pham");
        int so_luong = Integer.parseInt(request.getParameter("so_luong"));
        float sale = Float.parseFloat(request.getParameter("sale"));
        String sdt = request.getParameter("sdt");
        String dia_chi = request.getParameter("dia_chi");
        long millis = System.currentTimeMillis();  
        java.sql.Date ngay_mua = new java.sql.Date(millis);        
        int tong_tien = (int)(Integer.parseInt(request.getParameter("gia_ban")) * so_luong * (1-sale));        
        Cart c = new Cart(Integer.parseInt(ma_nguoi_dung), Integer.parseInt(ma_san_pham), ten_san_pham, ngay_mua, so_luong, tong_tien, "Đang xử lí", sdt, dia_chi);        
        CartDAOImple cartDAO = new CartDAOImple();
        cartDAO.addCart(c);      
        String messager = "Thông tin chi tiết về đơn hàng đã được gửi đến địa chỉ email của bạn. Vui lòng kiểm tra email!";
        if(messager.length() > 0) {
            request.setAttribute("messager", messager);
        }             
        String url = "/yourcart.jsp";
        try {
            UserDAOImple userDAO = new UserDAOImple();
            User u = userDAO.getUser(username);           
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
                message.setSubject("Information Cart");
                String text ="<i>Thông tin đơn hàng Electro</i><br/>";
                text+="<p>Tên sản phẩm: <strong>"; text+=c.getTen_san_pham(); text+="</strong></p>";
                text+="<p>Trạng thái: <strong>"; text+=c.getTrang_thai(); text +="</strong></p>";
                text+="<p>Số điện thoại: <strong>"; text+=c.getSdt(); text +="</strong></p>";
                text+="<p>Địa chỉ giao hàng: <strong>"; text+=c.getDia_chi(); text +="</strong></p>";
                text+="<p>Thời gian: <strong>"; text+=c.getNgay_mua(); text +="</strong></p>";
                text+="<p>Số lượng: <strong>"; text+=c.getSo_luong(); text +="</strong></p>";
                text+="<p>Tổng tiền: <strong>"; text+=c.getThanh_tien(); text +=" VNĐ</strong></p>";              
                message.setContent(text, "text/html; charset=utf-8");
                    
                Transport.send(message);                  
                System.out.println("Done");

            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }              
        } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("/index.jsp");
            }
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request, response);
        }  
               
} 
   
       
