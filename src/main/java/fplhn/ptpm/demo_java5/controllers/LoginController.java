package fplhn.ptpm.demo_java5.controllers;

import fplhn.ptpm.demo_java5.dto.LoginRequest;
import fplhn.ptpm.demo_java5.dto.nhan_vien.StoreRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("login")
public class LoginController {

    private List<StoreRequest> listNV;
    @GetMapping("index")
    public String getLoginForm(Model model){
        return "admin/login";
    }
    @PostMapping("admin")
    public String login(
         StoreRequest nhanVien,
                        Model model){
        for (StoreRequest nv : listNV) {
            if (nv.getTenDangNhap().equals(nhanVien.getTenDangNhap()) && nv.getMatKhau().equals(nhanVien.getMatKhau())) {
                return "admin/ql-ban-hang/index";
            }else {
                model.addAttribute("error", "Invalid username or password");
            }
        }
        return "admin/login";

    }

}
