package com.example.Website_Selling_Shoes_Men_Sport.controller;

import com.example.Website_Selling_Shoes_Men_Sport.entity.*;
import com.example.Website_Selling_Shoes_Men_Sport.repository.ChiTietSanPhamRepo;
import com.example.Website_Selling_Shoes_Men_Sport.repository.LoaiGiayRepo;
import com.example.Website_Selling_Shoes_Men_Sport.service.ChiTietSanPhamService;
import com.example.Website_Selling_Shoes_Men_Sport.service.HinhAnhService;
import com.example.Website_Selling_Shoes_Men_Sport.service.KichCoService;
import com.example.Website_Selling_Shoes_Men_Sport.service.MauSacService;
import com.example.Website_Selling_Shoes_Men_Sport.service.impl.LoaiGiayServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
public class UserController {
    //phần test
    @Autowired
    ChiTietSanPhamService chiTietSanPhamService;
    @Autowired
    HinhAnhService hinhAnhService;
    @Autowired
    MauSacService mauSacService;

    @ModelAttribute("listLoaiGiay")
    List<LoaiGiay> listLoaiGiay() {
        return loaiGiayRepo.findAll();
    }

    @ModelAttribute("listMS")
    List<MauSac> listMauSac() {
        return mauSacService.GetAllMauSac();
    }

    @Autowired
    KichCoService kichCoService;

    @ModelAttribute("listKC")
    List<KichCo> listKC() {
        return kichCoService.getListKC();
    }

    //sort sp
    @Data
    public static class SortForm {
        String key;
    }

    //search buy kích cỡ, giá bán
    @Data
    public static class SearchFormByKichCo {
        Double key;
    }

    @Data
    public static class SearchFormByGiaBan {
        Double minPrice;
        Double maxPrice;
    }

    @ModelAttribute("soLuongSP")
    Integer count() {
        return repo.countSanPham();
    }

    //
    @GetMapping("/user/home")
    public String home(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model) {
        List<ChiTietSanPham> listSP = chiTietSanPhamService.getList();
        model.addAttribute("view", "../home/a.jsp");
        model.addAttribute("listSP", listSP);
        return "/home/index";
    }

    @GetMapping("/user/cart")
    public String cart(Model model) {
        model.addAttribute("view", "../home/cart.jsp");
        return "/home/index";
    }

    @GetMapping("/user/blog")
    public String blogSanPham(Model model) {

        model.addAttribute("view", "../home/blog.jsp");
        return "/home/index";
    }

    @Autowired
    ChiTietSanPhamRepo repo;

    @GetMapping("/user/category")
    public String category(@RequestParam(defaultValue = "0", name = "p") Integer number,
                           @ModelAttribute("searchFormByGiaban") SearchFormByGiaBan searchFormByGiaBan, @ModelAttribute("sortForm") SortForm sortForm
            , Model model) {
        Pageable pageable = PageRequest.of(number, 9);
        Page<ChiTietSanPham> listCTSP = chiTietSanPhamService.getListSP(pageable);
        List<ChiTietSanPham> listSP = chiTietSanPhamService.getList();
        model.addAttribute("listSP", listSP);
        List<LoaiGiay> listLG = loaiGiayRepo.findAll();
        model.addAttribute("listLG", listLG);
        model.addAttribute("listCTSP", listCTSP);
//        model.addAttribute("view", "../home/category.jsp");
        return "/home/category";
    }

    @GetMapping("/user/login")
    public String login() {
        return "/home/login";
    }

    @GetMapping("/user/contact")
    public String contact() {
        return "/home/contact";
    }

    @GetMapping("/user/product-detail/{id}")
    public String detail(Model model, @PathVariable UUID id) {
        //lấy ctsp
        ChiTietSanPham chiTietSanPham = chiTietSanPhamService.getOne(id);

        model.addAttribute("sp", chiTietSanPham);
        model.addAttribute("view", "../home/product-detail.jsp");
        return "/home/index";
    }

    @GetMapping("/user/checkout")
    public String checkout() {
        return "/home/checkout";
    }

    @GetMapping("/user/confirmation")
    public String confirmation(Model model) {
        model.addAttribute("view", "../home/confirmation.jsp");
        return "/home/index";
    }

    @GetMapping("/user/single-blog")
    public String singleBlog(Model model) {
        model.addAttribute("view", "../home/single-blog.jsp");
        return "/home/index";
    }

    //search lg
    @Autowired
    LoaiGiayRepo loaiGiayRepo;

    @RequestMapping("/user/category/searchbyloaigiay")
    public String getListByLoaiGiay(Model model,
                                    @RequestParam(defaultValue = "0") int p,
                                    @ModelAttribute("searchFormByGiaban") SearchFormByGiaBan searchFormByGiaBan,
                                    @ModelAttribute("sortForm") SortForm sortForm,
                                    @RequestParam(name = "idLoaiGiayList") UUID idLoaiGiayList
    ) {

        Pageable pageable = PageRequest.of(p, 9);
        Page<ChiTietSanPham> listCTSPByLoaiGiay = chiTietSanPhamService.searchLoaiGiay(idLoaiGiayList, pageable);
        List<LoaiGiay> listLG = loaiGiayRepo.findAll();

        model.addAttribute("listCTSP", listCTSPByLoaiGiay);
        model.addAttribute("listLG", listLG);
        return "/home/category";
    }

