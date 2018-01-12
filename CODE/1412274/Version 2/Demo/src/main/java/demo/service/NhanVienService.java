package demo.service;

import demo.dao.INhanVienDAO;
import demo.dao.NhanVienDAO;
import demo.model.NhanVien;

import java.util.List;

public class NhanVienService implements INhanVienService {
    private INhanVienDAO IDAO = new NhanVienDAO();

    public int ThemNhanVien(NhanVien nhanvien) {
        return IDAO.Add(nhanvien);
    }
    public List<NhanVien> XemNhanVien(NhanVien nhanvien) {
        return IDAO.Select(nhanvien);
    }
    public List<NhanVien> XemMotNhanVien(String MaNV) {
        return IDAO.SelectOne(MaNV);
    }
    public int XoaNhanVien(String MaNV) {
        return IDAO.Delete(MaNV);
    }
    public int CapNhatNhanVien(NhanVien nhanvien) {
        return IDAO.Update(nhanvien);
    }
    public String LayMaLonNhat() {
        return IDAO.findMaxID();
    }

}
