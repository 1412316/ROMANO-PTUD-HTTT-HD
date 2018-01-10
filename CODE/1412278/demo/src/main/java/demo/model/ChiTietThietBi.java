package demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ChiTietThietBi")
public class ChiTietThietBi implements Serializable {
    @Id
    @Column(name="Serial")
    private String Serial;
    @Column(name="TinhTrang")
    private String TinhTrang;
    @ManyToOne
    @JoinColumn(name = "MaPhong")
    private PhongBase Phong;
    @Column(name="MaDNH")
    private String MaDNH;
    @Column(name="NgayTao")
    private String NgayTao;
    @Column(name="NgayCapNhat")
    private String NgayCapNhat;
    @ManyToOne
    @JoinColumn(name = "MaThietBi")
    private ThietBi ThietBi;

    public String getMaDNH() {
        return MaDNH;
    }

    public void setMaDNH(String maDNH) {
        MaDNH = maDNH;
    }

    public demo.model.ThietBi getThietBi() {
        return ThietBi;
    }

    public void setThietBi(demo.model.ThietBi thietBi) {
        ThietBi = thietBi;
    }

    public PhongBase getPhong() {
        return Phong;
    }

    public void setPhong(PhongBase phong) {
        Phong = phong;
    }

    public String getSerial() {
        return Serial;
    }

    public void setSerial(String serial) {
        Serial = serial;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        TinhTrang = tinhTrang;
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

    public ChiTietThietBi() {
    }
}
