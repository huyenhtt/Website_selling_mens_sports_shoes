package com.example.Website_Selling_Shoes_Men_Sport.controller.admin;

import com.example.Website_Selling_Shoes_Men_Sport.entity.Account;
import com.example.Website_Selling_Shoes_Men_Sport.entity.ChiTietSanPham;
import com.example.Website_Selling_Shoes_Men_Sport.repository.AccountRepos;
import com.example.Website_Selling_Shoes_Men_Sport.service.AccountService;
import com.example.Website_Selling_Shoes_Men_Sport.service.ChiTietSanPhamService;
import com.example.Website_Selling_Shoes_Men_Sport.service.impl.AccountServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AccountServiceImpl service;

    @Autowired
    HttpSession session;

    //    đây là phần test
    @GetMapping("/home")
    public String dashboard(Model model) {
        model.addAttribute("view", "../admin/index.jsp");
        return "admin/dashboard";
    }

    @PostMapping("/save")
    public String saveAccount(Account account) {
        service.save(account);
        return "redirect:/admin/home";
    }

    @GetMapping("/login")
    public String login() {
        return "admin/page-login";
    }
    @Autowired
    ChiTietSanPhamService chiTietSanPhamService;
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        // TODO: Check if user/password exists in database
        for (Account a : service.findAll()) {
            if (a.getUsername().equals(username) && a.getPassword().equals(password)) {
                if (a.isRole() == true) {
                    session.setAttribute("account", a);
                    List<ChiTietSanPham> listSP = chiTietSanPhamService.getList();
                    model.addAttribute("view", "../home/a.jsp");
                    model.addAttribute("listSP", listSP);
                    return "/home/index";
                }
                if (a.isRole() == false) {
                    session.setAttribute("username", username);
                    return "redirect:/admin/home";
                }
            }
        }
        model.addAttribute("message", "Tên đăng nhập/mật khẩu không đúng");
        return "/admin/login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        return "admin/register";
    }

    @GetMapping("/logout")
    public String logout() {
        session.removeAttribute("username");
        return "redirect:/admin/login";
    }

    @GetMapping("/thong-ke")
    public String thong_ke(Model model) {
        model.addAttribute("view", "../admin/thong_ke.jsp");
        return "admin/dashboard";
    }
}
