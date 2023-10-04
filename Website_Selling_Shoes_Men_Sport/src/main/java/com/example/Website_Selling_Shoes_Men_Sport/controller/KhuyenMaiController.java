package com.example.Website_Selling_Shoes_Men_Sport.controller;

import com.example.Website_Selling_Shoes_Men_Sport.entity.KhuyenMai;
import com.example.Website_Selling_Shoes_Men_Sport.service.KhuyenMaiService;
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
@RequestMapping("/admin/khuyen-mai")
public class KhuyenMaiController {
    @Autowired
    KhuyenMaiService khuyenMaiService;

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

    @RequestMapping("/hien-khuyen-mai")
    public String getListKhuyenMai(@RequestParam(defaultValue = "0") int p, Model model) {
        if (p < 0) {
            p = 0;
        }
        Pageable pageable = PageRequest.of(p, 5);
        Page<KhuyenMai> page = khuyenMaiService.getListKhuyenMai(pageable);
        model.addAttribute("page", page);
        model.addAttribute("searchForm", new Searchform());
        model.addAttribute("view", "../admin/khuyen-mai/list-khuyenmai.jsp");
        return "/admin/dashboard";
    }

    @RequestMapping("/view-add")
    public String viewAdd(@ModelAttribute("khuyenMai") KhuyenMai khuyenMai, Model model) {
        model.addAttribute("action", "/admin/khuyen-mai/add");
        model.addAttribute("view", "../admin/khuyen-mai/add.jsp");
        return "/admin/dashboard";
    }

    @RequestMapping("/view-update/{id}")
    public String viewUpdate(@PathVariable UUID id, Model model) {
        KhuyenMai khuyenMai = khuyenMaiService.GetKhuyenMaiById(id);
        model.addAttribute("khuyenMai", khuyenMai);
        model.addAttribute("action", "/admin/khuyen-mai/update/" + khuyenMai.getId());
        model.addAttribute("view", "../admin/khuyen-mai/update.jsp");
        return "/admin/dashboard";
    }
    @RequestMapping("/add")
    public String addKhuyenMai(Model model, @Valid @ModelAttribute("khuyenMai") KhuyenMai khuyenMai, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("mess", "Vui lòng nhập đúng các thuộc tính !");
            model.addAttribute("view", "../admin/khuyen-mai/add.jsp");
            return "/admin/dashboard";
        }
        khuyenMaiService.AddKhuyenMai(khuyenMai);
        return "redirect:/admin/khuyen-mai/hien-khuyen-mai";

    }
    @RequestMapping("/delete/{id}")
    public String deleteKhuyenMai(@PathVariable UUID id, Model model) {
        khuyenMaiService.DeleteKhuyenMai(id);
        return "redirect:/admin/khuyen-mai/hien-khuyen-mai";

    }

    @RequestMapping("/update/{id}")
    public String updateKhuyenMai( Model model,@Valid @ModelAttribute("khuyenMai") KhuyenMai khuyenMai, @PathVariable UUID id, BindingResult result) {
        if (result.hasErrors()){
            model.addAttribute("mess", "Vui lòng nhập đúng các thuộc tính !");
            model.addAttribute("view", "../admin/khuyen-mai/update.jsp");
            return "/admin/dashboard";
        }

        khuyenMaiService.UpdateKhuyenMai(khuyenMai,khuyenMai.getId());
        return "redirect:/admin/khuyen-mai/hien-khuyen-mai";

    }
    @RequestMapping("/search")
    public String searchKhuyenMai(@ModelAttribute("searchForm") KhuyenMaiController.Searchform searchform, @RequestParam(defaultValue = "0") int p, Model model){
        if (p<0){
            p=0;
        }
        Pageable pageable=PageRequest.of(p,5);
        Page<KhuyenMai> page=khuyenMaiService.searchKhuyenMai(searchform.keyword,pageable);
        model.addAttribute("page",page);
        model.addAttribute("view", "../admin/khuyen-mai/list-khuyenmai.jsp");
        return "/admin/dashboard";
    }
}
