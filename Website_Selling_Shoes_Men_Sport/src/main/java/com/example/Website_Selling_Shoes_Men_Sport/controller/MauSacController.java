package com.example.Website_Selling_Shoes_Men_Sport.controller;

import com.example.Website_Selling_Shoes_Men_Sport.entity.MauSac;
import com.example.Website_Selling_Shoes_Men_Sport.service.MauSacService;
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
@RequestMapping("/admin/mau-sac")
public class MauSacController {
    @Autowired
    MauSacService mauSacService;

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

    @RequestMapping("/hien-mau-sac")
    public String getListMauSac(@RequestParam(defaultValue = "0") int p, Model model) {
        if (p < 0) {
            p = 0;
        }
        Pageable pageable = PageRequest.of(p, 5);
        Page<MauSac> page = mauSacService.getListMauSac(pageable);
        model.addAttribute("page", page);
        model.addAttribute("searchForm", new Searchform());
        return "/admin/mau-sac/list-mausac";
    }

    @RequestMapping("/view-add")
    public String viewAdd(@ModelAttribute("mauSac") MauSac mauSac, Model model) {
        model.addAttribute("action", "/admin/mau-sac/add");
        return "/admin/mau-sac/add";
    }

    @RequestMapping("/view-update/{id}")
    public String viewUpdate(@PathVariable UUID id, Model model) {
        MauSac mauSac = mauSacService.GetMauSacById(id);
        model.addAttribute("mauSac", mauSac);
        model.addAttribute("action", "/admin/mau-sac/update/" + mauSac.getId());
        return "/admin/mau-sac/add";
    }
    @RequestMapping("/add")
    public String addMauSac(Model model, @Valid @ModelAttribute("mauSac") MauSac mauSac, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("mess", "Vui lòng nhập đúng các thuộc tính !");
            return "/admin/mau-sac/hien-mau-sac";
        }
        mauSacService.AddMauSac(mauSac);
        return "redirect:/admin/mau-sac/hien-mau-sac";

    }
    @RequestMapping("/delete/{id}")
    public String deleteMauSac(@PathVariable UUID id, Model model) {
        mauSacService.DeleteMauSac(id);
        return "redirect:/admin/mau-sac/hien-mau-sac";

    }

    @RequestMapping("/update/{id}")
    public String updateMauSac( Model model,@Valid @ModelAttribute("mauSac") MauSac mauSac, @PathVariable UUID id, BindingResult result) {
        if (result.hasErrors()){
            model.addAttribute("mess", "Vui lòng nhập đúng các thuộc tính !");
        }

        mauSacService.UpdateMauSac(mauSac,mauSac.getId());
        return "redirect:/admin/mau-sac/hien-mau-sac";

    }
    @RequestMapping("/search")
    public String searchMauSac(@ModelAttribute("searchForm") LoaiGiayController.Searchform searchform, @RequestParam(defaultValue = "0") int p, Model model){
        if (p<0){
            p=0;
        }
        Pageable pageable=PageRequest.of(p,5);
        Page<MauSac> page=mauSacService.searchMauSac(searchform.keyword,pageable);
        model.addAttribute("page",page);
        return "/admin/mau-sac/list-mausac";
    }
}
