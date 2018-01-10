package demo.service;


import demo.dao.IUnitOfWork;
import demo.dao.UnitOfWork;
import demo.model.CacYeuCauVePhong;
import demo.model.ChiTietThongTinDatPhongBase;
import demo.model.PhongBase;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class PhongService implements IPhongService {
    private IUnitOfWork<PhongBase> IDAO;

    public PhongService(Session session) {
        IDAO = new UnitOfWork<PhongBase>(session);
    }

    public List<PhongBase> XemPhong() {
        String sql = "select p from " + PhongBase.class.getName() + " p";

        return IDAO.Repository().Select(sql);
    }

    public int XoaPhong(String SoPhong) {
        String sql = "delete " + PhongBase.class.getName() + " where SoPhong = " + SoPhong;

        return IDAO.Repository().Delete(sql);
    }

    public int CapNhatPhong(PhongBase Phong) {
        return IDAO.Repository().Update(Phong);
    }

    public int ThemPhong(PhongBase Phong) {
        return IDAO.Repository().Add(Phong);
    }

    public List<PhongBase> TimPhongPhuHop(CacYeuCauVePhong CacYeuCauVePhong) {
        List<PhongBase> DSPhong = new ArrayList<PhongBase>();
        String sql = "";

        for (int i = 0; i < CacYeuCauVePhong.getCacYeuCauVePhong().size(); i++) {
            sql = "select p from " + PhongBase.class.getName() + " p" +
                    " where p.GiaHienTai >= :GiaNhoNhat" +
                    " and p.GiaHienTai <= :GiaLonNhat" +
                    " and p.ViTri like :ViTri" +
                    " and p.Tang = :Tang" +
                    " and p.SoLuongGiuong = :SoLuongGiuong" +
                    " and p.LoaiPhong.MaLoaiPhong = :MaLoaiPhong" +
                    " and p.LoaiPhong.LoaiGiuong like :LoaiGiuong" +
                    " and not exists(from " + ChiTietThongTinDatPhongBase.class.getName() + " ct" +
                    " where ct.Phong.SoPhong = p.SoPhong" +
                    " and (" +
                    "(ct.ThongTinDatPhong.ThoiGianNhanPhong >= :ThoiGianNhanPhong" +
                    " and ct.ThongTinDatPhong.ThoiGianNhanPhong <= :ThoiGianTraPhong)" +
                    " or (ct.ThongTinDatPhong.ThoiGianTraPhong >= :ThoiGianNhanPhong" +
                    " and ct.ThongTinDatPhong.ThoiGianTraPhong <= :ThoiGianTraPhong)" +
                    " or (ct.ThongTinDatPhong.ThoiGianNhanPhong <= :ThoiGianNhanPhong" +
                    " and ct.ThongTinDatPhong.ThoiGianTraPhong >= :ThoiGianTraPhong)" +
                    ")" +
                    ")";

            DSPhong.addAll(IDAO.Repository().Select(sql,
                    CacYeuCauVePhong.getCacYeuCauVePhong().get(i).getGiaNhoNhat(),
                    CacYeuCauVePhong.getCacYeuCauVePhong().get(i).getGiaLonNhat(),
                    CacYeuCauVePhong.getCacYeuCauVePhong().get(i).getViTri(),
                    Integer.toString(CacYeuCauVePhong.getCacYeuCauVePhong().get(i).getTang()),
                    CacYeuCauVePhong.getCacYeuCauVePhong().get(i).getSoLuongGiuong(),
                    CacYeuCauVePhong.getCacYeuCauVePhong().get(i).getLoaiPhong(),
                    CacYeuCauVePhong.getCacYeuCauVePhong().get(i).getLoaiGiuong(),
                    CacYeuCauVePhong.getCacYeuCauVePhong().get(i).getThoiGianNhanPhong(),
                    CacYeuCauVePhong.getCacYeuCauVePhong().get(i).getThoiGianTraPhong()));
        }

        for (int i = 0; i < CacYeuCauVePhong.getCacYeuCauVePhong().size(); i++) {
            sql = "select p from " + PhongBase.class.getName() + " p" +
                    " where p.GiaHienTai >= :GiaNhoNhat" +
                    " and p.GiaHienTai <= :GiaLonNhat" +
                    " and p.LoaiPhong.MaLoaiPhong = :MaLoaiPhong" +
                    " and not exists(from " + ChiTietThongTinDatPhongBase.class.getName() + " ct" +
                    " where ct.Phong.SoPhong = p.SoPhong" +
                    " and (" +
                    "(ct.ThongTinDatPhong.ThoiGianNhanPhong >= :ThoiGianNhanPhong" +
                    " and ct.ThongTinDatPhong.ThoiGianNhanPhong <= :ThoiGianTraPhong)" +
                    " or (ct.ThongTinDatPhong.ThoiGianTraPhong >= :ThoiGianNhanPhong" +
                    " and ct.ThongTinDatPhong.ThoiGianTraPhong <= :ThoiGianTraPhong)" +
                    " or (ct.ThongTinDatPhong.ThoiGianNhanPhong <= :ThoiGianNhanPhong" +
                    " and ct.ThongTinDatPhong.ThoiGianTraPhong >= :ThoiGianTraPhong)" +
                    ")" +
                    ")";

            DSPhong.addAll(IDAO.Repository().Select(sql,
                    CacYeuCauVePhong.getCacYeuCauVePhong().get(i).getGiaNhoNhat(),
                    CacYeuCauVePhong.getCacYeuCauVePhong().get(i).getGiaLonNhat(),
                    CacYeuCauVePhong.getCacYeuCauVePhong().get(i).getLoaiPhong(),
                    CacYeuCauVePhong.getCacYeuCauVePhong().get(i).getThoiGianNhanPhong(),
                    CacYeuCauVePhong.getCacYeuCauVePhong().get(i).getThoiGianTraPhong()));
        }

        return DSPhong;
    }

    public IUnitOfWork<PhongBase> getIDAO() {
        return IDAO;
    }
}
