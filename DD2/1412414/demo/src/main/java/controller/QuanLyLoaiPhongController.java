package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.LoaiPhongBase;

@Controller
public class QuanLyLoaiPhongController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model map) {
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();
            LoaiPhongBase lpb = new LoaiPhongBase();
            lpb.setTenLoaiPhong("Phong Vip");
            lpb.setLoaiGiuong("Giuong Doi");
            lpb.setMoTa("Phong rat là vip");
            session.persist(lpb);

            session.getTransaction().commit();
            session.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        map.addAttribute("title", "Quản lý loại phòng");
        return "QuanLyLoaiPhong";
    }

}
