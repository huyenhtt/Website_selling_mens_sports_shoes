package com.example.Website_sell_soccer_shoes_bumblebee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThongKeController {

    @GetMapping("/admin/thong-ke")
    public String getThongKe(Model model) {
        model.addAttribute("view", "../admin/thong-ke.jsp");
        return "/admin/index";
    }
}
