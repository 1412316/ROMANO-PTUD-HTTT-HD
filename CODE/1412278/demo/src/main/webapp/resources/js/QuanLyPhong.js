$(function(){
    function XacNhanThemPhong() {
        var id_option = $("#ThemLoaiP").children(":selected").attr("id");

        var Phong = {
            SoPhong: $("#ThemSoP").val(),
            GiaHienTai: $("#ThemGiaHT").val(),
            ViTri: $("#ThemViTri").val(),
            MoTa: $("#ThemMoTa").val(),
            Tang: $("#ThemTang").val(),
            SoLuongGiuong: $("#ThemSoLgGg").val(),
            LoaiPhong: id_option.substr(0, id_option.indexOf('_'))
        };

        $.post("/ThemPhong", Phong, function(result) {
            if (result != "-1") {
                var ThemSoP = "<td>" +
                    "<input type=\"number\" class=\"form-control\" id=\"" +
                    Phong.SoPhong + "_SoP\" value=\"" +
                    Phong.SoPhong + "\" disabled>" +
                    "</td>";

                var ThemGiaHT = "<td>" +
                    "<input type=\"number\" class=\"form-control\" id=\"" +
                    Phong.SoPhong + "_GiaHT\" value=\"" +
                    Phong.GiaHienTai + "\" disabled>" +
                    "</td>";

                var ThemViTri = "<td>" +
                    "<input type=\"text\" class=\"form-control\" id=\"" +
                    Phong.SoPhong + "_ViTri\" value=\"" +
                    Phong.ViTri + "\" disabled>" +
                    "</td>";

                var ThemMoTa = "<td>" +
                    "<input type=\"text\" class=\"form-control\" id=\"" +
                    Phong.SoPhong + "_MoTa\" value=\"" +
                    Phong.MoTa + "\" disabled>" +
                    "</td>";

                var ThemTang = "<td>" +
                    "<input type=\"number\" class=\"form-control\" id=\"" +
                    Phong.SoPhong + "_Tang\" value=\"" +
                    Phong.Tang + "\" disabled>" +
                    "</td>";

                var ThemSoLgGg = "<td>" +
                    "<input type=\"number\" class=\"form-control\" id=\"" +
                    Phong.SoPhong + "_SoLgGg\" value=\"" +
                    Phong.SoLuongGiuong + "\" disabled>" +
                    "</td>";

                var ThemLoaiP ="<td>" +
                    "<select class=\"form-control\" id=\"" +
                    Phong.SoPhong + "_LoaiP\" disabled>";

                for (var i = 0; i < dsloaiphong.length; i++) {
                    if (dsloaiphong[i].MaLoaiPhong == Phong.LoaiPhong) {
                        ThemLoaiP = ThemLoaiP + "<option id=\"" + dsloaiphong[i].MaLoaiPhong + "_option\">" +
                            dsloaiphong[i].TenLoaiPhong + "</option>"
                    }
                }

                for (var i = 0; i < dsloaiphong.length; i++) {
                    if (dsloaiphong[i].MaLoaiPhong != Phong.LoaiPhong) {
                        ThemLoaiP = ThemLoaiP + "<option id=\"" + dsloaiphong[i].MaLoaiPhong + "_option\">" +
                            dsloaiphong[i].TenLoaiPhong + "</option>"
                    }
                }

                ThemLoaiP = ThemLoaiP + "</select>" + "</td>";

                var ThemButton = "<td>" +
                    "<button type=\"button\" class=\"btn btn-danger btn-sm\" id=\"" +
                    Phong.SoPhong + "_Xoa\">Xóa</button> " +
                    "<button type=\"button\" class=\"btn btn-warning btn-sm\" id=\"" +
                    Phong.SoPhong + "_Sua\">Sửa</button>" +
                    "</td>";

                var ThemP = "<tr id=\"" +
                    Phong.SoPhong + "_P\">" + ThemSoP + ThemGiaHT + ThemViTri + ThemMoTa + ThemTang +
                    ThemSoLgGg + ThemLoaiP + ThemButton + "</tr>";

                $("#BangP").append(ThemP);

                $("#Modal_Dong").click();
            } else {
                alert("Có lỗi xảy ra");
            }
        });
    };

    function Sua(SoPhong) {
        $("#" + SoPhong + "_P td input").attr("disabled", false);
        $("#" + SoPhong + "_P td select").attr("disabled", false);

        $("#" + SoPhong + "_P td:last-child button:first-child")
            .text("Hủy")
            .attr("id", SoPhong + "_Huy_Cap_Nhat");

        $("#" + SoPhong + "_P td:last-child button:last-child")
            .removeClass("btn-warning")
            .addClass("btn-success")
            .attr("id", SoPhong + "_Luu_Thay_Doi")
            .text("Lưu");
    };

    function HuyCapNhat(SoPhong) {
        $("#" + SoPhong + "_P td input").attr("disabled", true);
        $("#" + SoPhong + "_P td select").attr("disabled", true);

        $("#" + SoPhong + "_P td:last-child button:first-child")
            .text("Xóa")
            .attr("id", SoPhong + "_Xoa");

        $("#" + SoPhong + "_P td:last-child button:last-child")
            .removeClass("btn-success")
            .addClass("btn-warning")
            .attr("id", SoPhong + "_Sua")
            .text("Sửa");
    };

    function XacNhanCapNhatPhong(SoPhong) {
        var id_option = $("#" + SoPhong + "_LoaiP").children(":selected").attr("id");
        console.log("ID của loại phòng là: " + id_option);

        Phong = {
            SoPhong: SoPhong,
            GiaHienTai: $("#" + SoPhong + "_GiaHT").val(),
            ViTri:  $("#" + SoPhong + "_ViTri").val(),
            MoTa:  $("#" + SoPhong + "_MoTa").val(),
            Tang:  $("#" + SoPhong + "_Tang").val(),
            SoLuongGiuong:  $("#" + SoPhong + "_SoLgGg").val(),
            LoaiPhong: id_option.substr(0, id_option.indexOf('_'))
        };

        $.post("/CapNhatPhong", Phong, function(result) {
            if (result != "-1") {
                HuyCapNhat(SoPhong);
            } else {
                alert("Có lỗi xảy ra");
            }
        });
    };

    function Xoa(SoPhong) {
        Phong = {
            "SoPhong": SoPhong
        };

        $.post("/XoaPhong", Phong, function(result) {
            if (result != "-1") {
                $("#" + SoPhong + "_P").remove();
            } else {
                alert("Có lỗi xảy ra");
            }
        });
    };

    $(document).on("click", "button", function() {
        var LoaiButton = this.id;

        console.log("Loại button là: " + LoaiButton);

        if (LoaiButton.indexOf("_Xoa") !== -1) {
            if (confirm("Xác nhận xóa phòng") == true) {
                Xoa(LoaiButton.substr(0, LoaiButton.indexOf('_')));
            }
        } else {
            if (LoaiButton.indexOf("_Sua") !== -1) {
                Sua(LoaiButton.substr(0, LoaiButton.indexOf('_')));
            } else {
                if (LoaiButton == "Them_Luu") {
                    if (confirm("Xác nhận thêm phòng") == true) {
                        XacNhanThemPhong();
                    }
                } else {
                    if (LoaiButton.indexOf("_Luu_Thay_Doi") !== -1) {
                        if (confirm("Xác nhận lưu thay đổi") == true) {
                            XacNhanCapNhatPhong(LoaiButton.substr(0, LoaiButton.indexOf('_')));
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