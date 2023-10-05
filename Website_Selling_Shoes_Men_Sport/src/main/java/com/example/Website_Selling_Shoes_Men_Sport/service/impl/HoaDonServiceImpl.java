package com.example.Website_Selling_Shoes_Men_Sport.service.impl;

import com.example.Website_Selling_Shoes_Men_Sport.entity.HoaDon;
import com.example.Website_Selling_Shoes_Men_Sport.repository.HoaDonRepository;
import com.example.Website_Selling_Shoes_Men_Sport.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public class HoaDonServiceImpl implements HoaDonService {

    @Autowired
    private HoaDonRepository hoaDonRepository;
    @Override
    public List<HoaDon> getListHD() {
        return null;
    }

    @Override
    public HoaDon insertHD(HoaDon hoaDon) {
        return null;
    }

    @Override
    public HoaDon deleteHD(UUID id) {
        return null;
    }

    @Override
    public HoaDon updateHD(HoaDon hoaDon, UUID id) {
        return null;
    }

    @Override
    public HoaDon getOne(UUID id) {
        return null;
    }

    @Override
    public Page<HoaDon> getListHoaDon(Pageable pageable) {
        return null;
    }

    @Override
    public Page<HoaDon> searchHD(String keyword, Pageable pageable) {
        return null;
    }
}
