package com.example.Website_Selling_Shoes_Men_Sport.service;

import com.example.Website_Selling_Shoes_Men_Sport.entity.KhuyenMai;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface KhuyenMaiService {
    List<KhuyenMai> GetAllKhuyenMai();
    KhuyenMai AddKhuyenMai(KhuyenMai khuyenMai);
    KhuyenMai UpdateKhuyenMai(KhuyenMai khuyenMai, UUID id);
    KhuyenMai DeleteKhuyenMai(UUID id);
    KhuyenMai GetKhuyenMaiById(UUID id);
    Page<KhuyenMai> getListKhuyenMai(Pageable pageable);

    Page<KhuyenMai> searchKhuyenMai(String keyword, Pageable pageable);
}
