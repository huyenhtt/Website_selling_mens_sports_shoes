package com.example.Website_Selling_Shoes_Men_Sport.controller;

import com.example.Website_Selling_Shoes_Men_Sport.entity.ChiTietSanPham;
import com.example.Website_Selling_Shoes_Men_Sport.entity.HinhAnh;
import com.example.Website_Selling_Shoes_Men_Sport.entity.LoaiGiay;
import com.example.Website_Selling_Shoes_Men_Sport.repository.ChiTietSanPhamRepo;
import com.example.Website_Selling_Shoes_Men_Sport.repository.LoaiGiayRepo;
import com.example.Website_Selling_Shoes_Men_Sport.service.ChiTietSanPhamService;
import com.example.Website_Selling_Shoes_Men_Sport.service.HinhAnhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
    //phần test
    @Autowired
    ChiTietSanPhamService chiTietSanPhamService;
    @Autowired
    HinhAnhService hinhAnhService;
    @Autowired
    LoaiGiayRepo loaiGiayRepo;

    @ModelAttribute("listLoaiGiay")
    List<LoaiGiay> listLoaiGiay() {
        return loaiGiayRepo.findAll();
    }

    @GetMapping("/home")
    public String home(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model) {
        List<ChiTietSanPham> listSP = chiTietSanPhamService.getList();
        model.addAttribute("view", "../home/a.jsp");
        model.addAttribute("listSP", listSP);
        return "/home/index";
    }

    @GetMapping("/cart")
    public String cart(Model model) {
        model.addAttribute("view", "../home/cart.jsp");
        return "/home/index";
    }

    @GetMapping("/blog")
    public String blogSanPham(Model model) {

        model.addAttribute("view", "../home/blog.jsp");
        return "/home/index";
    }

    @Autowired
    ChiTietSanPhamRepo repo;

    @GetMapping("/category")
    public String category(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model) {
        Pageable pageable = PageRequest.of(number, 5);
        Page<ChiTietSanPham> listCTSP = repo.findAll(pageable);
//        List<ChiTietSanPham> listSP = chiTietSanPhamService.getList();
        model.addAttribute("listCTSP", listCTSP);
        return "/home/category";
    }

    @GetMapping("/login")
    public String login() {
        return "/home/login";
    }

    @GetMapping("/contact")
    public String contact() {
        return "/home/contact";
    }

    @GetMapping("/product-detail/{id}")
    public String detail(Model model, @PathVariable UUID id) {
        //lấy ctsp
        ChiTietSanPham chiTietSanPham = chiTietSanPhamService.getOne(id);

        model.addAttribute("sp", chiTietSanPham);
        model.addAttribute("view", "../home/product-detail.jsp");
        return "/home/index";
    }

    @GetMapping("/checkout")
    public String checkout() {
        return "/home/checkout";
    }

    @GetMapping("/confirmation")
    public String confirmation(Model model) {
        model.addAttribute("view", "../home/confirmation.jsp");
        return "/home/index";
    }

    @GetMapping("/single-blog")
    public String singleBlog(Model model) {
        model.addAttribute("view", "../home/single-blog.jsp");
        return "/home/index";
    }

    //search lg
//    lấy ctsp theo loại giầy
    @GetMapping("/search/loai-giay/tenTheLoai")
    public String searchLG(Model model) {

        model.addAttribute("");
        return "/home/index";
    }
}
