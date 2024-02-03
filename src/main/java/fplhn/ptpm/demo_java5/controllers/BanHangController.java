package fplhn.ptpm.demo_java5.controllers;

import fplhn.ptpm.demo_java5.dto.hoa_don.StoreRequest;
import fplhn.ptpm.demo_java5.entities.HoaDon;
import fplhn.ptpm.demo_java5.entities.HoaDonChiTiet;
import fplhn.ptpm.demo_java5.entities.KhachHang;
import fplhn.ptpm.demo_java5.entities.SanPhamChiTiet;
import fplhn.ptpm.demo_java5.repositories.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("ban-hang")
public class BanHangController {
    private int stt = 0;

    @Autowired
    private SanPhamChiTietRepository sanPhamChiTietRepository;
    @Autowired
    private SanPhamRepository sanPhamRepository;
    @Autowired
    private MauSacRepository mauSacRepository;
    @Autowired
    private KichThuocRepository kichThuocRepository;
    @Autowired
    private HoaDonRepository hoaDonRepository;
    @Autowired
    private NhanVienRepository nhanVienRepository;
    @Autowired
    private KhachHangRepository khachHangRepository;
    @Autowired
    private HoaDonChiTietRepository hoaDonChiTietRepository;
    int idHoaDon;
    //Hiển thị giao diện bán hàng
    @GetMapping("index")
    public String getList(Model model, fplhn.ptpm.demo_java5.dto.hoa_don.StoreRequest hd,
                          @RequestParam("page") Optional<Integer> pageParam,
                          RedirectAttributes redirectAttributes, HttpSession session) {
        int page = pageParam.orElse(0);
        Pageable p = PageRequest.of(page, 5);
        Page<SanPhamChiTiet> pageDataSPCT = sanPhamChiTietRepository.findByTrangThai(sanPhamChiTietRepository.ACTIVE, p);
        model.addAttribute("data", hd);
        model.addAttribute("pageDataSPCT", pageDataSPCT);
        model.addAttribute("listCTSP", this.sanPhamChiTietRepository.findAll());
        model.addAttribute("listSP", this.sanPhamRepository.findAll());
        model.addAttribute("listMS", this.mauSacRepository.findAll());
        model.addAttribute("listKT", this.kichThuocRepository.findAll());
        model.addAttribute("listHD", this.hoaDonRepository.findAll());
        model.addAttribute("listNV", this.nhanVienRepository.findAll());
        model.addAttribute("listKH", this.khachHangRepository.findAll());
        session.setAttribute("idHoaDon", idHoaDon);
        if (redirectAttributes.containsAttribute("success")) {
            model.addAttribute("success", redirectAttributes.getAttribute("success"));
        }
        return "admin/ql-ban-hang/index";
    }

    //Tạo hóa đơn chờ
    @PostMapping("add-hoa-don")
    public String addHoaDon(Model model, HttpSession session) {
        HoaDon hd = new HoaDon();
        Date ngayTao = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        hd.setNgayMuaHang(ngayTao);
        hd.setIdNhanVien(1);
        hd.setTrangThai(3);
        if (hoaDonRepository.findAllByTrangThai(hoaDonRepository.HOA_DON_CHO).size() >= 5) {
            session.setAttribute("error", "Không được vượi quá 5 hóa đơn chờ");
            return "redirect:/ban-hang/index";
        }
        this.hoaDonRepository.save(hd);
        model.addAttribute("listHD", this.hoaDonRepository.findAll());
        model.addAttribute("listNV", this.nhanVienRepository.findAll());
        return "redirect:/ban-hang/index";
    }

