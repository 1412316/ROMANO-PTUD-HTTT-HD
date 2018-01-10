package demo.controller;
import demo.hibernate.HibernateUtils;
import demo.model.ThietBi;
import demo.service.ThietBiService;
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
import java.util.Date;
import java.util.List;

@Controller
public class thietbiController {
    @RequestMapping(value = "/QuanLyThietBi", method = RequestMethod.GET)
    public String index(Model model) {
        /*Tao session cho hibernate */
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();
        List<ThietBi> list;
        ThietBiService TBService = new ThietBiService(session);
        TBService.getIDAO().Begin();
        list = TBService.XemThietBi();

        /* Kiem Tra Loi , Neu Loi thi rollback */
        if (list == null) {
            TBService.getIDAO().Rollback();
        } else {
            try {
                TBService.getIDAO().Save();
            } catch (Exception e) {
                e.printStackTrace();
                TBService.getIDAO().Rollback();
                list = null;

            }
        }
        model.addAttribute("DSTB", list);
        model.addAttribute("active", "qltb");
        return "QuanLyThietBi";
    }
    /* trả ket qua ve chu ko phai tra view ve */
    @ResponseBody
    @RequestMapping(value = "/QuanLyThietBi/Them", method = RequestMethod.POST)
    public String ThemThietBi(
            @RequestParam(required = false, name = "TenThietBi") String tenthietbi,
            @RequestParam(required = false, name = "Gia") int giatien,
            @RequestParam(required = false, name = "TenLoai") String tenloai,
            @RequestParam(required = false, name = "SoLuong") int soluong,
            HttpServletRequest request, HttpServletResponse response) {
        String KetQuaTraVe = "";

        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();

        ThietBiService TBService = new ThietBiService(session);
        /* Phai luon begin truoc khi truy xuat database  */
        TBService.getIDAO().Begin();
        String mathietbi = TBService.LayMaThietBiLonNhat();
        if (mathietbi == "Error") {
            /*Bi loi goi IDAO de huy giao tac */
            TBService.getIDAO().Rollback();
            KetQuaTraVe = "Error";
        } else {
            int TBTiepTheo = Integer.parseInt(mathietbi.substring(2)) + 1;
            int SoLuongSo0 = 3 - Integer.toString(TBTiepTheo).length();
            String MaTBTiepTheo = "TB";

            for (int i = 0; i < SoLuongSo0; i++) {
                MaTBTiepTheo += "0";
            }

            MaTBTiepTheo += TBTiepTheo;
            ThietBi thietBi = new ThietBi();
            thietBi.setMaThietBi(MaTBTiepTheo);
            thietBi.setTenThietBi(tenthietbi);
            thietBi.setGiaTien(giatien);
            thietBi.setTenLoai(tenloai);
            thietBi.setSoluong(soluong);
            if (TBService.ThemThietBi(thietBi) == -1) {
                TBService.getIDAO().Rollback();
                KetQuaTraVe = "Error";
            } else {
                try {
                    TBService.getIDAO().Save();
                    KetQuaTraVe = MaTBTiepTheo;
                } catch (Exception e) {
                    e.printStackTrace();
                    TBService.getIDAO().Rollback();
                    KetQuaTraVe = "Error";
                }
            }
        }

        return KetQuaTraVe;
    }
    @ResponseBody
    @RequestMapping(value="/QuanLyThietBi/XoaThietBi", method = RequestMethod.POST)
    public String XoaThietBi(@RequestParam(required=false, name="MaThietBi") String mathietbi,
                                                       HttpServletRequest request, HttpServletResponse response) {
        String result;
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();
        ThietBi tb = new ThietBi();
        tb.setMaThietBi(mathietbi);
        ThietBiService TBService = new ThietBiService(session);
        TBService.getIDAO().Begin();
        if(TBService.XoaThietBi(tb) ==-1 )
        {
            TBService.getIDAO().Rollback();
            /* result duoc dua qua ajax xu ly, -1 => loi, 1 la thanh cong */
            result = "-1";

        } else {
            try {
                TBService.getIDAO().Save();
                result = "0";
            } catch (Exception e) {
                e.printStackTrace();
                TBService.getIDAO().Rollback();
                result = "-1";
            }

        }
        return result;
    }
    @ResponseBody
    @RequestMapping(value="/QuanLyThietBi/CapNhatThietBi",method = RequestMethod.POST)
            public String CapNhatThietBi(
            @RequestParam(required = true, name = "MaTB") String mathietbi,
            @RequestParam(required = false, name = "TenThietBi") String tenthietbi,
            @RequestParam(required = false, name = "Gia") int giatien,
            @RequestParam(required = false, name = "TenLoai") String tenloai,
            @RequestParam(required = false, name = "SoLuong") int soluong,
            HttpServletRequest request, HttpServletResponse response
    )
    {
        String result;
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();
        ThietBi tb = new ThietBi();
        tb.setMaThietBi(mathietbi);
        tb.setTenThietBi(tenthietbi);
        tb.setGiaTien(giatien);
        tb.setTenLoai(tenloai);
        tb.setSoluong(soluong);

        ThietBiService TBService = new ThietBiService(session);
        TBService.getIDAO().Begin();

        if(  TBService.SuaThietBi(tb)==-1)
        {
            TBService.getIDAO().Rollback();
            result = "-1";

        }
        else
        {
            try{
                TBService.getIDAO().Save();
                result = "1";
            }
            catch (Exception e)
            {
                e.printStackTrace();
                TBService.getIDAO().Rollback();
                result = "-1";
            }

        }
        return result;
    }

}
