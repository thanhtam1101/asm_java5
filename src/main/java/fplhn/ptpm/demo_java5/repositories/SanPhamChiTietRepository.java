package fplhn.ptpm.demo_java5.repositories;

import fplhn.ptpm.demo_java5.entities.KhachHang;
import fplhn.ptpm.demo_java5.entities.SanPhamChiTiet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamChiTietRepository extends JpaRepository<SanPhamChiTiet, Integer> {
    public static final int ACTIVE = 1;
    public static final int INACTIVE = 0;
    public Page<SanPhamChiTiet> findByTrangThai(int TrangThai, Pageable pageable);
    public SanPhamChiTiet findById(int id);
    @Query("SELECT spct FROM SanPhamChiTiet spct WHERE spct.idSanPham = :idSanPham and " +
            "spct.idMauSac = :idMauSac and spct.idKichThuoc = :idKichThuoc ")
    public SanPhamChiTiet findById(@Param("idSanPham") int idSanPham,
                                   @Param("idMauSac") int idMauSac,
                                   @Param("idKichThuoc") int idKichThuoc );
}
