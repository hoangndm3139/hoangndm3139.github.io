<%@page import="dao.CartDAOImple"%>
<%@page import="model.Product"%>
<%@page import="dao.ProductDAOImple"%>
<%@page import="model.User"%>
<%@page import="dao.UserDAOImple"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
         <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>Thêm sản phẩm</title>
        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">
        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>
        <!-- Slick -->
        <link type="text/css" rel="stylesheet" href="css/slick.css"/>
        <link type="text/css" rel="stylesheet" href="css/slick-theme.css"/>
        <!-- nouislider -->
        <link type="text/css" rel="stylesheet" href="css/nouislider.min.css"/>
        <!-- Font Awesome Icon -->
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <!-- Custom stlylesheet -->
        <link type="text/css" rel="stylesheet" href="css/style.css"/>
    </head>
    
    <body>
        <%
            UserDAOImple userDAO = new UserDAOImple();
            ProductDAOImple productDAO = new ProductDAOImple();
            CartDAOImple cartDAO = new CartDAOImple();
            int sum1 = productDAO.countProduct(1) + productDAO.countProduct(2) + productDAO.countProduct(3) + productDAO.countProduct(4) + productDAO.countProduct(5);
            int sum2 = cartDAO.countCartCategory(1) + cartDAO.countCartCategory(2) + cartDAO.countCartCategory(3) + cartDAO.countCartCategory(4) + cartDAO.countCartCategory(5);
        %>     
        <div>
            <h4>TÀI KHOẢN</h4>
            <nav class="list-group">
                <ul>
                    <li class="list-group-item"><a href="myaccount.jsp">Tài khoản của tôi</a></li>
                    <li class="list-group-item"><a href="useradmin.jsp">Tài khoản khách hàng(<%=userDAO.countUser()%>)</a></li>
                </ul>
            </nav>
            <h4>SẢN PHẨM</h4>
            <nav class="list-group">
                <ul>
                    <li class="list-group-item"><a href="listproductadmin.jsp?ma_loai_san_pham=1&tuy_chon=0">Điện thoại(<%=productDAO.countProduct(1)%>)</a></li>
                    <li class="list-group-item"><a href="listproductadmin.jsp?ma_loai_san_pham=2&tuy_chon=0">Tivi(<%=productDAO.countProduct(2)%>)</a></li>
                    <li class="list-group-item"><a href="listproductadmin.jsp?ma_loai_san_pham=3&tuy_chon=0">Máy tính(<%=productDAO.countProduct(3)%>)</a></li>
                    <li class="list-group-item"><a href="listproductadmin.jsp?ma_loai_san_pham=4&tuy_chon=0">Máy ảnh(<%=productDAO.countProduct(4)%>)</a></li>
                    <li class="list-group-item"><a href="listproductadmin.jsp?ma_loai_san_pham=5&tuy_chon=0">Máy tính bảng(<%=productDAO.countProduct(5)%>)</a></li>
                    <li class="list-group-item"><a href="listproductadmin.jsp?ma_loai_san_pham=12345&tuy_chon=0">Tất cả sản phẩm(<%=sum1%>)</a></li>
                    <li class="list-group-item"><a href="addproductadmin.jsp">Thêm sản phẩm</a></li>
                </ul>
            </nav>
            <h4>ĐƠN HÀNG</h4>
            <nav class="list-group">
                <ul>
                    <li class="list-group-item"><a href="listcartadmin.jsp?ma_loai_san_pham=1&tuy_chon=0">Đơn hàng điện thoại(<%=cartDAO.countCartCategory(1)%>)</a></li>
                    <li class="list-group-item"><a href="listcartadmin.jsp?ma_loai_san_pham=2&tuy_chon=0">Đơn hàng ti vi(<%=cartDAO.countCartCategory(2)%>)</a></li>
                    <li class="list-group-item"><a href="listcartadmin.jsp?ma_loai_san_pham=3&tuy_chon=0">Đơn hàng máy tính(<%=cartDAO.countCartCategory(3)%>)</a></li>
                    <li class="list-group-item"><a href="listcartadmin.jsp?ma_loai_san_pham=4&tuy_chon=0">Đơn hàng máy ảnh(<%=cartDAO.countCartCategory(4)%>)</a></li>
                    <li class="list-group-item"><a href="listcartadmin.jsp?ma_loai_san_pham=5&tuy_chon=0">Đơn hàng máy tính bảng(<%=cartDAO.countCartCategory(5)%>)</a></li>
                    <li class="list-group-item"><a href="listcartadmin.jsp?ma_loai_san_pham=12345&tuy_chon=0">Tất cả đơn hàng(<%=sum2%>)</a></li>
                </ul>
            </nav>
        </div>   
                   
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/slick.min.js"></script>
        <script src="js/nouislider.min.js"></script>
        <script src="js/jquery.zoom.min.js"></script>
        <script src="js/main.js"></script>
        
    </body>
</html>