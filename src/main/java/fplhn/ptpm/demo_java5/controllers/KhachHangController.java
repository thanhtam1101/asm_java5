package fplhn.ptpm.demo_java5.controllers;

import fplhn.ptpm.demo_java5.dto.khach_hang.StoreRequest;
import fplhn.ptpm.demo_java5.entities.KhachHang;
import fplhn.ptpm.demo_java5.entities.KichThuoc;
import fplhn.ptpm.demo_java5.entities.NhanVien;
import fplhn.ptpm.demo_java5.repositories.KhachHangRepository;
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
@RequestMapping("khach-hang")
public class KhachHangController {

    @Autowired
    private KhachHangRepository khachHangRepository;

    @GetMapping("index")
    public String index(Model model, @RequestParam("page") Optional<Integer> pageParam) {
        StoreRequest req = new StoreRequest();
        model.addAttribute("data", req);
        int page = pageParam.orElse(0);
        Pageable p = PageRequest.of(page, 5,  Sort.by(Sort.Direction.DESC, "id"));
        Page<KhachHang> pageData = khachHangRepository.findByTrangThai(khachHangRepository.ACTIVE,p);
        model.addAttribute("pageData", pageData);
        return "admin/ql-khach-hang/index";
    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("data") StoreRequest req, BindingResult result, Model model) {
     //   model.addAttribute("listKH", this.khachHangRepository.findAll());
        if (result.hasErrors()) {
            return "admin/ql-khach-hang/index";
        }
        KhachHang kh = new KhachHang(null,"KH" + this.khachHangRepository.findAll().size()+ 1, req.getTen(), req.getSdt(), req.getTrangThai());
        this.khachHangRepository.save(kh);
        return "redirect:/khach-hang/index";


    }

    @GetMapping("edit/{id}")
    public String viewUpdate(@PathVariable("id") KhachHang kh, Model model) {
        model.addAttribute("data", kh);
        return "admin/ql-khach-hang/edit";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") KhachHang kh, @Valid @ModelAttribute("data") StoreRequest req, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/ql-khach-hang/edit";
        }
        kh.setMa(req.getMa());
        kh.setTen(req.getTen());
        kh.setSdt(req.getSdt());
        kh.setTrangThai(req.getTrangThai());
        this.khachHangRepository.save(kh);
        return "redirect:/khach-hang/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.khachHangRepository.deleteById(id);
        return "redirect:/khach-hang/index";
    }
}
