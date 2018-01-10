package demo.dao;

import demo.model.LoaiPhongBase;

import java.util.List;

public interface ILoaiPhongDAO {
    int Add(LoaiPhongBase LoaiPhong);
    int Delete(int MaLoaiPhong);
    int Update (LoaiPhongBase LoaiPhong);
    List<LoaiPhongBase> Select(LoaiPhongBase LoaiPhong);
}
