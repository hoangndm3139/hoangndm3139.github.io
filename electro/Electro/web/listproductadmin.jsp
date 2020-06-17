<%@page import="java.text.DecimalFormat"%>
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
        <title>Danh sách sản phẩm</title>
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
            int ma_loai_san_pham = 0;
            if(request.getParameter("ma_loai_san_pham") != null) {
                ma_loai_san_pham = Integer.parseInt(request.getParameter("ma_loai_san_pham"));
            }
            
            int tuy_chon = 0;
            if(request.getParameter("tuy_chon") != null) {
                tuy_chon = Integer.parseInt(request.getParameter("tuy_chon"));
            }
                          
            String cart = "";
            if(ma_loai_san_pham == 1) cart = "SẢN PHẨM ĐIỆN THOẠI";
            if(ma_loai_san_pham == 2) cart = "SẢN PHẨM TIVI";
            if(ma_loai_san_pham == 3) cart = "SẢN PHẨM MÁY TÍNH";
            if(ma_loai_san_pham == 4) cart = "SẢN PHẨM MÁY ẢNH";
            if(ma_loai_san_pham == 5) cart = "SẢN PHẨM MÁY TÍNH BẢNG";
            if(ma_loai_san_pham == 12345) cart = "TẤT CẢ SẢN PHẨM";
        %>
        <jsp:include page="header.jsp"></jsp:include>     
        <div class="section">
            <div class="container" style="width: 100%">
                <div class="row">
                    <div class="col-md-3">
                        <jsp:include page="taskadmin.jsp"></jsp:include> 
                    </div>
                    <div class="col-md-9">
                        <h3 class="section-title"><%=cart%></h3>
                        <div class="dropdown">
                            <button class="btn btn-secondary dropdown-toggle" type="button" data-toggle="dropdown" aria-expanded="false">Tuỳ Chọn
                            <span class="caret"></span></button>
                            <ul class="dropdown-menu">
                              <li><a href="listproductadmin.jsp?ma_loai_san_pham=<%=ma_loai_san_pham%>&tuy_chon=1" style="font-weight: bold">Sắp xếp theo mã sản phẩm</a></li>
                              <li><a href="listproductadmin.jsp?ma_loai_san_pham=<%=ma_loai_san_pham%>&tuy_chon=2" style="font-weight: bold">Sắp xếp theo tên sản phẩm</a></li>
                              <li><a href="listproductadmin.jsp?ma_loai_san_pham=<%=ma_loai_san_pham%>&tuy_chon=3" style="font-weight: bold">Săp xếp theo giá bán sản phẩm</a></li>
                            </ul>
                        </div>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th class="text-center">STT</th>
                                    <th class="text-center">Mã sản phẩm</th>
                                    <th class="text-center">Tên sản phẩm</th>
                                    <th class="text-center">Giá bán</th>
                                </tr>
                            </thead>
                            <%
                                if(ma_loai_san_pham != 12345) {
                                    int i = 1;
                                    ProductDAOImple productDAO = new ProductDAOImple();
                                    for (Product p : productDAO.getListByCategory(ma_loai_san_pham,tuy_chon)) {
                                        DecimalFormat formatter = new DecimalFormat("###,###,###");
                            %>
                                        <tbody class="text-center">
                                            <tr>
                                                <td><%=i%></td>
                                                <td><%=p.getMa_san_pham()%></td>                                                  
                                                <td><a href="productadmin.jsp?ma_san_pham=<%=p.getMa_san_pham()%>"><%=p.getTen_san_pham()%></a></td>
                                                <td><%=formatter.format((int)(p.getGia_ban()))%> VNĐ</td>
                                            </tr>
                                        </tbody>
                            <% 
                                        i++; 
                                    }
                                } else {
                                    int i = 1;
                                    ProductDAOImple productDAO = new ProductDAOImple();
                                    for (Product p : productDAO.getList(tuy_chon)) { 
                                        DecimalFormat formatter = new DecimalFormat("###,###,###");
                            %>
                                        <tbody class="text-center">
                                            <tr>
                                                <td><%=i%></td>
                                                <td><%=p.getMa_san_pham()%></td>                                                  
                                                <td><a href="productadmin.jsp?ma_san_pham=<%=p.getMa_san_pham()%>"><%=p.getTen_san_pham()%></a></td>
                                                <td><%=formatter.format((int)(p.getGia_ban()))%> VNĐ</td>
                                            </tr>
                                        </tbody>
                            <%
                                        i++;
                                    } 
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
        
        <script>
            $(document).ready(function(){
                $('.dropdown-toggle').dropdown();
            });
        </script>
    </body>
</html>