create database KhachSan
go

use KhachSan
go

--===================Tạo các table===================
create table LoaiNV
(
	MaLoaiNV int IDENTITY(1, 1),
	TenLoaiNV nvarchar(50),
	NgayTao datetime,
	NgayCapNhat datetime,
	primary key(MaLoaiNV)
)
go

create table NhanVien
(
	MaNV varchar(6),
	TenNV nvarchar(50),
	DiaChi nvarchar(100),
	SoDT varchar(12),
	NgaySinh date,
	CMND varchar(12) unique,
	LoaiNV int,
	Luong varchar(200),
	BoPhan int,
	MatKhau varchar(200),
	GioiTinh nvarchar(5),
	NgayTao datetime,
	NgayCapNhat datetime,
	primary key(MaNV)
)
go

create table BoPhan
(
	MaBoPhan int identity(1, 1),
	TenBoPhan nvarchar(50),
	SoNhanVien int,
	QuanLyBP varchar(6),
	NgayTao datetime,
	NgayCapNhat datetime,
	primary key(MaBoPhan)
)
go

create table CaLam
(
	MaCa int identity(1, 1),
	GioBatDau time,
	GioKetThuc time,
	Thu nvarchar(10),
	NgayTao datetime,
	NgayCapNhat datetime,
	primary key(MaCa)
)
go

create table PhanCong
(
	MaPhanCong int identity(1, 1),
	MaBoPhan int,
	CaLam int,
	SoLuong int,
	Tang int,
	NgayTao datetime,
	NgayCapNhat datetime,
	primary key(MaPhanCong)
)
go

--===================Tạo các khóa ngoại===================
--Bảng NhanVien
alter table NhanVien add
constraint FK_NhanVien_BoPhan foreign key(BoPhan) references BoPhan(MaBoPhan)
alter table NhanVien add
constraint FK_NhanVien_LoaiNV foreign key(LoaiNV) references LoaiNV(MaLoaiNV)
go

--Bảng BoPhan
alter table BoPhan add
constraint FK_BoPhan_NhanVien foreign key(QuanLyBP) references NhanVien(MaNV)
go

--Bảng PhanCong
alter table PhanCong add
constraint FK_PhanCong_BoPhan foreign key(MaBoPhan) references BoPhan(MaBoPhan)
alter table PhanCong add
constraint FK_PhanCong_CaLam foreign key(CaLam) references CaLam(MaCa)
go

--===================Tạo dữ liệu cho bảng===================
insert into LoaiNV values (N'Nhân viên bảo vệ', getdate(), getdate())
insert into LoaiNV values (N'Nhân viên nhà bếp', getdate(), getdate())
insert into LoaiNV values (N'Nhân viên vệ sinh', getdate(), getdate())
insert into LoaiNV values (N'Nhân viên tiếp tân', getdate(), getdate())
insert into LoaiNV values (N'Nhân viên thiết bị', getdate(), getdate())
insert into LoaiNV values (N'Nhân viên chăm sóc khách hàng', getdate(), getdate())
go

insert into BoPhan values (N'Bộ phận bảo vệ', 50, null, getdate(), getdate())
insert into BoPhan values (N'Bộ phận nhà bếp', 50, null, getdate(), getdate())
insert into BoPhan values (N'Bộ phận vệ sinh', 50, null, getdate(), getdate())
insert into BoPhan values (N'Bộ phận tiếp tân', 50, null, getdate(), getdate())
insert into BoPhan values (N'Bộ phận thiết bị', 50, null, getdate(), getdate())
insert into BoPhan values (N'Bộ phận chăm sóc khách hàng', 50, null, getdate(), getdate())
go

insert into NhanVien values('NV0001', N'Vương Thiên Phú', N'Đường Nguyễn Văn Cừ', '01234567891', '12/02/1996', '015432672', 1, null, 1, null, N'Nam', getdate(), getdate())
insert into NhanVien values('NV0002', N'Phan Khánh Lâm', N'Đường Nguyễn Văn Cừ', '01234567891', '12/02/1996', '016427977', 1, null, 1, null, N'Nam', getdate(), getdate())
insert into NhanVien values('NV0003', N'Nguyễn Hoàng Kim', N'Đường Nguyễn Văn Cừ', '01234567891', '12/02/1996', '022364899', 2, null, 2, null, N'Nam', getdate(), getdate())
insert into NhanVien values('NV0004', N'Nguyễn Minh Duy', N'Đường Nguyễn Văn Cừ', '01234567891', '12/02/1996', '034521876', 2, null, 2, null, N'Nam', getdate(), getdate())
insert into NhanVien values('NV0005', N'Hòa Thị Lan', N'Đường Nguyễn Văn Cừ', '01234567891', '12/02/1996', '049821657', 3, null, 3, null, N'Nữ', getdate(), getdate())
insert into NhanVien values('NV0006', N'Phương Kim Tuyến', N'Đường Nguyễn Văn Cừ', '01234567891', '12/02/1996', '051385789', 3, null, 3, null, N'Nữ', getdate(), getdate())
insert into NhanVien values('NV0007', N'Nguyễn Thị Bích Ngọc', N'Đường Nguyễn Văn Cừ', '01234567891', '12/02/1996', '064897231', 4, null, 4, null, N'Nam', getdate(), getdate())
insert into NhanVien values('NV0008', N'Trần Mỹ Liên', N'Đường Nguyễn Văn Cừ', '01234567891', '12/02/1996', '078915364', 4, null, 4, null, N'Nữ', getdate(), getdate())
insert into NhanVien values('NV0009', N'Hà Bội Tuyền', N'Đường Nguyễn Văn Cừ', '01234567891', '12/02/1996', '083659841', 5, null, 5, null, N'Nam', getdate(), getdate())
insert into NhanVien values('NV0010', N'Nguyễn Mạnh Hùng', N'Đường Nguyễn Văn Cừ', '01234567891', '12/02/1996', '093215649', 5, null, 5, null, N'Nam', getdate(), getdate())
insert into NhanVien values('NV0011', N'Trần Vỹ Quân', N'Đường Nguyễn Văn Cừ', '01234567891', '12/02/1996', '010324986', 6, null, 6, null, N'Nam', getdate(), getdate())
insert into NhanVien values('NV0012', N'Nguyễn Hoàng Phước', N'Đường Nguyễn Văn Cừ', '01234567891', '12/02/1996', '011238465', 6, null, 6, null, N'Nam', getdate(), getdate())
go

update BoPhan set QuanLyBP = 'NV0001' where MaBoPhan = 1
update BoPhan set QuanLyBP = 'NV0003' where MaBoPhan = 2
update BoPhan set QuanLyBP = 'NV0005' where MaBoPhan = 3
update BoPhan set QuanLyBP = 'NV0007' where MaBoPhan = 4
update BoPhan set QuanLyBP = 'NV0009' where MaBoPhan = 5
update BoPhan set QuanLyBP = 'NV0011' where MaBoPhan = 6
go

select * from LoaiNV