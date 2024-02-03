package fplhn.ptpm.demo_java5.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SanPhamChiTiet")
public class SanPhamChiTiet {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "IdMauSac")
    private Integer idMauSac;
    @Column(name = "IdKichThuoc")
    private Integer idKichThuoc;

    @Column(name = "IdSanPham")
    private Integer idSanPham;
    @Column(name = "MaSPCT")
    private String maSPCT;
    @Column(name = "SoLuong")
    private Integer soLuong;
    @Column(name = "DonGia")
    private BigDecimal donGia;
    @Column(name = "TrangThai")
    private Integer trangThai;
}
