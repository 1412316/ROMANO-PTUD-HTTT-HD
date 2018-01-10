package demo.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ThietBi")
public class ThietBi implements Serializable {
    @Id
    @Column(name = "MaThietBi")
    private String MaThietBi;

    @Column(name = "TenThietBi")
    private String TenThietBi;

    @Column(name = "GiaTien")
    private int GiaTien;

    @Column(name = "TenLoai")
    private String TenLoai;

    @Column(name = "soluong")
    private int soluong;

    @Column(name = "ngaytao")
    private String ngaytao;

    @Column(name = "ngaycapnhat")
    private String ngaycapnhat;

    public ThietBi() {
    }

    public String getMaThietBi() {
        return MaThietBi;
    }

    public void setMaThietBi(String maThietBi) {
        MaThietBi = maThietBi;
    }
    public void setTenThietBi(String tenThietBi) {
        TenThietBi = tenThietBi;
    }

    public void setGiaTien(int giaTien) {
        GiaTien = giaTien;
    }

    public void setTenLoai(String tenLoai) {
        TenLoai = tenLoai;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }

    public void setNgaycapnhat(String ngaycapnhat) {
        this.ngaycapnhat = ngaycapnhat;
    }


    public String getTenThietBi() {
        return TenThietBi;
    }

    public int getGiaTien() {
        return GiaTien;
    }

    public String getTenLoai() {
        return TenLoai;
    }

    public int getSoluong() {
        return soluong;
    }

    public String getNgaytao() {
        return ngaytao;
    }

    public String getNgaycapnhat() {
        return ngaycapnhat;
    }


}
