package demo.controller;

import demo.hibernate.HibernateUtils;
import demo.model.*;
import demo.service.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThongTinDatPhongController {
    private ILoaiPhongService LPService;
    private IPhongService PService;
    private IKhachHangService KHService;
    private IThongTinDatPhongService TTDPService;
    private IChiTietThongTinDatPhongService CTTTDPService;

    @RequestMapping(value = "/DatPhongOffline", method = RequestMethod.GET)
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
                PService.getIDAO().Rollback();
                DSLP = null;
            }
        }

        model.addAttribute("active", "dpoff");
        model.addAttribute("DSLP", DSLP);

        return "DatPhongOffline";
    }

    @RequestMapping(value = "/TimPhong", method = RequestMethod.POST)
    public @ResponseBody List<PhongBase> TimPhong(@RequestBody CacYeuCauVePhong CacYeuCauVePhong) {
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();

        PService = new PhongService(session);

        PService.getIDAO().Begin();

        List<PhongBase> DSP = new ArrayList<PhongBase>();

        DSP = PService.TimPhongPhuHop(CacYeuCauVePhong);

        if (DSP == null) {
            PService.getIDAO().Rollback();
        } else {
            try {
                PService.getIDAO().Save();
            } catch (Exception e) {
                e.printStackTrace();
                PService.getIDAO().Rollback();
                DSP = null;
            }
        }

        return DSP;
    }

    @RequestMapping(value = "/DatPhong", method = RequestMethod.POST)
    public @ResponseBody String DatPhong(@RequestBody ToanBoThongTinDeDatPhong ToanBoThongTinDeDatPhong) {
        System.out.print("\nPhong: " + ToanBoThongTinDeDatPhong.getCacPhongKHMuonDat()[0]);
        System.out.print("\nSo luong phong: " + ToanBoThongTinDeDatPhong.getThongTinDatPhong().getSoLuongPhong());
        System.out.print("\nThoi gian nhan phong: " + ToanBoThongTinDeDatPhong.getThongTinDatPhong().getThoiGianNhanPhong());
        System.out.print("\nTen khach hang: " + ToanBoThongTinDeDatPhong.getThongTinKhachHang().getHoTen());

        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();

        String DatPhong_Message = "";

        KHService = new KhachHangService(session);
        TTDPService = new ThongTinDatPhongService(session);
        CTTTDPService = new ChiTietThongTinDatPhongService(session);
        KHService.getIDAO().Begin();

        //Tạo mã khách hàng tiếp theo
        String MaKHLonNhatHienTai = KHService.LayMaKHLonNhat();

        if (MaKHLonNhatHienTai == "Error") {
            KHService.getIDAO().Rollback();
            DatPhong_Message = "failed";
        } else {
            int KHTiepTheo = Integer.parseInt(MaKHLonNhatHienTai.substring(2)) + 1;
            int SoLuongSo0 = 5 - Integer.toString(KHTiepTheo).length();
            String MaKHTiepTheo = "KH";

            for (int i = 0; i < SoLuongSo0; i++) {
                MaKHTiepTheo += "0";
            }

            MaKHTiepTheo += KHTiepTheo;
            System.out.println("Ma kh tiep theo: " + MaKHTiepTheo);

            //Tạo mã thông tin đặt phòng tiếp theo
            String MaThongTinDatPhongLonNhatHienTai = TTDPService.LayMaThongTinDatPhongLonNhat();

            if (MaThongTinDatPhongLonNhatHienTai == "Error") {
                KHService.getIDAO().Rollback();
                DatPhong_Message = "failed";
            } else {
                int TTDPTiepTheo = Integer.parseInt(MaThongTinDatPhongLonNhatHienTai.substring(4)) + 1;
                SoLuongSo0 = 4 - Integer.toString(TTDPTiepTheo).length();
                String MaTTDPTiepTheo = "TTDP";

                for (int i = 0; i < SoLuongSo0; i++) {
                    MaTTDPTiepTheo += "0";
                }

                MaTTDPTiepTheo += TTDPTiepTheo;
                System.out.println("Ma ttdp tiep theo: " + MaTTDPTiepTheo);

                //Set các thông tin
                ToanBoThongTinDeDatPhong.getThongTinKhachHang().setMaKH(MaKHTiepTheo);
                ToanBoThongTinDeDatPhong.getThongTinDatPhong().setMaThongTinDatPhong(MaTTDPTiepTheo);
                ToanBoThongTinDeDatPhong.getThongTinDatPhong().setKhachHang(ToanBoThongTinDeDatPhong.getThongTinKhachHang());

                //Bắt đầu thêm
                if (KHService.ThemKH(ToanBoThongTinDeDatPhong.getThongTinKhachHang()) == 0 &&
                        TTDPService.ThemThongTinDatPhong(ToanBoThongTinDeDatPhong.getThongTinDatPhong()) == 0) {
                    int KetQua = 0;

                    for(int i = 0; i < ToanBoThongTinDeDatPhong.getCacPhongKHMuonDat().length; i++) {
                        String SoPhong = ToanBoThongTinDeDatPhong.getCacPhongKHMuonDat()[i].getSoPhong();
                        int GiaHT = ToanBoThongTinDeDatPhong.getCacPhongKHMuonDat()[i].getGiaHienTai();

                        System.out.println("So phong: " + SoPhong);
                        System.out.println("Gia HT: " + GiaHT);

                        ChiTietThongTinDatPhongBase CTTTDP = new ChiTietThongTinDatPhongBase(
                                new ChiTietThongTinDatPhongBasePK(MaTTDPTiepTheo, SoPhong), GiaHT,
                                new PhongBase(SoPhong),
                                ToanBoThongTinDeDatPhong.getThongTinDatPhong());

                        KetQua = CTTTDPService.ThemChiTietThongTinDatPhong(CTTTDP);

                        if (KetQua == -1) {
                            break;
                        }
                    }

                    if (KetQua == 0) {
                        try {
                            KHService.getIDAO().Save();
                            DatPhong_Message = "Successfully";
                        } catch (Exception e) {
                            e.printStackTrace();
                            KHService.getIDAO().Rollback();
                            DatPhong_Message =  "failed";
                        }
                    }
                    else {
                        KHService.getIDAO().Rollback();
                        DatPhong_Message =  "failed";
                    }
                } else {
                    KHService.getIDAO().Rollback();
                    DatPhong_Message =  "failed";
                }
            }
        }

        System.out.print("\nTin nhan dat phong: " + DatPhong_Message);

        return DatPhong_Message;
    }
}
