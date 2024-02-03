package fplhn.ptpm.demo_java5.repositories;

import fplhn.ptpm.demo_java5.entities.HoaDon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Integer> {
    public static final int ACTIVE = 1;
    public static final int INACTIVE = 0;
    public static final int HOA_DON_CHO = 3;
    public Optional<HoaDon> findById(Integer id);
    public Page<HoaDon> findByTrangThai(int trangThai, Pageable pageable);
    public List<HoaDon> findAllByTrangThai(int trangThai);

}
