package service;

import model.LoaiPhongBase;

import java.util.List;

public interface ILoaiPhongService {
    int ThemLoaiPhong(LoaiPhongBase LoaiPhong);
    int XoaLoaiPhong(int MaLoaiPhong);
    int CapNhatLoaiPhong(LoaiPhongBase LoaiPhong);
    List<LoaiPhongBase> XemLoaiPhong(LoaiPhongBase LoaiPhong);
}
