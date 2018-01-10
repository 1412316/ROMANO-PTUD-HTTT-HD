package demo.dao;

import demo.model.PhongBase;

import java.util.List;

public interface IPhongDAO {
    int Add(PhongBase LPhong);
    int Delete(String SoPhong);
    int Update (PhongBase Phong);
    List<PhongBase> Select(PhongBase Phong);
}
