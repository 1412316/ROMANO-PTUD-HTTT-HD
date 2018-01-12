package demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "NhanVien")
public class NhanVien implements Serializable {
    @Id
    @Column(name = "MaNV", nullable = false, length = 6)
    private String MaNV;

    @Column(name = "TenNV", nullable = true, length = 50)
    @Nationalized
    private String TenNV;

    @Column(name = "GioiTinh", nullable = true, length = 4)
    @Nationalized
    private String GioiTinh;

    @Column(name = "NgaySinh", nullable = true)
    private String NgaySinh;

    @Column(name = "DiaChi", nullable = true, length = 100)
    @Nationalized
    private String DiaChi;

    @Column(name = "SoDT", nullable = true, length = 12)
    private String SoDT;

    @Column(name = "SoCMND", nullable = true, length = 12)
    private String SoCMND;

    @Column(name = "Luong", nullable = true, length = 200)
    private String Luong;

    @Column(name = "MatKhau", nullable = true, length = 200)
    private String MatKhau;

    @Column(name = "NgayTao", nullable = true)
    private String NgayTao;

    @Column(name = "NgayCapNhat", nullable = true)
    private String NgayCapNhat;

    //Getter va Setter

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSoDT() {
        return SoDT;
    }

    public void setSoDT(String SoDT) {
        this.SoDT = SoDT;
    }

    public String getSoCMND() {
        return SoCMND;
    }

    public void setSoCMND(String SoCMND) {
        this.SoCMND = SoCMND;
    }

    public String getLuong() {
        return Luong;
    }

    public void setLuong(String Luong) {
        this.Luong = Luong;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }

    public String getNgayCapNhat() {
        return NgayCapNhat;
    }

    public void setNgayCapNhat(String NgayCapNhat) {
        this.NgayCapNhat = NgayCapNhat;
    }

}
