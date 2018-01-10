package demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CacPhongKHMuonDat {
    @JsonProperty("SoPhong")
    private String SoPhong;
    @JsonProperty("GiaHienTai")
    private int GiaHienTai;

    @JsonCreator
    public CacPhongKHMuonDat(@JsonProperty("SoPhong") String soPhong, @JsonProperty("GiaHienTai") int giaHienTai) {
        SoPhong = soPhong;
        GiaHienTai = giaHienTai;
    }

    public String getSoPhong() {
        return SoPhong;
    }

    public void setSoPhong(String soPhong) {
        SoPhong = soPhong;
    }

    public int getGiaHienTai() {
        return GiaHienTai;
    }

    public void setGiaHienTai(int giaHienTai) {
        GiaHienTai = giaHienTai;
    }
}
