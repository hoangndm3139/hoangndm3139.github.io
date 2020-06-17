<%@page import="model.User"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Date"%>
<%@page import="model.Review"%>
<%@page import="model.Product"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="dao.UserDAOImple"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="dao.ProductDAOImple"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Sản phẩm</title>
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>
        <link type="text/css" rel="stylesheet" href="css/slick.css"/>
        <link type="text/css" rel="stylesheet" href="css/slick-theme.css"/>
        <link type="text/css" rel="stylesheet" href="css/nouislider.min.css"/>
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link type="text/css" rel="stylesheet" href="css/style.css"/>
    </head>
    <body>
        <%
            String error = "";
            if (request.getAttribute("error") != null) {
                    error = (String) request.getAttribute("error");
            }
            
            String ma_san_pham = "";
            String ten_ma_loai_san_pham = "";
            String username = null;
            Cookie[] cookies = request.getCookies();
            if(cookies !=null){
                for(Cookie cookie : cookies){
                    if(cookie.getName().equals("username")) 
                        username = cookie.getValue();
                }
            }
            
            //lấy mã người dùng
            UserDAOImple userDAO = new UserDAOImple();
            User u = userDAO.getUser(username);
            int id = u.getMa_nguoi_dung();
            
            //lấy mã sản phẩm
            if (request.getParameter("ma_san_pham") != null) {
                    ma_san_pham = request.getParameter("ma_san_pham");
            }          
            
            //định dạng tiền
            NumberFormat nf = NumberFormat.getInstance();
            nf.setMinimumFractionDigits(0);
            DecimalFormat formatter = new DecimalFormat("###,###,###");
        
            //tính toán lượng rating
            ProductDAOImple productDAO = new ProductDAOImple();
            Product p = productDAO.getProduct(Integer.parseInt(ma_san_pham));
            
            List<Review> list = productDAO.getListReviewProduct(Integer.parseInt(ma_san_pham));
            int rating_avg = 0;
            int sum = 0;
            int rating[] = {0,0,0,0,0,0};
            if(list.size() != 0) { 
                for(int i=0; i<list.size(); i++) {
                    if(list.get(i).getSo_luong_sao() == 0) rating[0]++;
                    if(list.get(i).getSo_luong_sao() == 1) rating[1]++;
                    if(list.get(i).getSo_luong_sao() == 2) rating[2]++;
                    if(list.get(i).getSo_luong_sao() == 3) rating[3]++;
                    if(list.get(i).getSo_luong_sao() == 4) rating[4]++;
                    if(list.get(i).getSo_luong_sao() == 5) rating[5]++;
                }
                sum = rating[0] + rating[1] + rating[2] + rating[3] + rating[4] + rating[5];
            }
            if(sum != 0) { 
                rating_avg = (rating[0]*0 + rating[1]*1 + rating[2]*2 + rating[3]*3 + rating[4]*4 +rating[5]*5)/sum;
            }
        %>
        <jsp:include page="header.jsp"></jsp:include>
        <div class="section">
            <div class="container">
                <div class="col-md-12">
                    <div class="product-details">
                        <h2 class="product-name">TÊN SẢN PHẨM: <%=p.getTen_san_pham()%></h2>
                        <div>      
                            <div class="product-rating">
                                Đánh giá: 
                                <% for(int j=1 ;j<=rating_avg; j++) { %>
                                <i class="fa fa-star"></i>
                                <% } %>
                                <% for(int k=1 ;k<=(5-rating_avg); k++) { %>
                                    <i class="fa fa-star-o"></i>
                                <% } %>
                            </div>
                        </div>
                        <div>
                            <h3 class="product-price">
                                <%=formatter.format((int)(p.getGia_ban() * (1 - p.getSale())))%> VNĐ 
                                <% if(p.getSale() != 1) { %>
                                <del class="product-old-price"><%=formatter.format((int)(p.getGia_ban()))%> VNĐ</del>
                                <% } %>
                            </h3>
                        </div>
                    </div>
                    <div>&MediumSpace;</div>
                </div>
                    
                <div class="row">
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
                        <% if(username != null) { %>
                            <div class="order-details">
                                <div class="section-title text-center">
                                        <h3 class="title">ĐẶT HÀNG</h3>
                                </div>
                                <form  action="CartServlet" method="post">
                                    <input type="hidden" value="<%=id%>" name="ma_nguoi_dung"/>
                                    <input type="hidden" value="<%=username%>" name="username"/>
                                    <input type="hidden" value="<%=ma_san_pham%>" name="ma_san_pham" />
                                    <input type="hidden" value="<%=p.getSale()%>" name="sale" />
                                    <div class="form-group">
                                        <label>Tên sản phẩm:</label>
                                        <input type="text" class="input" readonly value="<%=p.getTen_san_pham()%>" name="ten_san_pham" />
                                    </div>
                                    <div class="form-group">
                                        <label>Số lượng:</label>
                                        <input type="number" min="1" value="1" class="input" name="so_luong" />
                                    </div>
                                    <div class="form-group">
                                        <label>Giá bán:</label>
                                        <input type="text" readonly=" "class="input" name="gia_ban" value="<%=(int)p.getGia_ban()%>" />
                                    </div>
                                    <div class="form-group">
                                        <label>Số điện thoại:</label>
                                        <input class="input" type="text" value="<%= u.getSdt()%>" onfocus="this.value = '';"
                                        onblur="if (this.value == '') {this.value = '<%=u.getSdt()%>';}" name="sdt" />
                                    </div>
                                    <div class="form-group">
                                        <label>Địa chỉ:</label>
                                        <input class="input" type="text" value="<%= u.getDia_chi()%>" onfocus="this.value = '';"
                                            onblur="if (this.value == '') {this.value = '<%=u.getDia_chi()%>';}" name="dia_chi" />
                                    </div>                                  
                                    <div class="form-group">
                                        <button class="primary-btn order-submit center-block">ĐẶT HÀNG</button>
                                    </div>
                                </form>
                            </div>   
                        <% 
                        } else { 
                        %>
                            <div class="alert alert-info">Vui lòng <a href="signin.jsp">đăng nhập</a> để tiếp tục...</div>
                        <% } %>                        
                    </div>
                    
                    <div class="col-md-12">
                        <div id="product-tab">
                            <ul class="tab-nav">
                                <li class="active"><a data-toggle="tab" href="#tab1" ><h1>Mô tả</h1></a></li>
                                <li><a data-toggle="tab" href="#tab2"><h1>Chi tiết</h1></a></li>
                                <li><a data-toggle="tab" href="#tab3"><h1>Đánh giá</h1></a></li>
                            </ul>
                            
                            <div class="tab-content">
                                <!-- tab1  -->
                                <div id="tab1" class="tab-pane fade in active">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <h1> Hàng chính hãng 100%, chất lượng vô đối! </h1>    
                                            
                                            
                                        </div>
                                    </div>
                                </div>
                                
                                <div id="tab2" class="tab-pane fade in">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <h3> Màn hình:	OLED, 6.5", Super Retina </h3>
                                            <h3> Hệ điều hành:	iOS 12 </p>
                                            <h3> Camera sau:	Chính 12 MP & Phụ 12 MP </h3>
                                            <h3>                                    RAM:4 GB </h3>
                                            <h3> Bộ nhớ trong:	64 GB </p>
