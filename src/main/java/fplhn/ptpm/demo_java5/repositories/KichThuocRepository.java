package fplhn.ptpm.demo_java5.repositories;

import fplhn.ptpm.demo_java5.entities.KichThuoc;
import fplhn.ptpm.demo_java5.entities.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KichThuocRepository extends JpaRepository<KichThuoc, Integer> {
    public static final int ACTIVE = 1;
    public static final int INACTIVE = 0;
    public Page<KichThuoc> findByTrangThai(int trangThai, Pageable pageable);
}
