use DEMO_PTUDHTTTHD;

delete from ChiTietThietBi;
delete from ThietBi;
delete from ChiTietThongTinDatPhong;
delete from ThongTinDatPhong;
delete from KhachHang;
delete from TaiKhoan;
delete from Phong;
delete from LoaiPhong;

insert into ThietBi values ('TB001',120,'LED Pana 1102','LED Tivi',left(convert(varchar(255), getdate(), 126),10),left(convert(varchar(255), getdate(), 126),10),10);
insert into ThietBi values ('TB002',120,'Tu lanh ES122','Tu lanh',left(convert(varchar(255), getdate(), 126),10),left(convert(varchar(255), getdate(), 126),10),10);
insert into ThietBi values ('TB004',120,'Panasonic AC112','May lanh',left(convert(varchar(255), getdate(), 126),10),left(convert(varchar(255), getdate(), 126),10),10);
insert into ThietBi values ('TB005',120,'Rinnai X0122','Bep Ga',left(convert(varchar(255), getdate(), 126),10),left(convert(varchar(255), getdate(), 126),10),10);

insert into LoaiPhong values (1, N'Giường đơn', N'Phòng có phong cách bình thường', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), N'Phòng bình thường');
insert into LoaiPhong values (2, N'Giường đôi', N'Phòng có phong cách bình thường', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), N'Phòng bình thường');
insert into LoaiPhong values (3, N'Giường đôi', N'Phòng dành cho những vị khách đặt biệt', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), N'Phòng VIP');
insert into LoaiPhong values (4, N'Giường đơn', N'Tận hường phong cách của một vị tổng thống', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), N'Phòng tổng thống');
insert into LoaiPhong values (5, N'Giường đôi', N'Dành cho những cặp đôi yêu nhau', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), N'Phòng tình nhân');
insert into LoaiPhong values (6, N'Giường đơn', N'Trải nghiệm ngủ cùng với những linh hồn tà ác', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), N'Phòng kinh dị');
insert into LoaiPhong values (7, N'Giường đôi', N'Trải nghiệm một đêm của giới quý tộc hoàng gia', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), N'Phòng hoàng gia');
insert into LoaiPhong values (8, N'Giường đôi', N'Hãy cùng đến thế kỷ 22 nào', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), N'Phòng tương lai');

insert into Phong values ('100', 40000, N'Phòng bình thường', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 1, '1', N'Bình thường', 1);
insert into Phong values ('101', 45000, N'Phòng bình thường', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 1, '1', N'Bình thường', 2);
insert into Phong values ('202', 70000, N'Phòng bình thường', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 2, '2', N'Bình thường', 2);
insert into Phong values ('203', 75000, N'Tuy có phong cách bình thường nhưng có thể ngắm bãi biển', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 2, '2', N'Ngắm biển', 1);
insert into Phong values ('304', 85000, N'Dành cho những cặp đôi muốn tận hưởng hương vị của biển cả', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 1, '3', N'Ngắm biển', 5);
insert into Phong values ('303', 70000, N'Cùng nhau ngắm rặng núi lãng mạng', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 1, '3', N'Ngắm núi', 5);
insert into Phong values ('401', 80000, N'Căn phòng của ác quỷ', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 1, '4', N'Bình thường', 6);
insert into Phong values ('402', 100000, N'Cùng nhau tận hưởng cảm giác rùng rợn hòa quyện cùng với hương vị của biển cả', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 1, '4', N'Ngắm biển', 6);
insert into Phong values ('404', 150000, N'Cùng những người bạn trải qua một đêm kinh hoàng', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 3, '4', N'Ngắm biển', 6);
insert into Phong values ('504', 120000, N'Cùng nhau trải qua một đêm thật thế kỷ 22', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 2, '5', N'Ngắm thành phố', 8);
insert into Phong values ('605', 175000, N'Cùng bạn bè và người thân đến thế kỷ 22', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 3, '6', N'Ngắm núi', 8);
insert into Phong values ('702', 200000, N'Là một V.I.P ngắm biển', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 1, '7', N'Ngắm biển', 3);
insert into Phong values ('703', 165000, N'Là một V.I.P với phong cảnh thành phố hiện đại', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 1, '7', N'Ngắm thành phố', 3);
insert into Phong values ('804', 200000, N'Hãy trở thành một vị tổng thống', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 1, '8', N'Bình thường', 4);
insert into Phong values ('805', 230000, N'Hãy trở thành một vị tổng thống', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 1, '8', N'Ngắm thành phố', 4);
insert into Phong values ('806', 280000, N'Hãy trở thành một vị tổng thống', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 1, '8', N'Ngắm biển', 4);
insert into Phong values ('901', 340000, N'Tận hưởng cảm giác làm những ông hoàng bà chúa', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 1, '9', N'Bình thường', 7);
insert into Phong values ('902', 380000, N'Tận hưởng cảm giác làm những ông hoàng bà chúa', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 1, '9', N'Ngắm thành phố', 7);
insert into Phong values ('903', 420000, N'Tận hưởng cảm giác làm những ông hoàng bà chúa', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 1, '9', N'Ngắm biển', 7);
insert into Phong values ('904', 3000000, N'Là một V.I.P', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 1, '9', N'Bình thường', 3);
insert into Phong values ('503', 140000, N'Cùng với một nữa dạo bước trên bải biển cực kỳ lãng mạng', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 1, '5', N'Ngắm biển', 5);

