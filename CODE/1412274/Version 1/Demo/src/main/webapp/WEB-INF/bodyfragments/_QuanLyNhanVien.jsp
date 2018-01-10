<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<br />

<a href="/ThemNhanVien" class="btn btn-primary" role="button">Thêm nhân viên</a>

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
            <td><input type="text" class="form-control" id="<c:out value="${MaNV}" />_maNV"
                       value="<c:out value="${MaNV}" />" disabled></td>
            <td><input type="text" class="form-control" id="<c:out value="${MaNV}" />_tenNV"
                       value="<c:out value="${TenNV}" />" disabled></td>
            <td><input type="text" class="form-control" id="<c:out value="${MaNV}" />_gioiTinh"
                       value="<c:out value="${GioiTinh}" />" disabled></td>
            <td>
                <a href="/XemChiTiet/${MaNV}" >Xem chi tiết </a>
            </td>
            <td>
                <button class="btn btn-danger btn-sm" id="<c:out value="${MaNV}" />_Xoa">Xóa</button>
            </td>
        </tr>

    </c:forEach>
    </tbody>
</table>
