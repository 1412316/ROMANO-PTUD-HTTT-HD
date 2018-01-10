package demo.service;

import demo.dao.IUnitOfWork;
import demo.dao.UnitOfWork;
import demo.model.PhongBase;
import demo.model.ThietBi;
import org.hibernate.Session;

import java.util.List;

public class ThietBiService implements IThietBiService {
    /* cho phep lay bien co kieu IUnitOfWork  len controller => De su dung UnitOfWork ( begin ,save,commit,...)*/
    public IUnitOfWork<ThietBi> getIDAO() {
        return IDAO;
    }

    private IUnitOfWork<ThietBi> IDAO;

    public ThietBiService(Session session) {
        IDAO = new UnitOfWork<ThietBi>(session);
    }

    public List<ThietBi> XemThietBi() {
        String hql = "select tb from  " + ThietBi.class.getName() + " tb";
        return IDAO.Repository().Select(hql);
    }

    /*IDAO(unitofwork) dung thuc thi lenh them qua method ADD cua Respository  */
    public int ThemThietBi(ThietBi tb) {
        return IDAO.Repository().Add(tb);
    }

    /* Goi Cau truy van lay Ma thiet bi  lon nhat  thao Irepository*/
    public String LayMaThietBiLonNhat() {
        String hql = "select max(tb.MaThietBi) from " + ThietBi.class.getName() + " tb";
        return IDAO.Repository().findMaxID(hql);
    }

    public int XoaThietBi(ThietBi tb) {
        String hql = "delete " + ThietBi.class.getName() + " where MaThietBi = '"+ tb.getMaThietBi() + "'";
        return IDAO.Repository().Delete(hql);
    }
    public int SuaThietBi(ThietBi tb)
    {
        return IDAO.Repository().Update(tb);
    }
}