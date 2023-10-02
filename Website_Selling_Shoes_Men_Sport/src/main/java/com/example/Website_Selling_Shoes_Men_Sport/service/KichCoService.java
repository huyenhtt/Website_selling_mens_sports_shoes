package com.example.Website_Selling_Shoes_Men_Sport.service;

import com.example.Website_Selling_Shoes_Men_Sport.entity.KichCo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface KichCoService {

    List<KichCo> getListKC();

    KichCo insertKC(KichCo kichCo);

    KichCo deleteKC(UUID id);

    KichCo updateKC(KichCo kichCo, UUID id);

    KichCo getOne(UUID id);

    Page<KichCo> getListKichCo(Pageable pageable);

    Page<KichCo> searchKC(String keyword, Pageable pageable);

}
