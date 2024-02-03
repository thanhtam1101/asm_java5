package fplhn.ptpm.demo_java5.repositories;

import fplhn.ptpm.demo_java5.entities.KhachHang;
import fplhn.ptpm.demo_java5.entities.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Integer> {
    public static final int ACTIVE = 1;
    public static final int INACTIVE = 0;

    public Page<KhachHang> findByTrangThai(int trangThai, Pageable pageable);

    @Query("SELECT kh FROM KhachHang kh WHERE kh.sdt = :sdt")
    public KhachHang findBySdt(@Param("sdt") String sdt);
}
