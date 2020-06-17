<%@page import="dao.CartDAOImple"%>
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
        <title>Tài khoản</title>
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
            
            String username = null;
            Cookie[] cookies = request.getCookies();
            if(cookies !=null){
                for(Cookie cookie : cookies){
                    if(cookie.getName().equals("username")) 
                        username = cookie.getValue();
                }
            }
            
            UserDAOImple userDAO = new UserDAOImple();
            User u= userDAO.getUser(username);
            if(u.getRo_le() == 2) {
	%>
        <div id="signup" class="section">
            <div class="container">
                <div class="row">
                    <div class="col-md-6 center-block">
                        <form action="MyAccount" method="post" class="billing-details" >
                            <h3 class="section-title">TÀI KHOẢN</h3>
                            <div style="color: red"><%=error%></div>                          
                            <div class="form-group">
                                <label>Tên đăng nhập:</label>
                                <input class="input" type="text" readonly name="username" value="<%=u.getUser__name()%>" >
                            </div>
                            <div class="form-group">
                                <label>Email:</label>
                                <input class="input" type="text" readonly name="email" value="<%=u.getEmail()%>" >
                            </div>
                            <div class="form-group">
                                <label>Giới tính:</label>
                                <input class="input" type="text" value="<%=u.getGioi_tinh() %>"
                                    list="exampleList" onfocus="this.value = '';"
                                    onblur="if (this.value == '') {this.value = '<%=u.getGioi_tinh() %>';}"
                                    name="sex"> 
                                <datalist id="exampleList">
                                    <option value="Nam">
                                    <option value="Nữ">
                                </datalist>
                            </div>
                            <div class="form-group">
                                <label>Ngày sinh:</label>
                                <input class="input" type="date" value="<%=u.getNgay_sinh()%>"
                                    onfocus="this.value = '';"
                                    onblur="if (this.value == '') {this.value = '<%=u.getNgay_sinh() %>';}"
                                    name="date" >
                            </div>
                            <div class="form-group">
                                <label>Số điện thoại:</label>
                                <input class="input" type="text" value="<%= u.getSdt()%>" onfocus="this.value = '';"
                                    onblur="if (this.value == '') {this.value = '<%=u.getSdt()%>';}" name="phone">
                            </div>
                            <div class="form-group">
                                <label>Địa chỉ:</label>
                                <input class="input" type="text" value="<%= u.getDia_chi()%>" onfocus="this.value = '';"
                                    onblur="if (this.value == '') {this.value = '<%=u.getDia_chi()%>';}" name="address">
                            </div>
                            <div class="form-group">                               
                                <input class="input" type="hidden" value="<%= u.getPass_word()%>" onfocus="this.value = '';"
                                    onblur="if (this.value == '') {this.value = '<%=u.getPass_word()%>';}" name="password">
                            </div>      
                            <a href="changepassword.jsp">Bạn muốn đổi mật khẩu?</a>
                            <div class="form-group">
                                <button type="submit" value="myaccount" class="primary-btn order-submit">LƯU</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <% 
            } 
            else {
        %>
        <div class="section">
            <div class="container" style="width: 100%">
                <div class="row">
                    <div class="col-md-3">
                        <jsp:include page="taskadmin.jsp"></jsp:include>
                    </div>
                    <div class="col-md-9">
                        <div class="col-md-7 center-block">
                            <form action="MyAccount" method="post" class="billing-details" >
                                <h3 class="section-title">TÀI KHOẢN</h3>
                                <% if(error != "") { %>
                                    <div class="alert alert-danger"><%=error%></div>
                                <% } %>
                                <div class="form-group">
                                    <label>Tên đăng nhập:</label>
                                    <input class="input" type="text" readonly name="username" value="<%=u.getUser__name()%>" >
                                </div>
                                <div class="form-group">
                                    <label>Email:</label>
                                    <input class="input" type="text" readonly name="email" value="<%=u.getEmail()%>" >
                                </div>
                                <div class="form-group">
                                    <label>Giới tính:</label>
                                    <input class="input" type="text" value="<%=u.getGioi_tinh() %>"
                                        list="exampleList" onfocus="this.value = '';"
                                        onblur="if (this.value == '') {this.value = '<%=u.getGioi_tinh() %>';}"
                                        name="sex"> 
                                    <datalist id="exampleList">
                                        <option value="Nam">
                                        <option value="Nữ">
                                    </datalist>
                                </div>
                                <div class="form-group">
                                    <label>Ngày sinh:</label>
                                    <input class="input" type="date" value="<%=u.getNgay_sinh()%>"
                                        onfocus="this.value = '';"
                                        onblur="if (this.value == '') {this.value = '<%=u.getNgay_sinh() %>';}"
                                        name="date" >
                                </div>
                                <div class="form-group">
                                    <label>Số điện thoại:</label>
                                    <input class="input" type="text" value="<%= u.getSdt()%>" onfocus="this.value = '';"
                                        onblur="if (this.value == '') {this.value = '<%=u.getSdt()%>';}" name="phone">
                                </div>
                                <div class="form-group">
                                    <label>Địa chỉ:</label>
                                    <input class="input" type="text" value="<%= u.getDia_chi()%>" onfocus="this.value = '';"
                                        onblur="if (this.value == '') {this.value = '<%=u.getDia_chi()%>';}" name="address">
                                </div>
                                <a href="changepassword.jsp">Bạn muốn đổi mật khẩu?</a>          
                                <div class="form-group">
                                    <button type="submit" value="myaccount" class="primary-btn order-submit">LƯU</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%
            }
        %>
        <jsp:include page="footer.jsp"></jsp:include>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/slick.min.js"></script>
        <script src="js/nouislider.min.js"></script>
        <script src="js/jquery.zoom.min.js"></script>
        <script src="js/main.js"></script>
        
    </body>
</html>