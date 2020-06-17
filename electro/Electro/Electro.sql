CREATE DATABASE Electro;
go
use Electro
go

DROP TABLE IF EXISTS CATEGORY;
CREATE TABLE CATEGORY (
	ma_loai_san_pham INT PRIMARY KEY,
	ten_loai_san_pham NVARCHAR(255) NULL,
);

DROP TABLE IF EXISTS PRODUCT;
CREATE TABLE PRODUCT (
	ma_san_pham INT IDENTITY(1, 1) PRIMARY KEY,
	ma_loai_san_pham INT NULL,
	ten_san_pham NVARCHAR(255) NULL,
	hinh_anh_1 NVARCHAR(255) NULL,
	hinh_anh_2 NVARCHAR(255) NULL,
	hinh_anh_3 NVARCHAR(255) NULL,
	hinh_anh_4 NVARCHAR(255) NULL,
	hinh_anh_5 NVARCHAR(255) NULL,
	gia_ban INT NULL,
	sale FLOAT DEFAULT 0,
	FOREIGN KEY (ma_loai_san_pham) REFERENCES CATEGORY(ma_loai_san_pham),
);

DROP TABLE IF EXISTS REVIEW;
CREATE TABLE REVIEW (
	id_review INT IDENTITY(1, 1) PRIMARY KEY,
	ma_san_pham INT NULL,
	ten_nguoi_danh_gia NVARCHAR(MAX) NULL, 
	dia_chi_email NVARCHAR(255) NULL,
	danh_gia NVARCHAR(MAX) NULL,
	so_luong_sao INT NULL,
	FOREIGN KEY (ma_san_pham) REFERENCES PRODUCT(ma_san_pham),	
);

ALTER TABLE REVIEW ADD thoi_gian_danh_gia DATE;

DROP TABLE IF EXISTS USER_ELECTRO;
CREATE TABLE USER_ELECTRO (
	ma_nguoi_dung INT IDENTITY(1, 1) PRIMARY KEY,
	user__name NVARCHAR(255) NULL,
	pass_word NVARCHAR(255) NULL,
	ngay_sinh DATE ,
	gioi_tinh NVARCHAR(10) NULL,
	email NVARCHAR(255) NULL,
	sdt NVARCHAR(20) NULL,
	dia_chi NVARCHAR(255) NULL,
	ro_le int NULL,
	trang_thai NVARCHAR(255) NULL
);

DROP TABLE IF EXISTS CART;
CREATE TABLE CART (
	id_cart INT IDENTITY(1, 1) PRIMARY KEY,
	ma_nguoi_dung INT NULL,
	ma_san_pham INT NULL,
	ngay_mua DATE NULL,
	so_luong INT NULL,
	thanh_tien INT NULL,
	trang_thai NVARCHAR(255) NULL,
	sdt NVARCHAR(255) NULL,
	dia_chi NVARCHAR(255) NULL,
	FOREIGN KEY (ma_nguoi_dung) REFERENCES USER_ELECTRO(ma_nguoi_dung),
	FOREIGN KEY (ma_san_pham) REFERENCES PRODUCT(ma_san_pham)
);

--mot bang wishlist chung cho tat ca nguoi dung
DROP TABLE IF EXISTS WISHLIST;
CREATE TABLE WISHLIST (
	id_wishlist INT IDENTITY(1, 1) NOT NULL PRIMARY KEY,
	ma_nguoi_dung INT NULL,
	ma_san_pham INT NULL,
	FOREIGN KEY (ma_nguoi_dung) REFERENCES USER_ELECTRO(ma_nguoi_dung),
	FOREIGN KEY (ma_san_pham) REFERENCES PRODUCT(ma_san_pham)
)
-- SET IDENTITY_INSERT TENQUANHE ON/OFF => chèn bản ghi vs quan hệ có identity --
INSERT INTO CATEGORY VALUES ('1', 'SMARTPHONE');
INSERT INTO CATEGORY VALUES ('2', 'TV');
INSERT INTO CATEGORY VALUES ('3', 'LAPTOP');
INSERT INTO CATEGORY VALUES ('4', 'CAMERA');
INSERT INTO CATEGORY VALUES ('5', 'TABLET');

--SMARTPHONE 4--
INSERT INTO PRODUCT(ma_loai_san_pham, ten_san_pham, hinh_anh_1, hinh_anh_2, hinh_anh_3, hinh_anh_4, hinh_anh_5, gia_ban) 
	VALUES ('1', 'Oppo Reno 256GB Ocean', '21.1.png', '21.2.png', '21.3.png', '21.4.png', '21.5.png', '8000000');
INSERT INTO PRODUCT(ma_loai_san_pham, ten_san_pham, hinh_anh_1, hinh_anh_2, hinh_anh_3, hinh_anh_4, hinh_anh_5, gia_ban) 
	VALUES ('1', 'Oppo A5s 32GB Red', '22.1.png', '22.2.png', '22.3.png', '22.4.png', '22.5.png', '20000000');
