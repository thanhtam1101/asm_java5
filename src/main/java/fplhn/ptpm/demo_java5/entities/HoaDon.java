package fplhn.ptpm.demo_java5.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "HoaDon")
public class HoaDon {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "IdKH")
    private Integer idKhachHang;
    @Column(name = "IdNV")
    private Integer idNhanVien;

    @Column(name = "NgayMuaHang")
    private Date ngayMuaHang;
    @Column(name = "TrangThai")
    private Integer trangThai;
}
