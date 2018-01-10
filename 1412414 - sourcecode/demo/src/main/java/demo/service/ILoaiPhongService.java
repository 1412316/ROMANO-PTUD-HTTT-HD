package demo.service;

import demo.dao.IUnitOfWork;
import demo.model.LoaiPhongBase;

import java.util.List;

public interface ILoaiPhongService {
    int ThemLoaiPhong(LoaiPhongBase LoaiPhong);
    int XoaLoaiPhong(int MaLoaiPhong);
    int CapNhatLoaiPhong(LoaiPhongBase LoaiPhong);
    List<LoaiPhongBase> XemLoaiPhong();
    IUnitOfWork<LoaiPhongBase> getIDAO();
}
