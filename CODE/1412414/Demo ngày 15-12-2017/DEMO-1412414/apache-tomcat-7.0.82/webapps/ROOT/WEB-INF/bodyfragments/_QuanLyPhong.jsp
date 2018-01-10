<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<br />
<button class="btn btn-success" style="margin-bottom: 15px;" id="Them">Thêm</button>
<script>
    dsloaiphong = [];

    <c:forEach items="${DSLP}" var="LoaiPhong">
        dsloaiphong.push({MaLoaiPhong: ${LoaiPhong.getMaLoaiPhong()},
            TenLoaiPhong: "${LoaiPhong.getTenLoaiPhong()}"
            });
    </c:forEach>
</script>

<table class="table table-bordered">
    <thead>
    <tr>
        <th>Số phòng</th>
        <th>Giá hiện tại</th>
        <th>Vị trí</th>
        <th>Mô tả phòng</th>
        <th>Tầng</th>
        <th>Số lượng giường</th>
        <th>Loại phòng</th>
        <th>Chức năng</th>
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
