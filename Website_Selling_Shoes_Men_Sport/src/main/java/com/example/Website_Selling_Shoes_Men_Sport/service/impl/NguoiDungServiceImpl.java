package com.example.Website_Selling_Shoes_Men_Sport.service.impl;

import com.example.Website_Selling_Shoes_Men_Sport.entity.NguoiDung;
import com.example.Website_Selling_Shoes_Men_Sport.repository.NguoiDungRepository;
import com.example.Website_Selling_Shoes_Men_Sport.service.NguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class NguoiDungServiceImpl implements NguoiDungService{
    @Autowired
    NguoiDungRepository ndRepo;
    @Override
    public List<NguoiDung> getLstND() {
        return ndRepo.findAll();
    }

    @Override
    public NguoiDung getObjByAccount(UUID uuid) {
        return ndRepo.findNguoiDungByAccount(uuid);
    }

    @Override
    public NguoiDung save(NguoiDung nd) {
        return ndRepo.save(nd);
    }

    @Override
    public NguoiDung delete(UUID id) {
        ndRepo.deleteById(id);
        return null;
    }

    @Override
    public NguoiDung update(NguoiDung nd) {
        Boolean exists = ndRepo.existsById(nd.getId());
        if (exists) {
            return ndRepo.save(nd);
        }
        return null;
    }

    @Override
    public NguoiDung getObj(UUID id) {
        return ndRepo.findById(id).get();
    }

    @Override
    public Page<NguoiDung> getListNguoiDung(Pageable pageable) {
        return null;
    }

    @Override
    public Page<NguoiDung> searchND(String keyword, Pageable pageable) {
        return null;
    }
}
