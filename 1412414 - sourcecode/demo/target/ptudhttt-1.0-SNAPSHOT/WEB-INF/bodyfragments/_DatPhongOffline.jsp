<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
    var dsloaiphong = [];

    <c:forEach items="${DSLP}" var="LoaiPhong">
    dsloaiphong.push({MaLoaiPhong: ${LoaiPhong.getMaLoaiPhong()},
        TenLoaiPhong: "${LoaiPhong.getTenLoaiPhong()}"
    });
    </c:forEach>
</script>
<br />
<div class="container">
    <form id="DatPhong">
        <div class="row">
            <div class="col-lg-8">
                <div class="card">
                    <div class="card-header bg-info text-white">Thông tin khách hàng</div>
                    <div class="card-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="form-group form-group-sm">
                                    <label for="HoTen">Họ tên khách hàng:</label>
                                    <input type="text" class="form-control" id="HoTen">
                                    <label for="CMND">Chứng minh nhân dân:</label>
                                    <input type="number" class="form-control" id="CMND">
                                    <label for="SDT">Số điện thoại:</label>
                                    <input type="number" class="form-control" id="SDT">
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="form-group form-group-sm">
                                    <label for="LoaiKH">Loại khách hàng:</label>
                                    <select class="form-control" id="LoaiKH">
                                        <option value="2">Công ty</option>
                                        <option value="1">Cá nhân</option>
                                    </select>
                                    <label for="NgaySinh">Ngày sinh:</label>
                                    <input type="date" class="form-control" id="NgaySinh">
                                    <label>Giới tính: </label>
                                    <label class="radio-inline"><input type="radio" name="GioiTinh" value="Nam">Nam</label>
                                    <label class="radio-inline"><input type="radio" name="GioiTinh" value="Nữ">Nữ</label>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group form-group-sm">
                                    <label for="DiaChi">Địa chỉ:</label>
                                    <input type="text" class="form-control" id="DiaChi">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="card">
                    <div class="card-header bg-info text-white">Thông tin đặt phòng</div>
                    <div class="card-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group form-group-sm">
                                    <label for="SoNguoi">Số người:</label>
                                    <input type="number" class="form-control" id="SoNguoi">
                                    <label for="ThoiGianNhanPhong">Thời gian nhận phòng:</label>
                                    <input type="date" class="form-control" id="ThoiGianNhanPhong">
                                    <label for="ThoiGianTraPhong">Thời gian trả phòng:</label>
                                    <input type="date" class="form-control" id="ThoiGianTraPhong">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <br />
        <div class="row">
            <div class="col-lg-12">
                <button type="button" class="btn btn-success" data-toggle="modal"
                        data-target="#Modal_Them_Yeu_Cau_Phong" id="Mo_Modal_Them_Yeu_Cau_Phong">Thêm yêu cầu về phòng</button>
            </div>
        </div>
        <br />
        <div class="modal fade" id="Modal_Them_Yeu_Cau_Phong">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Thêm yêu cầu về phòng</h4>
                    </div>
                    <div class="modal-body">
                        <div id="CacYeuCau">
                        </div>
                        <button type="button" class="btn btn-success" id="ThemYCPhong">Thêm</button>
                        <button type="button" class="btn btn-secondary" data-toggle="modal"
                                data-target="#Modal_Tim_Phong" id="TimPhong">Tìm phòng</button>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" id="Dong_Modal_Them_Yeu_Cau_Phong"
                                data-dismiss="modal">Đóng</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="Modal_Tim_Phong">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Thông tin các phòng</h4>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-lg-12" id="CacPhong">
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary"
                                data-dismiss="modal" id="Dong_Modal_Tim_Phong">Đóng</button>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
<br />