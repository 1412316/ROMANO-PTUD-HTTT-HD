package demo.service;

import demo.dao.IUnitOfWork;
import demo.model.ThietBi;

import java.util.List;

public interface IThietBiService {
    List<ThietBi> XemThietBi();
    IUnitOfWork<ThietBi> getIDAO();
    int ThemThietBi(ThietBi tb);
    String LayMaThietBiLonNhat();
    int XoaThietBi(ThietBi tb);
    int SuaThietBi (ThietBi tb);

}