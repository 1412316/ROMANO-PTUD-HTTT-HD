<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container-fluid">

        <div class="container-page">
            <div class="col-md-12">
                <h3 class="text-center">Thêm Nhân Viên</h3>
                <form method="POST">
                <div class="form-group col-lg-8">
                    <label>Tên nhân viên</label>
                    <input type="text" class="form-control" id="ThemTenNV">
                </div>

                <div class="form-group col-lg-8">
                    <label>Giới tính</label>
                    <input type="text" class="form-control" id="ThemGioiTinh">
                </div>

                <div class="form-group col-lg-8">
                    <label>Ngày sinh</label>
                    <input type="text" class="form-control" id="ThemNgaySinh">
                </div>

                <div class="form-group col-lg-8">
                    <label>Địa chỉ</label>
                    <input type="text" class="form-control" id="ThemDiaChi">
                </div>

                <div class="form-group col-lg-8">
                    <label>Số điện thoại</label>
                    <input type="text" class="form-control" id="ThemSoDT">
                </div>

                <div class="form-group col-lg-8">
                    <label>Số CMND</label>
                    <input type="text" class="form-control" id="ThemSoCMND">
                </div>

                </form>
            </div>

            <button type="button" class="btn btn-success btn-sm" id="Them_Luu">Lưu</button>

        </div>
</div>