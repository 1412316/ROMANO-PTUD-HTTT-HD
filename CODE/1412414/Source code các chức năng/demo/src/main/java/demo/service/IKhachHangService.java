package demo.service;

import demo.dao.IUnitOfWork;
import demo.model.KhachHang;
import demo.model.ThongTinDatPhongBase;

public interface IKhachHangService {
    int ThemKH(KhachHang KhachHang);
    String LayMaKHLonNhat();
    IUnitOfWork<KhachHang> getIDAO();
}
