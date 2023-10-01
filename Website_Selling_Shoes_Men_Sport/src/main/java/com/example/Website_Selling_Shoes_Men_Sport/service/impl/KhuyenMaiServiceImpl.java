package com.example.Website_Selling_Shoes_Men_Sport.service.impl;

import com.example.Website_Selling_Shoes_Men_Sport.entity.KhuyenMai;
import com.example.Website_Selling_Shoes_Men_Sport.repository.KhuyenMaiRepository;
import com.example.Website_Selling_Shoes_Men_Sport.service.KhuyenMaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class KhuyenMaiServiceImpl implements KhuyenMaiService {
    @Autowired
    KhuyenMaiRepository khuyenMaiRepository;
    @Override
    public List<KhuyenMai> GetAllKhuyenMai() {
        return khuyenMaiRepository.findAll();
    }

    @Override
    public KhuyenMai AddKhuyenMai(KhuyenMai khuyenMai) {
        khuyenMai.setId(UUID.randomUUID());
        //ngày hiện tại
        khuyenMai.setCreateDate(LocalDateTime.now());
        //ngày cập nhật cuối
        khuyenMai.setLastModifiledDate(LocalDateTime.now());
        return khuyenMaiRepository.save(khuyenMai);
    }

    @Override
    public KhuyenMai UpdateKhuyenMai(KhuyenMai khuyenMai, UUID id) {
        Optional<KhuyenMai> exitingKhuyenMai = khuyenMaiRepository.findById(id);
        if (exitingKhuyenMai.isPresent()) {
            KhuyenMai khuyenMaiToUpdate = exitingKhuyenMai.get();
            khuyenMaiToUpdate.setMaKhuyenMai(khuyenMai.getMaKhuyenMai());
            khuyenMaiToUpdate.setTenKhuyenMai(khuyenMai.getTenKhuyenMai());
            khuyenMaiToUpdate.setGiaTri(khuyenMai.getGiaTri());
            khuyenMaiToUpdate.setLoaiKhuyenMai(khuyenMai.getLoaiKhuyenMai());
            khuyenMaiToUpdate.setNgayBatDau(khuyenMai.getNgayBatDau());
            khuyenMaiToUpdate.setNgayKetThuc(khuyenMai.getNgayKetThuc());
            khuyenMaiToUpdate.setLastModifiledDate(LocalDateTime.now());
            khuyenMaiToUpdate.setTrangThai(khuyenMai.getTrangThai());
            khuyenMaiRepository.save(khuyenMaiToUpdate);
            return khuyenMaiToUpdate;
        }else {
            return null;
        }
    }

    @Override
    public KhuyenMai DeleteKhuyenMai(UUID id) {
        KhuyenMai khuyenMai = khuyenMaiRepository.findById(id).get();
        if (khuyenMai.getId() != null) {
            khuyenMai.setTrangThai(1);
            khuyenMaiRepository.save(khuyenMai);
        }
        return khuyenMai;
    }

    @Override
    public KhuyenMai GetKhuyenMaiById(UUID id) {
        return khuyenMaiRepository.findById(id).orElse(null);
    }

    @Override
    public Page<KhuyenMai> getListKhuyenMai(Pageable pageable) {
        return khuyenMaiRepository.findAll(pageable);
    }

    @Override
    public Page<KhuyenMai> searchKhuyenMai(String keyword, Pageable pageable) {
        return khuyenMaiRepository.searchKhuyenMai(keyword, pageable);
    }
}
