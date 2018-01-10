package demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CacYeuCauVePhong {
    @JsonProperty("CacYeuCauVePhong") private List<YeuCauVePhong> CacYeuCauVePhong;

    @JsonCreator
    public CacYeuCauVePhong(@JsonProperty("CacYeuCauVePhong") List<YeuCauVePhong> cacYeuCauVePhong) {
        CacYeuCauVePhong = cacYeuCauVePhong;
    }

    public List<YeuCauVePhong> getCacYeuCauVePhong() {
        return CacYeuCauVePhong;
    }

    public void setCacYeuCauVePhong(List<YeuCauVePhong> cacYeuCauVePhong) {
        CacYeuCauVePhong = cacYeuCauVePhong;
    }
}