    //Hiển thị sản phẩm trong giỏ hàng theo từng hóa đơn
    @GetMapping("detail/{id}")
    public String HoaDonCT(Model model, @PathVariable("id") HoaDon hd, RedirectAttributes redirectAttributes,HttpSession session,
                           @RequestParam("page") Optional<Integer> pageParam) {
        int page = pageParam.orElse(0);
        Pageable p = PageRequest.of(page, 5);
        Page<SanPhamChiTiet> listSPCT = sanPhamChiTietRepository.findByTrangThai(sanPhamChiTietRepository.ACTIVE, p);
        model.addAttribute("pageDataSPCT", listSPCT);
        model.addAttribute("data", hd);
        model.addAttribute("listCTSP", this.sanPhamChiTietRepository.findAll());
        model.addAttribute("listSP", this.sanPhamRepository.findAll());
        model.addAttribute("listMS", this.mauSacRepository.findAll());
        model.addAttribute("listKT", this.kichThuocRepository.findAll());
        model.addAttribute("listHD", this.hoaDonRepository.findAll());
        model.addAttribute("listNV", this.nhanVienRepository.findAll());
        model.addAttribute("listKH", this.khachHangRepository.findAll());
        idHoaDon = hd.getId();
        System.out.println(idHoaDon);
        session.setAttribute("idHoaDon",hd.getId() );
        // Lọc danh sách sản phẩm trong giỏ hàng cho hóa đơn được chọn
        List<HoaDonChiTiet> gioHangTheoHoaDon = this.hoaDonChiTietRepository.findByIdHoaDon(hd.getId());
        if (gioHangTheoHoaDon != null) {
            model.addAttribute("listHDCT", gioHangTheoHoaDon);

            // Tính tổng tiền
            BigDecimal tongTien = BigDecimal.ZERO; // Khởi tạo tổng tiền là 0
            for (HoaDonChiTiet hdct : gioHangTheoHoaDon) {
                int soLuong = hdct.getSoLuong();
                BigDecimal donGia = hdct.getDonGia();
                BigDecimal thanhTien = donGia.multiply(BigDecimal.valueOf(soLuong)); // Sử dụng multiply() thay vì toán tử *
                tongTien = tongTien.add(thanhTien);
                model.addAttribute("soLuong", hdct.getSoLuong());
            }


            model.addAttribute("tongTien", tongTien);
        }

        if (redirectAttributes.containsAttribute("err")) {
            model.addAttribute("err", redirectAttributes.getAttribute("err"));
        }
        if (redirectAttributes.containsAttribute("checkSL")) {
            model.addAttribute("checkSL", redirectAttributes.getAttribute("checkSL"));
        }
        return "admin/ql-ban-hang/index";
    }

    // Thêm sản phẩm vào giỏ hàng
    @PostMapping("add-hdct/{id}")
    public String addHoaDonCT(Model model, @PathVariable("id") int idsp, @ModelAttribute("idHoaDon") int idHoaDon, RedirectAttributes redirectAttributes) {
        HoaDonChiTiet hdct = new HoaDonChiTiet();
        model.addAttribute("idHoaDon", idHoaDon);
        // Tìm sản phẩm trong giỏ hàng
        boolean spTonTaiTrongGioHang = false;
        SanPhamChiTiet ct = this.sanPhamChiTietRepository.findById(idsp);
        for (HoaDonChiTiet hd : this.hoaDonChiTietRepository.findAll()) {
            if (hd.getIdSPCT() == idsp && hd.getIdHoaDon() == idHoaDon) {
                if(ct.getSoLuong() <= 0){
                    redirectAttributes.addFlashAttribute("checkSL", "Số lượng cập nhật vượt quá số lượng tồn kho");
                    return "redirect:/ban-hang/detail/" + idHoaDon;
                }
                ct.setSoLuong(ct.getSoLuong() - 1);
                hd.setSoLuong(hd.getSoLuong() + 1);// Nếu sản phẩm đã tồn tại, tăng số lượng lên
                this.hoaDonChiTietRepository.save(hd);
                this.sanPhamChiTietRepository.save(ct);
                spTonTaiTrongGioHang = true;
                break;
            }
        }
        BigDecimal donGia = BigDecimal.ZERO;
        if (!spTonTaiTrongGioHang) {
            ct.setSoLuong(ct.getSoLuong() - 1);
            SanPhamChiTiet spct = new SanPhamChiTiet();
            for (SanPhamChiTiet sp : this.sanPhamChiTietRepository.findAll()) {
                if (sp.getId() == idsp) {
                    donGia = sp.getDonGia();
                }
            }
            stt++;
            hdct.setIdHoaDon(idHoaDon);
            hdct.setIdSPCT(idsp);
            hdct.setSoLuong(1);
            hdct.setDonGia(donGia);
            Date thoiGian = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            hdct.setThoiGian(thoiGian);
            hdct.setTrangThai(this.hoaDonChiTietRepository.ACTIVE);
            this.hoaDonChiTietRepository.save(hdct);
            this.sanPhamChiTietRepository.save(ct);

        }
        return "redirect:/ban-hang/detail/" + idHoaDon;
    }

