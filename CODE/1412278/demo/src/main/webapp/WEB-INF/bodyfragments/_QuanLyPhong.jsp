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
<button class="btn btn-success" style="margin-bottom: 15px;" data-toggle="modal" data-target="#Modal_Them">Thêm</button>
<table class="table table-bordered">
    <thead>
    <tr>
        <th style="width: 8%">Số phòng</th>
        <th style="width: 10%">Giá hiện tại</th>
        <th style="width: 19%">Vị trí</th>
        <th style="width: 24%">Mô tả phòng</th>
        <th style="width: 8%">Tầng</th>
        <th style="width: 5%">Số lượng giường</th>
        <th style="width: 17%">Loại phòng</th>
        <th style="width: 90%">Chức năng</th>
    </tr>
    </thead>
    <tbody id="BangP">
    <c:forEach items="${DSP}" var="Phong">
        <c:set var="SoP" value="${Phong.getSoPhong()}" />
        <c:set var="GiaHT" value="${Phong.getGiaHienTai()}" />
        <c:set var="ViTri" value="${Phong.getViTri()}" />
        <c:set var="MoTa" value="${Phong.getMoTa()}" />
        <c:set var="Tang" value="${Phong.getTang()}" />
        <c:set var="SoLgGg" value="${Phong.getSoLuongGiuong()}" />
        <c:set var="LoaiP" value="${Phong.getLoaiPhong().getMaLoaiPhong()}" />

        <tr id="<c:out value="${SoP}_P" />">
            <td><input type="number" class="form-control" id="<c:out value="${SoP}" />_SoP"
                       value="<c:out value="${SoP}" />" disabled></td>
            <td><input type="number" class="form-control" id="<c:out value="${SoP}" />_GiaHT"
                       value="<c:out value="${GiaHT}" />" disabled></td>
            <td><input type="text" class="form-control" id="<c:out value="${SoP}" />_ViTri"
                       value="<c:out value="${ViTri}" />" disabled></td>
            <td><input type="text" class="form-control" id="<c:out value="${SoP}" />_MoTa"
                       value="<c:out value="${MoTa}" />" disabled></td>
            <td><input type="number" class="form-control" id="<c:out value="${SoP}" />_Tang"
                       value="<c:out value="${Tang}" />" disabled></td>
            <td><input type="number" class="form-control" id="<c:out value="${SoP}" />_SoLgGg"
                       value="<c:out value="${SoLgGg}" />" disabled></td>
            <td>
                <select class="form-control" id="<c:out value="${SoP}" />_LoaiP"  disabled>
                    <c:forEach items="${DSLP}" var="LoaiPhong">
                        <c:if test="${LoaiP == LoaiPhong.getMaLoaiPhong()}">
                            <option id="${LoaiPhong.getMaLoaiPhong()}_option">${LoaiPhong.getTenLoaiPhong()}</option>
                        </c:if>
                    </c:forEach>
                    <c:forEach items="${DSLP}" var="LoaiPhong">
                        <c:if test="${LoaiP != LoaiPhong.getMaLoaiPhong()}">
                            <option id="${LoaiPhong.getMaLoaiPhong()}_option">${LoaiPhong.getTenLoaiPhong()}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </td>
            <td>
                <button class="btn btn-danger btn-sm" id="<c:out value="${SoP}" />_Xoa">Xóa</button>
                <button class="btn btn-warning btn-sm" id="<c:out value="${SoP}" />_Sua">Sửa</button>
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
                <h4 class="modal-title">Thêm phòng</h4>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="ThemSoP">Số phòng:</label>
                        <input type="number" class="form-control" id="ThemSoP">
                        <label for="ThemGiaHT">Giá hiện tại:</label>
                        <input type="number" class="form-control" id="ThemGiaHT">
                        <label for="ThemViTri">Vị trí:</label>
                        <input type="text" class="form-control" id="ThemViTri">
                        <label for="ThemMoTa">Mô tả:</label>
                        <input type="text" class="form-control" id="ThemMoTa">
                        <label for="ThemTang">Tầng:</label>
                        <input type="number" class="form-control" id="ThemTang">
                        <label for="ThemSoLgGg">Số lượng giường:</label>
                        <input type="number" class="form-control" id="ThemSoLgGg">
                        <label for="ThemLoaiP">Loại phòng:</label>
                        <select class="form-control" id="ThemLoaiP">
                            <c:forEach items="${DSLP}" var="LoaiPhong">
                                <option id="${LoaiPhong.getMaLoaiPhong()}_option">
                                        ${LoaiPhong.getTenLoaiPhong()}
                                </option>
                            </c:forEach>
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