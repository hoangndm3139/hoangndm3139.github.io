<%@page import="model.CartAdmin"%>
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
        <title>Danh sách đơn hàng</title>
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
            if (request.getParameter("ma_loai_san_pham") != null) {
                ma_loai_san_pham = Integer.parseInt(request.getParameter("ma_loai_san_pham"));
            } 
            
            int tuy_chon = 0;
            if(request.getParameter("tuy_chon") != null) {
                tuy_chon = Integer.parseInt(request.getParameter("tuy_chon"));
            }
            
            String cart = "";
            if(ma_loai_san_pham == 1) cart = "ĐƠN HÀNG ĐIỆN THOẠI";
            if(ma_loai_san_pham == 2) cart = "ĐƠN HÀNG TIVI";
            if(ma_loai_san_pham == 3) cart = "ĐƠN HÀNG MÁY TÍNH";
            if(ma_loai_san_pham == 4) cart = "ĐƠN HÀNG MÁY ẢNH";
            if(ma_loai_san_pham == 5) cart = "ĐƠN HÀNG MÁY TÍNH BẢNG";
            if(ma_loai_san_pham == 12345) cart = "TẤT CẢ ĐƠN HÀNG";
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
                              <li><a href="listcartadmin.jsp?ma_loai_san_pham=<%=ma_loai_san_pham%>&tuy_chon=1" style="font-weight: bold">Sắp xếp theo tên sản phẩm</a></li>
                              <li><a href="listcartadmin.jsp?ma_loai_san_pham=<%=ma_loai_san_pham%>&tuy_chon=2" style="font-weight: bold">Sắp xếp theo giá trị đơn hàng</a></li>
                              <li><a href="listcartadmin.jsp?ma_loai_san_pham=<%=ma_loai_san_pham%>&tuy_chon=3" style="font-weight: bold">Săp xếp theo thời gian</a></li>
                              <li><a href="listcartadmin.jsp?ma_loai_san_pham=<%=ma_loai_san_pham%>&tuy_chon=4" style="font-weight: bold">Săp xếp theo trạng thái đơn hàng</a></li>
                            </ul>
                        </div>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th class="text-center">STT</th>
                                    <th class="text-center">Tên sản phẩm</th>
                                    <th class="text-center">Tổng tiền</th>
                                    <th class="text-center">Ngày mua</th>
                                    <th class="text-center">Trạng thái</th>
                               </tr>
                            </thead>
                            <%
                                if(ma_loai_san_pham != 12345) {
                                    int i = 1;
                                    CartDAOImple cartDAO = new CartDAOImple();
                                    for (CartAdmin c : cartDAO.getListCartAdminCategory(ma_loai_san_pham,tuy_chon)) {
                            %>
                                    <tbody class="text-center">
                                        <tr>
                                            <td><%=i%></td>                                                  
                                            <td><a href="cartadmin.jsp?ma_loai_san_pham=<%=c.getId_cart()%>&ma_san_pham=<%=c.getMa_san_pham()%>"><%=c.getTen_san_pham()%></a></td>
                                            <td><%=(int)c.getThanh_tien()%> VNĐ</td>
                                            <td><%=c.getNgay_mua()%></td>
                                            <td><%=c.getTrang_thai()%></td>
                                        </tr>
                                    </tbody>
                            <% 
                                    i++; 
                                }   
                            }else{
                                    int i = 1;
                                    CartDAOImple cartDAO = new CartDAOImple();
                                    for (CartAdmin c : cartDAO.getListCartAdmin(tuy_chon)) {
                            %>
                                    <tbody class="text-center">
                                        <tr>
                                            <td><%=i%></td>                                                  
                                            <td><a href="cartadmin.jsp?ma_loai_san_pham=<%=c.getId_cart()%>&ma_san_pham=<%=c.getMa_san_pham()%>"><%=c.getTen_san_pham()%></a></td>
                                            <td><%=(int)c.getThanh_tien()%> VNĐ</td>
                                            <td><%=c.getNgay_mua()%></td>
                                            <td><%=c.getTrang_thai()%></td>
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
