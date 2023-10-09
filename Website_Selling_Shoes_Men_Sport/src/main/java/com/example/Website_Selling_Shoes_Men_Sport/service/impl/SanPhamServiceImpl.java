package com.example.Website_Selling_Shoes_Men_Sport.service.impl;

import com.example.Website_Selling_Shoes_Men_Sport.entity.KichCo;
import com.example.Website_Selling_Shoes_Men_Sport.entity.SanPham;
import com.example.Website_Selling_Shoes_Men_Sport.repository.SanPhamRepository;
import com.example.Website_Selling_Shoes_Men_Sport.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SanPhamServiceImpl implements SanPhamService {
    @Autowired
    SanPhamRepository sanPhamRepository;

    @Override
    public List<SanPham> getList() {
        return sanPhamRepository.findAll();
    }

    @Override
    public Page<SanPham> findAllSP(Pageable pageable) {
        return sanPhamRepository.findALlSP(pageable);
    }

    @Override
    public Page<SanPham> findByKeyword(String key, Pageable pageable) {
        return sanPhamRepository.searchSP(key, pageable);
    }

    @Override
    public SanPham addSanPham(SanPham sanPham) {
        sanPham.setCreateDate(LocalDateTime.now());
        sanPham.setLastModifiedDate(LocalDateTime.now());
        return sanPhamRepository.save(sanPham);
    }

    @Override
    public SanPham udpateSanPham(SanPham sanPham, UUID id) {
        Optional<SanPham> exitingSanPham = sanPhamRepository.findById(id);
        if (exitingSanPham.isPresent()) {
            SanPham spToUpdate = exitingSanPham.get();
            spToUpdate.setLastModifiedDate(LocalDateTime.now());
            spToUpdate.setTenSanPham(sanPham.getTenSanPham());
            spToUpdate.setTrangThai(sanPham.getTrangThai());
            sanPhamRepository.save(spToUpdate);
            return spToUpdate;
        } else {
            return null;
        }
    }

    @Override
    public SanPham getOne(UUID id) {
        return sanPhamRepository.findById(id).orElse(null);
    }

    @Override
    public SanPham getByMa(String ma) {
        return sanPhamRepository.getSanPhamByMaSP(ma);
    }

}
