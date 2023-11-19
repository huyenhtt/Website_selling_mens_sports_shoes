Create Database JAVA_DA_Sell_Sports_Shoes_Men
GO

Use JAVA_DA_Sell_Sports_Shoes_Men
GO

CREATE TABLE SanPham(
	Id  UNIQUEIDENTIFIER 
		DEFAULT NEWID() PRIMARY KEY,
	MaSanPham    VARCHAR (100) UNIQUE,
	TenSanPham   NVARCHAR(150),
	CreateDate Date,
	LastModifiledDate Date,
	TrangThai INT
)
GO

CREATE TABLE ChatLieu(
    Id  UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
    MaChatLieu  VARCHAR(100) UNIQUE,
    TenChatLieu  NVARCHAR(150),
	CreateDate Date,
	LastModifiledDate Date,
	TrangThai INT
)
GO

CREATE TABLE KichCo(
    Id  UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
    MaKichCo  VARCHAR(100) UNIQUE,
    Size   INT ,
LoaiSize VARCHAR(10),
	GioiTinh  BIT,
	CreateDate Date,
	LastModifiledDate Date,
	TrangThai INT
)
GO

CREATE TABLE LoaiGiay(
    Id  UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
    Ma  VARCHAR(100) UNIQUE,
    TenTheLoai  NVARCHAR(150),
	CreateDate Date,
	LastModifiledDate Date,
	TrangThai INT
)
GO

CREATE TABLE DeGiay(
    Id  UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
    Ma  VARCHAR(100) UNIQUE,
    LoaiDe  NVARCHAR(150),
	MoTa  NVARCHAR(255),
	CreateDate Date,
	LastModifiledDate Date,
	TrangThai INT
)
GO

CREATE TABLE MauSac(
    Id  UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
    Ma  VARCHAR(100) UNIQUE,
    TenMau  NVARCHAR(150),
	CreateDate Date,
	LastModifiledDate Date,
	TrangThai INT
)
GO

CREATE TABLE ChiTietSanPham(
    Id  UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
    IdSP  UNIQUEIDENTIFIER REFERENCES SanPham(Id),
    IdMauSac UNIQUEIDENTIFIER REFERENCES MauSac(Id),
    IdTheLoai UNIQUEIDENTIFIER REFERENCES LoaiGiay(Id),
    IdKichCo UNIQUEIDENTIFIER REFERENCES KichCo(Id),
    IdChatLieu UNIQUEIDENTIFIER REFERENCES ChatLieu(Id),
    IdDeGiay UNIQUEIDENTIFIER REFERENCES DeGiay(Id),
    MaCTSP VARCHAR(100) UNIQUE,
	GiaBan   MONEY,
    SoLuong INT,
    MoTaCT   NVARCHAR(255),
	CreateDate Date,
	LastModifiledDate Date,
    TrangThai INT
)
GO

CREATE TABLE TaiKhoan(
    Id  UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
    Username VARCHAR(100) UNIQUE,
    Password VARCHAR(100),
    Role     BIT
)
GO

CREATE TABLE NguoiDung(
    Id UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
    IdTaiKhoan  UNIQUEIDENTIFIER REFERENCES TaiKhoan(Id),
    Ma    VARCHAR(50),
    Ho    NVARCHAR(250),
    TenDem NVARCHAR(250),
    Ten    NVARCHAR(250),
    GioiTinh  BIT,
    NgaySinh  DATE,
    DiaChi   NVARCHAR(255),
    SoDienThoai  VARCHAR(15) UNIQUE,
    Email    VARCHAR(200),
	CreateDate Date,
	LastModifiledDate Date,
    TrangThai INT
)
GO

CREATE TABLE GioHang(
    Id UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
    IdND  UNIQUEIDENTIFIER REFERENCES NguoiDung(Id),
	CreateDate Date,
	LastModifiledDate Date,
	GhiChu NVARCHAR(50),
    TrangThai INT
)
GO
CREATE TABLE KhuyenMai(
 Id  UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
    MaKhuyenMai  VARCHAR(100) UNIQUE,
    TenKhuyenMai  NVARCHAR(150),
	GiaTri Money,
	LoaiKhuyenMai NVARCHAR(150),
	NgayBatDau Date,
	NgayKetThuc Date,
	CreateDate Date,
	LastModifiledDate Date,
	TrangThai INT
)
GO
CREATE TABLE HoaDon(
    Id UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
    IdND  UNIQUEIDENTIFIER REFERENCES NguoiDung(Id),
    MaHD    VARCHAR(150),
    NgayTao  DATE,
    NgayThanhToan  DATE,
    NgayNhan  DATE,
    NgayShip  DATE,
    DiaChi   NVARCHAR(255),
	HinhThucThanhToan int,
	HinhThucGiaoHang int,
    SDTNguoiNhan  VARCHAR(15),
    SDTNguoiShip  VARCHAR(15),
    TenNguoiNhan    NVARCHAR(100),
	CreateDate Date,
	LastModifiledDate Date,
    TrangThai INT
)
GO
insert into HoaDon(MaHD,CreateDate) values ('2','01/05/2023'),
										('2','01/06/2023'),
										('2','01/09/2023')
