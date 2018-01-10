$(function(){
    function Them(){
        var ThemSoP = "<td><input type=\"number\" class=\"form-control\" id=\"ThemSoP\"></td>";
        var ThemGiaHT = "<td><input type=\"number\" class=\"form-control\" id=\"ThemGiaHT\"></td>";
        var ThemViTri = "<td><input type=\"text\" class=\"form-control\" id=\"ThemViTri\"></td>";
        var ThemMoTa = "<td><input type=\"text\" class=\"form-control\" id=\"ThemMoTa\"></td>";
        var ThemTang = "<td><input type=\"number\" class=\"form-control\" id=\"ThemTang\"></td>";
        var ThemSoLgGg = "<td><input type=\"number\" class=\"form-control\" id=\"ThemSoLgGg\"></td>";
        var ThemLoaiP ="<td>" +
            "<select class=\"form-control\" id=\"ThemLoaiP\">";

        for (var i = 0; i < dsloaiphong.length; i++) {
            ThemLoaiP = ThemLoaiP + "<option id=\"" + dsloaiphong[i].MaLoaiPhong + "_option\">" +
                dsloaiphong[i].TenLoaiPhong + "</option>"
        }

        ThemLoaiP = ThemLoaiP + "</select>" + "</td>";

        var ThemButton = "<td>" +
            "<button type=\"button\" class=\"btn btn-success btn-sm\" id=\"Them_Luu\">Lưu</button> " +
            "<button type=\"button\" class=\"btn btn-danger btn-sm\" id=\"Them_Huy\">Hủy</button>" +
            "</td>";

        var ThemP = "<tr id=\"ThemP\">" + ThemSoP + ThemGiaHT + ThemViTri + ThemMoTa + ThemTang +
            ThemSoLgGg + ThemLoaiP + ThemButton + "</tr>";

        $("#BangP").append(ThemP);

        $("#Them").attr("disabled", true);
    };

    function Them_Huy() {
        $("#ThemP").remove();
        $("#Them").attr("disabled", false);
    };

    function XacNhanLuu() {
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
                $("#Them").attr("disabled", false);

                $("#ThemP td input").attr("disabled", true);
                $("#ThemP td select").attr("disabled", true);

                $("#ThemP td:last-child button:first-child")
                    .removeClass("btn-success")
                    .addClass("btn-danger")
                    .text("Xóa")
                    .attr("id", Phong.SoPhong + "_Xoa");

                $("#ThemLP td:last-child button:last-child")
                    .removeClass("btn-danger")
                    .addClass("btn-warning")
                    .text("Sửa")
                    .attr("id", Phong.SoPhong + "_Sua");

                $("#ThemP td:nth-child(1) input").attr("id", Phong.SoPhong + "_SoP");
                $("#ThemP td:nth-child(2) input").attr("id", Phong.SoPhong + "_GiaHT");
                $("#ThemP td:nth-child(3) input").attr("id", Phong.SoPhong + "_ViTri");
                $("#ThemP td:nth-child(4) input").attr("id", Phong.SoPhong + "_MoTa");
                $("#ThemP td:nth-child(5) input").attr("id", Phong.SoPhong + "_Tang");
                $("#ThemP td:nth-child(6) input").attr("id", Phong.SoPhong + "_SoLgGg");
                $("#ThemP td:nth-child(7) select").attr("id", Phong.SoPhong + "_LoaiP");

                $("#ThemP").attr("id", Phong.SoPhong + "_P");
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

    $(document).on("click", "button", function() {
        var LoaiButton = this.id;

        console.log("Loại button là: " + LoaiButton);

        if (LoaiButton == "Them") {
            Them();
        } else {
            if (LoaiButton.indexOf("_Xoa") !== -1) {
                if (confirm("Xác nhận xóa loại phòng") == true) {
                    Xoa(LoaiButton.substr(0, LoaiButton.indexOf('_')));
                }
            } else {
                if (LoaiButton.indexOf("_Sua") !== -1) {
                    Sua(LoaiButton.substr(0, LoaiButton.indexOf('_')));
                } else {
                    if (LoaiButton == "Them_Huy") {
                        Them_Huy();
                    } else {
                        if (LoaiButton == "Them_Luu") {
                            if (confirm("Xác nhận thêm loại phòng") == true) {
                                XacNhanLuu();
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
            }
        }
    });
});