insert into ChiTietThietBi values('CT00001','DNH0001',left(convert(varchar(255), getdate(), 126),10),left(convert(varchar(255), getdate(), 126),10),'DangSuDung','404','TB001');
insert into ChiTietThietBi values('CT00002','DNH0004',left(convert(varchar(255), getdate(), 126),10),left(convert(varchar(255), getdate(), 126),10),'KhongSuDung','504','TB002');
insert into ChiTietThietBi values('CT00003','DNH0005',left(convert(varchar(255), getdate(), 126),10),left(convert(varchar(255), getdate(), 126),10),'KhongSuDung','804','TB001');
insert into ChiTietThietBi values('CT00004','DNH0001',left(convert(varchar(255), getdate(), 126),10),left(convert(varchar(255), getdate(), 126),10),'KhongSuDug','902','TB002');
insert into ChiTietThietBi values('CT00005','DNH0003',left(convert(varchar(255), getdate(), 126),10),left(convert(varchar(255), getdate(), 126),10),'DangSuDung','503','TB004');

insert into TaiKhoan values ('tpv@gmail.com', 3, '12345678', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10));
insert into TaiKhoan values ('nhk@gmail.com', 5, '12345678', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10));
insert into TaiKhoan values ('pkl@gmail.com', 6, '12345678', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10));
insert into TaiKhoan values ('dnm@gmail.com', 7, '12345678', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10));

