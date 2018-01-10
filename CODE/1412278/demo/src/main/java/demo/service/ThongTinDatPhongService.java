package demo.service;

import demo.dao.IUnitOfWork;
import demo.dao.UnitOfWork;
import demo.model.ThongTinDatPhongBase;
import org.hibernate.Session;

public class ThongTinDatPhongService implements IThongTinDatPhongService {
    private IUnitOfWork<ThongTinDatPhongBase> IDAO;

    public ThongTinDatPhongService(Session session) {
        IDAO = new UnitOfWork<ThongTinDatPhongBase>(session);
    }

    public String LayMaThongTinDatPhongLonNhat() {
        String sql = "select max(p.MaThongTinDatPhong) from " + ThongTinDatPhongBase.class.getName() + " p";

        return IDAO.Repository().findMaxID(sql);
    }

    public int ThemThongTinDatPhong(ThongTinDatPhongBase ThongTinDatPhong) {
        return IDAO.Repository().Add(ThongTinDatPhong);
    }

    public IUnitOfWork<ThongTinDatPhongBase> getIDAO() {
        return IDAO;
    }
}
