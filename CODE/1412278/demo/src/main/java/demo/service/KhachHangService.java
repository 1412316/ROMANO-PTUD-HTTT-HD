package demo.service;

import demo.dao.IUnitOfWork;
import demo.dao.UnitOfWork;
import demo.model.KhachHang;
import org.hibernate.Session;

public class KhachHangService implements IKhachHangService {
    private IUnitOfWork<KhachHang> IDAO;

    public KhachHangService(Session session) {
        IDAO = new UnitOfWork<KhachHang>(session);
    }

    public int ThemKH(KhachHang KhachHang) {
        return IDAO.Repository().Add(KhachHang);
    }

    public String LayMaKHLonNhat() {
        String sql = "select max(p.MaKH) from " + KhachHang.class.getName() + " p";

        return IDAO.Repository().findMaxID(sql);
    }

    public IUnitOfWork<KhachHang> getIDAO() {
        return IDAO;
    }
}
