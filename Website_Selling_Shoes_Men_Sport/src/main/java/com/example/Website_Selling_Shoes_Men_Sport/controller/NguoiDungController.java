package com.example.Website_Selling_Shoes_Men_Sport.controller;

import com.example.Website_Selling_Shoes_Men_Sport.entity.Account;
import com.example.Website_Selling_Shoes_Men_Sport.entity.NguoiDung;
import com.example.Website_Selling_Shoes_Men_Sport.service.AccountService;
import com.example.Website_Selling_Shoes_Men_Sport.service.NguoiDungService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/admin/user")
public class NguoiDungController {

        private Boolean isUser = true;
        @Autowired
        private NguoiDungService ndService;
        @Autowired
        private AccountService tkService;
        @ModelAttribute("tk")
        public Account tk(){
            return new Account();
        }

        @GetMapping()
        public String index(Model model, @RequestParam(defaultValue = "0") int p) {
            if (p < 0) {
                p = 0;
            }
            Pageable pageable = PageRequest.of(p, 5);
            Page<NguoiDung> pages = ndService.getLstNguoiDung(pageable);

            model.addAttribute("lstNd", pages.getContent());
            model.addAttribute("view", "../admin/user_management/index.jsp");
            return "/admin/dashboard";
        }

        @GetMapping("/view-add")
        public String viewAdd(Model model, @ModelAttribute("nd") NguoiDung nd, @ModelAttribute("tk") Account tk) {


            model.addAttribute("view", "../admin/user_management/form.jsp");

            model.addAttribute("action", "/admin/user/add-user");
            return "/admin/dashboard";
        }

        @GetMapping("/search")
        public String search(@RequestParam("search") String search,@RequestParam(defaultValue = "0") int p, Model model) {
            if (p<0){
                p=0;
            }
            Pageable pageable= PageRequest.of(p,5);
            Page<NguoiDung> page= ndService.searchND(search,pageable);
            model.addAttribute("lstNd",page.getContent());
            model.addAttribute("view", "../admin/user_management/index.jsp");
            return "/admin/dashboard";
        }

        @PostMapping("/add-user")
        public String add(@Valid @ModelAttribute("nd") NguoiDung nd, BindingResult result, @RequestParam("username") String username, Model model){

            Account account = new Account();
            account.setUsername(username);
            tkService.save(account);
            if (result.hasErrors()){
                return "admin/user_management/form";
            }
            nd.setCreateDate(new Date());
            nd.setLastModifiedDate(new Date());
            nd.setAccount(account);
            ndService.save(nd);

            return "redirect:/admin/user";
        }


        @PostMapping("/update-user/{id}")
        public String update(@Valid @ModelAttribute("nd") NguoiDung nd, Model model, @PathVariable("id") UUID id) {

            NguoiDung nd1 = ndService.getObj(id);
            nd.setId(nd1.getId());
            nd.setAccount(nd1.getAccount());
            nd.setCreateDate(nd1.getCreateDate());
            nd.setLastModifiedDate(new Date());
            ndService.update(nd);

            return "redirect:/admin/user";
        }

        @GetMapping("/update/{id}")
        public String viewUpdate(Model model, @PathVariable("id") UUID id) {
            NguoiDung nd = ndService.getObj(id);
            model.addAttribute("nd", nd);
            model.addAttribute("isAcc", isUser);
            model.addAttribute("action", "/admin/user/update-user/"+nd.getId());
            model.addAttribute("view", "../admin/user_management/form.jsp");
            return "/admin/dashboard";
        }
    }

