package fplhn.ptpm.demo_java5.controllers;

import fplhn.ptpm.demo_java5.dto.chi_tiet_san_pham.StoreRequest;
import fplhn.ptpm.demo_java5.entities.SanPhamChiTiet;
import fplhn.ptpm.demo_java5.repositories.KichThuocRepository;
import fplhn.ptpm.demo_java5.repositories.MauSacRepository;
import fplhn.ptpm.demo_java5.repositories.SanPhamChiTietRepository;
import fplhn.ptpm.demo_java5.repositories.SanPhamRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@Controller
@RequestMapping("spct")
public class SanPhamChiTietController {
    @Autowired
    private SanPhamChiTietRepository sanPhamChiTietRepository;
    @Autowired
    private SanPhamRepository sanPhamRepository;
    @Autowired
    private MauSacRepository mauSacRepository;
    @Autowired
    private KichThuocRepository kichThuocRepository;

    @GetMapping("index")
    public String index(Model model, StoreRequest req,
                        @RequestParam("page")Optional<Integer> pageParam) {
        int page = pageParam.orElse(0);
        Pageable p = PageRequest.of(page, 5, Sort.by(Sort.Direction.DESC, "id"));
        Page<SanPhamChiTiet> pageData = sanPhamChiTietRepository.findByTrangThai(sanPhamChiTietRepository.ACTIVE, p);
        model.addAttribute("data", req);
        model.addAttribute("pageData", pageData);
        model.addAttribute("listSP", sanPhamRepository.findAll());
        model.addAttribute("listMS", mauSacRepository.findAll());
        model.addAttribute("listKT", kichThuocRepository.findAll());
        return "admin/ql-chi-tiet-sp/index";
    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("data") StoreRequest req, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("list", sanPhamChiTietRepository.findAll());
            model.addAttribute("listSP", sanPhamRepository.findAll());
            model.addAttribute("listMS", mauSacRepository.findAll());
            model.addAttribute("listKT", kichThuocRepository.findAll());
            return "admin/ql-chi-tiet-sp/index";
        }
        SanPhamChiTiet spct = new SanPhamChiTiet();
        spct.setMaSPCT("SPCT" + sanPhamChiTietRepository.findAll().size()+ 1);
        spct.setIdMauSac(req.getIdMauSac());
        spct.setIdKichThuoc(req.getIdKichThuoc());
        spct.setSoLuong(req.getSoLuong());
        spct.setDonGia(req.getDonGia());
        spct.setIdSanPham(req.getIdSanPham());
        spct.setTrangThai(1);
        this.sanPhamChiTietRepository.save(spct);
        return "redirect:/spct/index";

    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.sanPhamChiTietRepository.deleteById(id);
        return "redirect:/spct/index";
    }

    @GetMapping("edit/{id}")
    public String viewUpdate(@PathVariable("id") SanPhamChiTiet spct, Model model) {
        model.addAttribute("data", spct);
        model.addAttribute("listSP", sanPhamRepository.findAll());
        model.addAttribute("listMS", mauSacRepository.findAll());
        model.addAttribute("listKT", kichThuocRepository.findAll());
        return "admin/ql-chi-tiet-sp/edit";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable("id") SanPhamChiTiet spct, Model model,  @RequestParam("page")Optional<Integer> pageParam) {
        int page = pageParam.orElse(0);
        Pageable p = PageRequest.of(page, 5, Sort.by(Sort.Direction.DESC, "id"));
        Page<SanPhamChiTiet> pageData = sanPhamChiTietRepository.findByTrangThai(sanPhamChiTietRepository.ACTIVE, p);
        model.addAttribute("data", spct);
        model.addAttribute("pageData", pageData);
        model.addAttribute("listSP", sanPhamRepository.findAll());
        model.addAttribute("listMS", mauSacRepository.findAll());
        model.addAttribute("listKT", kichThuocRepository.findAll());
        return "admin/ql-chi-tiet-sp/index";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") SanPhamChiTiet spct, @Valid @ModelAttribute("data") StoreRequest req, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("listSP", sanPhamRepository.findAll());
            model.addAttribute("listMS", mauSacRepository.findAll());
            model.addAttribute("listKT", kichThuocRepository.findAll());
            return "admin/ql-chi-tiet-sp/edit";
        }
        spct.setMaSPCT(req.getMaSPCT());
        spct.setMaSPCT(req.getMaSPCT());
        spct.setIdMauSac(req.getIdMauSac());
        spct.setIdKichThuoc(req.getIdKichThuoc());
        spct.setSoLuong(req.getSoLuong());
        spct.setDonGia(req.getDonGia());
        spct.setIdSanPham(req.getIdSanPham());
        spct.setTrangThai(req.getTrangThai());
        this.sanPhamChiTietRepository.save(spct);
        return "redirect:/spct/index";
    }

}
