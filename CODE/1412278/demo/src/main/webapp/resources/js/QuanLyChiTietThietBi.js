$(function(){
    /* chi don thuan sua lai cai button khi nhan sua, chua post data len controller */
    function Sua(Serial) {
        $("#" + Serial + "_CTTB td input").attr("disabled", false);
        $("#" + Serial + "_CTTB td select").attr("disabled", false);
        $("#" + Serial + "_Serial").attr("disabled", true);
        $("#" + Serial + "_MaThietBi").attr("disabled", true);
        /* td:last-child button:first-child : button dautien trong dong table data dang xet,capnhat lai ten button, id */
        $("#" + Serial + "_CTTB td:last-child button:first-child")
            .text("Hủy")
            .attr("id", Serial + "_Huy_Cap_Nhat");
        /* td:last-child button:last-child : button phia sau  trong dong table data dang xet, capnhat lai ten button, id */
        $("#" + Serial + "_CTTB td:last-child button:last-child")
            .removeClass("btn-warning")
            .addClass("btn-success")
            .attr("id", Serial + "_Luu_Thay_Doi")
            .text("Lưu");
    };

    /* Sua lai cai button tro ve ban dau */
    function HuyCapNhat(Serial) {
        $("#" + Serial + "_CTTB td input").attr("disabled", true);
        $("#" + Serial + "_CTTB td select").attr("disabled", true);

        $("#" + Serial + "_CTTB td:last-child button:first-child")
            .text("Xóa")
            .attr("id", Serial + "_Xoa");

        $("#" + Serial + "_CTTB td:last-child button:last-child")
            .removeClass("btn-success")
            .addClass("btn-warning")
            .attr("id", Serial + "_Sua")
            .text("Sửa");
    };

    function XacNhanCapNhat(Serial) {
        ChiTietThietBi = {
            Serial: Serial,
            TinhTrang: $("#" + Serial + "_TinhTrang").find(":selected").text(),
            MaPhong:  $("#" + Serial + "_MaPhong").val(),
            MaDNH:  $("#" + Serial + "_MaDNH").val(),
            MaThietBi: $("#" + Serial + "_MaThietBi").val()
        };

        $.post("/QuanLyChiTietThietBi/CapNhatChiTietThietBi", ChiTietThietBi, function(result) {
            if (result != "-1") {
                HuyCapNhat(Serial);
            } else {
                alert("Có lỗi xảy ra");
            }
        });
    };

    function Xoa(Serial) {
        cttb = {
            "Serial": Serial
        };

        $.post("/QuanLyChiTietThietBi/XoaChiTietThietBi", cttb, function(result) {
            if (result != "-1") {
                $("#" + Serial + "_CTTB").remove();
            } else {
                alert("Có lỗi xảy ra");
            }
        });
    };

    $(document).on("click", "button", function() {
        var LoaiButton = this.id;

        console.log("Loại button là: " + LoaiButton);

        if (LoaiButton.indexOf("_Xoa") !== -1) {
            if (confirm("Xác nhận xoá chi tiết thiết bị ") == true) {
                Xoa(LoaiButton.substr(0, LoaiButton.indexOf('_')));
            }
        } else {
            if (LoaiButton.indexOf("_Sua") !== -1) {
                Sua(LoaiButton.substr(0, LoaiButton.indexOf('_')));
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
    });
});