package demo.dao;

import demo.model.NhanVien;

import java.util.List;

public interface INhanVienDAO {
    int Add(NhanVien nhanvien);
    int Update (NhanVien nhanvien);
    List<NhanVien> Select(NhanVien nhanvien);
    List<NhanVien> SelectOne(String MaNV);
    int Delete(String MaNV);
    String findMaxID();
}
