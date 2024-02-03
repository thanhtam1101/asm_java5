package fplhn.ptpm.demo_java5.controllers;

import fplhn.ptpm.demo_java5.dto.nhan_vien.StoreRequest;
import fplhn.ptpm.demo_java5.entities.NhanVien;
import fplhn.ptpm.demo_java5.repositories.NhanVienRepository;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("nhan-vien")
public class NhanVienController {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @GetMapping("index")
    public String index(Model model, @RequestParam("page")Optional<Integer> pageParam) {
        int page = pageParam.orElse(0);
        Pageable p = PageRequest.of(page, 5,  Sort.by(Sort.Direction.DESC, "id"));
        Page<NhanVien> pageData = nhanVienRepository.findByTrangThai(nhanVienRepository.ACTIVE,p);
        model.addAttribute("pageData", pageData);
        StoreRequest req = new StoreRequest();
        model.addAttribute("data", req);
        return "admin/ql-nhan-vien/index";
    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("data") StoreRequest req, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "admin/ql-nhan-vien/index";
        }
        NhanVien nv = new NhanVien(null, "NV" + this.nhanVienRepository.findAll().size()+ 1,
                req.getTen(), req.getTenDangNhap(), req.getMatKhau(), req.getTrangThai());
        this.nhanVienRepository.save(nv);
        return "redirect:/nhan-vien/index";
    }

    @GetMapping("edit/{id}")
    public String viewUpdate(@PathVariable("id") NhanVien nv, Model model) {
        model.addAttribute("data", nv);
        return "admin/ql-nhan-vien/edit";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") NhanVien nv, @Valid @ModelAttribute("data") StoreRequest req, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/ql-nhan-vien/edit";
        }
        nv.setMa(req.getMa());
        nv.setTen(req.getTen());
        nv.setTenDangNhap(req.getTenDangNhap());
        nv.setMatKhau(req.getMatKhau());
        nv.setTrangThai(req.getTrangThai());
        this.nhanVienRepository.save(nv);
        return "redirect:/nhan-vien/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.nhanVienRepository.deleteById(id);
        return "redirect:/nhan-vien/index";
    }
}
