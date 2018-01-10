$(function(){
    function XacNhanThemThietBi() {

        var ThietBi = {
            TenThietBi: $("#ThemTenTB").val(),
            Gia: $("#ThemGia").val(),
            TenLoai: $("#ThemTenLoai").val(),
            SoLuong: 0
        };

        $.post("/QuanLyThietBi/Them", ThietBi, function(result) {
            console.log(result);

            if (result != "Error") {
                var ThemMaTB = "<td>" +
                    "<input type=\"text\" class=\"form-control\" id=\"" +
                    ThietBi.MaThietBi + "_MaThietBi\" value=\"" +
                    result + "\" disabled>" +
                    "</td>";

                var ThemTenTB = "<td>" +
                    "<input type=\"text\" class=\"form-control\" id=\"" +
                    ThietBi.MaThietBi + "_TenThietBi\" value=\"" +
                    ThietBi.TenThietBi + "\" disabled>" +
                    "</td>";

                var ThemGia = "<td>" +
                    "<input type=\"text\" class=\"form-control\" id=\"" +
                    ThietBi.MaThietBi + "_Gia\" value=\"" +
                    ThietBi.Gia + "\" disabled>" +
                    "</td>";

                var ThemTenLoai = "<td>" +
                    "<input type=\"text\" class=\"form-control\" id=\"" +
                    ThietBi.MaThietBi + "_TenLoai\" value=\"" +
                    ThietBi.TenLoai + "\" disabled>" +
                    "</td>";

                var ThemSL = "<td>" +
                    "<input type=\"number\" class=\"form-control\" id=\"" +
                    ThietBi.MaThietBi + "_SoLuong\" value=\"" +
                    ThietBi.SoLuong + "\" disabled>" +
                    "</td>";

                var ThemButton = "<td>" +
                    "<button type=\"button\" class=\"btn btn-danger btn-sm\" id=\"" +
                    ThietBi.MaThietBi  + "_Xoa\">Xóa</button> " +
                    "<a href=\"/QuanLyChiTietThietBi/" + ThietBi.MaThietBi+ "\" class=\"btn btn-info btn-sm\" role=\"button\">Xem chi tiết thiết bị</a>" +
                    "<button type=\"button\" class=\"btn btn-warning btn-sm\" id=\"" +
                    ThietBi.MaThietBi  + "_Sua\">Sửa</button>" +
                    "</td>";

                var ThemTB = "<tr id=\"" +
                    ThietBi.MaThietBi + "_P\">" + ThemMaTB + ThemTenTB + ThemGia + ThemTenLoai + ThemSL + ThemButton + "</tr>";

                $("#BangThietBi").append(ThemTB);

                $("#Modal_Dong").click();
            } else {
                alert("Có lỗi xảy ra");
            }
        });
    };
    /* chi don thuan sua lai cai button khi nhan sua, chua post data len controller */
    function Sua(MaThietBi) {
        $("#" + MaThietBi + "_P td input").attr("disabled", false);
        $("#" + MaThietBi + "_MaThietBi").attr("disabled", true);
        $("#" + MaThietBi + "_SoLuong").attr("disabled", true);
        /* td:last-child button:first-child : button dautien trong dong table data dang xet,capnhat lai ten button, id */
        $("#" + MaThietBi + "_P td:last-child button:first-child")
            .text("Hủy")
            .attr("id", MaThietBi + "_Huy_Cap_Nhat");
        /* td:last-child button:last-child : button phia sau  trong dong table data dang xet, capnhat lai ten button, id */
        $("#" + MaThietBi + "_P td:last-child button:last-child")
            .removeClass("btn-warning")
            .addClass("btn-success")
            .attr("id", MaThietBi + "_Luu_Thay_Doi")
            .text("Lưu");
    };

    /* Sua lai cai button tro ve ban dau */
    function HuyCapNhat(MaThietBi) {
        $("#" + MaThietBi + "_P td input").attr("disabled", true);
        $("#" + MaThietBi + "_P td select").attr("disabled", true);

        $("#" + MaThietBi + "_P td:last-child button:first-child")
            .text("Xóa")
            .attr("id", MaThietBi + "_Xoa");

        $("#" + MaThietBi + "_P td:last-child button:last-child")
            .removeClass("btn-success")
            .addClass("btn-warning")
            .attr("id", MaThietBi + "_Sua")
            .text("Sửa");
    };

    function XacNhanCapNhat(MaThietBi) {

        ThietBi = {
            MaTB: MaThietBi,
            TenThietBi: $("#" + MaThietBi + "_TenThietBi").val(),
            Gia:  $("#" + MaThietBi + "_Gia").val(),
            TenLoai:  $("#" + MaThietBi + "_TenLoai").val(),
            SoLuong: $("#" + MaThietBi + "_SoLuong").val()
        };

        $.post("/QuanLyThietBi/CapNhatThietBi", ThietBi, function(result) {
            if (result != "-1") {
                HuyCapNhat(MaThietBi);
            } else {
                alert("Có lỗi xảy ra");
            }
        });
    };

    function Xoa(MaThietBi) {
        thietbi = {
            "MaThietBi": MaThietBi
        };

        $.post("/QuanLyThietBi/XoaThietBi", thietbi, function(result) {
            if (result != "-1") {
                $("#" + MaThietBi + "_P").remove();
            } else {
                alert("Có lỗi xảy ra");
            }
        });
    };

    $(document).on("click", "button", function() {
        var LoaiButton = this.id;

        console.log("Loại button là: " + LoaiButton);

        if (LoaiButton.indexOf("_Xoa") !== -1) {
            if (confirm("Xác nhận xoá thiết ") == true) {
                Xoa(LoaiButton.substr(0, LoaiButton.indexOf('_')));
            }
        } else {
            if (LoaiButton.indexOf("_Sua") !== -1) {
                Sua(LoaiButton.substr(0, LoaiButton.indexOf('_')));
            } else {
                if (LoaiButton == "Them_Luu") {
                    if (confirm("Xác nhận thêm thiết ") == true) {
                        XacNhanThemThietBi();
                    }
                } else {
                    if (LoaiButton.indexOf("_Luu_Thay_Doi") !== -1) {
                        if (confirm("Xác nhận lưu thay đổi") == true) {
                            XacNhanCapNhat(LoaiButton.substr(0, LoaiButton.indexOf('_')));
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