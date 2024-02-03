package fplhn.ptpm.demo_java5.controllers;

import fplhn.ptpm.demo_java5.dto.san_pham.StoreRequest;
import fplhn.ptpm.demo_java5.entities.SanPham;
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


import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("san-pham")
public class SanPhamController {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @GetMapping("index")
    public String index(Model model, @RequestParam("page")Optional<Integer> pageParam) {
        int page = pageParam.orElse(0);
        Pageable p = PageRequest.of(page, 8, Sort.by(Sort.Direction.DESC, "id"));
        Page<SanPham> pageData = sanPhamRepository.findByTrangThai(sanPhamRepository.ACTIVE,p);
        model.addAttribute("pageData",pageData);
        StoreRequest sp = new StoreRequest();
        model.addAttribute("data", sp);
        return "admin/ql-san-pham/index";
    }


    @PostMapping("store")
    public String store(@Valid @ModelAttribute("data") StoreRequest req, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "admin/ql-san-pham/index";
        }
        SanPham sp = new SanPham(null, "SP" + sanPhamRepository.findAll().size() + 1, req.getTen(), req.getTrangThai());
        this.sanPhamRepository.save(sp);
        return "redirect:/san-pham/index";

    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.sanPhamRepository.deleteById(id);
        return "redirect:/san-pham/index";
    }

    @GetMapping("edit/{id}")
    public String viewUpdate(@PathVariable("id") SanPham sp, Model model) {
        model.addAttribute("data", sp);
        return "admin/ql-san-pham/edit";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") SanPham sp, @Valid @ModelAttribute("data") StoreRequest req, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/ql-san-pham/edit";
        }
        sp.setMa(req.getMa());
        sp.setTen(req.getTen());
        sp.setTrangThai(req.getTrangThai());
        this.sanPhamRepository.save(sp);
        return "redirect:/san-pham/index";
    }
}
