package com.example.Website_Selling_Shoes_Men_Sport.controller;

import com.example.Website_Selling_Shoes_Men_Sport.entity.*;
import com.example.Website_Selling_Shoes_Men_Sport.repository.*;
import com.example.Website_Selling_Shoes_Men_Sport.service.ChatLieuService;
import com.example.Website_Selling_Shoes_Men_Sport.service.ChiTietSanPhamService;
import com.example.Website_Selling_Shoes_Men_Sport.service.KichCoService;
import com.example.Website_Selling_Shoes_Men_Sport.service.SanPhamService;
import com.example.Website_Selling_Shoes_Men_Sport.service.impl.SanPhamServiceImpl;
import com.google.zxing.WriterException;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class SanPhamController {

    @Autowired
    ChiTietSanPhamService service;

    @Autowired
    DeGiayRepository deGiayRepo;

    @Autowired
    ChatLieuRepository chatLieuRepo;
    @Autowired
    KichCoService kichCoService;
    @Autowired
    LoaiGiayRepo loaiGiayRepo;
    @Autowired
    MauSacRepository mauSacReponsitories;
    @Autowired
    SanPhamRepository sanPhamRepo;
    @Autowired
    SanPhamService sanPhamService;

    @ModelAttribute("listDeGiay")
    List<DeGiay> listDeGiay() {
        return deGiayRepo.findAll();
    }

    @ModelAttribute("listChatLieu")
    List<ChatLieu> listChatLieu() {
        return chatLieuRepo.findAll();
    }

    @ModelAttribute("listKichCo")
    List<KichCo> listKichCo() {
        return kichCoService.getListKC();
    }

    @ModelAttribute("listMau")
    List<MauSac> listMauSac() {
        return mauSacReponsitories.findAll();
    }

    @ModelAttribute("listLoaiGiay")
    List<LoaiGiay> listLoaiGiay() {
        return loaiGiayRepo.findAll();
    }

    @ModelAttribute("dsGioiTinh")
    public Map<Boolean, String> getDsGioiTinh() {
        Map<Boolean, String> dsGT = new HashMap<>();
        dsGT.put(true, "Nam");
        dsGT.put(false, "Nữ");
        return dsGT;
    }

    @ModelAttribute("dsTrangThai")
    public Map<Integer, String> getDSTrangThai() {
        Map<Integer, String> dsTrangThai = new HashMap<>();
        dsTrangThai.put(0, "Hoạt động");
        dsTrangThai.put(1, "Ngưng Hoạt động");
        return dsTrangThai;
    }
    @Getter
    @Setter
    public static class SearchForm {
        String keyword = "";
    }

    @GetMapping("/admin/san-pham/hien-thi")
    public String hienThi(Model model, @RequestParam(defaultValue = "0") int p) {
        model.addAttribute("view", "../admin/san-pham/list-sp.jsp");
        if (p < 0) {
            p = 0;
        }
        Pageable pageable = PageRequest.of(p, 5);
        Page<SanPham> page = sanPhamService.findAllSP(pageable);
        model.addAttribute("searchForm", new SearchForm());
        model.addAttribute("page", page);
        return "/admin/dashboard";
    }


    @RequestMapping("/admin/san-pham/search")
    public String search(Model model, @ModelAttribute("searchForm") SearchForm searchForm, @RequestParam(defaultValue = "0") int p) {
        model.addAttribute("view", "../admin/san-pham/list-sp.jsp");
        if (p < 0) {
            p = 0;
        }
        Pageable pageable = PageRequest.of(p, 5);
        Page<SanPham> page = sanPhamService.findByKeyword(searchForm.keyword, pageable);
        model.addAttribute("page", page);
//        model.addAttribute("view", "../san-pham/index.jsp");
        return "/admin/dashboard";
    }

    @GetMapping("/admin/san-pham/view-add")
    public String viewAdd(Model model, @ModelAttribute("sanPham") SanPham sanPham) {
        model.addAttribute("action", "/admin/san-pham/add");
        model.addAttribute("view", "../admin/san-pham/add_update.jsp");
        return "/admin/dashboard";
    }

    @RequestMapping("/admin/san-pham/view-update/{id}")
    public String viewUpdate(@PathVariable UUID id, Model model) {
        SanPham sp = sanPhamService.getOne(id);
        model.addAttribute("sanPham", sp);
        model.addAttribute("action", "/admin/san-pham/update/" + sp.getId());
        model.addAttribute("view", "../admin/san-pham/add_update.jsp");
        return "/admin/dashboard";

    }
    @PostMapping("/admin/san-pham/add")
    public String add(Model model, @Valid @ModelAttribute("sanPham") SanPham sanPham, BindingResult result) {
        Boolean hasError = result.hasErrors();
        SanPham product = sanPhamService.getByMa(sanPham.getMaSanPham());
        if (product != null) {
            hasError = true;
            model.addAttribute("maspError", "Vui lòng không nhập trùng mã");
            model.addAttribute("view", "../admin/san-pham/add_update.jsp");
            return "/admin/dashboard";
        }
        if (hasError) {
            model.addAttribute("view", "../admin/san-pham/add_update.jsp");
            return "/admin/dashboard";
        }
        sanPhamService.addSanPham(sanPham);
        return "redirect:/admin/san-pham/hien-thi";
    }

    @PostMapping("/admin/san-pham/update/{id}")
    public String udpate(@PathVariable("id") UUID id, Model model, @Valid @ModelAttribute("sanPham") SanPham sanPham,
                         BindingResult result) {
        Boolean hasError = result.hasErrors();
        if (sanPham.getMaSanPham().trim().length() < 5) {
            hasError = true;
            model.addAttribute("erorLenghMa", "Mã sản phẩm phải lớn hơn hoặc bằng 5");
            model.addAttribute("view", "../admin/san-pham/add_update.jsp");
            return "/admin/dashboard";
        }
        if (hasError) {
            model.addAttribute("view", "../admin/san-pham/add_update.jsp");
            return "/admin/dashboard";
        }

        sanPhamService.udpateSanPham(sanPham, sanPham.getId());
        return "redirect:/admin/san-pham/hien-thi";
    }

    @RequestMapping("/chi-tiet-san-pham/view-add/{id}")
    public String viewAdd(Model model, @ModelAttribute("sanpham") QLSanPham sp, @PathVariable("id") UUID id) {
        model.addAttribute("lg", new LoaiGiay());
        model.addAttribute("degiay", new DeGiay());
        model.addAttribute("vm", new ChatLieu());
        model.addAttribute("kichco", new KichCo());
        model.addAttribute("ms", new MauSac());
        model.addAttribute("action2", "/san-pham/kich-co/add/" + id);
        model.addAttribute("action3", "/san-pham/mau-sac/add/" + id);
        model.addAttribute("action4", "/san-pham/loai-giay/add/" + id);
        model.addAttribute("action5", "/san-pham/de-giay/add/" + id);
        model.addAttribute("action6", "/san-pham/chat-lieu/add/" + id);

        SanPham sanPham1 = sanPhamService.getOne(id);
        model.addAttribute("idsp",sanPham1.getId());
        model.addAttribute("tensp", sanPham1.getTenSanPham());
        model.addAttribute("action", "/chi-tiet-san-pham/add/" + sanPham1.getId());
        model.addAttribute("view", "../admin/chi-tiet-san-pham/add_update.jsp");
        return "/admin/dashboard";
    }

    // add ctsp
    @PostMapping("/chi-tiet-san-pham/add/{id}")
    public String AddSanPham(Model model, @PathVariable("id") UUID id, @Valid @ModelAttribute("sanpham") QLSanPham sp, BindingResult result) throws WriterException, IOException {
        model.addAttribute("lg", new LoaiGiay());
        model.addAttribute("degiay", new DeGiay());
        model.addAttribute("vm", new ChatLieu());

        model.addAttribute("ms", new MauSac());
        model.addAttribute("kichco", new KichCo());
        if (result.hasErrors()) {
            model.addAttribute("mess", "Lỗi! Vui lòng kiểm tra các trường trên !");
            model.addAttribute("view", "../admin/chi-tiet-san-pham/add_update.jsp");
            return "/admin/dashboard";
        }
        SanPham sanPham1 = sanPhamService.getOne(id);
        sp.setSanPham(sanPham1);
        ChiTietSanPham ctsp = new ChiTietSanPham();
        ctsp.loadFromViewModel(sp);


        model.addAttribute("tensp", sanPham1.getTenSanPham());
        service.addCTSP(ctsp);


        return "redirect:/chi-tiet-san-pham/list-san-pham/"+id;
    }

    //add modal loai giay
    @RequestMapping("/san-pham/loai-giay/add/{id}")
    public String save(Model model, @ModelAttribute("lg") LoaiGiay loaiGiay, @PathVariable("id") UUID id, BindingResult result) {
        Boolean hasE = result.hasErrors();
        List<LoaiGiay> list = loaiGiayRepo.findAll();
        SanPham sanPham1 = sanPhamService.getOne(id);
        model.addAttribute("idsp", sanPham1.getId());
        model.addAttribute("tensp", sanPham1.getTenSanPham());
        model.addAttribute("vm", new ChatLieu());
        model.addAttribute("degiay", new DeGiay());
        model.addAttribute("ms", new MauSac());
        model.addAttribute("kichco", new KichCo());
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMa().equals(loaiGiay.getMa())) {
                model.addAttribute("errorMa", "Ma loai giay da ton tai");
                hasE = true;
            }
            if (loaiGiay.getMa().length() < 5) {
                model.addAttribute("errorMa", "Ma loai giay nhieu hon 5 ki tu");
                hasE = true;
            }
            if (loaiGiay.getMa().length() > 100) {
                model.addAttribute("errorMa", "Ma loai giay it hon 100 ki tu");
                hasE = true;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTenTheLoai().equals(loaiGiay.getTenTheLoai())) {
                model.addAttribute("errorTen", "Ten loai giay da ton tai");
                hasE = true;
            }
            if (loaiGiay.getTenTheLoai().length() > 150) {
                model.addAttribute("errorTen", "Ten loai giay it hon 150 ki tu");
                hasE = true;
            }
            if (loaiGiay.getTenTheLoai().length() == 0) {
                model.addAttribute("errorTen", "Ten loai giay khong duoc bo trong");
                hasE = true;
            }
        }
        if (hasE) {

            model.addAttribute("sanpham", new QLSanPham());
            model.addAttribute("view", "../admin/chi-tiet-san-pham/add_update.jsp");
            return "/chi-tiet-san-pham/view-add/" + sanPham1.getId();
        }
        loaiGiay.setTrangThai(1);
        loaiGiayRepo.save(loaiGiay);
        model.addAttribute("view", "../admin/chi-tiet-san-pham/list.jsp");
        return "redirect:/chi-tiet-san-pham/view-add/" + sanPham1.getId();
    }

    @RequestMapping("/san-pham/kich-co/add/{id}")
    public String addKC(Model model, @Valid @ModelAttribute("kichco") KichCo kichCo, @PathVariable("id") UUID id, BindingResult resultt) {
        SanPham sanPham1 = sanPhamService.getOne(id);
        model.addAttribute("idsp", sanPham1.getId());
        model.addAttribute("tensp", sanPham1.getTenSanPham());
        model.addAttribute("vm", new ChatLieu());
        model.addAttribute("degiay", new DeGiay());
        model.addAttribute("ms", new MauSac());
        model.addAttribute("lg", new LoaiGiay());

        if (resultt.hasErrors()) {
            model.addAttribute("mess", "Chi tiết sản phẩm chưa tồn tại");
            return "redirect:/chi-tiet-san-pham/view-add/" + sanPham1.getId();


        }

        kichCoService.insertKC(kichCo);
        return "redirect:/chi-tiet-san-pham/view-add/" + sanPham1.getId();

    }

    @PostMapping("/san-pham/mau-sac/add/{id}")
    public String add(@Valid @ModelAttribute("ms") MauSac ms, @PathVariable("id") UUID id, BindingResult result, Model model) {
        SanPham sanPham1 = sanPhamService.getOne(id);
        model.addAttribute("idsp", sanPham1.getId());
        model.addAttribute("tensp", sanPham1.getTenSanPham());
        model.addAttribute("vm", new ChatLieu());
        model.addAttribute("degiay", new DeGiay());
        model.addAttribute("kichco", new KichCo());
        model.addAttribute("lg", new LoaiGiay());
        if (result.hasErrors()) {
            model.addAttribute("mess", "Nhập lại thông tin kích cỡ!");
            return "redirect:/chi-tiet-san-pham/view-add/" + sanPham1.getId();
        } else {
            this.mauSacReponsitories.save(ms);
        }
        model.addAttribute("view", "../admin/chi-tiet-san-pham/add_update.jsp");
        return "redirect:/chi-tiet-san-pham/view-add/" + sanPham1.getId();
    }

    @Autowired
    ChatLieuService chatLieuService;

    @RequestMapping("/san-pham/chat-lieu/add/{id}")
    public String store(Model model, @PathVariable("id") UUID id,
                        @Valid @ModelAttribute("vm") ChatLieu cl,
                        BindingResult result
    ) {
        SanPham sanPham1 = sanPhamService.getOne(id);
        model.addAttribute("idsp", sanPham1.getId());
        model.addAttribute("tensp", sanPham1.getTenSanPham());
        model.addAttribute("ms", new MauSac());
        model.addAttribute("degiay", new DeGiay());
        model.addAttribute("kichco", new KichCo());
        model.addAttribute("lg", new LoaiGiay());
        Boolean hasError = result.hasErrors();
        ChatLieu product = chatLieuService.getOne(cl.getMaChatLieu());
        if (product != null) {
            hasError = true;
            model.addAttribute("maspError", "Vui lòng không nhập trùng mã");
            model.addAttribute("view", "../admin/chi-tiet-san-pham/add_update.jsp");
            return "redirect:/chi-tiet-san-pham/view-add/" + sanPham1.getId();
        }
        if (hasError) {
            // Báo lỗi
            model.addAttribute("view", "../admin/chi-tiet-san-pham/add_update.jsp");
            return "redirect:/chi-tiet-san-pham/view-add/" + sanPham1.getId();
        }
        this.chatLieuRepo.save(cl);
        model.addAttribute("view", "../admin/chi-tiet-san-pham/add_update.jsp");
        return "redirect:/chi-tiet-san-pham/view-add/" + sanPham1.getId();
    }

    @PostMapping("/san-pham/de-giay/add/{id}")
    public String add(Model model, @PathVariable("id") UUID id, @Valid @ModelAttribute("degiay") DeGiay degiay, BindingResult result) {
        SanPham sanPham1 = sanPhamService.getOne(id);
        model.addAttribute("idsp", sanPham1.getId());
        model.addAttribute("tensp", sanPham1.getTenSanPham());
        model.addAttribute("ms", new MauSac());
        model.addAttribute("vm", new ChatLieu());
        model.addAttribute("kichco", new KichCo());
        model.addAttribute("lg", new LoaiGiay());
        if (result.hasErrors()) {
            model.addAttribute("view", "../admin/chi-tiet-san-pham/add_update.jsp");
            return "redirect:/chi-tiet-san-pham/view-add/" + sanPham1.getId();
        }

        if (deGiayRepo.findByMa(degiay.getMa()) != null) {
            model.addAttribute("mess_Ma", "Lỗi! Mã không được trùng");
            model.addAttribute("view", "../admin/chi-tiet-san-pham/add_update.jsp");
            return "redirect:/chi-tiet-san-pham/view-add/" + sanPham1.getId();
        }

        deGiayRepo.save(degiay);
        model.addAttribute("view", "../admin/chi-tiet-san-pham/add_update.jsp");
        return "redirect:/chi-tiet-san-pham/view-add/" + sanPham1.getId();
    }
    //list ctsp theo id
    @RequestMapping("/chi-tiet-san-pham/list-san-pham/{id}")

    public String hienListSanPham(@ModelAttribute("sortForm") ChiTietSanPhamController.SortFormSP sortFormSP, @ModelAttribute("sanpham") QLSanPham sp, @RequestParam(defaultValue = "0") int p, @PathVariable("id") UUID id, Model model) throws IOException, WriterException {

        if (p < 0) {
            p = 0;
        }
        SanPham sanPham1 = sanPhamService.getOne(id);
        model.addAttribute("idsp",sanPham1.getId());
        model.addAttribute("tensp", sanPham1.getTenSanPham());
        Pageable pageable = PageRequest.of(p, 5);
        Page<ChiTietSanPham> qlSanPhamPage = service.listCTSP(id,pageable);
        model.addAttribute("page", qlSanPhamPage);
        model.addAttribute("searchChatLieu", new ChiTietSanPhamController.SearchChatlieu());
        model.addAttribute("lg", new ChiTietSanPhamController.SearchLoaiGiay());
        model.addAttribute("SP", new SanPham());
        model.addAttribute("view", "../admin/chi-tiet-san-pham/list-spct.jsp");
        model.addAttribute("searchForm", new ChiTietSanPhamController.SearchFormSP());
        model.addAttribute("searchFormByMau", new ChiTietSanPhamController.SearchFormSPByMau());
        model.addAttribute("searchKC", new ChiTietSanPhamController.SearchKC());
        model.addAttribute("searchDG", new ChiTietSanPhamController.SearchDeGiay());

        return "/admin/dashboard";
    }


}
