package demo.service;

import demo.dao.IUnitOfWork;
import demo.dao.UnitOfWork;
import demo.model.LoaiPhongBase;
import org.hibernate.Session;

import java.util.List;

public class LoaiPhongService implements ILoaiPhongService {
    private IUnitOfWork<LoaiPhongBase> IDAO;

    public LoaiPhongService(Session session) {
        IDAO = new UnitOfWork<LoaiPhongBase>(session);
    }

    public int ThemLoaiPhong(LoaiPhongBase LoaiPhong){
        return IDAO.Repository().Add(LoaiPhong);
    }

    public int XoaLoaiPhong(int MaLoaiPhong){
        String sql = "delete " + LoaiPhongBase.class.getName() + " where MaLoaiPhong = " + MaLoaiPhong;

        return IDAO.Repository().Delete(sql);
    }

    public int CapNhatLoaiPhong(LoaiPhongBase LoaiPhong){
        return IDAO.Repository().Update(LoaiPhong);
    }

    public List<LoaiPhongBase> XemLoaiPhong() {
        String sql = "select lp from " + LoaiPhongBase.class.getName() + " lp";;

        return IDAO.Repository().Select(sql);
    }

    public IUnitOfWork<LoaiPhongBase> getIDAO() {
        return IDAO;
    }
}
