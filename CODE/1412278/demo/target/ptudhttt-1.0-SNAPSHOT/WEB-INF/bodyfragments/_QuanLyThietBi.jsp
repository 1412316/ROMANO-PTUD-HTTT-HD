<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<br />
<button class="btn btn-success" style="margin-bottom: 15px;" data-toggle="modal" data-target="#Modal_Them">Thêm</button>
<table class="table table-bordered">
    <thead>
    <tr>
        <th style="width: 8%">Mã số thiết bị  </th>
        <th style="width: 10%">Tên thiết bị </th>
        <th style="width: 19%">Giá </th>
        <th style="width: 8%"> Tên Loại </th>
        <th style="width: 24%">Số Lượng </th>
        <th style="width: 24%"></th>
    </tr>
    </thead>
    <tbody id="BangThietBi">
    <c:forEach items="${DSTB}" var="thietbi">
        <c:set var="MaThietBi" value="${thietbi.getMaThietBi()}" />
        <c:set var="TenThietBi" value="${thietbi.getTenThietBi()}" />
        <c:set var="Gia" value="${thietbi.getGiaTien()}" />
        <c:set var="TenLoai" value="${thietbi.getTenLoai()}" />
        <c:set var="SoLuong" value="${thietbi.getSoluong()}" />


        <tr id="<c:out value="${MaThietBi}_P" />">

            <td width="10%"><input type="text" class="form-control" id="<c:out value="${MaThietBi}" />_MaThietBi"
                       value="<c:out value="${MaThietBi}" />" disabled></td>

            <td width="15%"><input type="text" class="form-control" id="<c:out value="${MaThietBi}" />_TenThietBi"
                       value="<c:out value="${TenThietBi}" />" disabled></td>
            <td width="5%"><input type="number" class="form-control" id="<c:out value="${MaThietBi}" />_Gia"
                       value="<c:out value="${Gia}" />" disabled></td>
            <td width="15%"><input type="text" class="form-control" id="<c:out value="${MaThietBi}" />_TenLoai"
                       value="<c:out value="${TenLoai}" />" disabled></td>
            <td width="5%"><input type="number" class="form-control" id="<c:out value="${MaThietBi}" />_SoLuong"
                       value="<c:out value="${SoLuong}" />" disabled></td>
            <td width="50%">
                <button class="btn btn-danger btn-sm" id="<c:out value="${MaThietBi}" />_Xoa">Xóa</button>
                <a href="/QuanLyChiTietThietBi/${MaThietBi}" class="btn btn-info btn-sm" role="button">Xem chi tiết thiết bị</a>
                <button class="btn btn-warning btn-sm" id="<c:out value="${MaThietBi}" />_Sua">Sửa</button>
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
                <h4 class="modal-title">Thêm thiết  bị </h4>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="ThemTenTB">Tên thiết bị:</label>
                        <input type="text" class="form-control" id="ThemTenTB">
                        <label for="ThemGia">Giá:</label>
                        <input type="number" class="form-control" id="ThemGia">
                        <label for="ThemTenLoai">Tên loại:</label>
                        <input type="text" class="form-control" id="ThemTenLoai">
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
