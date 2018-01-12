$(function(){
    function Xoa(MaNV) {
        console.log("Mã nhân viên: " + MaNV);
        NhanVien = {
            "MaNV": MaNV
        };

        $.post("/XoaNhanVien", NhanVien, function(result) {
            if (result != "-1") {
                $("#" + MaNV + "_NV").remove();
            } else {
                alert("Có lỗi xảy ra");
            }
        });
    };

    function XacNhanThemThemNhanVien() {
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

        $.post("/ThemNhanVien", NhanVien, function(result) {
            console.log("Kết quả là: " + result);
            if (result !== "Error") {
                console.log("Kết quả khác Error");

                var ThemMaNV = "<td><input type=\"text\" class=\"form-control\" id=\"" +
                    result + "_MaNV\" disabled value=\"" + result + "" + "\"></td>";

                var ThemTenNV = "<td><input type=\"text\" class=\"form-control\" id=\"" +
                    result + "_TenLP\" disabled value=\"" + NhanVien.TenNV + "" + "\"></td>";

                var ThemGioiTinh = "<td><input type=\"text\" class=\"form-control\" id=\"" +
                    result + "_GioiTinh\" disabled value=\"" + NhanVien.GioiTinh + "\"></td>";

                var ThemTag = "<td>" +
                    "<a href=\"/XemChiTiet/" + result + "\">Xem chi tiết</a>" +
                    "</td>";

                var ThemButton = "<td>" +
                    "<button type=\"button\" class=\"btn btn-danger btn-sm\" id=\"" +
                    result + "_Xoa\">Xóa</button> " +
                    "</td>";

                var ThemNV = "<tr id=\"" +
                    result + "_NV\">" + ThemMaNV + ThemTenNV + ThemGioiTinh + ThemTag + ThemButton + "</tr>";

                console.log(ThemNV);

                $("#BangNV").append(ThemNV);

                $("#Modal_Dong").click();
            } else {
                alert("Có lỗi xảy ra");
            }
        });
    };

    $(document).on("click", "button", function() {
        var LoaiButton = this.id;

        console.log("Loại button là: " + LoaiButton);

        if (LoaiButton.indexOf("_Xoa") !== -1) {
            if (confirm("Xác nhận xóa nhân viên") == true) {
                Xoa(LoaiButton.substr(0, LoaiButton.indexOf('_')));
            }
        }
        else {
            if (LoaiButton == "Them_Luu") {
                if (confirm("Xác nhận thêm nhân viên") == true) {
                    XacNhanThemThemNhanVien();
                }
            }
        }
    });

});