<h3>Thẻ SIM: 
    Nano SIM & eSIM, Hỗ trợ 4G </p>
<h3>HOTSIM Mobi Big 70 (3GB data/tháng). Giá từ 170.000đ
                                            </p>

                                        </div>
                                    </div>
                                </div>                            
                                <div id="tab3" class="tab-pane fade in">
                                    <div class="row">
                                        <div class="col-md-3">
                                            <div id="rating">
                                                <div class="rating-avg">
                                                    <span><%=rating_avg%></span>
                                                    <div class="rating-stars">
                                                        <% for(int j=1 ;j<=rating_avg; j++) { %>
                                                                <i class="fa fa-star"></i>
                                                        <% } %>
                                                        <% for(int k=1 ;k<=(5-rating_avg); k++) { %>
                                                            <i class="fa fa-star-o"></i>
                                                        <% } %>
                                                    </div>
                                                </div>
                                                <ul class="rating">
                                                    <li>
                                                        <div class="rating-stars">
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                        </div>
                                                        <div class="rating-progress">
                                                            <div style="width: 100%;"></div>
                                                        </div>
                                                        <span class="sum"><%=rating[5]%></span>
                                                    </li>
                                                    <li>
                                                        <div class="rating-stars">
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star-o"></i>
                                                        </div>
                                                        <div class="rating-progress">
                                                            <div style="width: 80%;"></div>
                                                        </div>
                                                        <span class="sum"><%=rating[4]%></span>
                                                    </li>
                                                    <li>
                                                        <div class="rating-stars">
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star-o"></i>
                                                            <i class="fa fa-star-o"></i>
                                                        </div>
                                                        <div class="rating-progress">
                                                            <div style="width: 60%;"></div>
                                                        </div>
                                                        <span class="sum"><%=rating[3]%></span>
                                                    </li>
                                                    <li>
                                                        <div class="rating-stars">
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star-o"></i>
                                                            <i class="fa fa-star-o"></i>
                                                            <i class="fa fa-star-o"></i>
                                                        </div>
                                                        <div class="rating-progress">
                                                            <div style="width: 40%;"></div>
                                                        </div>
                                                        <span class="sum"><%=rating[2]%></span>
                                                    </li>
                                                    <li>
                                                        <div class="rating-stars">
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star-o"></i>
                                                            <i class="fa fa-star-o"></i>
                                                            <i class="fa fa-star-o"></i>
                                                            <i class="fa fa-star-o"></i>
                                                        </div>
                                                        <div class="rating-progress">
                                                            <div style="width: 20%;"></div>
                                                        </div>
                                                        <span class="sum"><%=rating[1]%></span>
                                                    </li>
                                                    <li>
                                                        <div class="rating-stars">
                                                            <i class="fa fa-star-o"></i>
                                                            <i class="fa fa-star-o"></i>
                                                            <i class="fa fa-star-o"></i>
                                                            <i class="fa fa-star-o"></i>
                                                            <i class="fa fa-star-o"></i>
                                                        </div>
                                                        <div class="rating-progress">
                                                            <div style="width: 0%;"></div>
                                                        </div>
                                                        <span class="sum"><%=rating[0]%></span>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                        
                                        <div class="col-md-6">
                                            <div id="reviews">
                                                <ul class="reviews">
                                                    <h4>Đánh giá mới nhất</h4>
                                                    <%                                                                                                          
                                                        int temp = list.size();
                                                        if(temp >= 3) {
                                                        for (int i=temp-3; i<temp; i++) {
                                                            Review r = list.get(i);                                                                      
                                                            int t = r.getSo_luong_sao();
                                                            int f = 5 - t;                                                         
                                                    %>
                                                        <li>
                                                            <div class="review-heading">
                                                                <h5 class="name"><%=r.getTen_nguoi_danh_gia()%></h5>
                                                                <p class="date"><%=r.getThoi_gian()%></p>
                                                                <div class="review-rating">
                                                                    <% for(int j=1 ;j<=t; j++) { %>
                                                                        <i class="fa fa-star"></i>
                                                                    <% } %>
                                                                    <% for(int k=1 ;k<=f; k++) { %>
                                                                        <i class="fa fa-star-o"></i>
                                                                    <% } %>
                                                                </div>
                                                            </div>
                                                            <div class="review-body">
                                                                <p><%=r.getDanh_gia()%></p>
                                                            </div>
                                                        </li>   
                                                    <% }} else if(temp == 1 || temp == 2) { 
                                                        for(int i=0; i<temp; i++) {
                                                            Review r = list.get(i);                                                                      
                                                            int t = r.getSo_luong_sao();
                                                            int f = 5 - t;
                                                        %>
                                                        <li>
                                                            <div class="review-heading">
                                                                <h5 class="name"><%=r.getTen_nguoi_danh_gia()%></h5>
                                                                <p class="date"><%=r.getThoi_gian()%></p>
                                                                <div class="review-rating">
                                                                    <% for(int j=1 ;j<=t; j++) { %>
                                                                        <i class="fa fa-star"></i>
                                                                    <% } %>
                                                                    <% for(int k=1 ;k<=f; k++) { %>
                                                                        <i class="fa fa-star-o"></i>
                                                                    <% } %>
                                                                </div>
                                                            </div>
                                                            <div class="review-body">
                                                                <p><%=r.getDanh_gia()%></p>
                                                            </div>
                                                        </li>   
                                                    <% }} %>
                                                </ul>
                                            </div>
                                        </div>
                                        
                                        <div class="col-md-3">
                                            <div id="review-form">
                                                <div style="color: red"><%=error%></div>
                                                <form class="review-form" action="ReviewServlet" method="post">                                        
                                                    <input type="hidden" name="ma_san_pham" value="<%=ma_san_pham%>">
                                                    <input type="hidden" name="username" value="<%=username%>">
                                                    <input class="input" type="text" placeholder="Tên" name="name">
                                                    <input class="input" type="email" placeholder="Địa chỉ email" name="email">
                                                    <textarea class="input" placeholder="Đánh giá" name="reviewtext"></textarea>
                                                    <div class="input-rating">
                                                        <span>Đánh giá: </span>
                                                        <div class="stars">
                                                            <input id="star5" name="rating" value="5" type="radio"><label for="star5"></label>
                                                            <input id="star4" name="rating" value="4" type="radio"><label for="star4"></label>
                                                            <input id="star3" name="rating" value="3" type="radio"><label for="star3"></label>
                                                            <input id="star2" name="rating" value="2" type="radio"><label for="star2"></label>
                                                            <input id="star1" name="rating" value="1" type="radio"><label for="star1"></label>                                                         
                                                        </div>
                                                    </div>
                                                    <button class="primary-btn">Gửi</button>
                                                </form>
                                            </div>
                                        </div>
                                                    
                                    </div>
                                </div>
                            </div>
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
