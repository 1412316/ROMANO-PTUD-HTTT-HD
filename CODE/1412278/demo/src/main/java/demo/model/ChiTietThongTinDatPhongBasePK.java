package demo.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ChiTietThongTinDatPhongBasePK implements Serializable {
    @Basic(optional = false)
    @Column(name="MaThongTinDatPhong")
    private String MaThongTinDatPhong;

    @Basic(optional = false)
    @Column(name="SoPhong")
    private String SoPhong;

    public ChiTietThongTinDatPhongBasePK(String maThongTinDatPhong, String soPhong) {
        MaThongTinDatPhong = maThongTinDatPhong;
        SoPhong = soPhong;
    }

    public String getMaThongTinDatPhong() {
        return MaThongTinDatPhong;
    }

    public void setMaThongTinDatPhong(String maThongTinDatPhong) {
        MaThongTinDatPhong = maThongTinDatPhong;
    }

    public String getSoPhong() {
        return SoPhong;
    }

    public void setSoPhong(String soPhong) {
        SoPhong = soPhong;
    }
}
