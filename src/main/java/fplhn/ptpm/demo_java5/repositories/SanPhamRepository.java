package fplhn.ptpm.demo_java5.repositories;

import fplhn.ptpm.demo_java5.entities.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Integer> {
    public static final int ACTIVE = 1;
    public static final int INACTIVE = 0;
    public Page<SanPham> findByTrangThai(int trangThai, Pageable pageable);
}
