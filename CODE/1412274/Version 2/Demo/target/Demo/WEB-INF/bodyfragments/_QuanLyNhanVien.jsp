<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<br />
<!-- <a href="/ThemNhanVien" class="btn btn-primary" role="button">Thêm nhân viên</a> -->

<button class="btn btn-success" style="margin-bottom: 15px;" data-toggle="modal" data-target="#Modal_Them">Thêm</button>
<br />
<h1 class="text-center">Danh Sách Nhân Viên</h1>
<table class="table table-bordered">
    <thead>
    <tr>
        <th>Mã nhân viên</th>
        <th>Tên nhân viên</th>
        <th>Giới tính</th>
        <th></th>
        <th>Chức năng</th>
    </tr>
    </thead>
    <tbody id="BangNV">
    <c:forEach items="${DSNV}" var="NhanVien">
        <c:set var="MaNV" value="${NhanVien.getMaNV()}" />
        <c:set var="TenNV" value="${NhanVien.getTenNV()}" />
        <c:set var="GioiTinh" value="${NhanVien.getGioiTinh()}" />

        <tr id="<c:out value="${MaNV}_NV" />">
            <td><input type="text" class="form-control" id="<c:out value="${MaNV}" />_MaNV"
                       value="<c:out value="${MaNV}" />" disabled></td>
            <td><input type="text" class="form-control" id="<c:out value="${MaNV}" />_TenNV"
                       value="<c:out value="${TenNV}" />" disabled></td>
            <td><input type="text" class="form-control" id="<c:out value="${MaNV}" />_GioiTinh"
                       value="<c:out value="${GioiTinh}" />" disabled></td>
            <td>
                <a href="/XemChiTiet/${MaNV}">Xem chi tiết </a>
            </td>
            <td>
                <button class="btn btn-danger btn-sm" id="<c:out value="${MaNV}" />_Xoa">Xóa</button>
            </td>
        </tr>

    </c:forEach>
    </tbody>
</table>

<!-- The Modal -->
<div class="modal fade" id="Modal_Them">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">Thêm nhân viên</h4>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="ThemTenNV">Tên Nhân viên:</label>
                        <input type="text" class="form-control" id="ThemTenNV">
                        <label for="ThemGioiTinh">Giới tính:</label>
                        <input type="text" class="form-control" id="ThemGioiTinh">
                        <label for="ThemNgaySinh">Ngày sinh: (Định dạng YYYY-MM-DD)</label>
                        <input type="text" class="form-control" id="ThemNgaySinh">
                        <label for="ThemDiaChi">Địa chỉ:</label>
                        <input type="text" class="form-control" id="ThemDiaChi">
                        <label for="ThemSoDT">Số điện thoại:</label>
                        <input type="text" class="form-control" id="ThemSoDT">
                        <label for="ThemSoCMND">Số CMND:</label>
                        <input type="text" class="form-control" id="ThemSoCMND">

                    </div>
                </form>
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-success btn-sm" id="Them_Luu">Lưu</button>
                <button type="button" class="btn btn-secondary btn-sm" data-dismiss="modal" id="Modal_Dong">Đóng</button>
            </div>

        </div>
    </div>
</div>
