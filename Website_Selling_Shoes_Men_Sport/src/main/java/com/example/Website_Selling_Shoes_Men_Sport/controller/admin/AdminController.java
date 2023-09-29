package com.example.Website_Selling_Shoes_Men_Sport.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
//    đây là phần test
    @GetMapping("/")
    public String dashboard() {
        return "/admin/dashboard";
    }
}
