package demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TaiKhoan")
public class TaiKhoan {
    @Id
    @Column(name = "Email")
    private String Email;

    @Column(name = "MatKhau")
    private String MatKhau;

    @Column(name = "DiemThuong")
    private int DiemThuong;

    @Column(name = "NgayTao")
    private String NgayTao;

    @Column(name = "NgayCapNhat")
    private String NgayCapNhat;

    public TaiKhoan(String email, String matKhau, int diemThuong, String ngayTao, String ngayCapNhat) {
        Email = email;
        MatKhau = matKhau;
        DiemThuong = diemThuong;
        NgayTao = ngayTao;
        NgayCapNhat = ngayCapNhat;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String matKhau) {
        MatKhau = matKhau;
    }

    public int getDiemThuong() {
        return DiemThuong;
    }

    public void setDiemThuong(int diemThuong) {
        DiemThuong = diemThuong;
    }

    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String ngayTao) {
        NgayTao = ngayTao;
    }

    public String getNgayCapNhat() {
        return NgayCapNhat;
    }

    public void setNgayCapNhat(String ngayCapNhat) {
        NgayCapNhat = ngayCapNhat;
    }
}
