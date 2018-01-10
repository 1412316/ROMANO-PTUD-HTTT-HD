package demo.dao;

import demo.model.PhongBase;

import java.util.List;

public interface IRepository<T> {
    int Add(T Entity);
    String findMaxID(String sql);
    int Delete(String sql);
    int Update (T Entity);
    List<T> Select(String sql);
    List<PhongBase> Select(String sql, int GiaNhoNhat, int GiaLonNhat, String ViTri, String Tang, int SoLuongGiuong,
                           int MaLoaiPhong, String LoaiGiuong, String ThoiGianNhanPhong, String ThoiGianTraPhong);
    List<PhongBase> Select(String sql, int GiaNhoNhat, int GiaLonNhat, int MaLoaiPhong,
                           String ThoiGianNhanPhong, String ThoiGianTraPhong);
}
