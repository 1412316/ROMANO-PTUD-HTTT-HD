<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<br />
<button class="btn btn-success" style="margin-bottom: 15px;" data-toggle="modal" data-target="#Modal_Them">Thêm</button>
<table class="table table-bordered">
    <thead>
    <tr>
        <th style="width: 10%">Mã loại phòng</th>
        <th style="width: 25%">Tên loại phòng</th>
        <th style="width: 40%">Mô tả</th>
        <th style="width: 15%">Loại giường</th>
        <th style="width: 10%">Chức năng</th>
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
<!-- The Modal -->
<div class="modal fade" id="Modal_Them">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">Thêm loại phòng</h4>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="ThemTenLP">Tên loại phòng:</label>
                        <input type="text" class="form-control" id="ThemTenLP">
                        <label for="ThemMoTa">Mô tả:</label>
                        <input type="text" class="form-control" id="ThemMoTa">
                        <label for="ThemLoaiGg">Loại giường:</label>
                        <select class="form-control" id="ThemLoaiGg">
                            <option>Giường đơn</option>
                            <option>Giường đôi</option>
                        </select>
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