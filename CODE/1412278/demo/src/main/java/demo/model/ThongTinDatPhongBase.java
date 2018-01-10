package demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown=true)
@Entity
@Table(name = "ThongTinDatPhong")
public class ThongTinDatPhongBase {
    @Id
    @Column(name = "MaThongTinDatPhong")
    private String MaThongTinDatPhong;

    @JsonProperty("SoNguoi")
    @Column(name = "SoNguoi")
    private int SoNguoi;

    @Column(name = "ThoiGianDatPhong")
    private String ThoiGianDatPhong;

    @JsonProperty("ThoiGianNhanPhong")
    @Column(name = "ThoiGianNhanPhong")
    private String ThoiGianNhanPhong;

    @JsonProperty("ThoiGianTraPhong")
    @Column(name = "ThoiGianTraPhong")
    private String ThoiGianTraPhong;

    @Column(name = "ThoiGianHuyPhong")
    private String ThoiGianHuyPhong;

    @Nationalized
    @Column(name = "LyDoHuyPhong")
    private String LyDoHuyPhong;

    @Nationalized
    @Column(name = "TinhTrangThanhToan")
    private String TinhTrangThanhToan;

    @ManyToOne
    @JoinColumn(name = "MaKhachHang")
    private KhachHang KhachHang;

    @JsonProperty("SoLuongPhong")
    @Column(name = "SoLuongPhong")
    private int SoLuongPhong;

    @Column(name = "NgayCapNhat")
    private String NgayCapNhat;

    @JsonCreator
    public ThongTinDatPhongBase(@JsonProperty("SoNguoi") int soNguoi,
                                @JsonProperty("ThoiGianNhanPhong") String thoiGianNhanPhong,
                                @JsonProperty("ThoiGianTraPhong") String thoiGianTraPhong,
                                @JsonProperty("SoLuongPhong") int soLuongPhong) {
        SoNguoi = soNguoi;
        ThoiGianDatPhong = new Date().toString().substring(0, 10);
        ThoiGianNhanPhong = thoiGianNhanPhong;
        ThoiGianTraPhong = thoiGianTraPhong;
        TinhTrangThanhToan = "Chưa thanh toán";
        SoLuongPhong = soLuongPhong;
        NgayCapNhat = new Date().toString().substring(0, 10);
    }

    public ThongTinDatPhongBase(String maThongTinDatPhong, int soNguoi, String thoiGianDatPhong,
                                String thoiGianNhanPhong, String thoiGianTraPhong, String thoiGianHuyPhong,
                                String lyDoHuyPhong, String tinhTrangThanhToan, demo.model.KhachHang khachHang,
                                int soLuongPhong, String ngayCapNhat) {
        MaThongTinDatPhong = maThongTinDatPhong;
        SoNguoi = soNguoi;
        ThoiGianDatPhong = thoiGianDatPhong;
        ThoiGianNhanPhong = thoiGianNhanPhong;
        ThoiGianTraPhong = thoiGianTraPhong;
        ThoiGianHuyPhong = thoiGianHuyPhong;
        LyDoHuyPhong = lyDoHuyPhong;
        TinhTrangThanhToan = tinhTrangThanhToan;
        KhachHang = khachHang;
        SoLuongPhong = soLuongPhong;
        NgayCapNhat = ngayCapNhat;
    }

    public String getMaThongTinDatPhong() {
        return MaThongTinDatPhong;
    }

    public void setMaThongTinDatPhong(String maThongTinDatPhong) {
        MaThongTinDatPhong = maThongTinDatPhong;
    }

    public int getSoNguoi() {
        return SoNguoi;
    }

    public void setSoNguoi(int soNguoi) {
        SoNguoi = soNguoi;
    }

    public String getThoiGianDatPhong() {
        return ThoiGianDatPhong;
    }

    public void setThoiGianDatPhong(String thoiGianDatPhong) {
        ThoiGianDatPhong = thoiGianDatPhong;
    }

    public String getThoiGianNhanPhong() {
        return ThoiGianNhanPhong;
    }

    public void setThoiGianNhanPhong(String thoiGianNhanPhong) {
        ThoiGianNhanPhong = thoiGianNhanPhong;
    }

    public String getThoiGianTraPhong() {
        return ThoiGianTraPhong;
    }

    public void setThoiGianTraPhong(String thoiGianTraPhong) {
        ThoiGianTraPhong = thoiGianTraPhong;
    }

    public String getThoiGianHuyPhong() {
        return ThoiGianHuyPhong;
    }

    public void setThoiGianHuyPhong(String thoiGianHuyPhong) {
        ThoiGianHuyPhong = thoiGianHuyPhong;
    }

    public String getLyDoHuyPhong() {
        return LyDoHuyPhong;
    }

    public void setLyDoHuyPhong(String lyDoHuyPhong) {
        LyDoHuyPhong = lyDoHuyPhong;
    }

    public String getTinhTrangThanhToan() {
        return TinhTrangThanhToan;
    }

    public void setTinhTrangThanhToan(String tinhTrangThanhToan) {
        TinhTrangThanhToan = tinhTrangThanhToan;
    }

    public KhachHang getKhachHang() {
        return KhachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        KhachHang = khachHang;
    }

    public int getSoLuongPhong() {
        return SoLuongPhong;
    }

    public void setSoLuongPhong(int soLuongPhong) {
        SoLuongPhong = soLuongPhong;
    }

    public String getNgayCapNhat() {
        return NgayCapNhat;
    }

    public void setNgayCapNhat(String ngayCapNhat) {
        NgayCapNhat = ngayCapNhat;
    }
}
