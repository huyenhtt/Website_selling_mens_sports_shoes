package com.example.Website_Selling_Shoes_Men_Sport.controller;

import com.example.Website_Selling_Shoes_Men_Sport.entity.KichCo;
import com.example.Website_Selling_Shoes_Men_Sport.service.KichCoService;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/admin/kich-co")
public class KichCoController {
    @Autowired
    private KichCoService kichCoService;

    @ModelAttribute("dsGioiTinh")
    public Map<Boolean, String> dsGioiTinh() {
        Map<Boolean, String> map = new HashMap<>();
        map.put(true, "Nam");
        map.put(false, "Nu");
        return map;
    }

    @ModelAttribute("dsTrangThai")
    public Map<Integer, String> dsTrangThai() {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "Còn");
        map.put(1, "Hết");
        return map;
    }

    @Data
    public static class Searchform {
        String keyword;
    }

    @RequestMapping("/hien-thi")
    public String getListKC(@RequestParam(defaultValue = "0") int p, Model model) {
        if (p < 0) {
            p = 0;
        }
        Pageable pageable = PageRequest.of(p, 5);
        Page<KichCo> page = kichCoService.getListKichCo(pageable);
        model.addAttribute("page", page);
        model.addAttribute("searchForm", new Searchform());
        model.addAttribute("view", "../admin/kich-co/list-kc.jsp");
        return "/admin/dashboard";
    }

    @RequestMapping("/view-add")
    public String viewAdd(@ModelAttribute("kichCo") KichCo kichCo, Model model) {
        model.addAttribute("action", "admin/kich-co/add");
        model.addAttribute("view", "../admin/kich-co/add_update.jsp");
        return "/admin/dashboard";
    }

    @RequestMapping("/view-update/{id}")
    public String viewUpdate(@PathVariable UUID id, Model model) {
        KichCo kichCo = kichCoService.getOne(id);
        model.addAttribute("kichCo", kichCo);
        model.addAttribute("action", "/admin/kich-co/update/" + kichCo.getId());
        model.addAttribute("view", "../admin/kich-co/add_update.jsp");
        return "/admin/dashboard";

    }

    @RequestMapping("/add")
    public String addKichCo(Model model, @Valid @ModelAttribute("kichCo") KichCo kichCo, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("mess", "Vui lòng nhập đúng các thuộc tính !");
            model.addAttribute("view", "../admin/kich-co/add_update.jsp");
            return "/admin/dashboard";
        }
        kichCoService.insertKC(kichCo);
        return "redirect:/admin/kich-co/hien-thi";

    }

    @RequestMapping("/delete/{id}")
    public String deleteKichCo(@PathVariable UUID id) {
        kichCoService.deleteKC(id);
        return "redirect:/admin/kich-co/hien-thi";

    }

    @RequestMapping("/update/{id}")
    public String updateKichCo(Model model, @Valid @ModelAttribute("kichCo") KichCo kichCo, @PathVariable UUID id, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("mess", "Vui lòng nhập đúng các thuộc tính !");
            model.addAttribute("view", "../admin/kich-co/add_update.jsp");
            return "/admin/dashboard";
        }

        kichCoService.updateKC(kichCo, kichCo.getId());
        return "redirect:/admin/kich-co/hien-thi";

    }

    @RequestMapping("/search")
    public String searchKichCo(@ModelAttribute("searchForm") KichCoController.Searchform searchform, @RequestParam(defaultValue = "0") int p, Model model) {
        if (p < 0) {
            p = 0;
        }
        Pageable pageable = PageRequest.of(p, 5);
        Page<KichCo> page = kichCoService.searchKC(searchform.keyword, pageable);
        model.addAttribute("page", page);
        model.addAttribute("view", "../admin/kich-co/list-kc.jsp");
        return "/admin/dashboard";

    }
}