select *from HoaDon
select * from HoaDon where CreateDate between '01/01/2023' and '01/07/2023'

CREATE TABLE HoaDonChiTiet(
    Id UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
    IdHoaDon   UNIQUEIDENTIFIER REFERENCES HoaDon(Id),
    IdChiTietSP UNIQUEIDENTIFIER REFERENCES ChiTietSanPham(Id),
    SoLuong INT,
    DonGia   MONEY,
    GiaBan   MONEY,
    GiamGiaKhuyenMai   Decimal(20,0),
	CreateDate Date,
	LastModifiledDate Date,
)
GO
CREATE TABLE ChiTietKhuyenMai(
    Id UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
    IdKM   UNIQUEIDENTIFIER REFERENCES KhuyenMai(Id),
    IdChiTietSP UNIQUEIDENTIFIER REFERENCES ChiTietSanPham(Id),
    SoLuong INT,
    DonGia   MONEY,
    DonGiaConLai Money,
	CreateDate Date,
	LastModifiledDate Date,
	TrangThai INT
)
GO
CREATE TABLE DiaChi(
    Id UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	 IdNguoiDung   UNIQUEIDENTIFIER REFERENCES NguoiDung(Id),
    MaDiaChi VARCHAR(20),
	TenDiaChi NVARCHAR(50),
	MoTaCT NVARCHAR(100),
    TinhThanhPho NVARCHAR(100),
    QuanHuyen NVARCHAR(100),
    PhuongXa NVARCHAR(100),
    DuongPho NVARCHAR(100),
	CreateDate Date,
	LastModifiledDate Date
)
GO
CREATE TABLE PhieuGiaoHang(
    Id UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
    IdHoaDon   UNIQUEIDENTIFIER REFERENCES HoaDon(Id),
    IdDiaChi   UNIQUEIDENTIFIER REFERENCES DiaChi(Id),
	MaPhieu VARCHAR(50),
	NguoiNhan NVARCHAR(50),
	SdtNguoiNhan VARCHAR(20),
	NguoiGiao NVARCHAR(50),
	NgayGiao Date,
	NgayNhan Date,
	NguoiTao NVARCHAR(50),
	PhiGiaoHang MONEY,
	CreateDate Date,
	LastModifiledDate Date,
	GhiChu NVARCHAR(MAX),
	TrangThai INT
    
)
GO

CREATE TABLE GioHangChiTiet(
    Id  UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
    IdChiTietSP  UNIQUEIDENTIFIER REFERENCES ChiTietSanPham(Id),
    IdGioHang  UNIQUEIDENTIFIER REFERENCES GioHang(Id),
    SoLuong INT,
    DonGia  MONEY,
    DonGiaKhiGiam MONEY,
	TrangThai INT
)
Go
CREATE TABLE HinhAnh
(
    Id        UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
    IdCTSP    UNIQUEIDENTIFIER REFERENCES ChiTietSanPham (id),
    TenAnh    VARCHAR(255),
    DuongDan1 VARCHAR(255),
    DuongDan2 VARCHAR(255),
    DuongDan3 VARCHAR(255),
    TrangThai INT
)
GO
INSERT INTO [dbo].[ChatLieu]
           (
		 
           [MaChatLieu]
           ,[TenChatLieu]
           ,[CreateDate]
           ,[LastModifiledDate]
           ,[TrangThai])
     VALUES
           (
           '9247ds',N'Vải','2023-2-2','2023-12-12',1),
		   ( '9347ds',N'Da','2023-2-2','2023-12-12',1),
		    ( '9447ds',N'Nylon','2023-2-2','2023-12-12',1), 
			( '9547ds',N'Apolyurethane','2023-2-2','2023-12-12',1)

