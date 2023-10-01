package com.example.Website_Selling_Shoes_Men_Sport.service.impl;

import com.example.Website_Selling_Shoes_Men_Sport.entity.DeGiay;
import com.example.Website_Selling_Shoes_Men_Sport.repository.DeGiayRepository;
import com.example.Website_Selling_Shoes_Men_Sport.service.DeGiayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DeGiayServiceImpl implements DeGiayService {
    @Autowired
    DeGiayRepository deGiayRepository;

    @Override
    public List<DeGiay> GetAllDeGiay() {
        return deGiayRepository.findAll();
    }

    @Override
    public DeGiay AddDeGiay(DeGiay deGiay) {
        deGiay.setId(UUID.randomUUID());
        //ngày hiện tại
        deGiay.setCreateDate(LocalDateTime.now());
        //ngày cập nhật cuối
        deGiay.setLastModifiledDate(LocalDateTime.now());
        return deGiayRepository.save(deGiay);
    }

    @Override
    public DeGiay UpdateDeGiay(DeGiay deGiay, UUID id) {
        Optional<DeGiay> exitingDeGiay = deGiayRepository.findById(id);
        if (exitingDeGiay.isPresent()) {
            DeGiay deGiayToUpdate = exitingDeGiay.get();
            deGiayToUpdate.setMa(deGiay.getMa());
            deGiayToUpdate.setLoaiDe(deGiay.getLoaiDe());
            deGiayToUpdate.setMoTa(deGiay.getMoTa());
            deGiayToUpdate.setLastModifiledDate(LocalDateTime.now());
            deGiayToUpdate.setTrangThai(deGiay.getTrangThai());
            deGiayRepository.save(deGiayToUpdate);
            return deGiayToUpdate;
        }else {
            return null;
        }
    }

    @Override
    public DeGiay DeleteDeGiay(UUID id) {
        DeGiay deGiay = deGiayRepository.findById(id).get();
        if (deGiay.getId() != null) {
            deGiay.setTrangThai(1);
            deGiayRepository.save(deGiay);
        }
        return deGiay;
    }

    @Override
    public DeGiay GetDeGiayById(UUID id) {
        return deGiayRepository.findById(id).orElse(null);
    }
    @Override
    public Page<DeGiay> searchDeGiay(String keyword, Pageable pageable) {
        return deGiayRepository.searchDeGiay(keyword, pageable);
    }

    @Override
    public Page<DeGiay> getListDeGiay(Pageable pageable) {
        return deGiayRepository.findAll(pageable);
    }
}
