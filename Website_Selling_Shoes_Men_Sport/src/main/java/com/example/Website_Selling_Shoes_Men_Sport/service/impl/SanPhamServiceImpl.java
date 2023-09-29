package com.example.Website_Selling_Shoes_Men_Sport.service.impl;

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
    SanPhamRepository sanPhamRepo;

    @Override
    public List<SanPham> getListSP() {
        return sanPhamRepo.findAll();
    }

    @Override
    public SanPham insertSP(SanPham sp) {
//        long millis=System.currentTimeMillis();
//        java.sql.Date date=new java.sql.Date(millis);

        //ngày hiện tại
        sp.setCreateDate(LocalDateTime.now());
        //ngày cập nhật cuối
        sp.setLastModifiedDate(LocalDateTime.now());

        return sanPhamRepo.save(sp);
    }

    @Override
    public SanPham deleteSP(UUID id) {
        SanPham sp = sanPhamRepo.findById(id).get();
        if (sp.getId() != null) {
            sp.setTrangThai(1);
            sanPhamRepo.save(sp);
        }
        return sp;

    }

    @Override
    public SanPham updateSP(SanPham sp, UUID id) {
//        long millis = System.currentTimeMillis();
//        java.sql.Date date = new java.sql.Date(millis);
        Optional<SanPham> exitingSanPham = sanPhamRepo.findById(id);

        if (exitingSanPham.isPresent()) {
            SanPham sanPham = exitingSanPham.get();
            sanPham.setLastModifiedDate(LocalDateTime.now());
            sanPham.setTenSanPham(sp.getTenSanPham());
            sanPham.setTrangThai(sp.getTrangThai());

            sanPhamRepo.save(sanPham);
            return sanPham;
        } else {
            return null;
        }
    }

    @Override
    public SanPham getOne(UUID id) {
        return sanPhamRepo.findById(id).orElse(null);
    }

    @Override
    public Page<SanPham> searchSPkeyWord(String keywpord, Pageable pageable) {
        return sanPhamRepo.searchSP(keywpord, pageable);
    }

    @Override
    public Page<SanPham> getListOfPage(Pageable pageable) {
        return sanPhamRepo.findAll(pageable);
    }

}
