package demo.controller;

import demo.hibernate.HibernateUtils;
import demo.model.LoaiPhongBase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;

import demo.service.ILoaiPhongService;
import demo.service.LoaiPhongService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoaiPhongController {
    private ILoaiPhongService LPService;
    private static final Logger Log = Logger.getLogger(LoaiPhongController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        Log.debug("Trong ham index của controller LoaiPhong");
        Log.debug("Khai bao SessionFactory va Session");
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();

        Log.debug("new Loai phong service va truyen session vao");
        LPService = new LoaiPhongService(session);

        Log.debug("Bat dau Transaction");
        LPService.getIDAO().Begin();

        Log.debug("Khai bao va new List<LoaiPhongBase>");
        List<LoaiPhongBase> DSLP = new ArrayList<LoaiPhongBase>();

        Log.debug("Tien hinh xem loai phong va truyen vao List<LoaiPhongBase> phia tren");
        DSLP = LPService.XemLoaiPhong();

        Log.debug("Kiem tra ket qua tra ve");
        if (DSLP == null) {
            Log.error("List<LoaiPhongBase> bi null nghia la co loi xay ra trong qua trinh xem loai phong, tien hanh" +
                    " rollback roi dong session");
            LPService.getIDAO().Rollback();
        } else {
            try {
                Log.debug("Khong co loi gi xay ra tien hanh commit va dong session");
                LPService.getIDAO().Save();
            } catch (Exception e) {
                e.printStackTrace();
                LPService.getIDAO().Rollback();
                DSLP = null;
                Log.error("Co loi xay ra luc commit nen rollback lai roi dong session");
            }
        }

        Log.debug("Them List<LoaiPhongBase> vao model");
        model.addAttribute("active", "qllp");
        model.addAttribute("DSLP", DSLP);

        Log.debug("Tra ve view QuanLyLoaiPhong");
        return "QuanLyLoaiPhong";
    }

    @ResponseBody
    @RequestMapping(value = "/ThemLoaiPhong", method = RequestMethod.POST)
    public String ThemLoaiPhong(@RequestParam(required=false, name="TenLoaiPhong") String TenLoaiPhong,
                             @RequestParam(required=false,name="MoTa") String MoTa,
                             @RequestParam(required=false,name="LoaiGiuong") String LoaiGiuong,
                             HttpServletRequest request, HttpServletResponse response) {
        Log.debug("Trong ham them loai phong cua controller loai phong");
        Log.debug("Khoi tao LoaiPhongBase voi ten loai phong, mo ta, loai giuong duoc truyen len tu ajax");
        LoaiPhongBase LoaiPhong = new LoaiPhongBase(TenLoaiPhong, MoTa, LoaiGiuong);

        Log.debug("Khoi tao SessionFactory va Session");
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();

        Log.debug("Khoi tao LoaiPhongService và truyen session vao");
        LPService = new LoaiPhongService(session);

        Log.debug("Bat dau transaction");
        LPService.getIDAO().Begin();

        Log.debug("Bat dau them loai phong");
        int result = LPService.ThemLoaiPhong(LoaiPhong);

        Log.debug("Bat dau kiem tra ket qua them loai phong, ket qua la: " + result);
        if (result == -1) {
            Log.error("Co loi xay ra trong qua trinh them loai phong nen rollback roi dong session");
            LPService.getIDAO().Rollback();
        } else {
            Log.debug("Khong co loi xay ra trong qua trinh them loai phong");
            try {
                Log.debug("Bat dau commit transaction va dong session");
                LPService.getIDAO().Save();

                Log.debug("Lay ma loai phong (duoc tao tu dong) moi duoc them vao");
                result = LoaiPhong.getMaLoaiPhong();
            } catch (Exception e) {
                Log.error("Co loi xay ra trong qua trinh commit, chuan bi rollback va dong session");
                e.printStackTrace();
                LPService.getIDAO().Rollback();
                Log.error("Gan ket qua = -1 de cho biet co loi");
                result = -1;
            }
        }

        Log.debug("Tra ket qua ve cho ajax");
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
