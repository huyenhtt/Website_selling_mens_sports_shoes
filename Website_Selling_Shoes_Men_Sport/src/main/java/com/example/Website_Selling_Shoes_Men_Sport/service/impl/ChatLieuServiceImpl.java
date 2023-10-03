package com.example.Website_Selling_Shoes_Men_Sport.service.impl;

import com.example.Website_Selling_Shoes_Men_Sport.entity.ChatLieu;
import com.example.Website_Selling_Shoes_Men_Sport.repository.ChatLieuRepository;
import com.example.Website_Selling_Shoes_Men_Sport.service.ChatLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChatLieuServiceImpl implements ChatLieuService {

    @Autowired
    private ChatLieuRepository chatLieuRepository;

    @Override
    public List<ChatLieu> getListCL() {
        return chatLieuRepository.findAll();
    }

    @Override
    public ChatLieu insertCL(ChatLieu chatLieu) {
        chatLieu.setCreateDate(LocalDateTime.now());
        chatLieu.setLastModifiedDate(LocalDateTime.now());
        return chatLieuRepository.save(chatLieu);
    }

    @Override
    public ChatLieu deleteCL(UUID id) {
        ChatLieu chatLieu = chatLieuRepository.findById(id).get();
        if(chatLieu.getId() != null){
            chatLieu.setTrangThai(1);
            chatLieuRepository.save(chatLieu);
        }
        return chatLieu;
    }

    @Override
    public ChatLieu updateCL(ChatLieu chatLieu, UUID id) {
        Optional<ChatLieu> exitingChatLieu = chatLieuRepository.findById(id);
        if(exitingChatLieu.isPresent()){
            ChatLieu chatLieuToUpdate = exitingChatLieu.get();
            chatLieuToUpdate.setLastModifiedDate(LocalDateTime.now());
            chatLieuToUpdate.setTenChatLieu(chatLieu.getTenChatLieu());
            chatLieuToUpdate.setTrangThai(chatLieu.getTrangThai());
            chatLieuRepository.save(chatLieuToUpdate);
            return chatLieuToUpdate;
        }else {
            return null;
        }
    }

    @Override
    public ChatLieu getOne(UUID id) {
        return chatLieuRepository.findById(id).orElse(null);
    }

    @Override
    public Page<ChatLieu> getListChatLieu(Pageable pageable) {
        return chatLieuRepository.findAll(pageable);
    }

    @Override
    public Page<ChatLieu> searchCL(String keyword, Pageable pageable) {
        return chatLieuRepository.searchCL(keyword, pageable);
    }

}
