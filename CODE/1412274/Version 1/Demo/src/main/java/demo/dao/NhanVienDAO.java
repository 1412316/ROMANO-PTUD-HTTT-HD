package demo.dao;

import demo.hibernate.HibernateUtils;
import demo.model.NhanVien;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.annotations.Entity;
import org.hibernate.procedure.*;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@SuppressWarnings("unchecked")
public class NhanVienDAO implements INhanVienDAO {

    public List<NhanVien> Select(NhanVien nhanvien) {
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();

        List<NhanVien> DSNhanVien = new ArrayList<NhanVien>();

        try {
            session.getTransaction().begin();

            String sql = "select nv from " + NhanVien.class.getName() + " nv";

            System.out.println(sql);

            Query<NhanVien> query = session.createQuery(sql);

            DSNhanVien = query.getResultList();

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return DSNhanVien;
    }

    public List<NhanVien> SelectOne(String MaNV) {
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();

        List<NhanVien> DSNhanVien = new ArrayList<NhanVien>();

        try {
            session.getTransaction().begin();

            String sql = "select nv from " + NhanVien.class.getName() + " nv where nv.MaNV = '" + MaNV + "'";

            System.out.println(sql);

            Query<NhanVien> query = session.createQuery(sql);

            DSNhanVien = query.getResultList();

            //System.out.println("Ma nhan vien o duoi dao: " + DSNhanVien.get(0).getMaNV());
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return DSNhanVien;
    }

    public int Delete (String MaNV){
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();

        int result = -1;

        try {
            session.getTransaction().begin();

            String sql = "delete from " + NhanVien.class.getName() + " nv where nv.MaNV = '" + MaNV + "'";

            Query<NhanVien> query = session.createQuery(sql);

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

    public int Add(NhanVien nhanvien) {
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();

        int result = -1;

        try {
            session.getTransaction().begin();

            /*Query query1 = session.createNativeQuery("CALL ThemNhanVien(:tennv, :gioitinh, :ngaysinh, :diachi, :sodt, :socmnd)")
                    .addEntity(NhanVien.class)
                    .setParameter("tennv", nhanvien.getTenNv())
                    .setParameter("gioitinh", nhanvien.getGioiTinh())
                    .setParameter("ngaysinh", nhanvien.getNgaySinh())
                    .setParameter("diachi", nhanvien.getDiaChi())
                    .setParameter("sodt", nhanvien.getSoDt())
                    .setParameter("socmnd", nhanvien.getSoCmnd());*/

            StoredProcedureQuery query = session.createStoredProcedureCall("TaoMa");
            query.registerStoredProcedureParameter("manv", String.class, ParameterMode.OUT);
            query.execute();
            String manv = (String) query.getOutputParameterValue("manv");

            nhanvien.setMaNV(manv);
            nhanvien.setLuong("300000vnd");
            nhanvien.setMatKhau(manv);

            session.persist(nhanvien);
            session.flush();

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

    public int Update (NhanVien nhanvien){
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();

        int result = -1;

        try {
            session.getTransaction().begin();

            session.update(nhanvien);

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

}
