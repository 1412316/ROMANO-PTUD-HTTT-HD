package demo.service;

import demo.dao.IUnitOfWork;
import demo.model.ChiTietThongTinDatPhongBase;
import demo.model.ThongTinDatPhongBase;

public interface IChiTietThongTinDatPhongService {
    int ThemChiTietThongTinDatPhong(ChiTietThongTinDatPhongBase ChiTietThongTinDatPhong);
    IUnitOfWork<ChiTietThongTinDatPhongBase> getIDAO();
}
