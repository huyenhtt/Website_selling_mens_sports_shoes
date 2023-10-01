package com.example.Website_Selling_Shoes_Men_Sport.controller;

import com.example.Website_Selling_Shoes_Men_Sport.entity.DeGiay;
import com.example.Website_Selling_Shoes_Men_Sport.service.DeGiayService;
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
@RequestMapping("/admin/de-giay")
public class DeGiayController {
    @Autowired
    DeGiayService deGiayService;

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

    @RequestMapping("/hien-de-giay")
    public String getListDeGiay(@RequestParam(defaultValue = "0") int p, Model model) {
        if (p < 0) {
            p = 0;
        }
        Pageable pageable = PageRequest.of(p, 5);
        Page<DeGiay> page = deGiayService.getListDeGiay(pageable);
        model.addAttribute("page", page);
        model.addAttribute("searchForm", new Searchform());
        return "/admin/de-giay/list-degiay";
    }

    @RequestMapping("/view-add")
    public String viewAdd(@ModelAttribute("deGiay") DeGiay deGiay, Model model) {
        model.addAttribute("action", "/admin/de-giay/add");
        return "/admin/de-giay/add";
    }

    @RequestMapping("/view-update/{id}")
    public String viewUpdate(@PathVariable UUID id, Model model) {
        DeGiay deGiay = deGiayService.GetDeGiayById(id);
        model.addAttribute("deGiay", deGiay);
        model.addAttribute("action", "/admin/de-giay/update/" + deGiay.getId());
        return "/admin/de-giay/add";
    }
    @RequestMapping("/add")
    public String addDeGiay(Model model, @Valid @ModelAttribute("deGiay") DeGiay deGiay, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("mess", "Vui lòng nhập đúng các thuộc tính !");
            return "/admin/de-giay/hien-de-giay";
        }
        deGiayService.AddDeGiay(deGiay);
        return "redirect:/admin/de-giay/hien-de-giay";

    }
    @RequestMapping("/delete/{id}")
    public String deleteDeGiay(@PathVariable UUID id, Model model) {
        deGiayService.DeleteDeGiay(id);
        return "redirect:/admin/de-giay/hien-de-giay";

    }

    @RequestMapping("/update/{id}")
    public String updateDeGiay( Model model,@Valid @ModelAttribute("deGiay") DeGiay deGiay, @PathVariable UUID id, BindingResult result) {
        if (result.hasErrors()){
            model.addAttribute("mess", "Vui lòng nhập đúng các thuộc tính !");
        }

        deGiayService.UpdateDeGiay(deGiay,deGiay.getId());
        return "redirect:/admin/de-giay/hien-de-giay";

    }
    @RequestMapping("/search")
    public String searchDeGiay(@ModelAttribute("searchForm") LoaiGiayController.Searchform searchform, @RequestParam(defaultValue = "0") int p, Model model){
        if (p<0){
            p=0;
        }
        Pageable pageable=PageRequest.of(p,5);
        Page<DeGiay> page=deGiayService.searchDeGiay(searchform.keyword,pageable);
        model.addAttribute("page",page);
        return "/admin/de-giay/list-degiay";
    }
}
