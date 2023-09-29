package com.example.Website_Selling_Shoes_Men_Sport.controller;

import com.example.Website_Selling_Shoes_Men_Sport.entity.SanPham;
import com.example.Website_Selling_Shoes_Men_Sport.service.impl.SanPhamServiceImpl;
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
@RequestMapping("/admin/san-pham")
public class SanPhamController {

    @ModelAttribute("dsTrangThai")
    public Map<Integer, String> getDSTT() {
        Map<Integer, String> dsTrangThai = new HashMap<>();
        dsTrangThai.put( 0,"Còn sản phẩm");
        dsTrangThai.put( 1,"Hết sản phẩm");
        return dsTrangThai;
    }

    @Data
    public static class SearchForm {
        String keyword;
    }

    @Autowired
    SanPhamServiceImpl sanPhamService;

    @RequestMapping("/hien-thi")
    public String getListSanPham(@ModelAttribute("sanPham") SanPham sanPham, @RequestParam(defaultValue = "0") int p, BindingResult result, Model model) {

        if (p < 0) {
            p = 0;
        }
        Pageable pageable = PageRequest.of(p, 5);
        Page<SanPham> page = sanPhamService.getListOfPage(pageable);
//        listSP = page.getContent();
        model.addAttribute("page", page);
        model.addAttribute("searchForm", new SearchForm());
        model.addAttribute("action", "/san-pham/listSP");
        model.addAttribute("view", "../admin/san-pham/list-sp.jsp");
        model.addAttribute("list", sanPhamService.getListSP());
        return "/admin/dashboard";
    }

    @RequestMapping("/add")
    public String addSP(Model model, @Valid @ModelAttribute("sanPham") SanPham sanPham, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("mess", "Vui lòng nhập đúng các thuộc tính !");
            model.addAttribute("view", "../admin/san-pham/add_update.jsp");
            return "/admin/dashboard";
        }
        sanPhamService.insertSP(sanPham);
        model.addAttribute("view", "../admin/san-pham/list-sp.jsp");
        return "redirect:/admin/san-pham/hien-thi";

    }

    @RequestMapping("/update/{id}")
    public String updateSP(Model model, @PathVariable UUID id, @Valid @ModelAttribute("sanPham") SanPham sanPham, BindingResult result) {
        if (result.hasErrors()){
            model.addAttribute("mess","Vui lòng nhập đúng và đủ các trường trên !");
//            return "/san-pham/view-update/"+sanPham.getId();
            model.addAttribute("view", "../admin/san-pham/add_update.jsp");
            return "/admin/dashboard";
        }

        sanPhamService.updateSP(sanPham,sanPham.getId());
        model.addAttribute("view", "../admin/san-pham/list-sp.jsp");

        return "redirect:/admin/san-pham/hien-thi";

    }

    @RequestMapping("/view-add")
    public String viewAdd(@ModelAttribute("sanPham") SanPham sanPham, Model model) {
        model.addAttribute("action", "/admin/san-pham/add");
        model.addAttribute("view", "../admin/san-pham/add_update.jsp");

        return "/admin/dashboard";
    }


    @RequestMapping("/view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model) {
        SanPham sanPham = sanPhamService.getOne(id);
        model.addAttribute("sanPham",sanPham);
        model.addAttribute("action", "/admin/san-pham/update/" + sanPham.getId());
        model.addAttribute("view", "../admin/san-pham/add_update.jsp");

        return "/admin/dashboard";
    }

//    @RequestMapping("/delete/{id}")
//    public String deleteSP(@PathVariable UUID id, Model model) {
//        sanPhamService.deleteSP(id);
//        return "redirect:/san-pham/hien-thi";
//
//    }

    @RequestMapping("/search")
    public String searchSPWithKeyWord(@ModelAttribute("searchForm") SearchForm searchForm, @RequestParam(defaultValue = "0") int p, Model model) {

        if (p < 0) {
            p = 0;
        }
        Pageable pageable = PageRequest.of(p, 5);
        Page<SanPham> page = sanPhamService.searchSPkeyWord(searchForm.keyword, pageable);
        model.addAttribute("page", page);
        model.addAttribute("list", sanPhamService.getListSP());
        model.addAttribute("view", "../admin/san-pham/list-sp.jsp");

        return "/admin/dashboard";

    }
}
