package demo.service;

import demo.dao.ILoaiPhongDAO;
import demo.dao.LoaiPhongDAO;
import demo.model.LoaiPhongBase;

import java.util.List;

public class LoaiPhongService implements ILoaiPhongService {
    private ILoaiPhongDAO IDAO = new LoaiPhongDAO();

    public int ThemLoaiPhong(LoaiPhongBase LoaiPhong){
        return IDAO.Add(LoaiPhong);
    }

    public int XoaLoaiPhong(int MaLoaiPhong){
        return IDAO.Delete(MaLoaiPhong);
    }

    public int CapNhatLoaiPhong(LoaiPhongBase LoaiPhong){
        return IDAO.Update(LoaiPhong);
    }

    public List<LoaiPhongBase> XemLoaiPhong(LoaiPhongBase LoaiPhong) {
        return IDAO.Select(LoaiPhong);
    }
}
