<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-6 col-lg-offset-6 toppad" >
            <div class="panel panel-info">
                <div class="panel-body">
                    <div class="row">
                        <div class=" col-md-9 col-lg-9 ">
                            <table class="table table-user-information">
                                <tbody>
                                <c:forEach items="${NV}" var="NhanVien">
                                <c:set var="MaNV" value="${NhanVien.getMaNV()}" />
                                <c:set var="TenNV" value="${NhanVien.getTenNV()}" />
                                <c:set var="GioiTinh" value="${NhanVien.getGioiTinh()}" />
                                <c:set var="NgaySinh" value="${NhanVien.getNgaySinh()}" />
                                <c:set var="DiaChi" value="${NhanVien.getDiaChi()}" />
                                <c:set var="SoDT" value="${NhanVien.getSoDT()}" />
                                <c:set var="SoCMND" value="${NhanVien.getSoCMND()}" />
                                <c:set var="Luong" value="${NhanVien.getLuong()}" />
                                <c:set var="MatKhau" value="${NhanVien.getMatKhau()}" />
                                <c:set var="NgayTao" value="${NhanVien.getNgayTao()}" />
                                <c:set var="NgayCapNhat" value="${NhanVien.getNgayCapNhat()}" />

                                <tr id="<c:out value="${MaNV}_NV" />">
                                    <td>Mã nhân viên</td>
                                    <td><input type="text" class="form-control" id="<c:out value="${MaNV}" />_MaNV"
                                               value="<c:out value="${MaNV}" />" disabled></td>
                                </tr>

                                <tr id="<c:out value="${MaNV}_NV" />">
                                    <td>Tên nhân viên</td>
                                    <td><input type="text" class="form-control" id="<c:out value="${MaNV}" />_TenNV"
                                               value="<c:out value="${TenNV}" />" disabled></td>
                                </tr>

                                <tr id="<c:out value="${MaNV}_NV" />">
                                    <td>Giới tính</td>
                                    <td><input type="text" class="form-control" id="<c:out value="${MaNV}" />_GioiTinh"
                                               value="<c:out value="${GioiTinh}" />" disabled></td>
                                </tr>

                                <tr id="<c:out value="${MaNV}_NV" />">
                                    <td>Ngày sinh</td>
                                    <td><input type="text" class="form-control" id="<c:out value="${MaNV}" />_NgaySinh"
                                               value="<c:out value="${NgaySinh}" />" disabled></td>
                                </tr>

                                <tr id="<c:out value="${MaNV}_NV" />">
                                    <td>Địa chỉ</td>
                                    <td><input type="text" class="form-control" id="<c:out value="${MaNV}" />_DiaChi"
                                               value="<c:out value="${DiaChi}" />" disabled></td>
                                </tr>

                                <tr id="<c:out value="${MaNV}_NV" />">
                                    <td>Số điện thoại</td>
                                    <td><input type="text" class="form-control" id="<c:out value="${MaNV}" />_SoDT"
                                               value="<c:out value="${SoDT}" />" disabled></td>
                                </tr>

                                <tr id="<c:out value="${MaNV}_NV" />">
                                    <td>Số CMND</td>
                                    <td><input type="text" class="form-control" id="<c:out value="${MaNV}" />_SoCMND"
                                               value="<c:out value="${SoCMND}" />" disabled></td>
                                </tr>

                                <tr id="<c:out value="${MaNV}_NV" />">
                                    <td>Lương</td>
                                    <td><input type="text" class="form-control" id="<c:out value="${MaNV}" />_Luong"
                                               value="<c:out value="${Luong}" />" disabled></td>
                                </tr>

                                <tr id="<c:out value="${MaNV}_NV" />">
                                    <td>Mật khẩu</td>
                                    <td><input type="text" class="form-control" id="<c:out value="${MaNV}" />_MatKhau"
                                               value="<c:out value="${MatKhau}" />" disabled></td>
                                </tr>

                                <tr id="<c:out value="${MaNV}_NV" />">
                                    <td>Ngày tạo</td>
                                    <td><input type="text" class="form-control" id="<c:out value="${MaNV}" />_NgayTao"
                                               value="<c:out value="${NgayTao}" />" disabled></td>
                                </tr>

                                <tr id="<c:out value="${MaNV}_NV" />">
                                    <td>Ngày cập nhật</td>
                                    <td><input type="text" class="form-control" id="<c:out value="${MaNV}" />_NgayCapNhat"
                                               value="<c:out value="${NgayCapNhat}" />" disabled></td>
                                </tr>

                                <tr id="<c:out value="${MaNV}_NV" />">
                                    <td>
                                        <button class="btn btn-warning btn-sm" id="<c:out value="${MaNV}" />_Sua">Sửa</button>
                                        <button class="btn btn-danger btn-sm" id="<c:out value="${MaNV}" />_Huy">Hủy</button>
                                    </td>
                                </tr>

                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>