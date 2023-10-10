package com.example.Website_Selling_Shoes_Men_Sport.controller;

import com.example.Website_Selling_Shoes_Men_Sport.entity.HoaDonChiTiet;
import com.example.Website_Selling_Shoes_Men_Sport.service.HoaDonChiTietService;
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

import java.util.UUID;

@Controller
@RequestMapping("/admin/hoa-don-chi-tiet")
public class HoaDonChiTietController {

    @Autowired
    private HoaDonChiTietService hoaDonChiTietService;

    @Data
    public static class Searchform{
        String keyword;
    }

    @RequestMapping("/hien-thi")
    public String getListHDCT(@RequestParam(defaultValue = "0") int p, Model model){
        if(p < 0){
            p =0;
        }
        Pageable pageable = PageRequest.of(p, 5);
        Page<HoaDonChiTiet> page = hoaDonChiTietService.getListHDCT(pageable);
        model.addAttribute("page", page);
        model.addAttribute("searchForm", new Searchform());
        model.addAttribute("view", "../admin/hoa-don-chi-tiet/list-hdct.jsp");
        return "/admin/dashboard";
    }

    @RequestMapping("/view-add")
    public String viewAdd(@ModelAttribute("hoaDonChiTiet") HoaDonChiTiet hoaDonChiTiet, Model model) {
        model.addAttribute("action", "/admin/hoa-don-chi-tiet/add");
        model.addAttribute("view", "../admin/hoa-don-chi-tiet/add_update.jsp");
        return "/admin/dashboard";
    }

    @RequestMapping("/view-update/{id}")
    public String viewUpdate(@PathVariable UUID id, Model model) {
        HoaDonChiTiet hoaDonChiTiet = hoaDonChiTietService.getOne(id);
        model.addAttribute("hoaDonChiTiet", hoaDonChiTiet);
        model.addAttribute("action", "/admin/hoa-don-chi-tiet/update/" + hoaDonChiTiet.getId());
        model.addAttribute("view", "../admin/hoa-don-chi-tiet/add_update.jsp");
        return "/admin/dashboard";
    }

    @RequestMapping("/add")
    public String addHDCT(Model model, @Valid @ModelAttribute("hoaDonChiTiet") HoaDonChiTiet hoaDonChiTiet, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("mess", "Vui lòng nhập đúng các thuộc tính !");
            model.addAttribute("view", "../admin/hoa-don-chi-tiet/add_update.jsp");
            return "/admin/dashboard";
        }
        hoaDonChiTietService.insertHDCT(hoaDonChiTiet);
        model.addAttribute("view", "../admin/hoa-don-chi-tiet/list-hdct.jsp");
        return "redirect:/admin/hoa-don-chi-tiet/hien-thi";

    }

    @RequestMapping("/update/{id}")
    public String updateHDCT( Model model,@Valid @ModelAttribute("hoaDonChiTiet") HoaDonChiTiet hoaDonChiTiet, @PathVariable UUID id, BindingResult result) {
        if (result.hasErrors()){
            model.addAttribute("mess", "Vui lòng nhập đúng các thuộc tính !");
            model.addAttribute("view", "../admin/hoa-don-chi-tiet/add_update.jsp");
            return "/admin/dashboard";
        }

        hoaDonChiTietService.updateHDCT(hoaDonChiTiet,hoaDonChiTiet.getId());
        model.addAttribute("view", "../admin/hoa-don-chi-tiet/list-hdct.jsp");
        return "redirect:/admin/hoa-don-chi-tiet/hien-thi";
    }

    @RequestMapping("/delete/{id}")
    public String deleteHDCT(@PathVariable UUID id) {
        hoaDonChiTietService.deleteHDCT(id);
        return "redirect:/admin/hoa-don-chi-tiet/hien-thi";
    }

}