    @PostMapping("update-so-luong/{id}")
    public String updateSoLuong(@PathVariable("id") HoaDonChiTiet hdct,
                                @ModelAttribute("soLuong") Integer soLuong,
                                @ModelAttribute("idHoaDon") Integer idHoaDon,
                                Model model,
                                RedirectAttributes redirectAttributes) {

        int soLuongHienTaiHDCT = hdct.getSoLuong();

        // Lấy số lượng sản phẩm chi tiết hiện tại từ kho
        int soLuongHienTaiKho = 0;
        SanPhamChiTiet spct = this.sanPhamChiTietRepository.findById(hdct.getIdSPCT()).orElse(null);
        if (spct != null) {
            soLuongHienTaiKho = spct.getSoLuong();
        }

        // Kiểm tra hành động tăng hay giảm số lượng
        int chenhLechSoLuong = soLuong - soLuongHienTaiHDCT;
        if (chenhLechSoLuong > 0 && chenhLechSoLuong > soLuongHienTaiKho) {
            // Nếu là tăng số lượng và vượt quá số lượng trong kho
            redirectAttributes.addFlashAttribute("err", "Số lượng cập nhật vượt quá số lượng tồn kho");
        } else {
            // Cập nhật số lượng mới
            hdct.setSoLuong(soLuong);
            hdct = this.hoaDonChiTietRepository.save(hdct);

            // Cập nhật số lượng trong kho
            if (chenhLechSoLuong > 0) {
                // Nếu là tăng số lượng
                spct.setSoLuong(soLuongHienTaiKho - chenhLechSoLuong);
            } else {
                int soLuongThayThe = (chenhLechSoLuong >= 0) ? chenhLechSoLuong : -chenhLechSoLuong;

                spct.setSoLuong(soLuongHienTaiKho + soLuongThayThe);


            }
            this.sanPhamChiTietRepository.save(spct);
        }

        return "redirect:/ban-hang/detail/" + idHoaDon;
    }

    // Hàm lấy id khách hàng từ số điện thoại
    private Integer getIdKhachHangBySdt(String sdt) {
        KhachHang kh = this.khachHangRepository.findBySdt(sdt);
        return (kh != null) ? kh.getId() : null;
    }
    // Trong phương thức thanhToan
    @PostMapping("thanh-toan/{id}")
    public String thanhToan(Model model, @PathVariable("id") HoaDon hd,
                            @ModelAttribute("data") StoreRequest req,
                            @RequestParam("hiddenSdtForPayment") String hiddenSdtForPayment,
                            RedirectAttributes redirectAttributes) {
        hd.setTrangThai(hoaDonRepository.ACTIVE);
        hd.setIdKhachHang(getIdKhachHangBySdt(hiddenSdtForPayment));
        System.out.println("idKhachHang: " + hd.getIdKhachHang());

        this.hoaDonRepository.save(hd);

        // Lấy danh sách chi tiết hóa đơn theo ID hóa đơn
        List<HoaDonChiTiet> gioHangTheoHoaDon = this.hoaDonChiTietRepository.findByIdHoaDon(hd.getId());
//        // Cập nhật số lượng sản phẩm trong kho
//        for (HoaDonChiTiet hdct : gioHangTheoHoaDon) {
//            // Lấy sản phẩm chi tiết tương ứng
//            SanPhamChiTiet spct = this.sanPhamChiTietRepository.findById(hdct.getIdSPCT()).orElse(null);
//            if (spct != null) {
//                // Giảm số lượng sản phẩm trong kho
//                spct.setSoLuong(spct.getSoLuong() - hdct.getSoLuong());
//                this.sanPhamChiTietRepository.save(spct);
//            }
//        }
        model.addAttribute("listKH", this.khachHangRepository.findAll());
        model.addAttribute("listNV", this.nhanVienRepository.findAll());
        redirectAttributes.addFlashAttribute("success", "Thanh toán thành công");
        return "redirect:/ban-hang/index";
    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model, @ModelAttribute("idHoaDon") int idHoaDon) {
        // Lấy thông tin sản phẩm chi tiết trong giỏ hàng trước khi xóa
        Optional<HoaDonChiTiet> optionalHdct = hoaDonChiTietRepository.findById(id);

        if (optionalHdct.isPresent()) {
            HoaDonChiTiet hdct = optionalHdct.get();

            // Cộng lại số lượng vào kho
            int soLuongHienTaiKho = 0;
            SanPhamChiTiet spct = sanPhamChiTietRepository.findById(hdct.getIdSPCT()).orElse(null);
            if (spct != null) {
                soLuongHienTaiKho = spct.getSoLuong();
                spct.setSoLuong(soLuongHienTaiKho + hdct.getSoLuong());
                sanPhamChiTietRepository.save(spct);
            }

            // Xóa sản phẩm khỏi giỏ hàng
            hoaDonChiTietRepository.deleteById(id);
        }

        return "redirect:/ban-hang/detail/" + idHoaDon;
    }

