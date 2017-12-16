$(function(){
    function XacNhanThemLoaiPhong() {
        var LoaiPhong = {
            TenLoaiPhong: $("#ThemTenLP").val(),
            MoTa: $("#ThemMoTa").val(),
            LoaiGiuong: $("#ThemLoaiGg").find(":selected").text()
        };

        console.log("Tên loại phòng: " + LoaiPhong.TenLoaiPhong);
        console.log("Mô tả: " + LoaiPhong.MoTa);
        console.log("Loại giường: " + LoaiPhong.LoaiGiuong);

        $.post("/ThemLoaiPhong", LoaiPhong, function(result) {
            console.log("Kết quả là: " + result);
            if (result != "-1") {
                console.log("Kết quả khác -1");

                var ThemMaLP = "<td><input type=\"number\" class=\"form-control\" id=\"" +
                    result + "_MaLP\" disabled value=\"" + result + "" + "\"></td>";

                var ThemTenLP = "<td><input type=\"text\" class=\"form-control\" id=\"" +
                    result + "_TenLP\" disabled value=\"" + LoaiPhong.TenLoaiPhong + "" + "\"></td>";

                var ThemMoTa = "<td><input type=\"text\" class=\"form-control\" id=\"" +
                    result + "_MoTa\" disabled value=\"" + LoaiPhong.MoTa + "\"></td>";

                var ThemLoaiGg ="<td>" +
                    "<select class=\"form-control\" id=\"" + result + "_LoaiGg\" disabled>";

                if (LoaiPhong.LoaiGiuong =="Giường đơn") {
                    ThemLoaiGg = ThemLoaiGg + "<option>Giường đơn</option>" +
                        "<option>Giường đôi</option>";
                }
                else {
                    ThemLoaiGg = ThemLoaiGg + "<option>Giường đôi</option>" +
                        "<option>Giường đơn</option>";
                }

                ThemLoaiGg = ThemLoaiGg + "</select>" + "</td>";

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

                $("#Modal_Dong").click();
            } else {
                alert("Có lỗi xảy ra");
            }
        });
    };

    function Xoa(MaLoaiPhong) {
        console.log("Mã loại phòng: " + MaLoaiPhong);
        LoaiPhong = {
            "MaLoaiPhong": MaLoaiPhong
        };

        $.post("/XoaLoaiPhong", LoaiPhong, function(result) {
            if (result != "-1") {
                $("#" + MaLoaiPhong + "_LP").remove();
            } else {
                alert("Có lỗi xảy ra");
            }
        });
    };

    function Sua(MaLoaiPhong) {
        $("#" + MaLoaiPhong + "_LP td input").attr("disabled", false);
        $("#" + MaLoaiPhong + "_LP td select").attr("disabled", false);

        $("#" + MaLoaiPhong + "_LP td:last-child button:first-child")
            .text("Hủy")
            .attr("id", MaLoaiPhong + "_Huy_Cap_Nhat");

        $("#" + MaLoaiPhong + "_LP td:last-child button:last-child")
            .removeClass("btn-warning")
            .addClass("btn-success")
            .attr("id", MaLoaiPhong + "_Luu_Thay_Doi")
            .text("Lưu");
    };

    function HuyCapNhat(MaLoaiPhong) {
        $("#" + MaLoaiPhong + "_LP td input").attr("disabled", true);
        $("#" + MaLoaiPhong + "_LP td select").attr("disabled", true);

        $("#" + MaLoaiPhong + "_LP td:last-child button:first-child")
            .text("Xóa")
            .attr("id", MaLoaiPhong + "_Xoa");

        $("#" + MaLoaiPhong + "_LP td:last-child button:last-child")
            .removeClass("btn-success")
            .addClass("btn-warning")
            .attr("id", MaLoaiPhong + "_Sua")
            .text("Sửa");
    };

    function XacNhanCapNhatLoaiPhong(MaLoaiPhong) {
        LoaiPhong = {
            "MaLoaiPhong": MaLoaiPhong,
            "TenLoaiPhong": $("#" + MaLoaiPhong + "_TenLP").val(),
            "MoTa": $("#" + MaLoaiPhong + "_MoTa").val(),
            "LoaiGiuong": $("#" + MaLoaiPhong + "_LoaiGg").find(":selected").text()
        };

        console.log("Loại phòng trong xác nhận cập nhật: ");
        console.log(LoaiPhong);

        $.post("/CapNhatLoaiPhong", LoaiPhong, function(result) {
            if (result != "-1") {
                HuyCapNhat(MaLoaiPhong);
            } else {
                alert("Có lỗi xảy ra");
            }
        });
    };

    $(document).on("click", "button", function() {
        var LoaiButton = this.id;

        console.log("Loại button là: " + LoaiButton);

        if (LoaiButton.indexOf("_Xoa") !== -1) {
            if (confirm("Xác nhận xóa loại phòng") == true) {
                Xoa(LoaiButton.substr(0, LoaiButton.indexOf('_')));
            }
        } else {
            if (LoaiButton.indexOf("_Sua") !== -1) {
                Sua(LoaiButton.substr(0, LoaiButton.indexOf('_')));
            } else {
                if (LoaiButton == "Them_Luu") {
                    if (confirm("Xác nhận thêm loại phòng") == true) {
                        XacNhanThemLoaiPhong();
                    }
                } else {
                    if (LoaiButton.indexOf("_Luu_Thay_Doi") !== -1) {
                        if (confirm("Xác nhận lưu thay đổi") == true) {
                            XacNhanCapNhatLoaiPhong(LoaiButton.substr(0, LoaiButton.indexOf('_')));
                        }
                    } else {
                        if (LoaiButton.indexOf("_Huy_Cap_Nhat") !== -1) {
                            HuyCapNhat(LoaiButton.substr(0, LoaiButton.indexOf('_')));
                        }
                    }
                }
            }
        }
    });
});
