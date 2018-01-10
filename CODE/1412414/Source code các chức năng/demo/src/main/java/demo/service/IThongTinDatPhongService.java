package demo.service;

import demo.dao.IUnitOfWork;
import demo.model.ThongTinDatPhongBase;

public interface IThongTinDatPhongService {
    int ThemThongTinDatPhong(ThongTinDatPhongBase ThongTinDatPhong);
    String LayMaThongTinDatPhongLonNhat();
    IUnitOfWork<ThongTinDatPhongBase> getIDAO();
}
