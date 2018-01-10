package demo.dao;

import demo.model.PhongBase;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class Repository<T> implements IRepository<T> {
    private Session session;

    public Repository(Session session) {
        this.session = session;
    }

    public int Add(T Entity) {
        int result = -1;

        try {
            session.persist(Entity);
            session.flush();

            result = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public String findMaxID(String sql) {
        String result = "";

        try {
            Query query = session.createQuery(sql);

            result = query.getResultList().get(0).toString();
        }
        catch (Exception e) {
            e.printStackTrace();
            result = "Error";
        }

        return result;
    }

    public int Delete(String sql) {
        int result = -1;

        try {
            Query<T> query = session.createQuery(sql);

            query.executeUpdate();

            result = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public int Update (T Entity) {
        int result = -1;

        try {
            session.update(Entity);

            result = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<T> Select(String sql) {
        List<T> result = new ArrayList<T>();

        try {
            Query<T> query = session.createQuery(sql);

            result = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            result = null;
        }

        return result;
    }

    public List<PhongBase> Select(String sql, int GiaNhoNhat, int GiaLonNhat, String ViTri, String Tang, int SoLuongGiuong,
                          int MaLoaiPhong, String LoaiGiuong, String ThoiGianNhanPhong, String ThoiGianTraPhong) {
        List<PhongBase> result = new ArrayList<PhongBase>();

        try {
            Query<PhongBase> query = session.createQuery(sql);

            query.setParameter("GiaNhoNhat", GiaNhoNhat);
            query.setParameter("GiaLonNhat", GiaLonNhat);
            query.setParameter("ViTri", ViTri);
            query.setParameter("Tang", Tang);
            query.setParameter("SoLuongGiuong", SoLuongGiuong);
            query.setParameter("MaLoaiPhong", MaLoaiPhong);
            query.setParameter("LoaiGiuong", LoaiGiuong);
            query.setParameter("ThoiGianNhanPhong", ThoiGianNhanPhong);
            query.setParameter("ThoiGianTraPhong", ThoiGianTraPhong);
            System.out.print(query.getQueryString());

            result = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            result = null;
        }

        return result;
    }

    public List<PhongBase> Select(String sql, int GiaNhoNhat, int GiaLonNhat, int MaLoaiPhong,
                                  String ThoiGianNhanPhong, String ThoiGianTraPhong) {
        List<PhongBase> result = new ArrayList<PhongBase>();

        try {
            Query<PhongBase> query = session.createQuery(sql);

            query.setParameter("GiaNhoNhat", GiaNhoNhat);
            query.setParameter("GiaLonNhat", GiaLonNhat);
            query.setParameter("MaLoaiPhong", MaLoaiPhong);
            query.setParameter("ThoiGianNhanPhong", ThoiGianNhanPhong);
            query.setParameter("ThoiGianTraPhong", ThoiGianTraPhong);
            System.out.print(query.getQueryString());

            result = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            result = null;
        }

        return result;
    }
}
