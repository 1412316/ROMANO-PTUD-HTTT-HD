package demo.dao;

import demo.hibernate.HibernateUtils;
import demo.model.LoaiPhongBase;
import demo.model.PhongBase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class PhongDAO implements IPhongDAO {
    public int Add(PhongBase Phong) {
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();

        int result = -1;

        try {
            session.getTransaction().begin();

            session.merge(Phong);

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

    public int Delete(String SoPhong) {
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();

        int result = -1;

        try {
            session.getTransaction().begin();

            String sql = "delete " + PhongBase.class.getName() + " where SoPhong = " + SoPhong;

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

    public int Update (PhongBase Phong) {
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();

        int result = -1;

        try {
            session.getTransaction().begin();

            session.update(Phong);

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

    public List<PhongBase> Select(PhongBase Phong) {
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();

        List<PhongBase> DSPhong = new ArrayList<PhongBase>();

        try {
            session.getTransaction().begin();

            String sql = "select p from " + PhongBase.class.getName() + " p";

            Query<PhongBase> query = session.createQuery(sql);

            DSPhong = query.getResultList();

            session.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }

        return DSPhong;
    }
}
