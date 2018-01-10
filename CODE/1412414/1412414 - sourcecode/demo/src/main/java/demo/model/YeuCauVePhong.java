package demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class YeuCauVePhong {
    @JsonProperty("ViTri") private String ViTri;
    @JsonProperty("LoaiPhong") private int LoaiPhong;
    @JsonProperty("GiaNhoNhat") private int GiaNhoNhat;
    @JsonProperty("GiaLonNhat") private int GiaLonNhat;
    @JsonProperty("Tang") private int Tang;
    @JsonProperty("LoaiGiuong") private String LoaiGiuong;
    @JsonProperty("SoLuongGiuong") private int SoLuongGiuong;
    @JsonProperty("ThoiGianNhanPhong") private String ThoiGianNhanPhong;
    @JsonProperty("ThoiGianTraPhong") private String ThoiGianTraPhong;

    @JsonCreator
    public YeuCauVePhong(@JsonProperty("ViTri") String viTri, @JsonProperty("LoaiPhong") int loaiPhong,
                         @JsonProperty("GiaNhoNhat") int giaNhoNhat, @JsonProperty("GiaLonNhat") int giaLonNhat,
                         @JsonProperty("Tang") int tang, @JsonProperty("LoaiGiuong") String loaiGiuong,
                         @JsonProperty("SoLuongGiuong") int soLuongGiuong,
                         @JsonProperty("ThoiGianNhanPhong") String thoiGianNhanPhong,
                         @JsonProperty("ThoiGianTraPhong") String thoiGianTraPhong) {
        ViTri = viTri;
        LoaiPhong = loaiPhong;
        GiaNhoNhat = giaNhoNhat;
        GiaLonNhat = giaLonNhat;
        Tang = tang;
        LoaiGiuong = loaiGiuong;
        SoLuongGiuong = soLuongGiuong;
        ThoiGianNhanPhong = thoiGianNhanPhong;
        ThoiGianTraPhong = thoiGianTraPhong;
    }

    public String getViTri() {
        return ViTri;
    }

    public void setViTri(String viTri) {
        ViTri = viTri;
    }

    public int getLoaiPhong() {
        return LoaiPhong;
    }

    public void setLoaiPhong(int loaiPhong) {
        LoaiPhong = loaiPhong;
    }

    public int getGiaNhoNhat() {
        return GiaNhoNhat;
    }

    public void setGiaNhoNhat(int giaNhoNhat) {
        GiaNhoNhat = giaNhoNhat;
    }

    public int getGiaLonNhat() {
        return GiaLonNhat;
    }

    public void setGiaLonNhat(int giaLonNhat) {
        GiaLonNhat = giaLonNhat;
    }

    public int getTang() {
        return Tang;
    }

    public void setTang(int tang) {
        Tang = tang;
    }

    public String getLoaiGiuong() {
        return LoaiGiuong;
    }

    public void setLoaiGiuong(String loaiGiuong) {
        LoaiGiuong = loaiGiuong;
    }

    public int getSoLuongGiuong() {
        return SoLuongGiuong;
    }

    public void setSoLuongGiuong(int soLuongGiuong) {
        SoLuongGiuong = soLuongGiuong;
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
}
