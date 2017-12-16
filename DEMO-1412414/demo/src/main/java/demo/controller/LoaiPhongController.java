package demo.controller;

import demo.model.LoaiPhongBase;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import demo.service.ILoaiPhongService;
import demo.service.LoaiPhongService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Date;

@Controller
public class LoaiPhongController {
    private ILoaiPhongService LPService = new LoaiPhongService();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("active", "qllp");
        model.addAttribute("DSLP", LPService.XemLoaiPhong(null));
        return "QuanLyLoaiPhong";
    }

    @ResponseBody
    @RequestMapping(value = "/ThemLoaiPhong", method = RequestMethod.POST)
    public String ThemLoaiPhong(@RequestParam(required=false, name="TenLoaiPhong") String TenLoaiPhong,
                             @RequestParam(required=false,name="MoTa") String MoTa,
                             @RequestParam(required=false,name="LoaiGiuong") String LoaiGiuong,
                             HttpServletRequest request, HttpServletResponse response) {
        LoaiPhongBase LoaiPhong = new LoaiPhongBase();

        LoaiPhong.setTenLoaiPhong(TenLoaiPhong);
        LoaiPhong.setMoTa(MoTa);
        LoaiPhong.setLoaiGiuong(LoaiGiuong);
        LoaiPhong.setNgayTao(new Date().toString().substring(0, 10));
        LoaiPhong.setNgayCapNhat(new Date().toString().substring(0, 10));

        return Integer.toString(LPService.ThemLoaiPhong(LoaiPhong));
    }

    @ResponseBody
    @RequestMapping(value = "/XoaLoaiPhong", method = RequestMethod.POST)
    public String XoaLoaiPhong(@RequestParam(required=false, name="MaLoaiPhong") int MaLoaiPhong,
                                HttpServletRequest request, HttpServletResponse response) {

        return Integer.toString(LPService.XoaLoaiPhong(MaLoaiPhong));
    }

    @ResponseBody
    @RequestMapping(value = "/CapNhatLoaiPhong", method = RequestMethod.POST)
    public String CapNhatLoaiPhong(@RequestParam(required=false, name="MaLoaiPhong") int MaLoaiPhong,
                                   @RequestParam(required=false, name="TenLoaiPhong") String TenLoaiPhong,
                                   @RequestParam(required=false,name="MoTa") String MoTa,
                                   @RequestParam(required=false,name="LoaiGiuong") String LoaiGiuong,
                                   HttpServletRequest request, HttpServletResponse response) {

        LoaiPhongBase LoaiPhong = new LoaiPhongBase();

        LoaiPhong.setMaLoaiPhong(MaLoaiPhong);
        LoaiPhong.setTenLoaiPhong(TenLoaiPhong);
        LoaiPhong.setMoTa(MoTa);
        LoaiPhong.setLoaiGiuong(LoaiGiuong);
        LoaiPhong.setNgayCapNhat(new Date().toString().substring(0, 10));

        return Integer.toString(LPService.CapNhatLoaiPhong(LoaiPhong));
    }
}
