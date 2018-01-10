<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<br />
<table class="table table-bordered">
    <thead>
    <tr>
        <th style="width: 8%">Serial  </th>
        <th style="width: 10%">Tình Trạng </th>
        <th style="width: 19%">Mã Phòng </th>
        <th style="width: 8%"> Mã Đơn Nhập Hàng </th>
        <th style="width: 24%">Mã Thiết Bị </th>
    </tr>
    </thead>
    <tbody id="BangThietBi">
    <c:forEach items="${DSCTTB}" var="ctthietbi">
        <c:set var="Serial" value="${ctthietbi.getSerial()}" />
        <c:set var="TinhTrang" value="${ctthietbi.getTinhTrang()}" />
        <c:set var="MaPhong" value="${ctthietbi.getPhong().getSoPhong()}" />
        <c:set var="MaDNH" value="${ctthietbi.getMaDNH()}" />
        <c:set var="MaThietBi" value="${ctthietbi.getThietBi().getMaThietBi()}" />


        <tr id="<c:out value="${Serial}_CTTB" />">

            <td width="15%"><input type="text" class="form-control" id="<c:out value="${Serial}" />_Serial"
                       value="<c:out value="${Serial}" />" disabled></td>

            <td width="18%">
                <select class="form-control" id="<c:out value="${Serial}" />_TinhTrang"  disabled>
                    <c:if test="${TinhTrang == 'KhongSuDung'}">
                        <option>KhongSuDung</option>
                        <option>DangSuDung</option>
                        <option>HuHong</option>
                        <option>DangSuaChua</option>
                    </c:if>
                    <c:if test="${TinhTrang == 'DangSuDung'}">
                        <option>DangSuDung</option>
                        <option>KhongSuDung</option>
                        <option>HuHong</option>
                        <option>DangSuaChua</option>
                    </c:if>
                    <c:if test="${TinhTrang == 'HuHong'}">
                        <option>HuHong</option>
                        <option>KhongSuDung</option>
                        <option>DangSuDung</option>
                        <option>DangSuaChua</option>
                    </c:if>
                    <c:if test="${TinhTrang == 'DangSuaChua'}">
                        <option>DangSuaChua</option>
                        <option>KhongSuDung</option>
                        <option>DangSuDung</option>
                        <option>HuHong</option>
                    </c:if>
                </select>
            </td>
            <td><input type="text" class="form-control" id="<c:out value="${Serial}" />_MaPhong"
                       value="<c:out value="${MaPhong}" />" disabled></td>
            <td width="18%"><input type="text" class="form-control" id="<c:out value="${Serial}" />_MaDNH"
                       value="<c:out value="${MaDNH}" />" disabled></td>
            <td width="10%"><input type="text" class="form-control" id="<c:out value="${Serial}" />_MaThietBi"
                       value="<c:out value="${MaThietBi}" />" disabled></td>
            <td>
                <button class="btn btn-danger btn-sm" id="<c:out value="${Serial}" />_Xoa">Xóa</button>
                <button class="btn btn-warning btn-sm" id="<c:out value="${Serial}" />_Sua">Sửa</button>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>
