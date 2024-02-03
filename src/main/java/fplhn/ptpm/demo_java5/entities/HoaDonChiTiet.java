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
@Table(name = "HoaDonChiTiet")
public class HoaDonChiTiet {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "IdHoaDon")
    private Integer idHoaDon;

    @Column(name = "IdSPCT")
    private Integer idSPCT;
    @Column(name = "SoLuong")
    private Integer soLuong;
    @Column(name = "DonGia")
    private BigDecimal donGia;
    @Column(name = "ThoiGian")
    private Date thoiGian;
    @Column(name = "TrangThai")
    private Integer trangThai;
}