    @GetMapping("delete-hoa-don/{id}")
    public String deleteHoaDon(@PathVariable("id") Integer id, Model model) {
        List<HoaDonChiTiet> gioHangTheoHoaDon = this.hoaDonChiTietRepository.findByIdHoaDon(id);

        // Kiểm tra xem có sản phẩm trong giỏ hàng của hóa đơn không
        if (!gioHangTheoHoaDon.isEmpty()) {
            // Lặp qua từng chi tiết hóa đơn để cập nhật lại số lượng sản phẩm trong kho
            for (HoaDonChiTiet hdct : gioHangTheoHoaDon) {
                // Lấy sản phẩm chi tiết tương ứng
                SanPhamChiTiet spct = this.sanPhamChiTietRepository.findById(hdct.getIdSPCT()).orElse(null);
                if (spct != null) {
                    // Cộng lại số lượng sản phẩm trong kho
                    spct.setSoLuong(spct.getSoLuong() + hdct.getSoLuong());
                    this.sanPhamChiTietRepository.save(spct);
                }
                // Sau đó, xóa chi tiết hóa đơn
                this.hoaDonChiTietRepository.deleteById(hdct.getId());
            }
        }

        // Tiếp theo, sau khi xóa sản phẩm và cập nhật số lượng trong kho, bạn có thể xóa hóa đơn
        this.hoaDonRepository.deleteById(id);

        return "redirect:/ban-hang/index";
    }


    // Hiển thị hóa đơn chi tiết
    @GetMapping("/hdct/{id}")
    public String detailHDCT(Model model, @PathVariable("id") Integer idHD) {
        List<HoaDonChiTiet> listHDCT = this.hoaDonChiTietRepository.findByIdHoaDon(idHD);
        model.addAttribute("listHDCT", listHDCT);
        model.addAttribute("listCTSP", this.sanPhamChiTietRepository.findAll());
        model.addAttribute("listSP", this.sanPhamRepository.findAll());

        return "admin/ql-hoa-don/hoa-don-chi-tiet";
    }

    // Thêm nhanh khách hàng
    @PostMapping("add-khach-hang")
    @ResponseBody
    public ResponseEntity<String> addKhachHang(Model model, fplhn.ptpm.demo_java5.dto.khach_hang.StoreRequest req,
                               @RequestParam("ten") String ten, @RequestParam("sdt") String sdt) {
        KhachHang kh = new KhachHang();
        kh.setMa("KH" + this.khachHangRepository.findAll().size() + 1);
        kh.setTen(req.getTen());
        kh.setSdt(req.getSdt());
        kh.setTrangThai(1);
        this.khachHangRepository.save(kh);
        return ResponseEntity.ok(kh.getSdt());
    }

    @PostMapping("search-sdt")
    @ResponseBody
    public ResponseEntity<String> searchKHBySdt(@ModelAttribute("sdt") String sdt,
                                                HttpSession session) {
        KhachHang kh = this.khachHangRepository.findBySdt(sdt);

        if (kh != null) {
            String response = "{\"sdtKhachHang\":\"" + kh.getSdt() + "\",\"customerId\":\"" + kh.getId() + "\"}";
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }




}
