package com.example.Website_Selling_Shoes_Men_Sport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    //phần test
    @GetMapping("/home")
    public String home() {
        return "/home/a";
    }

    @GetMapping("/cart")
    public String cart() {
        return "/home/cart";
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

    @GetMapping("/detail-product")
    public String detail() {
        return "/home/product-detail";
    }

    @GetMapping("/checkout")
    public String checkout() {
        return "/home/checkout";
    }
}
