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
        <title>Chi tiết đơn hàng</title>
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
            String ma_loai_san_pham = "";
            if (request.getParameter("ma_loai_san_pham") != null) {
                ma_loai_san_pham = request.getParameter("ma_loai_san_pham");
            }
            
            String ma_san_pham = "";
            if (request.getParameter("ma_san_pham") != null) {
                ma_san_pham = request.getParameter("ma_san_pham");
            }
                                     
            ProductDAOImple productDAO = new ProductDAOImple();
            Product p = productDAO.getProduct(Integer.parseInt(ma_san_pham));
            
            CartDAOImple cartDAO = new CartDAOImple();
            CartAdmin ca = cartDAO.getCart(Integer.parseInt(ma_loai_san_pham));
        %>
        <jsp:include page="header.jsp"></jsp:include>     
        <div class="section">
            <div class="container" style="width: 100%">
                <div class="row">
                    <div class="col-md-3">
                        <jsp:include page="taskadmin.jsp"></jsp:include> 
                    </div>
                    <div class="col-md-9">
                        <h3 class="section-title">CHI TIẾT ĐƠN HÀNG</h3>
                        <div class="col-md-5 col-md-push-2">
                            <div id="product-main-img">
                                <div class="product-preview">
                                    <img src="image/<%=p.getHinh_anh_1()%>" alt="">
                                </div>
                                <div class="product-preview">
                                    <img src="image/<%=p.getHinh_anh_2()%>" alt="">
                                </div>
                                <div class="product-preview">
                                    <img src="image/<%=p.getHinh_anh_3()%>" alt="">
                                </div>
                                <div class="product-preview">
                                    <img src="image/<%=p.getHinh_anh_4()%>" alt="">
                                </div>
                                <div class="product-preview">
                                    <img src="image/<%=p.getHinh_anh_5()%>" alt="">
                                </div>
                            </div>   
                        </div>                    
                        <div class="col-md-2  col-md-pull-5">
                            <div id="product-imgs">
                                <div class="product-preview">
                                    <img src="image/<%=p.getHinh_anh_1()%>" alt="">
                                </div>
                                <div class="product-preview">
                                    <img src="image/<%=p.getHinh_anh_2()%>" alt="">
                                </div>
                                <div class="product-preview">
                                    <img src="image/<%=p.getHinh_anh_3()%>" alt="">
                                </div>
                                <div class="product-preview">
                                    <img src="image/<%=p.getHinh_anh_4()%>" alt="">
                                </div>
                                <div class="product-preview">
                                    <img src="image/<%=p.getHinh_anh_5()%>" alt="">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-5"> 
                            <h3><%=ca.getTen_san_pham()%></h3>
                            <form action="CartAdminServlet" method="post" class="billing-details" enctype="multipart/form-data">     
                                <input type="hidden" value="<%=ca.getId_cart()%>" name="id_cart" />
                                <input type="hidden" value="<%=ca.getMa_san_pham()%>" name="ma_san_pham" />
                                <div class="form-group">
                                    <label>Tên sản phẩm:</label>
                                    <input class="input" type="text" readonly name="username" value="<%=ca.getTen_san_pham()%>" >
                                </div>
                                <div class="form-group">
                                    <label>Số lượng:</label>
                                    <input class="input" type="text" readonly name="username" value="<%=ca.getSo_luong()%>" >
                                </div>
                                <div class="form-group">
                                    <label>Giá bán:</label>
                                    <input class="input" type="text" readonly name="username" value="<%=ca.getGia_ban()%>" >
                                </div>
                                <div class="form-group">
                                    <label>Tổng giá trị đơn hàng:</label>
                                    <input class="input" type="text" readonly name="username" value="<%=ca.getThanh_tien()%>" >
                                </div>
                                <div class="form-group">
                                    <label>Tên khách hàng:</label>
                                    <input class="input" type="text" readonly name="username" value="<%=ca.getTen_khach_hang()%>" >
                                </div>
                                
                                <div class="form-group">
                                    <label>Số điện thoại:</label>
                                    <input class="input" type="text" readonly name="username" value="<%=ca.getSdt()%>" >
                                </div>
                                
                                <div class="form-group">
                                    <label>Nơi giao hàng:</label>
                                    <input class="input" type="text" readonly name="username" value="<%=ca.getDia_chi()%>" >
                                </div>
                                <div class="form-group">
                                    <label>Ngày mua hàng:</label>
                                    <input class="input" readonly type="date" value="<%=ca.getNgay_mua()%>" name="date" >
                                </div>
                                <div class="form-group">
                                    <label>Trạng thái:</label>
                                    <input class="input" type="text" value="<%=ca.getTrang_thai()%>"
                                        list="statusList" onfocus="this.value = '';"
                                        onblur="if (this.value == '') {this.value = '<%=ca.getTrang_thai()%>';}"
                                        name="trang_thai"> 
                                        <datalist id="statusList">
                                            <option value="Đang xử lí">
                                            <option value="Đang vận chuyển">
                                            <option value="Đã giao">   
                                        </datalist>
                                </div>
                                <input type="submit" name="update" value="CẬP NHẬT" class="primary-btn order-submit" />
                                <input type="submit" name="delete" value="XOÁ" class="primary-btn order-submit" />
                            </form>                         
                        </div>        
                            
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
