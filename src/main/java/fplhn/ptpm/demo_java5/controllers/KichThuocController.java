package fplhn.ptpm.demo_java5.controllers;

import fplhn.ptpm.demo_java5.dto.kich_thuoc.StoreRequest;
import fplhn.ptpm.demo_java5.entities.KichThuoc;
import fplhn.ptpm.demo_java5.entities.MauSac;
import fplhn.ptpm.demo_java5.repositories.KichThuocRepository;
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
@RequestMapping("kich-thuoc")
public class KichThuocController {

    @Autowired
    private KichThuocRepository kichThuocRepository;

    @GetMapping("index")
    public String index(Model model, @RequestParam("page") Optional<Integer> pageParam) {
        StoreRequest ktReq = new StoreRequest();
        model.addAttribute("data", ktReq);
        int page = pageParam.orElse(0);
        Pageable p = PageRequest.of(page, 5,  Sort.by(Sort.Direction.DESC, "id"));
        Page<KichThuoc> pageData = kichThuocRepository.findByTrangThai(kichThuocRepository.ACTIVE,p);
        model.addAttribute("pageData", pageData);
        return "admin/ql-kich-thuoc/index";
    }


    @PostMapping("store")
    public String store(@Valid @ModelAttribute("data") StoreRequest req, BindingResult result, Model model) {
       // model.addAttribute("listKT", this.kichThuocRepository.findAll());
        if (result.hasErrors()) {
            return "admin/ql-kich-thuoc/index";
        }
        KichThuoc kt = new KichThuoc(null, "KT" + this.kichThuocRepository.findAll().size()+ 1, req.getTen(), req.getTrangThai());
        this.kichThuocRepository.save(kt);
        return "redirect:/kich-thuoc/index";

    }

    @GetMapping("edit/{id}")
    public String viewUpdate(@PathVariable("id") KichThuoc kt, Model model) {
        model.addAttribute("data", kt);
        return "admin/ql-kich-thuoc/edit";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") KichThuoc kt, @Valid @ModelAttribute("data") StoreRequest req, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/ql-kich-thuoc/edit";
        }
        kt.setMa(req.getMa());
        kt.setTen(req.getTen());
        kt.setTrangThai(req.getTrangThai());
        this.kichThuocRepository.save(kt);
        return "redirect:/kich-thuoc/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.kichThuocRepository.deleteById(id);
        return "redirect:/kich-thuoc/index";
    }
}
