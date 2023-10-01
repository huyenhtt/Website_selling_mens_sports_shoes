package com.example.Website_Selling_Shoes_Men_Sport.service.impl;

import com.example.Website_Selling_Shoes_Men_Sport.entity.MauSac;
import com.example.Website_Selling_Shoes_Men_Sport.repository.MauSacRepository;
import com.example.Website_Selling_Shoes_Men_Sport.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MauSacServiceImpl implements MauSacService {
    @Autowired
    MauSacRepository mauSacRepository;
    @Override
    public List<MauSac> GetAllMauSac() {
        return mauSacRepository.findAll();
    }

    @Override
    public MauSac AddMauSac(MauSac mauSac) {
        mauSac.setId(UUID.randomUUID());
        //ngày hiện tại
        mauSac.setCreateDate(LocalDateTime.now());
        //ngày cập nhật cuối
        mauSac.setLastModifiledDate(LocalDateTime.now());
        return mauSacRepository.save(mauSac);
    }

    @Override
    public MauSac UpdateMauSac(MauSac mauSac, UUID id) {
        Optional<MauSac> exitingMauSac = mauSacRepository.findById(id);
        if (exitingMauSac.isPresent()) {
            MauSac mauSacToUpdate = exitingMauSac.get();
            mauSacToUpdate.setMa(mauSac.getMa());
            mauSacToUpdate.setTenMau(mauSac.getTenMau());
            mauSacToUpdate.setLastModifiledDate(LocalDateTime.now());
            mauSacToUpdate.setTrangThai(mauSac.getTrangThai());
            mauSacRepository.save(mauSacToUpdate);
            return mauSac;
        }else {
            return null;
        }
    }

    @Override
    public MauSac DeleteMauSac(UUID id) {
        MauSac mauSac = mauSacRepository.findById(id).get();
        if (mauSac.getId() != null) {
            mauSac.setTrangThai(1);
            mauSacRepository.save(mauSac);
        }
        return mauSac;
    }

    @Override
    public MauSac GetMauSacById(UUID id) {
        return mauSacRepository.findById(id).orElse(null);
    }

    @Override
    public Page<MauSac> getListMauSac(Pageable pageable) {
        return mauSacRepository.findAll(pageable);
    }

    @Override
    public Page<MauSac> searchMauSac(String keyword, Pageable pageable) {
        return mauSacRepository.searchMauSac(keyword, pageable);
    }
}
