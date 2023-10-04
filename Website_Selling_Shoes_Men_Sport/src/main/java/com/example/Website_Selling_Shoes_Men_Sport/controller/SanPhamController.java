package com.example.Website_Selling_Shoes_Men_Sport.controller;

import com.example.Website_Selling_Shoes_Men_Sport.entity.*;
import com.example.Website_Selling_Shoes_Men_Sport.repository.*;
import com.example.Website_Selling_Shoes_Men_Sport.service.ChatLieuService;
import com.example.Website_Selling_Shoes_Men_Sport.service.ChiTietSanPhamService;
import com.example.Website_Selling_Shoes_Men_Sport.service.KichCoService;
import com.example.Website_Selling_Shoes_Men_Sport.service.SanPhamService;
import com.example.Website_Selling_Shoes_Men_Sport.service.impl.SanPhamServiceImpl;
import jakarta.validation.Valid;
import lombok.Data;
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
    public Map<Integer, String> getDSTT() {
        Map<Integer, String> dsTrangThai = new HashMap<>();
        dsTrangThai.put( 1,"Còn sản phẩm");
        dsTrangThai.put( 0,"Hết sản phẩm");
        return dsTrangThai;
    }

    @Data
    public static class SearchForm {
        String keyword;
    }


    @RequestMapping("/admin/san-pham/hien-thi")
    public String getListSanPham(@ModelAttribute("sanPham") SanPham sanPham, @RequestParam(defaultValue = "0") int p, BindingResult result, Model model) {

        if (p < 0) {
            p = 0;
        }
        Pageable pageable = PageRequest.of(p, 5);
        Page<SanPham> page = sanPhamService.getListOfPage(pageable);
//        listSP = page.getContent();
        model.addAttribute("page", page);
        model.addAttribute("searchForm", new SearchForm());
        model.addAttribute("action", "/san-pham/listSP");
        model.addAttribute("view", "../admin/san-pham/list-sp.jsp");
        model.addAttribute("list", sanPhamService.getListSP());
        return "/admin/dashboard";
    }

    @RequestMapping("/admin/san-pham/add")
    public String addSP(Model model, @Valid @ModelAttribute("sanPham") SanPham sanPham, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("mess", "Vui lòng nhập đúng các thuộc tính !");
            model.addAttribute("view", "../admin/san-pham/add_update.jsp");
            return "/admin/dashboard";
        }
        sanPhamService.insertSP(sanPham);
        model.addAttribute("view", "../admin/san-pham/list-sp.jsp");
        return "redirect:/admin/san-pham/hien-thi";

    }

    @RequestMapping("/admin/san-pham/update/{id}")
    public String updateSP(Model model, @PathVariable UUID id, @Valid @ModelAttribute("sanPham") SanPham sanPham, BindingResult result) {
        if (result.hasErrors()){
            model.addAttribute("mess","Vui lòng nhập đúng và đủ các trường trên !");
//            return "/san-pham/view-update/"+sanPham.getId();
            model.addAttribute("view", "../admin/san-pham/add_update.jsp");
            return "/admin/dashboard";
        }

        sanPhamService.updateSP(sanPham,sanPham.getId());
        model.addAttribute("view", "../admin/san-pham/list-sp.jsp");

        return "redirect:/admin/san-pham/hien-thi";

    }

    @RequestMapping("/admin/san-pham/view-add")
    public String viewAdd(@ModelAttribute("sanPham") SanPham sanPham, Model model) {
        model.addAttribute("action", "/admin/san-pham/add");
        model.addAttribute("view", "../admin/san-pham/add_update.jsp");

        return "/admin/dashboard";
    }


    @RequestMapping("/admin/san-pham/view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model) {
        SanPham sanPham = sanPhamService.getOne(id);
        model.addAttribute("sanPham",sanPham);
        model.addAttribute("action", "/admin/san-pham/update/" + sanPham.getId());
        model.addAttribute("view", "../admin/san-pham/add_update.jsp");

        return "/admin/dashboard";
    }