GO
INSERT INTO [dbo].[DeGiay]
           ([Ma]
           ,[LoaiDe]
           ,[MoTa]
           ,[CreateDate]
           ,[LastModifiledDate]
           ,[TrangThai])
     VALUES
           ('dh281','Kingsman',N'bảo hộ','2023-2-2','2023-2-2',1),
		     ('dh28w1','Jogger ',N'bảo hộ','2023-2-2','2023-2-2',1),
			  ('dhw281','Ziben ',N'bảo hộ','2023-2-2','2023-2-2',1),
			  ('dh2ww81','Cao su ',N'bền','2023-2-2','2023-2-2',1)
GO
INSERT INTO [dbo].[TaiKhoan]
           ([Username]
           ,[Password]
           ,[Role])
     VALUES
           ('huyenhtt','123456',1),
		   ('namnt','123456',0),
		   ('jekd','123456',1),
		   ('kientm','123456',1)
GO
INSERT INTO [dbo].[NguoiDung]
           ([IdTaiKhoan]
           ,[Ma]
           ,[Ho]
           ,[TenDem]
           ,[Ten]
           ,[GioiTinh]
           ,[NgaySinh]
           ,[DiaChi]
           ,[SoDienThoai]
           ,[Email]
           ,[CreateDate]
           ,[LastModifiledDate]
           ,[TrangThai])
     VALUES
           ('c220e99f-75f2-49bb-bad3-305c071adfeb','quanly2',N'Hoàng',N'Thị',N'Huyền',1,'1-12-2003',N'Hà Nội','0948378375','huuyen@gmail.com','2023-2-2','2023-2-2',1),
		    ('bd8398e4-281f-4a9c-b95c-5acc01d4dc67','khc23',N'Nguyễn',N'Tiến',N'Nam',0,'2-12-2003',N'Hà Nội','0948387452','namnt@gmail.com','2023-2-2','2023-2-2',1)
GO
INSERT INTO [dbo].[MauSac]
           ([Ma]
           ,[TenMau]
           ,[CreateDate]
           ,[LastModifiledDate]
           ,[TrangThai])
     VALUES
           ('mn279','green','2023-2-2','2023-2-2',1),
		   ('mn2792','blue','2023-2-2','2023-2-2',1),
		   ('mn2w7e9','puple','2023-2-2','2023-2-2',1),
		   ('mn27ws9','black','2023-2-2','2023-2-2',1),
		   ('mn2s79','white','2023-2-2','2023-2-2',1)
GO

INSERT INTO [dbo].[LoaiGiay]
           ([Ma]
           ,[TenTheLoai]
           ,[CreateDate]
           ,[LastModifiledDate]
           ,[TrangThai])
     VALUES
           ('ma1ee31',N'Giày chạy bộ','2023-2-2','2023-2-2',1),
		   ('ma1e31',N'Giày đi bộ','2023-2-2','2023-2-2',1),
		   ('ma1q31',N'Giày đá bóng','2023-2-2','2023-2-2',1),
		   ('ma13ed1',N'Giày chạy địa hình','2023-2-2','2023-2-2',1),
		   ('maed131',N'Giày bóng rổ','2023-2-2','2023-2-2',1)
GO

INSERT INTO [dbo].[KichCo]
           ([MaKichCo]
           ,[Size]
           ,[GioiTinh]
           ,[CreateDate]
           ,[LastModifiledDate]
           ,[TrangThai])
     VALUES
           ('anu32',40,1,'2023-2-1','2023-2-1',1),
		   ('anu232',41,1,'2023-2-1','2023-2-1',1),
		   ('anuqw32',42,1,'2023-2-1','2023-2-1',1),
		   ('awwnu32',44,1,'2023-2-1','2023-2-1',1),
		   ('anuwf32',43,1,'2023-2-1','2023-2-1',1)
GO

INSERT INTO [dbo].[KhuyenMai]
           ([MaKhuyenMai]
           ,[TenKhuyenMai]
           ,[GiaTri]
           ,[LoaiKhuyenMai]
           ,[NgayBatDau]
           ,[NgayKetThuc]
           ,[CreateDate]
           ,[LastModifiledDate]
           ,[TrangThai])
     VALUES
           ('km78q3',N'giảm 10%',120,'sp','2023-1-2','2023-1-3','2023-1-2','2023-1-3',0),
		   ('km78dsq3',N'giảm 30%',122,'sp','2023-1-2','2023-1-3','2023-1-2','2023-1-3',1)
GO