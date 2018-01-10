package demo.controller;

import demo.model.NhanVien;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import demo.service.INhanVienService;
import demo.service.NhanVienService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Date;

@Controller
public class NhanVienController {
    private INhanVienService NVService = new NhanVienService();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        NhanVien nv = new NhanVien();
        model.addAttribute("active", "qlnv");
        model.addAttribute("DSNV", NVService.XemNhanVien(nv));
        return "QuanLyNhanVien";
    }

    @RequestMapping(value = "/XemChiTiet/{MaNV}", method = RequestMethod.GET)
    public String XemChiTiet(Model model, @PathVariable("MaNV") String MaNV) {
        //NhanVien nv = new NhanVien();
        System.out.println("Ma nhan vien: " + MaNV);

        model.addAttribute("NV", NVService.XemMotNhanVien(MaNV));
        return "XemChiTiet";
    }

    @ResponseBody
    @RequestMapping(value = "/XoaNhanVien", method = RequestMethod.POST)
    public String XoaNhanVien(@RequestParam(required=false, name="MaNV") String MaNV,
                               HttpServletRequest request, HttpServletResponse response) {

        return Integer.toString(NVService.XoaNhanVien(MaNV));
    }

    @RequestMapping(value = "/ThemNhanVien", method = RequestMethod.GET)
    public String ThemNhanVien(Model model) {
        return "ThemNhanVien";
    }

    @ResponseBody
    @RequestMapping(value = "/XacNhanThemNhanVien", method = RequestMethod.POST)
    public String XacNhanThemNhanVien(@RequestParam(required=false, name="TenNV") String TenNV,
                                @RequestParam(required=false, name="GioiTinh") String GioiTinh,
                                @RequestParam(required=false, name="NgaySinh") String NgaySinh,
                                @RequestParam(required=false, name="DiaChi") String DiaChi,
                                @RequestParam(required=false, name="SoDT") String SoDT,
                                @RequestParam(required=false, name="SoCMND") String SoCMND,
                                HttpServletRequest request, HttpServletResponse response) {
        NhanVien nhanvien = new NhanVien();

        nhanvien.setTenNV(TenNV);
        nhanvien.setGioiTinh(GioiTinh);
        nhanvien.setNgaySinh(NgaySinh);
        nhanvien.setDiaChi(DiaChi);
        nhanvien.setSoDT(SoDT);
        nhanvien.setSoCMND(SoCMND);

        return Integer.toString(NVService.ThemNhanVien(nhanvien));
    }

    @ResponseBody
    @RequestMapping(value = "/CapNhatNhanVien", method = RequestMethod.POST)
    public String CapNhatNhanVien(@RequestParam(required=false, name="MaNV") String MaNV,
                                  @RequestParam(required=false, name="TenNV") String TenNV,
                                  @RequestParam(required=false, name="GioiTinh") String GioiTinh,
                                  @RequestParam(required=false, name="NgaySinh") String NgaySinh,
                                  @RequestParam(required=false, name="DiaChi") String DiaChi,
                                  @RequestParam(required=false, name="SoDT") String SoDT,
                                  @RequestParam(required=false, name="SoCMND") String SoCMND,
                                  HttpServletRequest request, HttpServletResponse response) {
        NhanVien nhanvien = new NhanVien();

        nhanvien.setMaNV(MaNV);
        nhanvien.setTenNV(TenNV);
        nhanvien.setGioiTinh(GioiTinh);
        nhanvien.setNgaySinh(NgaySinh);
        nhanvien.setDiaChi(DiaChi);
        nhanvien.setSoDT(SoDT);
        nhanvien.setSoCMND(SoCMND);

        return Integer.toString(NVService.CapNhatNhanVien(nhanvien));
    }
}