//    @RequestMapping("/delete/{id}")
//    public String deleteSP(@PathVariable UUID id, Model model) {
//        sanPhamService.deleteSP(id);
//        return "redirect:/san-pham/hien-thi";
//
//    }
@RequestMapping("/chi-tiet-san-pham/view-add/{id}")
public String viewAdd(Model model, @ModelAttribute("sanpham") QLSanPham sp, @PathVariable("id") UUID id) {
    model.addAttribute("lg", new LoaiGiay());
    model.addAttribute("degiay", new DeGiay());
    model.addAttribute("vm", new ChatLieu());
    model.addAttribute("kichco", new KichCo());
    model.addAttribute("ms", new MauSac());
    SanPham sanPham1 = sanPhamService.getOne(id);
    model.addAttribute("tensp", sanPham1.getTenSanPham());
    model.addAttribute("action", "/chi-tiet-san-pham/add/" + sanPham1.getId());
    model.addAttribute("view", "../admin/chi-tiet-san-pham/add_update.jsp");
    return "/admin/dashboard";
}

    // add ctsp
    @PostMapping("/chi-tiet-san-pham/add/{id}")
    public String AddSanPham(Model model, @PathVariable("id") UUID id, @Valid @ModelAttribute("sanpham") QLSanPham sp, BindingResult result) throws IOException {
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
//        MultipartFile multipartFile = sp.getHinhAnh();
//        String fileName = multipartFile.getOriginalFilename();
//        try {
//            FileCopyUtils.copy(sp.getHinhAnh().getBytes(), new File(this.fileUpload + fileName));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        ctsp.setHinhAnh(fileName);
        // Lấy đường dẫn thư mục "static/images"
//        String uploadDir = new File("src/main/resources/static/image/").getAbsolutePath();
//
//        MultipartFile multipartFile = sp.getHinhAnh();
//        String fileName = multipartFile.getOriginalFilename();
//        try {
//            FileCopyUtils.copy(multipartFile.getBytes(), new File(uploadDir + File.separator + fileName));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        ctsp.setHinhAnh(fileName);
        //

        model.addAttribute("tensp", sanPham1.getTenSanPham());
        service.addKC(ctsp);

        //generate code qr
//        String documentsPath = System.getProperty("user.home") + File.separator + "Documents";
//        String qrCodeFolderPath = documentsPath + File.separator + "QRCode";
//        new File(qrCodeFolderPath).mkdirs(); // Tạo thư mục "QRCode" nếu chưa tồn tại
//
//        // Lưu QR code vào thư mục "QRCode" trong "Documents"
//        QRCodeGenerator.generatorQRCode(ctsp, qrCodeFolderPath);
//        List<ChiTietSanPham> qlSanPhams = service.getList();
//        if (qlSanPhams.size() != 0) {
//            for (ChiTietSanPham ct : qlSanPhams
//            ) {
//                QRCodeGenerator.generatorQRCode(ct);
//            }
//        }
        return "redirect:/chi-tiet-san-pham/hien-thi";
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
        model.addAttribute("view", "../admin/chi-tiet-san-pham/index.jsp");
        return "redirect:/chi-tiet-san-pham/view-add/" + sanPham1.getId();
    }

    @RequestMapping("/san-pham/kich-co/add/{id}")
    public String addKC(Model model, @Valid @ModelAttribute("kichco") KichCo kichCo, @PathVariable("id") UUID id, BindingResult resultt) {
        SanPham sanPham22 = sanPhamService.getOne(id);
        Boolean hasError = resultt.hasErrors();
        model.addAttribute("idsp", sanPham22.getId());
        model.addAttribute("tensp", sanPham22.getTenSanPham());
        model.addAttribute("vm", new ChatLieu());
        model.addAttribute("degiay", new DeGiay());
        model.addAttribute("ms", new MauSac());
        model.addAttribute("lg", new LoaiGiay());
        if (kichCo != null) {
            hasError = true;
            model.addAttribute("maspError", "Vui lòng không nhập trùng mã");
            model.addAttribute("view", "../admin/chi-tiet-san-pham/add_update.jsp");
            return "redirect:/chi-tiet-san-pham/view-add/" + sanPham22.getId();
        }
        if (hasError) {
            // Báo lỗi
            model.addAttribute("view", "../admin/chi-tiet-san-pham/add_update.jsp");
            return "redirect:/chi-tiet-san-pham/view-add/" + sanPham22.getId();
        }
        this.kichCoService.insertKC(kichCo);
        model.addAttribute("view", "../admin/chi-tiet-san-pham/add_update.jsp");
        return "redirect:/chi-tiet-san-pham/view-add/" + sanPham22.getId();
    }

    @PostMapping("/san-pham/mau-sac/add/{id}")
    public String add(@Valid @ModelAttribute("ms") MauSac ms, @PathVariable("id") UUID id, BindingResult result, Model model) {
        SanPham sanPham2 = sanPhamService.getOne(id);
        model.addAttribute("idsp", sanPham2.getId());
        model.addAttribute("tensp", sanPham2.getTenSanPham());
        model.addAttribute("vm", new ChatLieu());
        model.addAttribute("degiay", new DeGiay());
        model.addAttribute("kichco", new KichCo());
        model.addAttribute("lg", new LoaiGiay());
        if (result.hasErrors()) {
            return "redirect:/chi-tiet-san-pham/view-add/" + sanPham2.getId();
        } else {
            this.mauSacReponsitories.save(ms);
        }
        model.addAttribute("view", "../admin/chi-tiet-san-pham/add_update.jsp");
        return "redirect:/chi-tiet-san-pham/view-add/" + sanPham2.getId();
    }

    @Autowired
    ChatLieuService chatLieuService;

    @RequestMapping("/san-pham/chat-lieu/add/{id}")
    public String store(Model model, @PathVariable("id") UUID id,
                        @Valid @ModelAttribute("vm") ChatLieu cl,
                        BindingResult result
    ) {
        SanPham sanPham2 = sanPhamService.getOne(id);
        model.addAttribute("idsp", sanPham2.getId());
        model.addAttribute("tensp", sanPham2.getTenSanPham());
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
            return "redirect:/chi-tiet-san-pham/view-add/" + sanPham2.getId();
        }
        if (hasError) {
            // Báo lỗi
            model.addAttribute("view", "../admin/chi-tiet-san-pham/add_update.jsp");
            return "redirect:/chi-tiet-san-pham/view-add/" + sanPham2.getId();
        }
        this.chatLieuRepo.save(cl);
        model.addAttribute("view", "../admin/chi-tiet-san-pham/add_update.jsp");
        return "redirect:/chi-tiet-san-pham/view-add/" + sanPham2.getId();
    }

    @PostMapping("/san-pham/de-giay/add/{id}")
    public String add(Model model, @PathVariable("id") UUID id, @Valid @ModelAttribute("degiay") DeGiay degiay, BindingResult result) {
        SanPham sanPham2 = sanPhamService.getOne(id);
        model.addAttribute("idsp", sanPham2.getId());
        model.addAttribute("tensp", sanPham2.getTenSanPham());
        model.addAttribute("ms", new MauSac());
        model.addAttribute("vm", new ChatLieu());
        model.addAttribute("kichco", new KichCo());
        model.addAttribute("lg", new LoaiGiay());
        if (result.hasErrors()) {
            model.addAttribute("view", "../admin/chi-tiet-san-pham/add_update.jsp");
            return "redirect:/chi-tiet-san-pham/view-add/" + sanPham2.getId();
        }

        if (deGiayRepo.findByMa(degiay.getMa()) != null) {
            model.addAttribute("mess_Ma", "Lỗi! Mã không được trùng");
            model.addAttribute("view", "../admin/chi-tiet-san-pham/add_update.jsp");
            return "redirect:/chi-tiet-san-pham/view-add/" + sanPham2.getId();
        }

        deGiayRepo.save(degiay);
        model.addAttribute("view", "../admin/chi-tiet-san-pham/add_update.jsp");
        return "redirect:/chi-tiet-san-pham/view-add/" + sanPham2.getId();
    }
    @RequestMapping("/search")
    public String searchSPWithKeyWord(@ModelAttribute("searchForm") SearchForm searchForm, @RequestParam(defaultValue = "0") int p, Model model) {

        if (p < 0) {
            p = 0;
        }
        Pageable pageable = PageRequest.of(p, 5);
        Page<SanPham> page = sanPhamService.searchSPkeyWord(searchForm.keyword, pageable);
        model.addAttribute("page", page);
        model.addAttribute("list", sanPhamService.getListSP());
        model.addAttribute("view", "../admin/san-pham/list-sp.jsp");

        return "/admin/dashboard";

    }

}
