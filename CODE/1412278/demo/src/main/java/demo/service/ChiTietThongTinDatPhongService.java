package demo.service;

import demo.dao.IUnitOfWork;
import demo.dao.UnitOfWork;
import demo.model.ChiTietThongTinDatPhongBase;
import org.hibernate.Session;

public class ChiTietThongTinDatPhongService implements IChiTietThongTinDatPhongService {
    private IUnitOfWork<ChiTietThongTinDatPhongBase> IDAO;

    public ChiTietThongTinDatPhongService(Session session) {
        IDAO = new UnitOfWork<ChiTietThongTinDatPhongBase>(session);
    }

    public int ThemChiTietThongTinDatPhong(ChiTietThongTinDatPhongBase ChiTietThongTinDatPhong) {
        return IDAO.Repository().Add(ChiTietThongTinDatPhong);
    }

    public IUnitOfWork<ChiTietThongTinDatPhongBase> getIDAO() {
        return IDAO;
    }
}
