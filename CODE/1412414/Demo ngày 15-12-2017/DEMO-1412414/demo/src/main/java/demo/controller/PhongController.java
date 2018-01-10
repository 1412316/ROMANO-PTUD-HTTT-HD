package demo.controller;

import demo.model.LoaiPhongBase;
import demo.model.PhongBase;
import demo.service.ILoaiPhongService;
import demo.service.IPhongService;
import demo.service.LoaiPhongService;
import demo.service.PhongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
public class PhongController {
    private IPhongService PService = new PhongService();

    @RequestMapping(value = "/QuanLyPhong", method = RequestMethod.GET)
    public String index(Model model) {
        ILoaiPhongService LPService = new LoaiPhongService();

        model.addAttribute("active", "qlp");
        model.addAttribute("DSP", PService.XemPhong(null));
        model.addAttribute("DSLP", LPService.XemLoaiPhong(null));

        return "QuanLyPhong";
    }

    @ResponseBody
    @RequestMapping(value = "/ThemPhong", method = RequestMethod.POST)
    public String ThemPhong(@RequestParam(required=false, name="SoPhong") String SoPhong,
                            @RequestParam(required=false,name="GiaHienTai") int GiaHienTai,
                            @RequestParam(required=false,name="ViTri") String ViTri,
                            @RequestParam(required=false,name="MoTa") String MoTa,
                            @RequestParam(required=false,name="Tang") String Tang,
                            @RequestParam(required=false,name="SoLuongGiuong") int SoLuongGiuong,
                            @RequestParam(required=false,name="LoaiPhong") int LoaiPhong,
                            HttpServletRequest request, HttpServletResponse response) {

        PhongBase Phong = new PhongBase();

        Phong.setSoPhong(SoPhong);
        Phong.setGiaHienTai(GiaHienTai);
        Phong.setViTri(ViTri);
        Phong.setMoTa(MoTa);
        Phong.setTang(Tang);
        Phong.setSoLuongGiuong(SoLuongGiuong);

        LoaiPhongBase LP = new LoaiPhongBase();
        LP.setMaLoaiPhong(LoaiPhong);

        Phong.setLoaiPhong(LP);
        Phong.setNgayTao(new Date().toString().substring(0, 10));
        Phong.setNgayCapNhat(new Date().toString().substring(0, 10));

        return Integer.toString(PService.ThemPhong(Phong));
    }

    @ResponseBody
    @RequestMapping(value = "/XoaPhong", method = RequestMethod.POST)
    public String XoaPhong(@RequestParam(required=false, name="SoPhong") String SoPhong,
                               HttpServletRequest request, HttpServletResponse response) {

        return Integer.toString(PService.XoaPhong(SoPhong));
    }

    @ResponseBody
    @RequestMapping(value = "/CapNhatPhong", method = RequestMethod.POST)
    public String CapNhatLoaiPhong(@RequestParam(required=false, name="SoPhong") String SoPhong,
                                   @RequestParam(required=false,name="GiaHienTai") int GiaHienTai,
                                   @RequestParam(required=false,name="ViTri") String ViTri,
                                   @RequestParam(required=false,name="MoTa") String MoTa,
                                   @RequestParam(required=false,name="Tang") String Tang,
                                   @RequestParam(required=false,name="SoLuongGiuong") int SoLuongGiuong,
                                   @RequestParam(required=false,name="LoaiPhong") int LoaiPhong,
                                   HttpServletRequest request, HttpServletResponse response) {

        PhongBase Phong = new PhongBase();

        Phong.setSoPhong(SoPhong);
        Phong.setGiaHienTai(GiaHienTai);
        Phong.setViTri(ViTri);
        Phong.setMoTa(MoTa);
        Phong.setTang(Tang);
        Phong.setSoLuongGiuong(SoLuongGiuong);

        LoaiPhongBase LP = new LoaiPhongBase();
        LP.setMaLoaiPhong(LoaiPhong);

        Phong.setLoaiPhong(LP);
        Phong.setNgayCapNhat(new Date().toString().substring(0, 10));

        return Integer.toString(PService.CapNhatPhong(Phong));
    }
}
