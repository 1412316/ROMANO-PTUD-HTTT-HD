$(function(){
    function XacNhanThemNhanVien() {
        var NhanVien = {
            TenNV: $("#ThemTenNV").val(),
            GioiTinh: $("#ThemGioiTinh").val(),
            NgaySinh: $("#ThemNgaySinh").val(),
            DiaChi: $("#ThemDiaChi").val(),
            SoDT: $("#ThemSoDT").val(),
            SoCMND: $("#ThemSoCMND").val()
        };

        console.log("Tên nhân viên: " + NhanVien.TenNV);
        console.log("Giới tinh: " + NhanVien.GioiTinh);
        console.log("Ngày sinh: " + NhanVien.NgaySinh);
        console.log("Địa chỉ: " + NhanVien.DiaChi);
        console.log("Số điện thoại: " + NhanVien.SoDT);
        console.log("Số CMND: " + NhanVien.SoCMND);

        $.post("/XacNhanThemNhanVien", NhanVien, function(result) {
            console.log("Kết quả là: " + result);
            if (result !== "-1") {
                console.log("Kết quả khác -1");

                /*
                var ThemMaLP = "<td><input type=\"number\" class=\"form-control\" id=\"" +
                    result + "_MaLP\" disabled value=\"" + result + "" + "\"></td>";

                var ThemTenLP = "<td><input type=\"text\" class=\"form-control\" id=\"" +
                    result + "_TenLP\" disabled value=\"" + LoaiPhong.TenLoaiPhong + "" + "\"></td>";

                var ThemMoTa = "<td><input type=\"text\" class=\"form-control\" id=\"" +
                    result + "_MoTa\" disabled value=\"" + LoaiPhong.MoTa + "\"></td>";

                var ThemButton = "<td>" +
                    "<button type=\"button\" class=\"btn btn-danger btn-sm\" id=\"" +
                    result + "_Xoa\">Xóa</button> " +
                    "<button type=\"button\" class=\"btn btn-warning btn-sm\" id=\"" +
                    result + "_Sua\">Sửa</button>" +
                    "</td>";

                var ThemLP = "<tr id=\"" +
                    result + "_LP\">" + ThemMaLP + ThemTenLP + ThemMoTa + ThemLoaiGg + ThemButton + "</tr>";

                console.log(ThemLP);

                $("#BangLP").append(ThemLP);
                */

            } else {
                alert("Có lỗi xảy ra");
            }
        });
    };

    $(document).on("click", "button", function() {
        var LoaiButton = this.id;

        console.log("Loại button là: " + LoaiButton);

        XacNhanThemNhanVien();
    });

});