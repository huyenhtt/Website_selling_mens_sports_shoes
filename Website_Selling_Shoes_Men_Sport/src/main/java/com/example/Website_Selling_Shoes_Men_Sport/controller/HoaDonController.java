package com.example.Website_Selling_Shoes_Men_Sport.controller;

import com.example.Website_Selling_Shoes_Men_Sport.entity.HoaDon;
import com.example.Website_Selling_Shoes_Men_Sport.service.HoaDonService;
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
@RequestMapping("/admin/hoa-don")
public class HoaDonController {

    @Autowired
    private HoaDonService hoaDonService;

    @ModelAttribute("dsTrangThai")
    public Map<Integer, String> dsTrangThai(){
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "Còn");
        map.put(1, "Hết");
        return map;
    }

    @ModelAttribute("dsHinhThucThanhoan")
    public Map<Integer, String> dsHinhThucThanhoan(){
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "Tiền mặt");
        map.put(1, "Chuyển khoản");
        return map;
    }

    @ModelAttribute("dsHinhThucGiaoHang")
    public Map<Integer, String> dsHinhThucGiaoHang(){
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "Tự giao hàng");
        map.put(1, "Thuê shipper");
        return map;
    }

    @Data
    public static class Searchform {
        String keyword;
    }

    @RequestMapping("/hien-thi")
    public String getListHD(@RequestParam(defaultValue = "0") int p, Model model){
        if(p < 0){
            p = 0;
        }
        Pageable pageable = PageRequest.of(p, 5);
        Page<HoaDon> page = hoaDonService.getListHoaDon(pageable);
        model.addAttribute("page", page);
        model.addAttribute("searchForm", new Searchform());
        model.addAttribute("view", "../admin/hoa-don/list-hd.jsp");
        return "/admin/dashboard";
    }

    @RequestMapping("/view-add")
    public String viewAdd(@ModelAttribute("hoaDon") HoaDon hoaDon, Model model) {
        model.addAttribute("action", "/admin/hoa-don/add");
        model.addAttribute("view", "../admin/hoa-don/add_update.jsp");
        return "/admin/dashboard";
    }

    @RequestMapping("/view-update/{id}")
    public String viewUpdate(@PathVariable UUID id, Model model) {
        HoaDon hoaDon = hoaDonService.getOne(id);
        model.addAttribute("hoaDon", hoaDon);
        model.addAttribute("action", "/admin/hoa-don/update/" + hoaDon.getId());
        model.addAttribute("view", "../admin/hoa-don/add_update.jsp");
        return "/admin/dashboard";
    }

    @RequestMapping("/add")
    public String addHoaDon(Model model, @Valid @ModelAttribute("hoaDon") HoaDon hoaDon, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("mess", "Vui lòng nhập đúng các thuộc tính !");
            model.addAttribute("view", "../admin/hoa-don/add_update.jsp");
            return "/admin/dashboard";
        }
        hoaDonService.insertHD(hoaDon);
        model.addAttribute("view", "../admin/hoa-don/list-hd.jsp");
        return "redirect:/admin/hoa-don/hien-thi";

    }

    @RequestMapping("/update/{id}")
    public String updateHoaDon( Model model,@Valid @ModelAttribute("hoaDon") HoaDon hoaDon, @PathVariable UUID id, BindingResult result) {
        if (result.hasErrors()){
            model.addAttribute("mess", "Vui lòng nhập đúng các thuộc tính !");
            model.addAttribute("view", "../admin/hoa-don/add_update.jsp");
            return "/admin/dashboard";
        }

        hoaDonService.updateHD(hoaDon,hoaDon.getId());
        model.addAttribute("view", "../admin/hoa-don/list-hd.jsp");
        return "redirect:/admin/hoa-don/hien-thi";
    }

    @RequestMapping("/delete/{id}")
    public String deleteHoaDon(@PathVariable UUID id) {
        hoaDonService.deleteHD(id);
        return "redirect:/admin/hoa-don/hien-thi";
    }

    @RequestMapping("/search")
    public String searchHoaDon(@ModelAttribute("searchForm") HoaDonController.Searchform searchform, @RequestParam(defaultValue = "0") int p, Model model){
        if (p<0){
            p=0;
        }
        Pageable pageable=PageRequest.of(p,5);
        Page<HoaDon> page=hoaDonService.searchHD(searchform.keyword,pageable);
        model.addAttribute("page",page);
        model.addAttribute("view", "../admin/hoadon/list-hd.jsp");
        return "/admin/dashboard";
    }

}
