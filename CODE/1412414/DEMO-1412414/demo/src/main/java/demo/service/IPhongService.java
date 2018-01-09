package demo.service;

import demo.model.PhongBase;

import java.util.List;

public interface IPhongService {
    List<PhongBase> XemPhong(PhongBase Phong);
    int XoaPhong(String SoPhong);
    int CapNhatPhong(PhongBase Phong);
    int ThemPhong(PhongBase Phong);
}
