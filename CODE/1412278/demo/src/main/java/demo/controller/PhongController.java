package demo.controller;

import demo.hibernate.HibernateUtils;
import demo.model.LoaiPhongBase;
import demo.model.PhongBase;
import demo.service.ILoaiPhongService;
import demo.service.IPhongService;
import demo.service.LoaiPhongService;
import demo.service.PhongService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class PhongController {
    private IPhongService PService;
    private ILoaiPhongService LPService;

    @RequestMapping(value = "/QuanLyPhong", method = RequestMethod.GET)
    public String index(Model model) {
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();

        PService = new PhongService(session);
        LPService = new LoaiPhongService(session);

        PService.getIDAO().Begin();

        List<PhongBase> DSP = new ArrayList<PhongBase>();
        List<LoaiPhongBase> DSLP = new ArrayList<LoaiPhongBase>();

        DSP = PService.XemPhong();
        DSLP = LPService.XemLoaiPhong();

        if (DSP == null || DSLP == null) {
            PService.getIDAO().Rollback();
        } else {
            try {
                PService.getIDAO().Save();
            } catch (Exception e) {
                e.printStackTrace();
                PService.getIDAO().Rollback();
                DSP = null;
                DSLP = null;
            }
        }

        model.addAttribute("active", "qlp");
        model.addAttribute("DSP", DSP);
        model.addAttribute("DSLP", DSLP);

        return "QuanLyPhong";
    }

    @ResponseBody
    @RequestMapping(value = "/ThemPhong", method = RequestMethod.POST)
    public String ThemPhong(@RequestParam(required=false, name="SoPhong") String SoPhong,
                            @RequestParam(required=false, name="GiaHienTai") int GiaHienTai,
                            @RequestParam(required=false, name="ViTri") String ViTri,
                            @RequestParam(required=false, name="MoTa") String MoTa,
                            @RequestParam(required=false, name="Tang") String Tang,
                            @RequestParam(required=false, name="SoLuongGiuong") int SoLuongGiuong,
                            @RequestParam(required=false, name="LoaiPhong") int LoaiPhong,
                            HttpServletRequest request, HttpServletResponse response) {

        LoaiPhongBase LP = new LoaiPhongBase();
        LP.setMaLoaiPhong(LoaiPhong);
        PhongBase Phong = new PhongBase(SoPhong, GiaHienTai, ViTri, MoTa, Tang, SoLuongGiuong, LP);

        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();

        PService = new PhongService(session);
        PService.getIDAO().Begin();

        int result = PService.ThemPhong(Phong);

        if (result == -1) {
            PService.getIDAO().Rollback();
        } else {
            try {
                PService.getIDAO().Save();
            } catch (Exception e) {
                e.printStackTrace();
                PService.getIDAO().Rollback();
                result = -1;
            }
        }

        return Integer.toString(result);
    }

    @ResponseBody
    @RequestMapping(value = "/XoaPhong", method = RequestMethod.POST)
    public String XoaPhong(@RequestParam(required=false, name="SoPhong") String SoPhong,
                               HttpServletRequest request, HttpServletResponse response) {

        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();

        PService = new PhongService(session);

        PService.getIDAO().Begin();

        int result = PService.XoaPhong(SoPhong);

        if (result == -1) {
            PService.getIDAO().Rollback();
        } else {
            try {
                PService.getIDAO().Save();
            } catch (Exception e) {
                e.printStackTrace();
                PService.getIDAO().Rollback();
                result = -1;
            }
        }

        return Integer.toString(result);
    }

    @ResponseBody
    @RequestMapping(value = "/CapNhatPhong", method = RequestMethod.POST)
    public String CapNhatLoaiPhong(@RequestParam(required=false, name="SoPhong") String SoPhong,
                                   @RequestParam(required=false, name="GiaHienTai") int GiaHienTai,
                                   @RequestParam(required=false, name="ViTri") String ViTri,
                                   @RequestParam(required=false, name="MoTa") String MoTa,
                                   @RequestParam(required=false, name="Tang") String Tang,
                                   @RequestParam(required=false, name="SoLuongGiuong") int SoLuongGiuong,
                                   @RequestParam(required=false, name="LoaiPhong") int LoaiPhong,
                                   HttpServletRequest request, HttpServletResponse response) {
        LoaiPhongBase LP = new LoaiPhongBase();
        LP.setMaLoaiPhong(LoaiPhong);

        PhongBase Phong = new PhongBase();
        Phong.setSoPhong(SoPhong);
        Phong.setGiaHienTai(GiaHienTai);
        Phong.setViTri(ViTri);
        Phong.setMoTa(MoTa);
        Phong.setTang(Tang);
        Phong.setSoLuongGiuong(SoLuongGiuong);
        Phong.setLoaiPhong(LP);
        Phong.setNgayCapNhat(new Date().toString().substring(0, 10));

        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();

        PService = new PhongService(session);

        PService.getIDAO().Begin();

        int result = PService.CapNhatPhong(Phong);

        if (result == -1) {
            PService.getIDAO().Rollback();
        } else {
            try {
                PService.getIDAO().Save();
            } catch (Exception e) {
                e.printStackTrace();
                PService.getIDAO().Rollback();
                result = -1;
            }
        }

        return Integer.toString(result);
    }
}
