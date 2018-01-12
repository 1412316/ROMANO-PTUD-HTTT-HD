create database NhanVienDB
go

use NhanVienDB
go

drop table NhanVien
go

create table NhanVien
(
	MaNV char(6) primary key,
	TenNV nvarchar(50),
	GioiTinh nvarchar(4),
	NgaySinh date,
	DiaChi nvarchar(100),
	SoDT varchar(12),
	SoCMND varchar(12) unique,
	Luong varchar(200),
	MatKhau varchar(200),
	NgayTao date,
	NgayCapNhat date
)
go

insert into NhanVien values('NV0001', N'Vương Thiên Phú', N'Nam', '1996-12-02', N'Đường Nguyễn Văn Cừ', '01234567891', '015432672', '300000', 'NV0001', getdate(), getdate())
insert into NhanVien values('NV0002', N'Phan Khánh Lâm', N'Nam', '1996-12-02', N'Đường Nguyễn Văn Cừ', '01234567891', '016427977', '300000', 'NV0002', getdate(), getdate())
insert into NhanVien values('NV0003', N'Nguyễn Hoàng Kim', N'Nam', '1996-12-02', N'Đường Nguyễn Văn Cừ', '01234567891', '022364899', '300000', 'NV0003', getdate(), getdate())
insert into NhanVien values('NV0004', N'Nguyễn Minh Duy', N'Nam', '1996-12-02', N'Đường Nguyễn Văn Cừ', '01234567891', '034521876', '300000', 'NV0004', getdate(), getdate())
insert into NhanVien values('NV0005', N'Hòa Thị Lan', N'Nữ', '1996-12-02', N'Đường Nguyễn Văn Cừ', '01234567891', '049821657', '300000', 'NV0005', getdate(), getdate())
insert into NhanVien values('NV0006', N'Phương Kim Tuyến', N'Nữ', '1996-12-02', N'Đường Nguyễn Văn Cừ', '01234567891', '051385789', '300000', 'NV0006', getdate(), getdate())
insert into NhanVien values('NV0007', N'Nguyễn Thị Bích Ngọc', N'Nam', '1996-12-02', N'Đường Nguyễn Văn Cừ', '01234567891', '064897231', '300000', 'NV0007', getdate(), getdate())
insert into NhanVien values('NV0008', N'Trần Mỹ Liên', N'Nữ', '1996-12-02', N'Đường Nguyễn Văn Cừ', '01234567891', '078915364', '300000', 'NV0008', getdate(), getdate())
insert into NhanVien values('NV0009', N'Hà Bội Tuyền', N'Nam', '1996-12-02', N'Đường Nguyễn Văn Cừ', '01234567891', '083659841', '300000', 'NV0009', getdate(), getdate())
insert into NhanVien values('NV0010', N'Nguyễn Mạnh Hùng', N'Nam', '1996-12-02', N'Đường Nguyễn Văn Cừ', '01234567891', '093215649', '300000', 'NV0010', getdate(), getdate())
insert into NhanVien values('NV0011', N'Trần Vỹ Quân', N'Nam', '1996-12-02', N'Đường Nguyễn Văn Cừ', '01234567891', '010324986', '300000', 'NV0011', getdate(), getdate())
insert into NhanVien values('NV0012', N'Nguyễn Hoàng Phước', N'Nam', '1996-12-02', N'Đường Nguyễn Văn Cừ', '01234567891', '011238465', '300000', 'NV0012', getdate(), getdate())
go

select * from NhanVien
go

delete from NhanVien where MaNV = 'NV0012'

update NhanVien set NgayTao = '2018-01-09', NgayCapNhat = '2018-01-09' where MaNV = 'NV0013'

drop procedure InNgay
go

create procedure InNgay @ngay char(100) output
as
begin
	set @ngay = left(convert(varchar(255), getdate(), 126),10)
end
go

declare @ketqua char(100)
exec InNgay @ketqua output
print @ketqua

