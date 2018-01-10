package demo.model;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Phong")
public class PhongBase {
    @Id
    @Column(name = "SoPhong")
    private String SoPhong;

    @Column(name = "GiaHienTai")
    int GiaHienTai;

    @Column(name = "ViTri")
    @Nationalized
    String ViTri;

    @Column(name = "MoTa")
    @Nationalized
    String MoTa;

    @Column(name = "Tang")
    String Tang;

    @Column(name = "SoLuongGiuong")
    int SoLuongGiuong;

    @Column(name = "NgayTao")
    String NgayTao;

    @Column(name = "NgayCapNhat")
    String NgayCapNhat;

    @ManyToOne
    @JoinColumn(name = "LoaiPhong")
    private LoaiPhongBase LoaiPhong;

    public PhongBase() {

    }

    public PhongBase(String soPhong) {
        SoPhong = soPhong;
    }

    public PhongBase(String soPhong, int giaHienTai, String viTri, String moTa,
                     String tang, int soLuongGiuong, LoaiPhongBase loaiPhong) {
        SoPhong = soPhong;
        GiaHienTai = giaHienTai;
        ViTri = viTri;
        MoTa = moTa;
        Tang = tang;
        SoLuongGiuong = soLuongGiuong;
        NgayTao = new Date().toString().substring(0, 10);
        NgayCapNhat = new Date().toString().substring(0, 10);
        LoaiPhong = loaiPhong;
    }

    public PhongBase(String soPhong, int giaHienTai, String viTri, String moTa, String tang, int soLuongGiuong, String ngayTao, String ngayCapNhat, LoaiPhongBase loaiPhong) {
        SoPhong = soPhong;
        GiaHienTai = giaHienTai;
        ViTri = viTri;
        MoTa = moTa;
        Tang = tang;
        SoLuongGiuong = soLuongGiuong;
        NgayTao = ngayTao;
        NgayCapNhat = ngayCapNhat;
        LoaiPhong = loaiPhong;
    }

    public String getSoPhong() {
        return this.SoPhong;
    }

    public void setSoPhong(String SoPhong) {
        this.SoPhong = SoPhong;
    }

    public int getGiaHienTai() {
        return this.GiaHienTai;
    }

    public void setGiaHienTai(int GiaHienTai) {
        this.GiaHienTai = GiaHienTai;
    }

    public String getViTri() {
        return this.ViTri;
    }

    public void setViTri(String ViTri) {
        this.ViTri = ViTri;
    }

    public String getMoTa() {
        return this.MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public String getTang() {
        return this.Tang;
    }

    public void setTang(String Tang) {
        this.Tang = Tang;
    }

    public int getSoLuongGiuong() {
        return this.SoLuongGiuong;
    }

    public void setSoLuongGiuong(int SoLuongGiuong) {
        this.SoLuongGiuong = SoLuongGiuong;
    }

    public LoaiPhongBase getLoaiPhong() {
        return this.LoaiPhong;
    }

    public void setLoaiPhong(LoaiPhongBase LoaiPhong) {
        this.LoaiPhong = LoaiPhong;
    }

    public String getNgayCapNhat() {
        return this.NgayCapNhat;
    }

    public void setNgayCapNhat(String NgayCapNhat) {
        this.NgayCapNhat = NgayCapNhat;
    }

    public String getNgayTao() {
        return this.NgayTao;
    }

    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }
}
