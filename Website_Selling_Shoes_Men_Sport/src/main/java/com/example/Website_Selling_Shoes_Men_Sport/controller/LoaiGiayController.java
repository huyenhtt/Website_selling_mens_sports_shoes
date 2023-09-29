package com.example.Website_Selling_Shoes_Men_Sport.controller;

import com.example.Website_Selling_Shoes_Men_Sport.entity.LoaiGiay;
import com.example.Website_Selling_Shoes_Men_Sport.service.LoaiGiayService;
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
@RequestMapping("/admin/loai-giay")
public class LoaiGiayController {
    @Autowired
    LoaiGiayService loaiGiayService;

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
    public String getListLG(@RequestParam(defaultValue = "0") int p, Model model) {
        if (p < 0) {
            p = 0;
        }
        Pageable pageable = PageRequest.of(p, 5);
        Page<LoaiGiay> page = loaiGiayService.getListLoaiGiay(pageable);
        model.addAttribute("page", page);
        model.addAttribute("searchForm", new Searchform());
        model.addAttribute("view", "../admin/loai-giay/list-lg.jsp");
        return "/admin/dashboard";
    }

    @RequestMapping("/view-add")
    public String viewAdd(@ModelAttribute("loaiGiay") LoaiGiay loaiGiay, Model model) {
        model.addAttribute("action", "admin/loai-giay/add");
        model.addAttribute("view", "../admin/loai-giay/add_update.jsp");
        return "/admin/dashboard";

    }

    @RequestMapping("/view-update/{id}")
    public String viewUpdate(@PathVariable UUID id, Model model) {
        LoaiGiay loaiGiay = loaiGiayService.getOne(id);
        model.addAttribute("loaiGiay", loaiGiay);
        model.addAttribute("action", "/admin/loai-giay/update/" + loaiGiay.getId());
        model.addAttribute("view", "../admin/loai-giay/add_update.jsp");
        return "/admin/dashboard";

    }
    @RequestMapping("/add")
    public String addLoaiGiay(Model model, @Valid @ModelAttribute("loaiGiay") LoaiGiay loaiGiay, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("mess", "Vui lòng nhập đúng các thuộc tính !");
            model.addAttribute("view", "../admin/loai-giay/add_update.jsp");
            return "/admin/dashboard";
        }
        loaiGiayService.insertLG(loaiGiay);
        return "redirect:/admin/loai-giay/hien-thi";

    }
    @RequestMapping("/delete/{id}")
    public String deleteLoaiGiay(@PathVariable UUID id, Model model) {
        loaiGiayService.deleteLG(id);
        return "redirect:/admin/loai-giay/hien-thi";

    }

    @RequestMapping("/update/{id}")
    public String updateLoaiGiay( Model model,@Valid @ModelAttribute("loaiGiay") LoaiGiay loaiGiay, @PathVariable UUID id, BindingResult result) {
        if (result.hasErrors()){
            model.addAttribute("mess", "Vui lòng nhập đúng các thuộc tính !");
            model.addAttribute("view", "../admin/loai-giay/add_update.jsp");
            return "/admin/dashboard";
        }

        loaiGiayService.updateLG(loaiGiay,loaiGiay.getId());
        return "redirect:/admin/loai-giay/hien-thi";

    }
    @RequestMapping("/search")
    public String searchLoaiGiay(@ModelAttribute("searchForm") Searchform searchform,@RequestParam(defaultValue = "0") int p,Model model){
        if (p<0){
            p=0;
        }
        Pageable pageable=PageRequest.of(p,5);
        Page<LoaiGiay> page=loaiGiayService.searchLG(searchform.keyword,pageable);
        model.addAttribute("page",page);
        model.addAttribute("view", "../admin/loai-giay/list-lg.jsp");
        return "/admin/dashboard";

    }
}
