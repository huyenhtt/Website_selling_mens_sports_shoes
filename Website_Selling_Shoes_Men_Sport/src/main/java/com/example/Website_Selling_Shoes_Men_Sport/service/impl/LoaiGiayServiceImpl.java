package com.example.Website_Selling_Shoes_Men_Sport.service.impl;

import com.example.Website_Selling_Shoes_Men_Sport.entity.LoaiGiay;
import com.example.Website_Selling_Shoes_Men_Sport.repository.LoaiGiayRepo;
import com.example.Website_Selling_Shoes_Men_Sport.service.LoaiGiayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LoaiGiayServiceImpl implements LoaiGiayService {

    @Autowired
    LoaiGiayRepo loaiGiayRepository;

    @Override
    public List<LoaiGiay> getListLG() {
        return loaiGiayRepository.findAll();
    }

    @Override
    public LoaiGiay insertLG(LoaiGiay sp) {
        //ngày hiện tại
        sp.setCreateDate(LocalDateTime.now());
        //ngày cập nhật cuối
        sp.setLastModifiedDate(LocalDateTime.now());

        return loaiGiayRepository.save(sp);
    }

    @Override
    public LoaiGiay deleteLG(UUID id) {
        LoaiGiay loaiGiay = loaiGiayRepository.findById(id).get();
        if (loaiGiay.getId() != null) {
            loaiGiay.setTrangThai(1);
            loaiGiayRepository.save(loaiGiay);
        }
        return loaiGiay;

    }

    @Override
    public LoaiGiay updateLG(LoaiGiay loaiGiay, UUID id) {
        Optional<LoaiGiay> exitingLoaiGiay = loaiGiayRepository.findById(id);
        if (exitingLoaiGiay.isPresent()) {
            LoaiGiay loaiGiayToUpdate = exitingLoaiGiay.get();
            loaiGiayToUpdate.setLastModifiedDate(LocalDateTime.now());
            loaiGiayToUpdate.setTenTheLoai(loaiGiay.getTenTheLoai());
            loaiGiayToUpdate.setTrangThai(loaiGiay.getTrangThai());
            loaiGiayRepository.save(loaiGiayToUpdate);
            return loaiGiayToUpdate;
        }else {
            return null;
        }
    }

    @Override
    public LoaiGiay getOne(UUID id) {
        return loaiGiayRepository.findById(id).orElse(null);
    }

    @Override
    public Page<LoaiGiay> searchLG(String keyword, Pageable pageable) {
        return loaiGiayRepository.searchLG(keyword,pageable);
    }

    @Override
    public Page<LoaiGiay> getListLoaiGiay(Pageable pageable) {
        return loaiGiayRepository.findAll(pageable);
    }

}
