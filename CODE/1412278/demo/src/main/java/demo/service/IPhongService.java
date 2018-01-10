package demo.service;

import demo.dao.IUnitOfWork;
import demo.model.CacYeuCauVePhong;
import demo.model.PhongBase;

import java.util.List;

public interface IPhongService {
    List<PhongBase> XemPhong();
    int XoaPhong(String SoPhong);
    int CapNhatPhong(PhongBase Phong);
    int ThemPhong(PhongBase Phong);
    List<PhongBase> TimPhongPhuHop(CacYeuCauVePhong CacYeuCauVePhong);
    IUnitOfWork<PhongBase> getIDAO();
}
