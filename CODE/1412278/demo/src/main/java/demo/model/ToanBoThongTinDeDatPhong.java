package demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ToanBoThongTinDeDatPhong {
    @JsonProperty("CacPhongKHMuonDat")
    private CacPhongKHMuonDat[] CacPhongKHMuonDat;

    @JsonProperty("ThongTinKhachHang")
    private KhachHang ThongTinKhachHang;

    @JsonProperty("ThongTinDatPhong")
    private ThongTinDatPhongBase ThongTinDatPhong;

    @JsonCreator
    public ToanBoThongTinDeDatPhong(@JsonProperty("CacPhongKHMuonDat") CacPhongKHMuonDat[] cacPhongKHMuonDat,
                                    @JsonProperty("ThongTinKhachHang") KhachHang thongTinKhachHang,
                                    @JsonProperty("ThongTinDatPhong") ThongTinDatPhongBase thongTinDatPhong) {
        CacPhongKHMuonDat = cacPhongKHMuonDat;
        ThongTinKhachHang = thongTinKhachHang;
        ThongTinDatPhong = thongTinDatPhong;
    }

    public CacPhongKHMuonDat[] getCacPhongKHMuonDat() {
        return CacPhongKHMuonDat;
    }

    public void setCacPhongKHMuonDat(CacPhongKHMuonDat[] cacPhongKHMuonDat) {
        CacPhongKHMuonDat = cacPhongKHMuonDat;
    }

    public KhachHang getThongTinKhachHang() {
        return ThongTinKhachHang;
    }

    public void setThongTinKhachHang(KhachHang thongTinKhachHang) {
        ThongTinKhachHang = thongTinKhachHang;
    }

    public ThongTinDatPhongBase getThongTinDatPhong() {
        return ThongTinDatPhong;
    }

    public void setThongTinDatPhong(ThongTinDatPhongBase thongTinDatPhong) {
        ThongTinDatPhong = thongTinDatPhong;
    }
}
