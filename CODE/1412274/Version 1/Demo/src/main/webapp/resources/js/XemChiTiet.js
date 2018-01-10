$(function(){
    function Sua(MaNV) {
        $("#" + MaNV + "_NV td input").attr("disabled", false);
        $("#" + MaNV + "_NV td select").attr("disabled", false);

        $("#" + MaNV + "_NV td:last-child button:first-child")
            .text("Hủy")
            .attr("id", MaNV + "_Huy_Cap_Nhat");

        $("#" + MaNV + "_NV td:last-child button:last-child")
            .removeClass("btn-warning")
            .addClass("btn-success")
            .attr("id", MaNV + "_Luu_Thay_Doi")
            .text("Lưu");
    };

    function HuyCapNhat(MaNV) {
        $("#" + MaNV + "_NV td input").attr("disabled", true);
        $("#" + MaNV + "_NV td select").attr("disabled", true);

        $("#" + MaNV + "_NV td:last-child button:first-child")
            .text("Xóa")
            .attr("id", MaNV + "_Xoa");

        $("#" + MaNV + "_NV td:last-child button:last-child")
            .removeClass("btn-success")
            .addClass("btn-warning")
            .attr("id", MaNV + "_Sua")
            .text("Sửa");
    };

    function XacNhanCapNhatNhanVien(MaNV) {
        NhanVien = {
            "MaNV": MaNV,
            "TenNV": $("#" + MaNV + "_TenNV").val(),
            "GioiTinh": $("#" + MaNV + "_GioiTinh").val(),
            "NgaySinh": $("#" + MaNV + "_NgaySinh").val(),
            "DiaChi": $("#" + MaNV + "_DiaChi").val(),
            "SoDT": $("#" + MaNV + "_SoDT").val(),
            "SoCMND": $("#" + MaNV + "_SoCMND").val()
        };

        console.log("Nhân viên trong xác nhận cập nhật: ");
        console.log(NhanVien);

        $.post("/CapNhatNhanVien", NhanVien, function(result) {
            if (result !== "-1") {
                HuyCapNhat(MaNV);
            } else {
                alert("Có lỗi xảy ra");
            }
        });
    };

    $(document).on("click", "button", function() {
        var LoaiButton = this.id;

        console.log("Loại button là: " + LoaiButton);

            if (LoaiButton.indexOf("_Sua") !== -1) {
                Sua(LoaiButton.substr(0, LoaiButton.indexOf('_')));
            }
            else {
                    if (LoaiButton.indexOf("_Luu_Thay_Doi") !== -1) {
                        if (confirm("Xác nhận lưu thay đổi") === true) {
                            XacNhanCapNhatNhanVien(LoaiButton.substr(0, LoaiButton.indexOf('_')));
                        }
                    } else {
                        if (LoaiButton.indexOf("_Huy_Cap_Nhat") !== -1) {
                            HuyCapNhat(LoaiButton.substr(0, LoaiButton.indexOf('_')));
                        }
                    }

            }

    });
});