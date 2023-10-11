package com.example.Website_Selling_Shoes_Men_Sport.controller;

import com.example.Website_Selling_Shoes_Men_Sport.entity.ChiTietSanPham;
import com.example.Website_Selling_Shoes_Men_Sport.entity.HinhAnh;
import com.example.Website_Selling_Shoes_Men_Sport.service.ChiTietSanPhamService;
import com.example.Website_Selling_Shoes_Men_Sport.service.HinhAnhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("/home")
    public String home(Model model) {
        List<ChiTietSanPham> listSP = chiTietSanPhamService.getList();
        model.addAttribute("view", "../home/a.jsp");
        model.addAttribute("listSP", listSP);
        return "/home/index";
    }

    @GetMapping("/cart")
    public String cart() {
        return "/home/cart";
    }

    @GetMapping("/blog")
    public String blogSanPham(Model model) {

        model.addAttribute("view", "../home/blog.jsp");
        return "/home/index";
    }

    @GetMapping("/category")
    public String category() {
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
    public String confirmation() {
        return "/home/confirmation";
    }

    @GetMapping("/single-blog")
    public String singleBlog() {
        return "/home/single-blog";
    }
}
