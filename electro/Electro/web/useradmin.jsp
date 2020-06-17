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
        <title>Tài khoản khách hàng</title>
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
            String error = "";
            if (request.getAttribute("error") != null) {
                    error = (String) request.getAttribute("error");
            }
	%>
        <jsp:include page="header.jsp"></jsp:include>     
        <div class="section">
            <div class="container" style="width: 100%">
                <div class="row">
                    <div class="col-md-3">
                        <jsp:include page="taskadmin.jsp"></jsp:include>
                    </div>
                    <div class="col-md-9">
                        <h3 class="section-title">TÀI KHOẢN KHÁCH HÀNG</h3>
                        <% if(error != "") { %>
                            <div class="alert alert-danger"><%=error%></div>
                        <% } %>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th class="text-center">STT</th>
                                    <th class="text-center">Tên người dùng</th>
                                    <th class="text-center">Ngày sinh</th>
                                    <th class="text-center">Giới tính</th>
                                    <th class="text-center">Email</th>
                                    <th class="text-center">Số điện thoại</th>
                                    <th class="text-center">Địa chỉ</th>
                                    <th class="text-center">Tuỳ chọn</th>
                                    <th class="text-center">Lưu</th>
                                </tr>
                            </thead>
                            <%
                                int i = 1;
                                UserDAOImple userDAO = new UserDAOImple();
                                for (User u : userDAO.getListUser()) {
                            %>
                            <tbody class="text-center">
                                <tr>
                                    <td><%=i%></td>
                                    <td><%=u.getUser__name()%></td>                                                  
                                    <td><%=u.getNgay_sinh()%></td>
                                    <td><%=u.getGioi_tinh()%></td>
                                    <td><%=u.getEmail()%></td>
                                    <td><%=u.getSdt()%></td>
                                    <td><%=u.getDia_chi()%></td>                                   
                                    <td>
                                        <form action="UserAdminServlet" method="post">
                                        <input class="input" type="text" value="<%=u.getTrang_thai()%>"
                                        list="statusList" onfocus="this.value = '';"
                                        onblur="if (this.value == '') {this.value = '<%=u.getTrang_thai()%>';}"
                                        name="trang_thai"> 
                                        <datalist id="statusList">
                                            <option value="Hoạt động">
                                            <option value="Khoá">  
                                        </datalist>
                                        <input type="hidden" value="<%=u.getUser__name()%>" name="username" />
                                    </td>
                                    <td>
                                        <input type="submit" name="useradmin" value="LƯU" class="primary-btn order-submit" />
                                        </form>
                                    </td>
                                </tr>
                            </tbody>
                            <% 
                                i++; 
                            }    
                            %>
                        </table>
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