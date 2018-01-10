<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<br />
<button class="btn btn-success" style="margin-bottom: 15px;" id="Them">Thêm</button>
<table class="table table-bordered">
    <thead>
    <tr>
        <th>Mã loại phòng</th>
        <th>Tên loại phòng</th>
        <th>Mô tả</th>
        <th>Loại giường</th>
        <th>Chức năng</th>
    </tr>
    </thead>
    <tbody id="BangLP">
    <c:forEach items="${DSLP}" var="LoaiPhong">
        <c:set var="MaLP" value="${LoaiPhong.getMaLoaiPhong()}" />
        <c:set var="TenLP" value="${LoaiPhong.getTenLoaiPhong()}" />
        <c:set var="MoTa" value="${LoaiPhong.getMoTa()}" />
        <c:set var="LoaiGg" value="${LoaiPhong.getLoaiGiuong()}" />

        <tr id="<c:out value="${MaLP}_LP" />">
            <td><input type="number" class="form-control" id="<c:out value="${MaLP}" />_MaLP"
                       value="<c:out value="${MaLP}" />" disabled></td>
            <td><input type="text" class="form-control" id="<c:out value="${MaLP}" />_TenLP"
                       value="<c:out value="${TenLP}" />" disabled></td>
            <td><input type="text" class="form-control" id="<c:out value="${MaLP}" />_MoTa"
                       value="<c:out value="${MoTa}" />" disabled></td>
            <td>
                <c:if test="${LoaiPhong.getLoaiGiuong().contains('Giường đôi')}">
                    <select class="form-control" id="<c:out value="${MaLP}" />_LoaiGg" disabled>
                        <option><c:out value="${LoaiGg}" /></option>
                        <option>Giường đơn</option>
                    </select>
                </c:if>
                <c:if test="${LoaiPhong.getLoaiGiuong().contains('Giường đơn')}">
                    <select class="form-control" id="<c:out value="${MaLP}" />_LoaiGg" disabled>
                        <option><c:out value="${LoaiGg}" /></option>
                        <option>Giường đôi</option>
                    </select>
                </c:if>
            </td>
            <td>
                <button class="btn btn-danger btn-sm" id="<c:out value="${MaLP}" />_Xoa">Xóa</button>
                <button class="btn btn-warning btn-sm" id="<c:out value="${MaLP}" />_Sua">Sửa</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
