create database NhanVienDB
go

use NhanVienDB
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
)
go

insert into NhanVien values('NV0001', N'Vương Thiên Phú', N'Nam', '12/02/1996', N'Đường Nguyễn Văn Cừ', '01234567891', '015432672', '300000vnd', 'NV0001')
insert into NhanVien values('NV0002', N'Phan Khánh Lâm', N'Nam', '12/02/1996', N'Đường Nguyễn Văn Cừ', '01234567891', '016427977', '300000vnd', 'NV0002')
insert into NhanVien values('NV0003', N'Nguyễn Hoàng Kim', N'Nam', '12/02/1996', N'Đường Nguyễn Văn Cừ', '01234567891', '022364899', '300000vnd', 'NV0003')
insert into NhanVien values('NV0004', N'Nguyễn Minh Duy', N'Nam', '12/02/1996', N'Đường Nguyễn Văn Cừ', '01234567891', '034521876', '300000vnd', 'NV0004')
insert into NhanVien values('NV0005', N'Hòa Thị Lan', N'Nữ', '12/02/1996', N'Đường Nguyễn Văn Cừ', '01234567891', '049821657', '300000vnd', 'NV0005')
insert into NhanVien values('NV0006', N'Phương Kim Tuyến', N'Nữ', '12/02/1996', N'Đường Nguyễn Văn Cừ', '01234567891', '051385789', '300000vnd', 'NV0006')
insert into NhanVien values('NV0007', N'Nguyễn Thị Bích Ngọc', N'Nam', '12/02/1996', N'Đường Nguyễn Văn Cừ', '01234567891', '064897231', '300000vnd', 'NV0007')
insert into NhanVien values('NV0008', N'Trần Mỹ Liên', N'Nữ', '12/02/1996', N'Đường Nguyễn Văn Cừ', '01234567891', '078915364', '300000vnd', 'NV0008')
insert into NhanVien values('NV0009', N'Hà Bội Tuyền', N'Nam', '12/02/1996', N'Đường Nguyễn Văn Cừ', '01234567891', '083659841', '300000vnd', 'NV0009')
insert into NhanVien values('NV0010', N'Nguyễn Mạnh Hùng', N'Nam', '12/02/1996', N'Đường Nguyễn Văn Cừ', '01234567891', '093215649', '300000vnd', 'NV0010')
insert into NhanVien values('NV0011', N'Trần Vỹ Quân', N'Nam', '12/02/1996', N'Đường Nguyễn Văn Cừ', '01234567891', '010324986', '300000vnd', 'NV0011')
insert into NhanVien values('NV0012', N'Nguyễn Hoàng Phước', N'Nam', '12/02/1996', N'Đường Nguyễn Văn Cừ', '01234567891', '011238465', '300000vnd', 'NV0012')
go

select * from NhanVien
go

--Tạo procedure thêm nhân viên mới 
create procedure ThemNhanVien @tennv nvarchar(50), @gioitinh nvarchar(4), @ngaysinh date, @diachi nvarchar(100), @sodt varchar(12), @socmnd varchar(12)
as
begin
	declare @maxmanv char(6), @manv char(6), @substr char(4), @tempstr char(4), @tempnum int
	
	--Lấy mã nhân viên lớn nhất
	select @maxmanv = max(MaNV)
	from NhanVien

	--Lay phần số của mã lớn nhất
	set @substr = substring(@maxmanv, 3, 4)
	set @tempnum = convert(int, @substr)

	--Tăng số của mã và chuyển thành chuỗi
	set @tempnum = @tempnum + 1
	set @tempstr = convert(char(4), @tempnum)
	
	if (@tempnum < 10)
		set @manv = CONCAT('NV000', @tempstr)

	if (@tempnum < 100 and @tempnum >= 10)
		set @manv = CONCAT('NV00', @tempstr)

	IF (@tempnum < 1000 and @tempnum >= 100)
		set @manv = CONCAT('NV0', @tempstr)
	
	IF (@tempnum < 10000 and @tempnum >= 1000)
		set @manv = CONCAT('NV', @tempstr)

	insert into NhanVien values(@manv, @tennv, @gioitinh, @ngaysinh, @diachi, @sodt, @socmnd, '300000vnd', @manv)
end
go

drop procedure TaoMa
go

create procedure TaoMa @manv char(6) output
as
begin
	declare @maxmanv char(6), @substr char(4), @tempstr char(4), @tempnum int
	
	--Lấy mã nhân viên lớn nhất
	select @maxmanv = max(MaNV)
	from NhanVien

	--Lay phần số của mã lớn nhất
	set @substr = substring(@maxmanv, 3, 4)
	set @tempnum = convert(int, @substr)

	--Tăng số của mã và chuyển thành chuỗi
	set @tempnum = @tempnum + 1
	set @tempstr = convert(char(4), @tempnum)
	
	if (@tempnum < 10)
		set @manv = CONCAT('NV000', @tempstr)

	if (@tempnum < 100 and @tempnum >= 10)
		set @manv = CONCAT('NV00', @tempstr)

	IF (@tempnum < 1000 and @tempnum >= 100)
		set @manv = CONCAT('NV0', @tempstr)
	
	IF (@tempnum < 10000 and @tempnum >= 1000)
		set @manv = CONCAT('NV', @tempstr)

end
go

declare @ketqua char(6)
exec TaoMa @ketqua output
print @ketqua





--exec ThemNhanVien N'Nguyễn Hoàng Phước', N'Nam', '12/02/1996', N'Đường Nguyễn Văn Cừ', '01234567891', '011238466'
--go