package com.example.Website_Selling_Shoes_Men_Sport.service.impl;

import com.example.Website_Selling_Shoes_Men_Sport.entity.KichCo;
import com.example.Website_Selling_Shoes_Men_Sport.repository.KichCoRepository;
import com.example.Website_Selling_Shoes_Men_Sport.service.KichCoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class KichCoServiceImpl implements KichCoService {

    @Autowired
    private KichCoRepository kichCoRepository;

    @Override
    public List<KichCo> getListKC() {
        return kichCoRepository.findAll();
    }

    @Override
    public KichCo insertKC(KichCo kichCo) {
        kichCo.setCreateDate(LocalDateTime.now());
        kichCo.setLastModifiedDate(LocalDateTime.now());
        return kichCoRepository.save(kichCo);
    }

    @Override
    public KichCo deleteKC(UUID id) {
        KichCo kichCo = kichCoRepository.findById(id).get();
        if(kichCo.getId() != null){
            kichCo.setTrangThai(1);
            kichCoRepository.save(kichCo);
        }
        return kichCo;
    }

    @Override
    public KichCo updateKC(KichCo kichCo, UUID id) {
        Optional<KichCo> exitingKichCo = kichCoRepository.findById(id);
        if(exitingKichCo.isPresent()){
            KichCo kichCoToUpdate = exitingKichCo.get();
            kichCoToUpdate.setLastModifiedDate(LocalDateTime.now());
            kichCoToUpdate.setLoaiSize(kichCo.getLoaiSize());
            kichCoToUpdate.setTrangThai(kichCo.getTrangThai());
            kichCoRepository.save(kichCoToUpdate);
            return kichCoToUpdate;
        }else {
            return null;
        }
    }

    @Override
    public KichCo getOne(UUID id) {
        return kichCoRepository.findById(id).orElse(null);
    }

    @Override
    public Page<KichCo> getListKichCo(Pageable pageable) {
        return kichCoRepository.findAll(pageable);
    }

    @Override
    public Page<KichCo> searchKC(String keyword, Pageable pageable) {
        return kichCoRepository.searchKC(keyword, pageable);
    }

}
