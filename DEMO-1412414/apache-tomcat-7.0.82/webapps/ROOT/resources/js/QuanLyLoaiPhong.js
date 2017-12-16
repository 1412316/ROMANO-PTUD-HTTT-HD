$(function(){
    function Them(){
        var ThemTenLP = "<td><input type=\"text\" class=\"form-control\" id=\"ThemTenLP\"></td>";
        var ThemMoTa = "<td><input type=\"text\" class=\"form-control\" id=\"ThemMoTa\"></td>";
        var ThemLoaiGg ="<td>" +
            "<select class=\"form-control\" id=\"ThemLoaiGg\">" +
            "<option>Giường đơn</option>" +
            "<option>Giường đôi</option>" +
            "</select>" +
            "</td>";
        var ThemButton = "<td>" +
            "<button type=\"button\" class=\"btn btn-success btn-sm\" id=\"Them_Luu\">Lưu</button> " +
            "<button type=\"button\" class=\"btn btn-danger btn-sm\" id=\"Them_Huy\">Hủy</button>" +
            "</td>";

        var ThemLP = "<tr id=\"ThemLP\">" + "<td></td>" + ThemTenLP + ThemMoTa + ThemLoaiGg + ThemButton + "</tr>";

        $("#BangLP").append(ThemLP);

        $("#Them").attr("disabled", true);
    };

    function Them_Huy() {
        $("#ThemLP").remove();
        $("#Them").attr("disabled", false);
    };

    function XacNhanLuu() {
        var LoaiPhong = {
            TenLoaiPhong: $("#ThemTenLP").val(),
            MoTa: $("#ThemMoTa").val(),
            LoaiGiuong: $("#ThemLoaiGg").find(":selected").text()
        };

        console.log("Tên loại phòng: " + LoaiPhong.TenLoaiPhong);
        console.log("Mô tả: " + LoaiPhong.MoTa);
        console.log("Loại giường: " + LoaiPhong.LoaiGiuong);

        $.post("/ThemLoaiPhong", LoaiPhong, function(result) {
            if (result != "-1") {
                $("#Them").attr("disabled", false);

                var ThemInputID = "<input type=\"text\" class=\"form-control\" id=\"" +
                    result + "_MaLP" + "\" value=\"" + result + "\">";
                $("#ThemLP td:first-child").append(ThemInputID);

                $("#ThemLP td input").attr("disabled", true);
                $("#ThemLP td select").attr("disabled", true);

                $("#ThemLP td:last-child button:first-child")
                    .removeClass("btn-success")
                    .addClass("btn-danger")
                    .text("Xóa")
                    .attr("id", result + "_Xoa");

                $("#ThemLP td:last-child button:last-child")
                    .removeClass("btn-danger")
                    .addClass("btn-warning")
                    .text("Sửa")
                    .attr("id", result + "_Sua");

                $("#ThemLP td:nth-child(2) input").attr("id", result + "_TenLP");
                $("#ThemLP td:nth-child(3) input").attr("id", result + "_MoTa");
                $("#ThemLP td:nth-child(4) select").attr("id", result + "_LoaiGg");

                $("#ThemLP").attr("id", result + "_LP");
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
