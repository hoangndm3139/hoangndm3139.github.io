
<%@page import="dao.UserDAOImple"%>
<%@page import="model.Cart"%>
<%@page import="dao.CartDAOImple"%>
<%@page import="dao.ProductDAOImple"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>       
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
         <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>Giỏ hàng</title>
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
            String username = null;
            Cookie[] cookies = request.getCookies();
            if(cookies !=null){
                for(Cookie cookie : cookies){
                    if(cookie.getName().equals("username")) 
                        username = cookie.getValue();
                }
            }
            
            UserDAOImple userDAO = new UserDAOImple();
            int id = userDAO.getUser(username).getMa_nguoi_dung();
            
            String messager ="";
            if (request.getAttribute("messager") != null) {
                messager = (String) request.getAttribute("messager");
            }           
        %>
        <jsp:include page="header.jsp"></jsp:include>
        <div class="section">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h3 class="section-title">GIỎ HÀNG</h3>
                        <% if(messager != "") { %>
                            <div class="alert alert-info"><%=messager%></div>
                        <% } %>
                        <table class="table">            
                            <thead>
                                <tr>
                                    <th class="text-center">STT</th>
                                    <th class="text-center">Tên sản phẩm</th>
                                    <th class="text-center">Ngày mua</th>
                                    <th class="text-center">Số lượng</th>
                                    <th class="text-center">Tổng tiền</th>
                                    <th class="text-center">Trạng thái</th>
                                    <th class="text-center">Huỷ đơn hàng</th>
                                </tr>
                            </thead>
                            <%
                                CartDAOImple cartDAO = new CartDAOImple();
                                int i = 1;
                                for (Cart c : cartDAO.getListCart(id)) {
                            %>
                            <tbody class="text-center">
                                <tr>
                                    <td><%=i%></td>
                                    <td><%=c.getTen_san_pham()%></td>                                                  
                                    <td><%=c.getNgay_mua()%></td>
                                    <td><%=c.getSo_luong()%></td>
                                    <td><%=(int)c.getThanh_tien()%> VNĐ</td>
                                    <td><%=c.getTrang_thai()%></td>
                                    <% if(c.getTrang_thai().length() == 10) { %>
                                    <td>
                                        <form action="DeleteCart" method="post">
                                            <input type="hidden" value="<%=c.getId_cart()%>" name="id_cart" />                                           
                                            <button class="primary-btn">
                                                <span></span>Huỷ
                                            </button>
                                        </form>
                                    </td>
                                    <% } %>
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
