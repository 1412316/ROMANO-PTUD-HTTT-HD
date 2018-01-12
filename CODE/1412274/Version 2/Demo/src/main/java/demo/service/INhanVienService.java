package demo.service;

import demo.model.NhanVien;

import java.util.List;

public interface INhanVienService {
    int ThemNhanVien(NhanVien nhanvien);
    int CapNhatNhanVien(NhanVien nhanvien);
    List<NhanVien> XemNhanVien(NhanVien nhanvien);
    List<NhanVien> XemMotNhanVien(String MaNV);
    int XoaNhanVien(String manv);
    String LayMaLonNhat();
}

