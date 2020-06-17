<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
         <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>Đăng kí</title>
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
        <jsp:include page="header.jsp"></jsp:include>
        <%
            String error = "";
            if (request.getAttribute("error") != null) {
                error = (String) request.getAttribute("error");
            }
	%>
        <div id="signup" class="section">
            <div class="container">
                <div class="row">
                    <div class="col-md-6 center-block">
                        <form action="SignupServlet" method="post" class="billing-details" >
                            <h3 class="section-title">ĐĂNG KÍ</h3>
                            <% if(error != "") { %>
                                <div class="alert alert-danger"><%=error%></div>
                            <% } %>
                            <div class="form-group">
                                <input class="input" type="text" name="username" placeholder="Tên đăng nhập">
                            </div>
                            <div class="form-group">
                                <input class="input" type="text" name="email" placeholder="Email">
                            </div>
                            <div class="form-group">
                                <input class="input" type="text" value=""
                                    placeholder="Giới tính"
                                    list="exampleList" onfocus="this.value = '';"                                    
                                    name="sex"> 
                                <datalist id="exampleList">
                                    <option value="Nam">
                                    <option value="Nữ">
                                </datalist>
                            </div>
                            <div class="form-group">
                                <input class="input" type="date" name="date" placeholder="Ngày sinh">
                            </div>
                            <div class="form-group">
                                    <input class="input" type="text" name="phone" placeholder="Số điện thoại">
                            </div>
                            <div class="form-group">
                                    <input class="input" type="text" name="address" placeholder="Địa chỉ">
                            </div>
                            <div class="form-group">
                                    <input class="input" type="password" name="password" placeholder="Mật khẩu">
                            </div>          
                            <div class="form-group">
                                    <input class="input" type="password" name="repassword" placeholder="Xác nhận mật khẩu">
                            </div>
                            <div class="form-group">
                                Tôi đồng ý với các <a href="https://www.facebook.com">Chính sách và Điều khoản của Electro!</a>
                            </div>
                            <div class="form-group">
                                <button type="submit" value="signin" class="primary-btn order-submit">Đăng kí</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        
        <jsp:include page="footer.jsp"></jsp:include>
        
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/slick.min.js"></script>
        <script src="js/nouislider.min.js"></script>
        <script src="js/jquery.zoom.min.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>
