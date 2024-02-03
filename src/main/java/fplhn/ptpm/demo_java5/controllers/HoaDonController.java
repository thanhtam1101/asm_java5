package fplhn.ptpm.demo_java5.controllers;

import fplhn.ptpm.demo_java5.dto.hoa_don.StoreRequest;
import fplhn.ptpm.demo_java5.entities.HoaDon;
import fplhn.ptpm.demo_java5.repositories.HoaDonRepository;
import fplhn.ptpm.demo_java5.repositories.KhachHangRepository;
import fplhn.ptpm.demo_java5.repositories.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class HoaDonController {
    @Autowired
    private HoaDonRepository hoaDonRepository;
    @Autowired
    private NhanVienRepository nhanVienRepository;
    @Autowired
    private KhachHangRepository khachHangRepository;
    @GetMapping("hoa-don/index")
    public String getList(Model model, StoreRequest hd,
                          @RequestParam("page")Optional<Integer> pageParam) {
        int page = pageParam.orElse(0);
        Pageable p = PageRequest.of(page, 8, Sort.by(Sort.Direction.DESC, "id"));
        Page<HoaDon> pageData = hoaDonRepository.findByTrangThai(HoaDonRepository.ACTIVE, p);
        model.addAttribute("data", hd);
        model.addAttribute("pageData", pageData);
        model.addAttribute("listNV", nhanVienRepository.findAll());
        model.addAttribute("listKH", khachHangRepository.findAll());
        return "admin/ql-hoa-don/index";
    }
}
