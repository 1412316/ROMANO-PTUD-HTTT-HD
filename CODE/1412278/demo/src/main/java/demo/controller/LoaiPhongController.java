package demo.controller;

import demo.hibernate.HibernateUtils;
import demo.model.LoaiPhongBase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import demo.service.ILoaiPhongService;
import demo.service.LoaiPhongService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class LoaiPhongController {
    private ILoaiPhongService LPService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();

        LPService = new LoaiPhongService(session);

        LPService.getIDAO().Begin();

        List<LoaiPhongBase> DSLP = new ArrayList<LoaiPhongBase>();
        DSLP = LPService.XemLoaiPhong();

        if (DSLP == null) {
            LPService.getIDAO().Rollback();
        } else {
            try {
                LPService.getIDAO().Save();
            } catch (Exception e) {
                e.printStackTrace();
                LPService.getIDAO().Rollback();
                DSLP = null;
            }
        }

        model.addAttribute("active", "qllp");
        model.addAttribute("DSLP", DSLP);

        return "QuanLyLoaiPhong";
    }

    @ResponseBody
    @RequestMapping(value = "/ThemLoaiPhong", method = RequestMethod.POST)
    public String ThemLoaiPhong(@RequestParam(required=false, name="TenLoaiPhong") String TenLoaiPhong,
                             @RequestParam(required=false,name="MoTa") String MoTa,
                             @RequestParam(required=false,name="LoaiGiuong") String LoaiGiuong,
                             HttpServletRequest request, HttpServletResponse response) {
        LoaiPhongBase LoaiPhong = new LoaiPhongBase(TenLoaiPhong, MoTa, LoaiGiuong);

        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();

        LPService = new LoaiPhongService(session);

        LPService.getIDAO().Begin();

        int result = LPService.ThemLoaiPhong(LoaiPhong);

        if (result == -1) {
            LPService.getIDAO().Rollback();
        } else {
            try {
                LPService.getIDAO().Save();
                result = LoaiPhong.getMaLoaiPhong();
            } catch (Exception e) {
                e.printStackTrace();
                LPService.getIDAO().Rollback();
                result = -1;
            }
        }

        return Integer.toString(result);
    }

    @ResponseBody
    @RequestMapping(value = "/XoaLoaiPhong", method = RequestMethod.POST)
    public String XoaLoaiPhong(@RequestParam(required=false, name="MaLoaiPhong") int MaLoaiPhong,
                                HttpServletRequest request, HttpServletResponse response) {
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();

        LPService = new LoaiPhongService(session);

        LPService.getIDAO().Begin();

        int result = LPService.XoaLoaiPhong(MaLoaiPhong);

        if (result == -1) {
            LPService.getIDAO().Rollback();
        } else {
            try {
                LPService.getIDAO().Save();
            } catch (Exception e) {
                e.printStackTrace();
                LPService.getIDAO().Rollback();
                result = -1;
            }
        }

        return Integer.toString(result);
    }

    @ResponseBody
    @RequestMapping(value = "/CapNhatLoaiPhong", method = RequestMethod.POST)
    public String CapNhatLoaiPhong(@RequestParam(required=false, name="MaLoaiPhong") int MaLoaiPhong,
                                   @RequestParam(required=false, name="TenLoaiPhong") String TenLoaiPhong,
                                   @RequestParam(required=false,name="MoTa") String MoTa,
                                   @RequestParam(required=false,name="LoaiGiuong") String LoaiGiuong,
                                   HttpServletRequest request, HttpServletResponse response) {
        LoaiPhongBase LoaiPhong = new LoaiPhongBase(MaLoaiPhong, TenLoaiPhong, MoTa, LoaiGiuong);

        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();

        LPService = new LoaiPhongService(session);

        LPService.getIDAO().Begin();

        int result = LPService.CapNhatLoaiPhong(LoaiPhong);

        if (result == -1) {
            LPService.getIDAO().Rollback();
        } else {
            try {
                LPService.getIDAO().Save();
            } catch (Exception e) {
                e.printStackTrace();
                LPService.getIDAO().Rollback();
                result = -1;
            }
        }

        return Integer.toString(result);
    }
}