INSERT INTO PRODUCT(ma_loai_san_pham, ten_san_pham, hinh_anh_1, hinh_anh_2, hinh_anh_3, hinh_anh_4, hinh_anh_5, gia_ban) 
	VALUES ('1', 'Oppo A5s 32GB Blue', '23.1.png', '23.2.png', '23.3.png', '23.4.png', '23.5.png', '21000000');
INSERT INTO PRODUCT(ma_loai_san_pham, ten_san_pham, hinh_anh_1, hinh_anh_2, hinh_anh_3, hinh_anh_4, hinh_anh_5, gia_ban) 
	VALUES ('1', 'Oppo A9 128GB Space', '24.1.png', '24.2.png', '24.3.png', '24.4.png', '24.5.png', '18000000');
--TV 4--
INSERT INTO PRODUCT(ma_loai_san_pham, ten_san_pham, hinh_anh_1, hinh_anh_2, hinh_anh_3, hinh_anh_4, hinh_anh_5, gia_ban) 
	VALUES ('2', 'Sony 49X7077F 4K Smart', '10.1.png', '10.2.png', '10.3.png', '10.4.png', '10.5.png', '20000000');
INSERT INTO PRODUCT(ma_loai_san_pham, ten_san_pham, hinh_anh_1, hinh_anh_2, hinh_anh_3, hinh_anh_4, hinh_anh_5, gia_ban) 
	VALUES ('2', 'Apple TV 4K 64GB Black', '9.1.png', '9.2.png', '9.3.png', '9.4.png', '9.5.png', '50000000');
INSERT INTO PRODUCT(ma_loai_san_pham, ten_san_pham, hinh_anh_1, hinh_anh_2, hinh_anh_3, hinh_anh_4, hinh_anh_5, gia_ban)
	VALUES ('2', 'Sony 4K HDR Android', '11.1.png', '11.2.png', '11.3', '11.4.png', '11.5.png', '21000000');
INSERT INTO PRODUCT(ma_loai_san_pham, ten_san_pham, hinh_anh_1, hinh_anh_2, hinh_anh_3, hinh_anh_4, hinh_anh_5, gia_ban) 
	VALUES ('2', 'Sony 85X9500G 4K Android', '12.1.png', '12.2.png', '12.3.png', '12.4.png', '12.5.png', '22000000');
--LAPTOP 4--
INSERT INTO PRODUCT(ma_loai_san_pham, ten_san_pham, hinh_anh_1, hinh_anh_2, hinh_anh_3, hinh_anh_4, hinh_anh_5, gia_ban) 
	VALUES ('3', 'Asus Laptop 14 X409 Laptop', '17.1.png', '17.2.png', '17.3.png', '17.4.png', '17.5.png', '12000000');
INSERT INTO PRODUCT(ma_loai_san_pham, ten_san_pham, hinh_anh_1, hinh_anh_2, hinh_anh_3, hinh_anh_4, hinh_anh_5, gia_ban) 
	VALUES ('3', 'Asus Laptop 14 X409 Laptop', '18.1.png', '18.2.png', '18.3.png', '18.4.png', '18.5.png', '15000000');
INSERT INTO PRODUCT(ma_loai_san_pham, ten_san_pham, hinh_anh_1, hinh_anh_2, hinh_anh_3, hinh_anh_4, hinh_anh_5, gia_ban)
	VALUES ('3', 'Microsoft Surface Laptop', '19.1.png', '19.2.png', '19.3.png', '19.4.png', '19.5.png', '10000000');
INSERT INTO PRODUCT(ma_loai_san_pham, ten_san_pham, hinh_anh_1, hinh_anh_2, hinh_anh_3, hinh_anh_4, hinh_anh_5, gia_ban) 
	VALUES ('3', 'HP 15-DA1016NE Laptop', '20.1.png', '20.2.png', '20.3.png', '20.4.png', '20.5.png', '20000000');
--CAMERA 4--
INSERT INTO PRODUCT(ma_loai_san_pham, ten_san_pham, hinh_anh_1, hinh_anh_2, hinh_anh_3, hinh_anh_4, hinh_anh_5, gia_ban) 
	VALUES ('4', 'Canon ZOEMINI S Instant Camera With Printer', '13.1.png', '13.2.png', '13.3.png', '13.4.png', '13.5.png', '1000');
INSERT INTO PRODUCT(ma_loai_san_pham, ten_san_pham, hinh_anh_1, hinh_anh_2, hinh_anh_3, hinh_anh_4, hinh_anh_5, gia_ban) 
	VALUES ('4', 'Ring 8SF1P7WEU0 Flood Light Camera White', '14.1.png', '14.2.png', '14.3.png', '14.4.png', '14.5.png', '1000');
INSERT INTO PRODUCT(ma_loai_san_pham, ten_san_pham, hinh_anh_1, hinh_anh_2, hinh_anh_3, hinh_anh_4, hinh_anh_5, gia_ban) 
	VALUES ('4', 'Canon EOS M50 Mirrorless Digital Camera Black', '15.1.png', '15.2.png', '15.3.png', '15.4.png', '15.5.png', '1000');
