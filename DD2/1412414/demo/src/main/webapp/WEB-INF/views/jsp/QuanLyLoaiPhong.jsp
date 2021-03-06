<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>${title}</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <!-- font-awesome -->
    <script src="https://use.fontawesome.com/ad779edd18.js"></script>
</head>

<body>
<div class="container-fluid">
    <button class="btn btn-success" style="margin-bottom: 15px;">Thêm</button>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Mã loại phòng</th>
            <th>Tên loại phòng</th>
            <th>Mô tả</th>
            <th>Loại giường</th>
            <th>Chức năng</th
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><input type="number" class="form-control" id="" value="1" disabled></td>
            <td><input type="text" class="form-control" id="" value="Phòng bình thường" disabled></td>
            <td><input type="text" class="form-control" id="" value="Loại phòng phong cách bình thường" disabled></td>
            <td>
                <select class="form-control" id="YeuCauLoaiPhong"  disabled>
                    <option>Giường đơn</option>
                    <option>Giường kép</option>
                </select>
            </td>
            <td><button class="btn btn-danger btn-sm">Xóa</button> <button class="btn btn-warning btn-sm">Sửa</button></td>
        </tr>
        <tr>
            <td><input type="number" class="form-control" id="" value="1"></td>
            <td><input type="text" class="form-control" id="" value="Phòng bình thường"></td>
            <td><input type="text" class="form-control" id="" value="Loại phòng phong cách bình thường"></td>
            <td>
                <select class="form-control" id="YeuCauLoaiPhong">
                    <option>Giường đơn</option>
                    <option>Giường kép</option>
                </select>
            </td>
            <td><button class="btn btn-danger btn-sm">Xóa</button> <button class="btn btn-success btn-sm">Lưu</button></td>
        </tr>
        <tr>
            <td><input type="number" class="form-control" id=""></td>
            <td><input type="text" class="form-control" id=""></td>
            <td><input type="text" class="form-control" id=""></td>
            <td>
                <select class="form-control" id="YeuCauLoaiPhong">
                    <option>Giường đơn</option>
                    <option>Giường kép</option>
                </select>
            </td>
            <td><button class="btn btn-success btn-sm">Lưu</button></td>
        </tr>
        </tbody>
    </table>
</div>
</body>

</html>