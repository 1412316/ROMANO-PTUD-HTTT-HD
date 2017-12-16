package demo.model;

import org.hibernate.annotations.Nationalized;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LoaiPhong")
public class LoaiPhongBase implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "MaLoaiPhong")
    private int MaLoaiPhong;
    @Column(name = "TenLoaiPhong")
    @Nationalized
    private String TenLoaiPhong;
    @Column(name = "MoTa")
    @Nationalized
    private String MoTa;
    @Column(name = "LoaiGiuong")
    @Nationalized
    private String LoaiGiuong;
    @Column(name = "NgayTao")
    private String NgayTao;
    @Column(name = "NgayCapNhat")
    private String NgayCapNhat;

    public LoaiPhongBase() {
        this.TenLoaiPhong = null;
        this.MoTa = null;
        this.LoaiGiuong = null;
        this.NgayTao = null;
        this.NgayCapNhat = null;
    }

    public LoaiPhongBase(int MaLoaiPhong, String TenLoaiPhong, String MoTa, String LoaiGiuong, String NgayTao, String NgayCapNhat) {
        this.MaLoaiPhong = MaLoaiPhong;
        this.TenLoaiPhong = TenLoaiPhong;
        this.MoTa = MoTa;
        this.LoaiGiuong = LoaiGiuong;
        this.NgayTao = NgayTao;
        this.NgayCapNhat = NgayCapNhat;
    }

    public int getMaLoaiPhong(){
        return this.MaLoaiPhong;
    }

    public void setMaLoaiPhong(int MaLoaiPhong) {
        this.MaLoaiPhong = MaLoaiPhong;
    }

    public String getTenLoaiPhong() {
        return this.TenLoaiPhong;
    }

    public void setTenLoaiPhong(String TenLoaiPhong) {
        this.TenLoaiPhong = TenLoaiPhong;
    }

    public String getMoTa() {
        return this.MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public String getLoaiGiuong() {
        return this.LoaiGiuong;
    }

    public void setLoaiGiuong(String LoaiGiuong) {
        this.LoaiGiuong = LoaiGiuong;
    }

    public String getNgayTao() {
        return this.NgayTao;
    }

    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }

    public String getNgayCapNhat() {
        return this.NgayCapNhat;
    }

    public void setNgayCapNhat(String NgayCapNhat) {
        this.NgayCapNhat = NgayCapNhat;
    }
}