    // search kichco mausac giaban
    @RequestMapping("/user/category/searchbygiaban")
    public String getListByGiaBan(Model model, @RequestParam(defaultValue = "0") int p,
                                  @ModelAttribute("sortForm") SortForm sortForm,
                                  @ModelAttribute("searchFormByGiaban") SearchFormByGiaBan searchFormByGiaBan) {
        System.out.println(searchFormByGiaBan.minPrice + "-" + searchFormByGiaBan.maxPrice);
        Pageable pageable = PageRequest.of(p, 12);
        Page<ChiTietSanPham> pageCTSPByGia = chiTietSanPhamService.getCTSPByGiaBan(searchFormByGiaBan.minPrice, searchFormByGiaBan.maxPrice, pageable);
        List<ChiTietSanPham> listSP = chiTietSanPhamService.getList();
        List<LoaiGiay> listLG = loaiGiayRepo.findAll();
        List<KichCo> listKC = kichCoService.getListKC();
        List<MauSac> listMS = mauSacService.GetAllMauSac();
        model.addAttribute("listCTSP", listSP);
        model.addAttribute("pageSP", pageCTSPByGia);
        model.addAttribute("listLG", listLG);
        model.addAttribute("listKC", listKC);
        model.addAttribute("listMS", listMS);

        return "redirect:/user/category";
    }

    @RequestMapping("/user/category/searchbykichco/{id}")
    public String getListByKichCo(Model model, @RequestParam(defaultValue = "0") int p,
                                  @ModelAttribute("sortForm") SortForm sortForm,
                                  @ModelAttribute("searchFormByGiaban") SearchFormByGiaBan searchFormByGiaBan,
                                  @PathVariable UUID id) {
        KichCo kichCo = kichCoService.getOne(id);
        System.out.println(kichCo);
        Pageable pageable = PageRequest.of(p, 12);
        Page<ChiTietSanPham> pageCTSPByKichCo = chiTietSanPhamService.searchKichCo(kichCo.getId(), pageable);

        System.out.println("aa");
        List<LoaiGiay> listLG = loaiGiayRepo.findAll();
        List<KichCo> listKC = kichCoService.getListKC();
        List<MauSac> listMS = mauSacService.GetAllMauSac();
        model.addAttribute("listCTSP", pageCTSPByKichCo);
        model.addAttribute("listLG", listLG);
        model.addAttribute("listKC", listKC);
        model.addAttribute("listMS", listMS);

        return "/home/category";
    }

    @RequestMapping("/user/category/searchbymausac")
    public String getListByMauSac(Model model, @RequestParam(defaultValue = "0") int p,
                                  @ModelAttribute("sortForm") SortForm sortForm,
                                  @ModelAttribute("searchFormByGiaban") SearchFormByGiaBan searchFormByGiaBan,
                                  @RequestParam UUID idMS
    ) {
        Pageable pageable = PageRequest.of(p, 12);
        Page<ChiTietSanPham> listCTSPBYMS = chiTietSanPhamService.getCTSPBYMauSac(idMS, pageable);
        List<LoaiGiay> listLG = loaiGiayRepo.findAll();
        List<KichCo> listKC = kichCoService.getListKC();
        List<MauSac> listMS = mauSacService.GetAllMauSac();
        model.addAttribute("listCTSP", listCTSPBYMS);
        model.addAttribute("listLG", listLG);
        model.addAttribute("listKC", listKC);
        model.addAttribute("listMS", listMS);
        return "/home/category";
    }

    @RequestMapping("/user/category/sort")
    public String sort(Model model, @RequestParam(defaultValue = "0") int p,
                       @ModelAttribute("sortForm") SortForm sortForm,
                       @ModelAttribute("searchFormByGiaban") SearchFormByGiaBan searchFormByGiaBan) {
        Sort sort = Sort.by(Sort.Direction.ASC, sortForm.key);
        Pageable pageable = PageRequest.of(p, 9, sort);
        Page<ChiTietSanPham> pageCTSP = chiTietSanPhamService.getListSP(pageable);
        List<ChiTietSanPham> listSP = chiTietSanPhamService.getList();
        List<LoaiGiay> listLG = loaiGiayRepo.findAll();
        List<KichCo> listKC = kichCoService.getListKC();
        List<MauSac> listMS = mauSacService.GetAllMauSac();
        model.addAttribute("listSP", listSP);
        model.addAttribute("listCTSP", pageCTSP);
        model.addAttribute("listLG", listLG);
        model.addAttribute("listKC", listKC);
        model.addAttribute("listMS", listMS);

        return "/home/category";
    }
}
