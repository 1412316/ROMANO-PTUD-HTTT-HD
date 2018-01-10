$(function(){
    var SoLuongYeuCau = 0;
    var CacPhongDuocChon = [];

    function ThemYeuCauPhong() {
        SoLuongYeuCau = SoLuongYeuCau + 1;

        console.log("Số lượng yêu cầu: " + SoLuongYeuCau);
        console.log("DSLP: ");
        console.log(dsloaiphong);

        var YeuCauTang = "<label for=\"" + SoLuongYeuCau + "_YCTang\">Tầng:</label>" +
            "<input type=\"number\" class=\"form-control\" id=\"" + SoLuongYeuCau + "_YCTang\">";
        var YeuCauViTri = "<label for=\"" + SoLuongYeuCau + "_YCViTri\">Vị trí:</label>" +
            "<select class=\"form-control\" id=\"" + SoLuongYeuCau + "_YCViTri\">" +
            "<option>Ngắm núi</option>" +
            "<option>Ngắm biển</option>" +
            "<option>Ngắm thành phố</option>" +
            "<option>Bình thường</option>" +
            "</select>";
        var FormGroup1 = "<div class=\"form-group form-group-sm\">" + YeuCauViTri + YeuCauTang + "</div>";
        var Col1 = "<div class=\"col-lg-4\">" + FormGroup1 + "</div>";

        var YeuCauLoaiPhong = "<label for=\"" + SoLuongYeuCau + "_YCLP\">Loại phòng:</label>" +
            "<select class=\"form-control\" id=\"" + SoLuongYeuCau + "_YCLP\">";

        for (var i = 0; i < dsloaiphong.length; i++) {
            YeuCauLoaiPhong = YeuCauLoaiPhong + "<option id=\"" + dsloaiphong[i].MaLoaiPhong + "_LoaiPhong_option\">" +
                    dsloaiphong[i].TenLoaiPhong + "</option>"
        }

        YeuCauLoaiPhong = YeuCauLoaiPhong + "</select>";

        var YeuCauLoaiGiuong = "<label for=\"" + SoLuongYeuCau + "_YCLGg\">Loại giường:</label>" +
            "<select class=\"form-control\" id=\"" + SoLuongYeuCau + "_YCLGg\">" +
            "<option>Giường đơn</option>" +
            "<option>Giường đôi</option>" +
            "</select>";
        var YeuCauSoLuongGiuong = "<label>Số lượng giường: </label>" +
            "<label class=\"radio-inline\"><input type=\"radio\" name=\"SLGg\" value=\"1\">1</label>" +
            "<label class=\"radio-inline\"><input type=\"radio\" name=\"SLGg\" value=\"2\">2</label>" +
            "<label class=\"radio-inline\"><input type=\"radio\" name=\"SLGg\" value=\"3\">3</label>";
        var FormGroup2 = "<div class=\"form-group form-group-sm\">" + YeuCauLoaiPhong + YeuCauLoaiGiuong +
            YeuCauSoLuongGiuong + "</div>";
        var Col2 = "<div class=\"col-lg-4\">" + FormGroup2 + "</div>";

        var GiaNhoNhat = "<label for=\"" + SoLuongYeuCau + "_YCGiaNN\">Giá nhỏ nhất:</label>" +
            "<input type=\"number\" class=\"form-control\" id=\"" + SoLuongYeuCau + "_YCGiaNN\">";
        var GiaLonNhat = "<label for=\"" + SoLuongYeuCau + "_YCGiaLN\">Giá lớn nhất:</label>" +
            "<input type=\"number\" class=\"form-control\" id=\"" + SoLuongYeuCau + "_YCGiaLN\">";
        var FormGroup3 = "<div class=\"form-group form-group-sm\">" + GiaNhoNhat + GiaLonNhat + "</div>";
        var Col3 = "<div class=\"col-lg-4\">" + FormGroup3 + "</div>";

        var Form = "<form><div class='row'>" + Col1 + Col2 + Col3 + "</div></form>";

        var CardBody = "<div class=\"card-body\">" + Form + "</div>";

        var CardHeader = "<div class=\"card-header bg-info text-white\">Yêu cầu về phòng " + SoLuongYeuCau + "</div>";

        var YeuCau = "<div class='row'><div class='col-lg-12'>" +
            "<div class=\"card\">" + CardHeader + CardBody + "</div></div></div>" + "<br />";

        console.log(YeuCau);

        $("#CacYeuCau").append(YeuCau);
    }

    function TimPhong() {
        $("#Dong_Modal_Them_Yeu_Cau_Phong").click();
        $("#CacPhong").empty();

        var CacYeuCauVePhong = [];
        CacPhongDuocChon.splice(0, CacPhongDuocChon.length);

        for (var i = 1; i <= SoLuongYeuCau; i++) {
            var id_option_LoaiPhong = $("#" + i + "_YCLP").children(":selected").attr("id");

            var YeuCauVePhong = {
                ViTri: $("#" + i + "_YCViTri").find(":selected").text(),
                LoaiPhong: id_option_LoaiPhong.substr(0, id_option_LoaiPhong.indexOf('_')),
                GiaNhoNhat: $("#" + i + "_YCGiaNN").val(),
                GiaLonNhat: $("#" + i + "_YCGiaLN").val(),
                Tang: $("#" + i + "_YCTang").val(),
                LoaiGiuong: $("#" + i + "_YCLGg").find(":selected").text(),
                SoLuongGiuong: $("input[name=SLGg]:checked").val(),
                ThoiGianNhanPhong: $("#ThoiGianNhanPhong").val(),
                ThoiGianTraPhong: $("#ThoiGianTraPhong").val()
            };

            CacYeuCauVePhong.push(YeuCauVePhong);
        }

        console.log("Các yêu cầu về phòng: ");
        console.log(CacYeuCauVePhong);

        $.ajax({
            type: "POST",
            url: "/TimPhong",
            data: JSON.stringify({ CacYeuCauVePhong: CacYeuCauVePhong }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            success: function(ThongTinCacPhong) {
                console.log("Thông tin các phòng: ");
                console.log(ThongTinCacPhong);

                var CacPhong = "";

                var header1 = "<thead>" +
                    "<tr>" +
                    "<th>Số phòng</th>" +
                    "<th>Giá hiện tại</th>" +
                    "<th>Vị trí</th>" +
                    "<th>Mô tả phòng</th>" +
                    "<th>Tầng</th>" +
                    "</tr>" +
                    "</thead>";

                var header2 = "<thead>" +
                    "<tr>" +
                    "<th>Số lượng giường</th>" +
                    "<th>Tên loại phòng</th>" +
                    "<th>Mô tả loại phòng</th>" +
                    "<th>Loại giường</th>" +
                    "<th>Chọn</th>" +
                    "</tr>" +
                    "</thead>";

                for(var i = 0; i < ThongTinCacPhong.length; i++) {
                    var body1 = "<tbody>" +
                        "<tr>" +
                        "<td>" + ThongTinCacPhong[i].soPhong + "</td>" +
                        "<td id='" + ThongTinCacPhong[i].soPhong + "_YC_GiaHT'>" + ThongTinCacPhong[i].giaHienTai + "</td>" +
                        "<td>" + ThongTinCacPhong[i].viTri + "</td>" +
                        "<td>" + ThongTinCacPhong[i].moTa + "</td>" +
                        "<td>" + ThongTinCacPhong[i].tang + "</td>" +
                        "</tr>" +
                        "</tbody>";

                    var body2 = "<tbody>" +
                        "<tr>" +
                        "<td>" + ThongTinCacPhong[i].soLuongGiuong + "</td>" +
                        "<td>" + ThongTinCacPhong[i].loaiPhong.tenLoaiPhong + "</td>" +
                        "<td>" + ThongTinCacPhong[i].loaiPhong.moTa + "</td>" +
                        "<td>" + ThongTinCacPhong[i].loaiPhong.loaiGiuong + "</td>" +
                        "<td>" + "<button type=\"button\" class=\"btn btn-success\" id=\"" +
                        ThongTinCacPhong[i].soPhong + "_Chon_Phong\">Chọn</button></td>" +
                        "</tr>" +
                        "</tbody>";

                    var table = "<table class=\"table table-bordered\">" + header1 + body1 + header2 + body2 + "</table>";
                    CacPhong += table;
                }

                CacPhong = CacPhong + "<br />" +
                    "<button type=\"button\" class=\"btn btn-primary\" id=\"DatPhong\">Đặt phòng</button>";

                $("#CacPhong").append(CacPhong);
            }
        });
    }

    function ChonPhong(SoPhong) {


        CacPhongDuocChon.push({
            SoPhong: SoPhong,
            GiaHienTai: $("#" + SoPhong + "_YC_GiaHT").text()
        });

        console.log("Sau khi push: ");
        console.log(CacPhongDuocChon);

        $("#" + SoPhong + "_Chon_Phong").removeClass("btn-success")
            .addClass("btn-danger")
            .attr("id", SoPhong + "_Bo_Chon")
            .text("Bỏ chọn");
    }

    function BoChonPhong(SoPhong) {
        CacPhongDuocChon.splice(CacPhongDuocChon.findIndex(function(element) {
            return element.SoPhong == SoPhong && element.GiaHienTai == $("#" + SoPhong + "_YC_GiaHT").text();
        }), 1);

        console.log("Sau khi splice: ");
        console.log(CacPhongDuocChon);

        $("#" + SoPhong + "_Bo_Chon").removeClass("btn-danger")
            .addClass("btn-success")
            .attr("id", SoPhong + "_Chon_Phong")
            .text("Chọn");
    }

    function DatPhong() {
        if (CacPhongDuocChon.length != 0) {
            //var CacPhongDuocChonDuyNhat = [];
            //$.each(CacPhongDuocChon, function(i, element){
            //    if($.inArray(element, CacPhongDuocChonDuyNhat) === -1) CacPhongDuocChonDuyNhat.push(element);
            //});

            //console.log("Các phòng được chọn sau khi bỏ giá trị trùng: ");
            //console.log(CacPhongDuocChonDuyNhat);

            var ThongTinKhachHang = {
                HoTen: $("#HoTen").val(),
                GioiTinh: $("input[name=GioiTinh]:checked").val(),
                NgaySinh: $("#NgaySinh").val(),
                CMND: $("#CMND").val(),
                SDT: $("#SDT").val(),
                DiaChi: $("#DiaChi").val(),
                LoaiKH:$("#LoaiKH").find(":selected").val()
            };

            console.log("Thông tin khách hàng: ");
            console.log(ThongTinKhachHang);

            var ThongTinDatPhong = {
                SoNguoi: $("#SoNguoi").val(),
                ThoiGianNhanPhong: $("#ThoiGianNhanPhong").val(),
                ThoiGianTraPhong: $("#ThoiGianTraPhong").val(),
                SoLuongPhong: CacPhongDuocChon.length
            };

            console.log("Thông tin đặt phòng: ");
            console.log(ThongTinDatPhong);

            $.ajax({
                type: "POST",
                url: "/DatPhong",
                data: JSON.stringify({
                    CacPhongKHMuonDat: CacPhongDuocChon,
                    ThongTinDatPhong: ThongTinDatPhong,
                    ThongTinKhachHang: ThongTinKhachHang }),
                headers: {
                    'Accept': 'text/plain',
                    'Content-Type': 'application/json'
                },
                success: function(DatPhong_Message) {
                    console.log("Tin nhắn đặt phòng: ");
                    console.log(DatPhong_Message);

                    if (DatPhong_Message == "Successfully") {
                        alert("Đặt phòng thành công");

                        $("#DatPhong")[0].reset();
                        $("#Dong_Modal_Tim_Phong").click()
                        $("#CacPhong").empty();
                        $("#CacYeuCau").empty();
                        $("#Dong_Modal_Them_Yeu_Cau_Phong").click();
                    } else {
                        alert("Đặt phòng thất bại");
                    }
                }
            });
        } else {
            alert("Xin chọn phòng cần đặt");
        }
    }

    $(document).on("click", "button", function() {
        var LoaiButton = this.id;

        if (LoaiButton == "ThemYCPhong") {
            ThemYeuCauPhong();
        } else {
            if (LoaiButton == "DatPhong") {
                if (confirm("Xác nhận đặt phòng") == true) {
                    DatPhong();
                }
            } else {
                if (LoaiButton == "Dong_Modal_Tim_Phong") {
                    $("#Mo_Modal_Them_Yeu_Cau_Phong").click();
                } else {
                    if (LoaiButton == "TimPhong") {
                        TimPhong();
                    } else {
                        if (LoaiButton.indexOf("_Chon_Phong") !== -1) {
                            ChonPhong(LoaiButton.substr(0, LoaiButton.indexOf('_')));
                        } else {
                            if (LoaiButton.indexOf("_Bo_Chon") !== -1) {
                                BoChonPhong(LoaiButton.substr(0, LoaiButton.indexOf('_')));
                            }
                        }
                    }
                }
            }
        }
    });
});