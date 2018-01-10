package demo.service;

import demo.dao.IPhongDAO;
import demo.dao.PhongDAO;
import demo.model.PhongBase;

import java.util.List;

public class PhongService implements IPhongService {
    private IPhongDAO IDAO = new PhongDAO();

    public List<PhongBase> XemPhong(PhongBase Phong) {
        return IDAO.Select(Phong);
    }

    public int XoaPhong(String SoPhong) {
        return IDAO.Delete(SoPhong);
    }

    public int CapNhatPhong(PhongBase Phong) {
        return IDAO.Update(Phong);
    }

    public int ThemPhong(PhongBase Phong) {
        return IDAO.Add(Phong);
    }
}
