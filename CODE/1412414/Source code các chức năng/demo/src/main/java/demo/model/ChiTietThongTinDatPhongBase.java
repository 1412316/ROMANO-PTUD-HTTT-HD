package demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ChiTietThongTinDatPhong")
public class ChiTietThongTinDatPhongBase implements Serializable {
    @EmbeddedId
    protected  ChiTietThongTinDatPhongBasePK ChiTietThongTinDatPhongBasePK;

    @ManyToOne
    @JoinColumn(name = "SoPhong", referencedColumnName = "SoPhong", insertable = false, updatable = false)
    private PhongBase Phong;

    @ManyToOne
    @JoinColumn(name = "MaThongTinDatPhong", referencedColumnName = "MaThongTinDatPhong",
            insertable = false, updatable = false)
    private ThongTinDatPhongBase  ThongTinDatPhong;

    @Column(name = "TienPhong")
    private int TienPhong;

    @Column(name = "NgayTao")
    private String NgayTao;

    @Column(name = "NgayCapNhat")
    private String NgayCapNhat;

    public ChiTietThongTinDatPhongBase(demo.model.ChiTietThongTinDatPhongBasePK chiTietThongTinDatPhongBasePK,
                                       int tienPhong, PhongBase phong, ThongTinDatPhongBase  thongTinDatPhong) {
        ChiTietThongTinDatPhongBasePK = chiTietThongTinDatPhongBasePK;
        TienPhong = tienPhong;
        NgayTao = new Date().toString().substring(0, 10);;
        NgayCapNhat = new Date().toString().substring(0, 10);
        Phong = phong;
        ThongTinDatPhong = thongTinDatPhong;
    }

    public ChiTietThongTinDatPhongBase(demo.model.ChiTietThongTinDatPhongBasePK chiTietThongTinDatPhongBasePK,
                                       PhongBase phong, ThongTinDatPhongBase thongTinDatPhong, int tienPhong,
                                       String ngayTao, String ngayCapNhat) {
        ChiTietThongTinDatPhongBasePK = chiTietThongTinDatPhongBasePK;
        Phong = phong;
        ThongTinDatPhong = thongTinDatPhong;
        TienPhong = tienPhong;
        NgayTao = ngayTao;
        NgayCapNhat = ngayCapNhat;
    }

    public demo.model.ChiTietThongTinDatPhongBasePK getChiTietThongTinDatPhongBasePK() {
        return ChiTietThongTinDatPhongBasePK;
    }

    public void setChiTietThongTinDatPhongBasePK(demo.model.ChiTietThongTinDatPhongBasePK chiTietThongTinDatPhongBasePK) {
        ChiTietThongTinDatPhongBasePK = chiTietThongTinDatPhongBasePK;
    }

    public PhongBase getPhong() {
        return Phong;
    }

    public void setPhong(PhongBase phong) {
        Phong = phong;
    }

    public ThongTinDatPhongBase getThongTinDatPhong() {
        return ThongTinDatPhong;
    }

    public void setThongTinDatPhong(ThongTinDatPhongBase thongTinDatPhong) {
        ThongTinDatPhong = thongTinDatPhong;
    }

    public int getTienPhong() {
        return TienPhong;
    }

    public void setTienPhong(int tienPhong) {
        TienPhong = tienPhong;
    }

    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String ngayTao) {
        NgayTao = ngayTao;
    }

    public String getNgayCapNhat() {
        return NgayCapNhat;
    }

    public void setNgayCapNhat(String ngayCapNhat) {
        NgayCapNhat = ngayCapNhat;
    }
}
