package demo.dao;

import demo.hibernate.HibernateUtils;
import demo.model.LoaiPhongBase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class LoaiPhongDAO implements ILoaiPhongDAO {
    public int Add(LoaiPhongBase LoaiPhong){
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();

        int result = -1;

        try {
            session.getTransaction().begin();

            session.persist(LoaiPhong);
            session.flush();

            result = LoaiPhong.getMaLoaiPhong();

            session.getTransaction().commit();
            session.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        return result;
    }

    public int Delete(int MaLoaiPhong){
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();

        int result = -1;

        try {
            session.getTransaction().begin();

            String sql = "delete " + LoaiPhongBase.class.getName() + " where MaLoaiPhong = " + MaLoaiPhong;

            Query<LoaiPhongBase> query = session.createQuery(sql);

            query.executeUpdate();

            result = 0;

            session.getTransaction().commit();
            session.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        return result;
    }

    public int Update (LoaiPhongBase LoaiPhong){
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();

        int result = -1;

        try {
            session.getTransaction().begin();

            session.update(LoaiPhong);

            result = 0;

            session.getTransaction().commit();
            session.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        return result;
    }

    public List<LoaiPhongBase> Select(LoaiPhongBase LoaiPhong){
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();

        List<LoaiPhongBase> DSLoaiPhong = new ArrayList<LoaiPhongBase>();

        try {
            session.getTransaction().begin();

            String sql = "select lp from " + LoaiPhongBase.class.getName() + " lp";

            Query<LoaiPhongBase> query = session.createQuery(sql);

            DSLoaiPhong = query.getResultList();

            session.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }

        return DSLoaiPhong;
    }
}
