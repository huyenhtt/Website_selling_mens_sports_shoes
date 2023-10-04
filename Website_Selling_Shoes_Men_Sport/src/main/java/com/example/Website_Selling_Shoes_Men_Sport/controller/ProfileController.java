package com.example.Website_Selling_Shoes_Men_Sport.controller;

import com.example.Website_Selling_Shoes_Men_Sport.entity.Account;
import com.example.Website_Selling_Shoes_Men_Sport.entity.NguoiDung;
import com.example.Website_Selling_Shoes_Men_Sport.service.NguoiDungService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/admin/profile")
public class ProfileController {
    @Autowired
    HttpSession session;
    @Autowired
    NguoiDungService ndService;

    @GetMapping()
    public String index(Model model, @ModelAttribute("nd") NguoiDung nds) {
        //Cần login

        Account account = (Account) session.getAttribute("account");
        NguoiDung nd = ndService.getObjByAccount(account.getId());

        System.out.println(account);
        System.out.println(nd);
        if (nd==null) {
            return "redirect:/admin/login";
        }
        model.addAttribute("nd", nd);
        model.addAttribute("action", "/admin/profile/update/"+nd.getId());
        model.addAttribute("view", "../admin/profile/index.jsp");
        return "/admin/dashboard";

    }
    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") UUID id, @Valid @ModelAttribute("nd") NguoiDung nds, BindingResult result) {
        nds.setId(id);
        ndService.update(nds);
        return "redirect:/admin/profile";
    }
}