insert into  KhachHang values ('KH00001', '123456789', N'3 tháng 2 p16 q11 hcm', N'Nam', N'Vương Thiên Phú', 1, left(convert(varchar(255), getdate(), 126),10), '1996-01-03', left(convert(varchar(255), getdate(), 126),10), '0164587521', 'tpv@gmail.com');
insert into  KhachHang values ('KH00002', '123456789', N'3 tháng 2 p16 q11 hcm', N'Nam', N'Nguyễn Hoàng Kim', 1, left(convert(varchar(255), getdate(), 126),10), '1996-01-03', left(convert(varchar(255), getdate(), 126),10), '0164587521', 'nhk@gmail.com');
insert into  KhachHang values ('KH00003', '123456789', N'3 tháng 2 p16 q11 hcm', N'Nữ', N'Trần Kim Anh', 1, left(convert(varchar(255), getdate(), 126),10), '1996-01-03', left(convert(varchar(255), getdate(), 126),10), '0164587521', null);
insert into  KhachHang values ('KH00004', '123456789', N'3 tháng 2 p16 q11 hcm', N'Nam', N'Phan Khánh Lâm', 1, left(convert(varchar(255), getdate(), 126),10), '1996-01-03', left(convert(varchar(255), getdate(), 126),10), '0164587521', 'pkl@gmail.com');
insert into  KhachHang values ('KH00005', '123456789', N'3 tháng 2 p16 q11 hcm', N'Nữ', N'Nguyễn Thị Mỹ Trân', 1, left(convert(varchar(255), getdate(), 126),10), '1996-01-03', left(convert(varchar(255), getdate(), 126),10), '0164587521', null);
insert into  KhachHang values ('KH00006', '123456789', N'3 tháng 2 p16 q11 hcm', N'Nữ', N'Lương Ngọc Lan', 1, left(convert(varchar(255), getdate(), 126),10), '1996-01-03', left(convert(varchar(255), getdate(), 126),10), '0164587521', null);
insert into  KhachHang values ('KH00007', '123456789', N'3 tháng 2 p16 q11 hcm', N'Nam', N'Đặng Nhật Minh', 1, left(convert(varchar(255), getdate(), 126),10), '1996-01-03', left(convert(varchar(255), getdate(), 126),10), '0164587521', 'dnm@gmail.com');

insert into ThongTinDatPhong values ('TTDP0001', null, left(convert(varchar(255), getdate(), 126),10), 2, 2, left(convert(varchar(255), getdate(), 126),10), null, left(convert(varchar(255), dateadd(day, 3, getdate()), 126),10), left(convert(varchar(255), dateadd(day, 5, getdate()), 126),10), N'Chưa thanh toán', 'KH00001');
insert into ThongTinDatPhong values ('TTDP0002', null, left(convert(varchar(255), getdate(), 126),10), 2, 2, left(convert(varchar(255), getdate(), 126),10), null, left(convert(varchar(255), dateadd(day, 4, getdate()), 126),10), left(convert(varchar(255), dateadd(day, 5, getdate()), 126),10), N'Chưa thanh toán', 'KH00002');
insert into ThongTinDatPhong values ('TTDP0003', null, left(convert(varchar(255), getdate(), 126),10), 2, 2, left(convert(varchar(255), getdate(), 126),10), null, left(convert(varchar(255), dateadd(day, 5, getdate()), 126),10), left(convert(varchar(255), dateadd(day, 7, getdate()), 126),10), N'Chưa thanh toán', 'KH00003');
insert into ThongTinDatPhong values ('TTDP0004', null, left(convert(varchar(255), getdate(), 126),10), 2, 2, left(convert(varchar(255), getdate(), 126),10), null, left(convert(varchar(255), dateadd(day, 6, getdate()), 126),10), left(convert(varchar(255), dateadd(day, 8, getdate()), 126),10), N'Chưa thanh toán', 'KH00004');
insert into ThongTinDatPhong values ('TTDP0005', null, left(convert(varchar(255), getdate(), 126),10), 2, 2, left(convert(varchar(255), getdate(), 126),10), null, left(convert(varchar(255), dateadd(day, 4, getdate()), 126),10), left(convert(varchar(255), dateadd(day, 6, getdate()), 126),10), N'Chưa thanh toán', 'KH00005');
insert into ThongTinDatPhong values ('TTDP0006', null, left(convert(varchar(255), getdate(), 126),10), 2, 2, left(convert(varchar(255), getdate(), 126),10), null, left(convert(varchar(255), dateadd(day, 3, getdate()), 126),10), left(convert(varchar(255), dateadd(day, 8, getdate()), 126),10), N'Chưa thanh toán', 'KH00006');
insert into ThongTinDatPhong values ('TTDP0007', null, left(convert(varchar(255), getdate(), 126),10), 2, 2, left(convert(varchar(255), getdate(), 126),10), null, left(convert(varchar(255), dateadd(day, 7, getdate()), 126),10), left(convert(varchar(255), dateadd(day, 9, getdate()), 126),10), N'Chưa thanh toán', 'KH00007');
insert into ThongTinDatPhong values ('TTDP0008', null, left(convert(varchar(255), getdate(), 126),10), 2, 2, left(convert(varchar(255), getdate(), 126),10), null, left(convert(varchar(255), dateadd(day, 3, getdate()), 126),10), left(convert(varchar(255), dateadd(day, 5, getdate()), 126),10), N'Chưa thanh toán', 'KH00001');
insert into ThongTinDatPhong values ('TTDP0009', null, left(convert(varchar(255), getdate(), 126),10), 2, 2, left(convert(varchar(255), getdate(), 126),10), null, left(convert(varchar(255), dateadd(day, 2, getdate()), 126),10), left(convert(varchar(255), dateadd(day, 5, getdate()), 126),10), N'Chưa thanh toán', 'KH00002');
insert into ThongTinDatPhong values ('TTDP0010', null, left(convert(varchar(255), getdate(), 126),10), 2, 2, left(convert(varchar(255), getdate(), 126),10), null, left(convert(varchar(255), dateadd(day, 4, getdate()), 126),10), left(convert(varchar(255), dateadd(day, 6, getdate()), 126),10), N'Chưa thanh toán', 'KH00004');
insert into ThongTinDatPhong values ('TTDP0011', null, left(convert(varchar(255), getdate(), 126),10), 2, 2, left(convert(varchar(255), getdate(), 126),10), null, left(convert(varchar(255), dateadd(day, 5, getdate()), 126),10), left(convert(varchar(255), dateadd(day, 8, getdate()), 126),10), N'Chưa thanh toán', 'KH00007');

