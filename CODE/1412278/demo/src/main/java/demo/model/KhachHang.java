package demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown=true)
@Entity
@Table(name = "KhachHang")
public class KhachHang {
    @Id
    @Column(name = "MaKH")
    private String MaKH;

    @Column(name = "HoTen")
    @Nationalized
    @JsonProperty("HoTen")
    private String HoTen;

    @Column(name = "GioiTinh")
    @Nationalized
    @JsonProperty("GioiTinh")
    private String GioiTinh;

    @Column(name = "NgaySinh")
    @JsonProperty("NgaySinh")
    private String NgaySinh;

    @Column(name = "CMND")
    @JsonProperty("CMND")
    private String CMND;

    @ManyToOne
    @JoinColumn(name = "Email")
    private TaiKhoan TaiKhoan;

    @Column(name = "SDT")
    @JsonProperty("SDT")
    private String SDT;

    @Column(name = "DiaChi")
    @Nationalized
    @JsonProperty("DiaChi")
    private String DiaChi;

    @Column(name = "LoaiKH")
    @JsonProperty("LoaiKH")
    private int LoaiKH;

    @Column(name = "NgayTao")
    private String NgayTao;

    @Column(name = "NgayCapNhat")
    private String NgayCapNhat;

    @JsonCreator
    public KhachHang(@JsonProperty("HoTen") String hoTen, @JsonProperty("GioiTinh") String gioiTinh,
                     @JsonProperty("NgaySinh") String ngaySinh, @JsonProperty("CMND") String CMND,
                     @JsonProperty("SDT") String SDT, @JsonProperty("DiaChi") String diaChi,
                     @JsonProperty("LoaiKH") int loaiKH) {
        HoTen = hoTen;
        GioiTinh = gioiTinh;
        NgaySinh = ngaySinh;
        this.CMND = CMND;
        this.SDT = SDT;
        DiaChi = diaChi;
        LoaiKH = loaiKH;
        NgayTao = new Date().toString().substring(0, 10);
        NgayCapNhat = new Date().toString().substring(0, 10);
    }

    public KhachHang(String maKH, String hoTen, String gioiTinh, String ngaySinh, String CMND, TaiKhoan taiKhoan,
                     String SDT, String diaChi, int loaiKH, String ngayTao, String ngayCapNhat) {
        MaKH = maKH;
        HoTen = hoTen;
        GioiTinh = gioiTinh;
        NgaySinh = ngaySinh;
        this.CMND = CMND;
        this.TaiKhoan = taiKhoan;
        this.SDT = SDT;
        DiaChi = diaChi;
        LoaiKH = loaiKH;
        NgayTao = ngayTao;
        NgayCapNhat = ngayCapNhat;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String maKH) {
        MaKH = maKH;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public TaiKhoan getTaiKhoan() {
        return TaiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        TaiKhoan = taiKhoan;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public int getLoaiKH() {
        return LoaiKH;
    }

    public void setLoaiKH(int loaiKH) {
        LoaiKH = loaiKH;
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
