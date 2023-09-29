package com.example.Website_Selling_Shoes_Men_Sport.service;

import com.example.Website_Selling_Shoes_Men_Sport.entity.LoaiGiay;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface LoaiGiayService {
    List<LoaiGiay> getListLG();

    LoaiGiay insertLG(LoaiGiay loaiGiay);

    LoaiGiay deleteLG(UUID id);

    LoaiGiay updateLG(LoaiGiay loaiGiay, UUID id);

    LoaiGiay getOne(UUID id);

    Page<LoaiGiay> getListLoaiGiay(Pageable pageable);

    Page<LoaiGiay> searchLG(String keyword, Pageable pageable);
}
