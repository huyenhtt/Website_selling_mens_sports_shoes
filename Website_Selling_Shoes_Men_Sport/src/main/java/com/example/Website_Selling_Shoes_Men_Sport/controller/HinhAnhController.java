package com.example.Website_Selling_Shoes_Men_Sport.controller;

import com.example.Website_Selling_Shoes_Men_Sport.entity.ChiTietSanPham;
import com.example.Website_Selling_Shoes_Men_Sport.entity.HinhAnh;
import com.example.Website_Selling_Shoes_Men_Sport.entity.SanPham;
import com.example.Website_Selling_Shoes_Men_Sport.repository.HinhAnhRepository;
import com.example.Website_Selling_Shoes_Men_Sport.service.HinhAnhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Controller
public class HinhAnhController {
    @Autowired
    HinhAnhService service;

    @Autowired
    HinhAnhRepository repository;


    @GetMapping("/hinh-anh/hien-thi")
    public String hienThi(Model model, @RequestParam(defaultValue = "0") int p) {
        model.addAttribute("view", "../hinh-anh/list.jsp");
        if (p < 0) {
            p = 0;
        }
        Pageable pageable = PageRequest.of(p, 5);
        Page<HinhAnh> page = service.listHinhAnh(pageable);
        model.addAttribute("page", page);
        return "/admin/dashboard";
    }
    @GetMapping("/hinh-anh/hien-thi/list")
    public ResponseEntity<?> index() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/hinh-anh/view-update/{id}")
    public String viewUpdate(Model model, @ModelAttribute("hinhAnh") HinhAnh hinhAnh, @PathVariable(name = "id") UUID id) {
        HinhAnh hinhAnh2 = service.findById(id);
        UUID idctsp = repository.getIdCTSP(id);
        model.addAttribute("idctsp", idctsp);
        model.addAttribute("listHinhAnh", hinhAnh2);
        model.addAttribute("action4", "/hinh-anh/update/" + hinhAnh2.getId());
        model.addAttribute("view", "../hinh-anh/add_update.jsp");
        return "/admin/dashboard";
    }

    @RequestMapping("/hinh-anh/update/{id}")
    public String update(@PathVariable(name = "id") UUID id,
                         @RequestParam(name = "tenanh") MultipartFile tenanh,
                         @RequestParam(name = "duongdan1") MultipartFile duongdan1,
                         @RequestParam(name = "duongdan2") MultipartFile duongdan2,
                         @RequestParam(name = "duongdan3") MultipartFile duongdan3,
                         @RequestParam(name = "ctsp") ChiTietSanPham ctsp, Model model) {
        HinhAnh hinhAnh = service.findById(id);
        model.addAttribute("hinhANh", hinhAnh);
        UUID idctsp = repository.getIdCTSP(id);
        model.addAttribute("idctsp", idctsp);
        // Cập nhật ảnh "tenanh" nếu người dùng đã chọn
        if (!tenanh.isEmpty()) {
            String newTenAnh = saveImage(tenanh);
            hinhAnh.setTenanh(newTenAnh);
        }
        if (!duongdan1.isEmpty()) {
            String newDuongdan1 = saveImage(duongdan1);
            hinhAnh.setDuongdan1(newDuongdan1);
        }
        if (!duongdan2.isEmpty()) {
            String newDuongdan2 = saveImage(duongdan2);
            hinhAnh.setDuongdan2(newDuongdan2);
        }
        if (!duongdan3.isEmpty()) {
            String newDuongdan3 = saveImage(duongdan3);
            hinhAnh.setDuongdan3(newDuongdan3);
        }

        repository.save(hinhAnh);

        return "redirect:/hinh-anh/hien-thi";
    }

    //
    @RequestMapping("/hinh-anh-ctsp/update/{id}")
    public String updateHinhAnhCTSP(@PathVariable(name = "id") UUID id,
                                    @RequestParam(name = "tenanh") MultipartFile tenanh,
                                    @RequestParam(name = "duongdan1") MultipartFile duongdan1,
                                    @RequestParam(name = "duongdan2") MultipartFile duongdan2,
                                    @RequestParam(name = "duongdan3") MultipartFile duongdan3,

                                    @RequestParam(name = "ctsp") ChiTietSanPham ctsp, Model model) {
        HinhAnh hinhAnh = service.findById(id);
        model.addAttribute("hinhANh", hinhAnh);
        UUID idctsp = repository.getIdCTSP(id);
        SanPham sp = service.getSanPhamByIDCTSP(idctsp);
        model.addAttribute("idctsp", idctsp);
        // Cập nhật ảnh "tenanh" nếu người dùng đã chọn
        if (!tenanh.isEmpty()) {
            String newTenAnh = saveImage(tenanh);
            hinhAnh.setTenanh(newTenAnh);
        }
        if (!duongdan1.isEmpty()) {
            String newDuongdan1 = saveImage(duongdan1);
            hinhAnh.setDuongdan1(newDuongdan1);
        }
        if (!duongdan2.isEmpty()) {
            String newDuongdan2 = saveImage(duongdan2);
            hinhAnh.setDuongdan2(newDuongdan2);
        }
        if (!duongdan3.isEmpty()) {
            String newDuongdan3 = saveImage(duongdan3);
            hinhAnh.setDuongdan3(newDuongdan3);
        }

        repository.save(hinhAnh);

        return "redirect:/chi-tiet-san-pham/list-san-pham/" + sp.getId();
    }

    //
    @RequestMapping("/hinh-anh-spct/update/{id}")
    public String updateHinhAnh(@PathVariable(name = "id") UUID id,
                                @RequestParam(name = "tenanh") MultipartFile tenanh,
                                @RequestParam(name = "duongdan1") MultipartFile duongdan1,
                                @RequestParam(name = "duongdan2") MultipartFile duongdan2,
                                @RequestParam(name = "duongdan3") MultipartFile duongdan3,
                                @RequestParam(name = "ctsp") ChiTietSanPham ctsp, Model model) {
        HinhAnh hinhAnh = service.findById(id);
        model.addAttribute("hinhANh", hinhAnh);
        UUID idctsp = repository.getIdCTSP(id);
        model.addAttribute("idctsp", idctsp);
        // Cập nhật ảnh "tenanh" nếu người dùng đã chọn
        if (!tenanh.isEmpty()) {
            String newTenAnh = saveImage(tenanh);
            hinhAnh.setTenanh(newTenAnh);
        }
        if (!duongdan1.isEmpty()) {
            String newDuongdan1 = saveImage(duongdan1);
            hinhAnh.setDuongdan1(newDuongdan1);
        }
        if (!duongdan2.isEmpty()) {
            String newDuongdan2 = saveImage(duongdan2);
            hinhAnh.setDuongdan2(newDuongdan2);
        }
        if (!duongdan3.isEmpty()) {
            String newDuongdan3 = saveImage(duongdan3);
            hinhAnh.setDuongdan3(newDuongdan3);
        }

        repository.save(hinhAnh);
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }

    //
    private String saveImage(MultipartFile file) {

        String newImageFileName = UUID.randomUUID().toString() + ".jpg";
        String imagePath = service.getImageUploadPath() + File.separator + newImageFileName;

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(imagePath);
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return newImageFileName;
    }
}
