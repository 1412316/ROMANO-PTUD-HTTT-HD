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
                        XacNhanThemLoaiPhong();
                }

            }
        }
    });

});