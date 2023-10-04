package com.example.Website_Selling_Shoes_Men_Sport.service;

import com.example.Website_Selling_Shoes_Men_Sport.entity.ChatLieu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ChatLieuService {

    List<ChatLieu> getListCL();

    ChatLieu getOne(String maCL) ;

    ChatLieu insertCL(ChatLieu chatLieu);

    ChatLieu deleteCL(UUID id);

    ChatLieu updateCL(ChatLieu chatLieu, UUID id);

    ChatLieu getOne(UUID id);

    Page<ChatLieu> getListChatLieu(Pageable pageable);

    Page<ChatLieu> searchCL(String keyword, Pageable pageable);

}
