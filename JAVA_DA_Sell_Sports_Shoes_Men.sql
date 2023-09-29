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
    LoaiSize  VARCHAR(20),
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
    HinhAnh   VARCHAR(250),
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
    Ho    NVARCHAR(50),
    TenDem NVARCHAR(50),
    Ten    NVARCHAR(50),
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

