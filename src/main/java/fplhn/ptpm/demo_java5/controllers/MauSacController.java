package fplhn.ptpm.demo_java5.controllers;

import fplhn.ptpm.demo_java5.dto.mau_sac.StoreRequest;
import fplhn.ptpm.demo_java5.entities.MauSac;
import fplhn.ptpm.demo_java5.entities.NhanVien;
import fplhn.ptpm.demo_java5.repositories.MauSacRepository;
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
@RequestMapping("mau-sac")
public class MauSacController {

    @Autowired
    private MauSacRepository mauSacRepository;

    @GetMapping("index")
    public String create(Model model, @RequestParam("page") Optional<Integer> pageParam) {
        StoreRequest msReq = new StoreRequest();
        model.addAttribute("data", msReq);
        int page = pageParam.orElse(0);
        Pageable p = PageRequest.of(page, 5,  Sort.by(Sort.Direction.DESC, "id"));
        Page<MauSac> pageData = mauSacRepository.findByTrangThai(mauSacRepository.ACTIVE,p);
        model.addAttribute("pageData", pageData);
        return "admin/ql-mau-sac/index";
    }

    @GetMapping("edit/{id}")
    public String viewUpdate(@PathVariable("id") MauSac ms, Model model) {
        model.addAttribute("data", ms);
        return "admin/ql-mau-sac/edit";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") MauSac ms, @Valid @ModelAttribute("data") StoreRequest req, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/ql-mau-sac/edit";
        }
        ms.setMa(req.getMa());
        ms.setTen(req.getTen());
        ms.setTrangThai(req.getTrangThai());
        this.mauSacRepository.save(ms);
        return "redirect:/mau-sac/index";
    }


    // XÓA
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.mauSacRepository.deleteById(id);
        return "redirect:/mau-sac/index";
    }

    // THÊM
    @PostMapping("store")
    public String store(@Valid @ModelAttribute("data") StoreRequest req, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "admin/ql-mau-sac/index";
        }
        MauSac ms = new MauSac(null,"MS" + this.mauSacRepository.findAll().size()+ 1, req.getTen(), req.getTrangThai());
        this.mauSacRepository.save(ms);
        return "redirect:/mau-sac/index";
    }


}
