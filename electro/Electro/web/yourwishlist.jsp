<%@page import="model.Wishlist"%>
<%@page import="dao.WishlistDAOImple"%>
<%@page import="dao.UserDAOImple"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
         <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>Danh sách yêu thích</title>
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
        %>
        <jsp:include page="header.jsp"></jsp:include>
        <div class="section">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h3 class="section-title">YÊU THÍCH</h3>               
                        <table class="table">            
                            <thead>
                                <tr>
                                    <th class="text-center">STT</th>
                                    <th class="text-center">Tên sản phẩm</th>
                                    <th class="text-center">Thao tác</th>
                                </tr>
                            </thead>
                            <%
                                WishlistDAOImple wishListDAO = new WishlistDAOImple();
                                int i = 1;
                                for (Wishlist w : wishListDAO.getWishlist(id)) {
                            %>
                            <tbody class="text-center">
                                <tr>
                                    <td><%=i%></td>
                                    <td><a href="product.jsp?ma_san_pham=<%=w.getMa_san_pham()%>"><%=w.getTen_san_pham()%></a></td>                                               
                                    <td>
                                        <form action="DeleteWishList" method="post" id="formwishlist">
                                            <input type="hidden" value="<%=w.getId_wishlist()%>" name="id_wishlist" />
                                            <button class="primary-btn">
                                                <span></span>Xoá
                                            </button>
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
