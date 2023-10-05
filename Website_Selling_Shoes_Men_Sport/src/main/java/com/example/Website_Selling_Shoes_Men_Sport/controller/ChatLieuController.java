package com.example.Website_Selling_Shoes_Men_Sport.controller;

import com.example.Website_Selling_Shoes_Men_Sport.entity.ChatLieu;
import com.example.Website_Selling_Shoes_Men_Sport.service.ChatLieuService;
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
@RequestMapping("/admin/chat-lieu")
public class ChatLieuController {

    @Autowired
    private ChatLieuService chatLieuService;

    @ModelAttribute("dsTrangThai")
    public Map<Integer, String> dsTranngThai(){
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
    public String getListCL(@RequestParam(defaultValue = "0") int p, Model model){
        if(p < 0){
            p = 0;
        }
        Pageable pageable = PageRequest.of(p, 5);
        Page<ChatLieu> page = chatLieuService.getListChatLieu(pageable);
        model.addAttribute("page", page);
        model.addAttribute("searchForm", new Searchform());
        model.addAttribute("view", "../admin/chat-lieu/list-cl.jsp");
        return "/admin/dashboard";
    }

    @RequestMapping("/view-add")
    public String viewAdd(@ModelAttribute("chatLieu") ChatLieu chatLieu, Model model) {
        model.addAttribute("action", "/admin/chat-lieu/add");
        model.addAttribute("view", "../admin/chat-lieu/add_update.jsp");
        return "/admin/dashboard";
    }

    @RequestMapping("/view-update/{id}")
    public String viewUpdate(@PathVariable UUID id, Model model) {
        ChatLieu chatLieu = chatLieuService.getOne(id);
        model.addAttribute("chatLieu", chatLieu);
        model.addAttribute("action", "/admin/chat-lieu/update/" + chatLieu.getId());
        model.addAttribute("view", "../admin/chat-lieu/add_update.jsp");
        return "/admin/dashboard";
    }

    @RequestMapping("/add")
    public String addChatLieu(Model model, @Valid @ModelAttribute("chatLieu") ChatLieu chatLieu, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("mess", "Vui lòng nhập đúng các thuộc tính !");
            model.addAttribute("view", "../admin/chat-lieu/add_update.jsp");
            return "/admin/dashboard";
        }
        chatLieuService.insertCL(chatLieu);
        model.addAttribute("view", "../admin/chat-lieu/list-cl.jsp");
        return "redirect:/admin/chat-lieu/hien-thi";
    }
    @RequestMapping("/delete/{id}")
    public String deleteChatLieu(@PathVariable UUID id) {
        chatLieuService.deleteCL(id);
        return "redirect:/admin/chat-lieu/hien-thi";

    }

    @RequestMapping("/update/{id}")
    public String updateLoaiGiay( Model model,@Valid @ModelAttribute("chatLieu") ChatLieu chatLieu, @PathVariable UUID id, BindingResult result) {
        if (result.hasErrors()){
            model.addAttribute("mess", "Vui lòng nhập đúng các thuộc tính !");
            model.addAttribute("view", "../admin/chat-lieu/add_update.jsp");
            return "/admin/dashboard";
        }

        chatLieuService.updateCL(chatLieu,chatLieu.getId());
        model.addAttribute("view", "../admin/chat-lieu/list-cl.jsp");
        return "redirect:/admin/chat-lieu/hien-thi";

    }
    @RequestMapping("/search")
    public String search(@ModelAttribute("searchForm") ChatLieuController.Searchform searchform, @RequestParam(defaultValue = "0") int p, Model model){
        if (p<0){
            p=0;
        }
        Pageable pageable=PageRequest.of(p,5);
        Page<ChatLieu> page=chatLieuService.searchCL(searchform.keyword,pageable);
        model.addAttribute("page",page);
        model.addAttribute("view", "../admin/chat-lieu/list-cl.jsp");
        return "/admin/dashboard";
    }
}
