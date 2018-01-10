package demo.service;

import demo.model.ChiTietThietBi;

import java.util.List;

public interface IChiTietThietBi {
    List <ChiTietThietBi> Xem(String MaThietBi);
    int XoaChiTietThietBi(ChiTietThietBi cttb);
    int SuaChiTietThietBi(ChiTietThietBi cttb);
}
