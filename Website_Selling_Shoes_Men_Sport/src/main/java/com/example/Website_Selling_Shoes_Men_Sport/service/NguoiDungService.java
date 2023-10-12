package com.example.Website_Selling_Shoes_Men_Sport.service;

import com.example.Website_Selling_Shoes_Men_Sport.entity.NguoiDung;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface NguoiDungService {
    List<NguoiDung> getLstND();
    NguoiDung getObjByAccount(UUID uuid);
    NguoiDung save(NguoiDung nd);

    NguoiDung delete(UUID id);

    NguoiDung update(NguoiDung nd);

    NguoiDung getObj(UUID id);
    Page<NguoiDung> getLstNguoiDung(Pageable pageable);

    Page<NguoiDung> searchND(String keyword, Pageable pageable);
}
