package demo.service;
import demo.dao.IUnitOfWork;
import demo.dao.UnitOfWork;
import demo.model.ChiTietThietBi;
import org.hibernate.Session;

import java.util.List;

public class ChiTietThietBiService {
    private IUnitOfWork<ChiTietThietBi> IDAO;

    public IUnitOfWork<ChiTietThietBi> getIDAO() {
        return IDAO;
    }

    public ChiTietThietBiService( Session session ) {
        IDAO = new UnitOfWork<ChiTietThietBi>(session);
    }

    public List<ChiTietThietBi> Xem(String MaThietBi){
        String hql = "select cttb from " + ChiTietThietBi.class.getName() +" cttb " +
                "where cttb.ThietBi.MaThietBi = '" + MaThietBi + "'";
        return IDAO.Repository().Select(hql);
    }

    public int XoaChiTietThietBi(ChiTietThietBi cttb) {
        String hql = "delete " + ChiTietThietBi.class.getName() + " where Serial = '"+ cttb.getSerial() + "'";
        return IDAO.Repository().Delete(hql);
    }

    public int SuaChiTietThietBi(ChiTietThietBi cttb)
    {
        return IDAO.Repository().Update(cttb);
    }
}
