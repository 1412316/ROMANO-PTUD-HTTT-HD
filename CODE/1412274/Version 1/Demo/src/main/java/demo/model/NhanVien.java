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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NhanVien nhanVien = (NhanVien) o;

        if (MaNV != null ? !MaNV.equals(nhanVien.MaNV) : nhanVien.MaNV != null) return false;
        if (TenNV != null ? !TenNV.equals(nhanVien.TenNV) : nhanVien.TenNV != null) return false;
        if (GioiTinh != null ? !GioiTinh.equals(nhanVien.GioiTinh) : nhanVien.GioiTinh != null) return false;
        if (NgaySinh != null ? !NgaySinh.equals(nhanVien.NgaySinh) : nhanVien.NgaySinh != null) return false;
        if (DiaChi != null ? !DiaChi.equals(nhanVien.DiaChi) : nhanVien.DiaChi != null) return false;
        if (SoDT != null ? !SoDT.equals(nhanVien.SoDT) : nhanVien.SoDT != null) return false;
        if (SoCMND != null ? !SoCMND.equals(nhanVien.SoCMND) : nhanVien.SoCMND != null) return false;
        if (Luong != null ? !Luong.equals(nhanVien.Luong) : nhanVien.Luong != null) return false;
        if (MatKhau != null ? !MatKhau.equals(nhanVien.MatKhau) : nhanVien.MatKhau != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = MaNV != null ? MaNV.hashCode() : 0;
        result = 31 * result + (TenNV != null ? TenNV.hashCode() : 0);
        result = 31 * result + (GioiTinh != null ? GioiTinh.hashCode() : 0);
        result = 31 * result + (NgaySinh != null ? NgaySinh.hashCode() : 0);
        result = 31 * result + (DiaChi != null ? DiaChi.hashCode() : 0);
        result = 31 * result + (SoDT != null ? SoDT.hashCode() : 0);
        result = 31 * result + (SoCMND != null ? SoCMND.hashCode() : 0);
        result = 31 * result + (Luong != null ? Luong.hashCode() : 0);
        result = 31 * result + (MatKhau != null ? MatKhau.hashCode() : 0);
        return result;
    }
}
