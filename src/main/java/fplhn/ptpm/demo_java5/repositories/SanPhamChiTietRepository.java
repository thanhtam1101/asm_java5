package fplhn.ptpm.demo_java5.repositories;

import fplhn.ptpm.demo_java5.entities.SanPhamChiTiet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamChiTietRepository extends JpaRepository<SanPhamChiTiet, Integer> {
    public static final int ACTIVE = 1;
    public static final int INACTIVE = 0;
    public Page<SanPhamChiTiet> findByTrangThai(int TrangThai, Pageable pageable);
    public SanPhamChiTiet findById(int id);
}
