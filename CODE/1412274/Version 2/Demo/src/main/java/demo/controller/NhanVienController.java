package demo.controller;

import demo.model.NhanVien;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import demo.service.INhanVienService;
import demo.service.NhanVienService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
import java.text.*;

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

    @ResponseBody
    @RequestMapping(value = "/ThemNhanVien", method = RequestMethod.POST)
    public String XacNhanThemNhanVien(@RequestParam(required=false, name="TenNV") String TenNV,
                                @RequestParam(required=false, name="GioiTinh") String GioiTinh,
                                @RequestParam(required=false, name="NgaySinh") String NgaySinh,
                                @RequestParam(required=false, name="DiaChi") String DiaChi,
                                @RequestParam(required=false, name="SoDT") String SoDT,
                                @RequestParam(required=false, name="SoCMND") String SoCMND,
                                HttpServletRequest request, HttpServletResponse response) {
        NhanVien nhanvien = new NhanVien();

        String result = "";
        String manvtemp = NVService.LayMaLonNhat();

        int SoNVTiepTheo = Integer.parseInt(manvtemp.substring(2)) + 1;
        int SoLuongSo0 = 4 - Integer.toString(SoNVTiepTheo).length();
        String MaNVTiepTheo = "NV";

        for (int i = 0; i < SoLuongSo0; i++) {
            MaNVTiepTheo += "0";
        }

        MaNVTiepTheo += SoNVTiepTheo;

        Date today = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        nhanvien.setMaNV(MaNVTiepTheo);
        nhanvien.setTenNV(TenNV);
        nhanvien.setGioiTinh(GioiTinh);
        nhanvien.setNgaySinh(NgaySinh);
        nhanvien.setDiaChi(DiaChi);
        nhanvien.setSoDT(SoDT);
        nhanvien.setSoCMND(SoCMND);
        nhanvien.setLuong("300000vnd");
        nhanvien.setMatKhau(MaNVTiepTheo);
        nhanvien.setNgayTao(dateFormat.format(today));
        nhanvien.setNgayCapNhat(dateFormat.format(today));

        if (NVService.ThemNhanVien(nhanvien) == -1)
            result = "Error";
        else
            result = MaNVTiepTheo;
        return result;
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
                                  @RequestParam(required=false, name="Luong") String Luong,
                                  @RequestParam(required=false, name="MatKhau") String MatKhau,
                                  @RequestParam(required=false, name="NgayTao") String NgayTao,
                                  @RequestParam(required=false, name="NgayCapNhat") String NgayCapNhat,
                                  HttpServletRequest request, HttpServletResponse response) {
        NhanVien nhanvien = new NhanVien();

        Date today = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        NgayCapNhat = dateFormat.format(today);

        nhanvien.setMaNV(MaNV);
        nhanvien.setTenNV(TenNV);
        nhanvien.setGioiTinh(GioiTinh);
        nhanvien.setNgaySinh(NgaySinh);
        nhanvien.setDiaChi(DiaChi);
        nhanvien.setSoDT(SoDT);
        nhanvien.setSoCMND(SoCMND);
        nhanvien.setLuong(Luong);
        nhanvien.setMatKhau(MatKhau);
        nhanvien.setNgayTao(NgayTao);
        nhanvien.setNgayCapNhat(NgayCapNhat);

        return Integer.toString(NVService.CapNhatNhanVien(nhanvien));
    }
}



