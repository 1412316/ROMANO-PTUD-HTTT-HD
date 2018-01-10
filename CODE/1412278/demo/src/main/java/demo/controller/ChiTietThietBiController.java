package demo.controller;

import demo.hibernate.HibernateUtils;
import demo.model.ChiTietThietBi;
import demo.model.PhongBase;
import demo.model.ThietBi;
import demo.service.ChiTietThietBiService;
import demo.service.ThietBiService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ChiTietThietBiController {
    @RequestMapping(value="/QuanLyChiTietThietBi/{MaThietBi}",method = RequestMethod.GET)
    public String index (Model model, @PathVariable("MaThietBi") String MaThietBi){
        /*Tao session cho hibernate */
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();
        List<ChiTietThietBi> list;
        ChiTietThietBiService CTTBService = new ChiTietThietBiService(session);
        CTTBService.getIDAO().Begin();
        list = CTTBService.Xem(MaThietBi);

        /* Kiem Tra Loi , Neu Loi thi rollback */
        if (list == null) {
            CTTBService.getIDAO().Rollback();
        } else {
            try {
                CTTBService.getIDAO().Save();
            } catch (Exception e) {
                e.printStackTrace();
                CTTBService.getIDAO().Rollback();
                list = null;

            }
        }
        model.addAttribute("DSCTTB", list);
        model.addAttribute("active", "qltb");
        return "QuanLyChiTietThietBi";
    }

    @ResponseBody
    @RequestMapping(value="/QuanLyChiTietThietBi/XoaChiTietThietBi",method = RequestMethod.POST)
    public String XoaChiTietThietBi(@RequestParam(required=false, name="Serial") String Serial,
                                    HttpServletRequest request, HttpServletResponse response){
        String result;
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();
        ChiTietThietBi cttb = new ChiTietThietBi();
        cttb.setSerial(Serial);
        ChiTietThietBiService CTTBService = new ChiTietThietBiService(session);
        CTTBService.getIDAO().Begin();
        if(CTTBService.XoaChiTietThietBi(cttb) ==-1 )
        {
            CTTBService.getIDAO().Rollback();
            /* result duoc dua qua ajax xu ly, -1 => loi, 1 la thanh cong */
            result = "-1";

        } else {
            try {
                CTTBService.getIDAO().Save();
                result = "0";
            } catch (Exception e) {
                e.printStackTrace();
                CTTBService.getIDAO().Rollback();
                result = "-1";
            }

        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value="/QuanLyChiTietThietBi/CapNhatChiTietThietBi",method = RequestMethod.POST)
    public String CapNhatChiTietThietBi(
            @RequestParam(required = true, name = "Serial") String Serial,
            @RequestParam(required = false, name = "TinhTrang") String TinhTrang,
            @RequestParam(required = false, name = "MaPhong") String MaPhong,
            @RequestParam(required = false, name = "MaDNH") String MaDNH,
            @RequestParam(required = false, name = "MaThietBi") String MaThietBi,
            HttpServletRequest request, HttpServletResponse response
    )
    {
        String result;
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();

        PhongBase phong = new PhongBase();
        phong.setSoPhong(MaPhong);

        ThietBi tb = new ThietBi();
        tb.setMaThietBi(MaThietBi);

        ChiTietThietBi cttb = new ChiTietThietBi();
        cttb.setSerial(Serial);
        cttb.setMaDNH(MaDNH);
        cttb.setPhong(phong);
        cttb.setThietBi(tb);
        cttb.setTinhTrang(TinhTrang);

        ChiTietThietBiService CTTBService = new ChiTietThietBiService(session);
        CTTBService.getIDAO().Begin();

        if(  CTTBService.SuaChiTietThietBi(cttb)==-1)
        {
            CTTBService.getIDAO().Rollback();
            result = "-1";

        }
        else
        {
            try{
                CTTBService.getIDAO().Save();
                result = "1";
            }
            catch (Exception e)
            {
                e.printStackTrace();
                CTTBService.getIDAO().Rollback();
                result = "-1";
            }

        }
        return result;
    }
}