INSERT INTO PRODUCT(ma_loai_san_pham, ten_san_pham, hinh_anh_1, hinh_anh_2, hinh_anh_3, hinh_anh_4, hinh_anh_5, gia_ban) 
	VALUES ('4', 'Canon EOS R Mirrorless Digital Camera Body Black', '16.1.png', '16.2.png', '16.3.png', '16.4.png', '16.5.png', '1000');

--TABLET 8--
INSERT INTO PRODUCT(ma_loai_san_pham, ten_san_pham, hinh_anh_1, hinh_anh_2, hinh_anh_3, hinh_anh_4, hinh_anh_5, gia_ban) 
	VALUES ('5', 'Wintouch Q75S Tablet', '1.1.png', '1.2.png', '1.3.png', '1.4.png', '1.5.png', '1000000')
INSERT INTO PRODUCT(ma_loai_san_pham, ten_san_pham, hinh_anh_1, hinh_anh_2, hinh_anh_3, hinh_anh_4, hinh_anh_5, gia_ban) 
	VALUES ('5', 'Huawei MediaPad T5', '2.1.png', '2.2.png', '2.3.png', '2.4.png', '2.5.png', '10000000')
INSERT INTO PRODUCT(ma_loai_san_pham, ten_san_pham, hinh_anh_1, hinh_anh_2, hinh_anh_3, hinh_anh_4, hinh_anh_5, gia_ban) 
	VALUES ('5', 'Huawei MediaPad T3', '3.1.png', '3.2.png', '3.3.png', '3.4.png', '3.5.png', '12000000')
INSERT INTO PRODUCT(ma_loai_san_pham, ten_san_pham, hinh_anh_1, hinh_anh_2, hinh_anh_3, hinh_anh_4, hinh_anh_5, gia_ban) 
	VALUES ('5', 'Apple iPad Mini 4', '4.1.png', '4.2.png', '4.3.png', '4.4.png', '4.5.png', '1500000')
INSERT INTO PRODUCT(ma_loai_san_pham, ten_san_pham, hinh_anh_1, hinh_anh_2, hinh_anh_3, hinh_anh_4, hinh_anh_5, gia_ban) 
	VALUES ('5', 'Samsung Galaxy Tab A', '5.1.png', '5.2.png', '5.3.png', '5.4.png', '5.5.png', '3000000')
INSERT INTO PRODUCT(ma_loai_san_pham, ten_san_pham, hinh_anh_1, hinh_anh_2, hinh_anh_3, hinh_anh_4, hinh_anh_5, gia_ban) 
	VALUES ('5', 'Lenovo Folio Case', '6.1.png', '6.2.png', '6.3.png', '6.4.png', '6.5.png', '4000000')
INSERT INTO PRODUCT(ma_loai_san_pham, ten_san_pham, hinh_anh_1, hinh_anh_2, hinh_anh_3, hinh_anh_4, hinh_anh_5, gia_ban) 
	VALUES ('5', 'Lenovo Tab E7', '7.1.png', '7.2.png', '7.3.png', '7.4.png', '6.5.png', '8000000')
INSERT INTO PRODUCT(ma_loai_san_pham, ten_san_pham, hinh_anh_1, hinh_anh_2, hinh_anh_3, hinh_anh_4, hinh_anh_5, gia_ban) 
	VALUES ('5', 'Maxguard BP-IPA', '8.1.png', '8.2.png', '8.3.png', '8.4.png', '8.5.png', '12000000')

--USER--
INSERT INTO USER_ELECTRO(user__name, pass_word, ngay_sinh, gioi_tinh, email, sdt, dia_chi, ro_le, trang_thai) VALUES ('test', 'test', '2015-05-04', 'Nam', 'kbs07101999@gmail.com', '0984552774', N'Số 75, ngõ 51 Tương Mai, Hoàng Mai, Hà Nội', '2', '1');
INSERT INTO USER_ELECTRO(user__name, pass_word, ngay_sinh, gioi_tinh, email, sdt, dia_chi, ro_le, trang_thai) VALUES ('admin', 'admin', '2019-10-30', 'Nam', 'ducpb07101999@gmail.com', '0912634300', N'Số 75, ngõ 51 Tương Mai, Hoàng Mai, Hà Nội', '1', '1');
--CART--
SET IDENTITY_INSERT CART OFF;
INSERT INTO CART(ma_nguoi_dung, ma_san_pham, ngay_mua, so_luong, thanh_tien) VALUES ('1', '1', '2015-05-17', '1', '100000');
INSERT INTO CART(ma_nguoi_dung, ma_san_pham, ngay_mua, so_luong, thanh_tien) VALUES ('1', '2', '2015-05-17', '2', '200000');

--WISHLIST--
SET IDENTITY_INSERT WISHLIST OFF;
INSERT INTO WISHLIST(ma_nguoi_dung, ma_san_pham) VALUES ('1', '1');
INSERT INTO WISHLIST(ma_nguoi_dung, ma_san_pham) VALUES ('1', '2');

