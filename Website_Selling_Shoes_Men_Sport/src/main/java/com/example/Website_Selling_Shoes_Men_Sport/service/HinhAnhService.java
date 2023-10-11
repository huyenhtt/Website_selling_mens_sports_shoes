package com.example.Website_Selling_Shoes_Men_Sport.service;

import com.example.Website_Selling_Shoes_Men_Sport.entity.ChiTietSanPham;
import com.example.Website_Selling_Shoes_Men_Sport.entity.HinhAnh;
import com.example.Website_Selling_Shoes_Men_Sport.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface HinhAnhService {
    List<HinhAnh> getAll();
    List<ChiTietSanPham> getAllCTSP();
    List<ChiTietSanPham> searchCTSP(UUID keyword);
    HinhAnh findById(UUID id);
    String getImageUploadPath();
    Page<HinhAnh> listHinhAnh(Pageable pageable);
    UUID getIdHinhAnh(UUID keyword);
    HinhAnh getHinhAnh(UUID id);
    SanPham getSanPhamByIDCTSP(UUID idCTSP);
}