insert into ChiTietThongTinDatPhong values ('TTDP0001', '100', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 300000);
insert into ChiTietThongTinDatPhong values ('TTDP0001', '101', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 45000);
insert into ChiTietThongTinDatPhong values ('TTDP0002', '101', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 300000);
insert into ChiTietThongTinDatPhong values ('TTDP0002', '202', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 45000);
insert into ChiTietThongTinDatPhong values ('TTDP0003', '203', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 65000);
insert into ChiTietThongTinDatPhong values ('TTDP0003', '303', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 70000);
insert into ChiTietThongTinDatPhong values ('TTDP0004', '304', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 65000);
insert into ChiTietThongTinDatPhong values ('TTDP0004', '401', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 70000);
insert into ChiTietThongTinDatPhong values ('TTDP0005', '401', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 300000);
insert into ChiTietThongTinDatPhong values ('TTDP0005', '402', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 70000);
insert into ChiTietThongTinDatPhong values ('TTDP0006', '404', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 70000);
insert into ChiTietThongTinDatPhong values ('TTDP0006', '402', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 45000);
insert into ChiTietThongTinDatPhong values ('TTDP0007', '503', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 70000);
insert into ChiTietThongTinDatPhong values ('TTDP0007', '901', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 45000);
insert into ChiTietThongTinDatPhong values ('TTDP0008', '504', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 300000);
insert into ChiTietThongTinDatPhong values ('TTDP0008', '605', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 45000);
insert into ChiTietThongTinDatPhong values ('TTDP0009', '702', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 65000);
insert into ChiTietThongTinDatPhong values ('TTDP0009', '804', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 65000);
insert into ChiTietThongTinDatPhong values ('TTDP0010', '805', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 300000);
insert into ChiTietThongTinDatPhong values ('TTDP0010', '903', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 65000);
insert into ChiTietThongTinDatPhong values ('TTDP0011', '903', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 45000);
insert into ChiTietThongTinDatPhong values ('TTDP0011', '904', left(convert(varchar(255), getdate(), 126),10), left(convert(varchar(255), getdate(), 126),10), 65000);

update hibernate_sequence set next_val = 9;