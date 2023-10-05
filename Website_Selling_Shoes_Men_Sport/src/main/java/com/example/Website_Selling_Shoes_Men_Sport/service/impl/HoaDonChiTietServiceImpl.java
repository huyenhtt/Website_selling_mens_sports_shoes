package com.example.Website_Selling_Shoes_Men_Sport.service.impl;

import com.example.Website_Selling_Shoes_Men_Sport.entity.HoaDon;
import com.example.Website_Selling_Shoes_Men_Sport.entity.HoaDonChiTiet;
import com.example.Website_Selling_Shoes_Men_Sport.repository.HoaDonChiTietRepository;
import com.example.Website_Selling_Shoes_Men_Sport.service.HoaDonChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HoaDonChiTietServiceImpl implements HoaDonChiTietService {

    @Autowired
    private HoaDonChiTietRepository hoaDonChiTietRepository;

    @Override
    public List<HoaDonChiTiet> getListHDCT() {
        return hoaDonChiTietRepository.findAll();
    }

    @Override
    public HoaDonChiTiet insertHDCT(HoaDonChiTiet hoaDonChiTiet) {
        hoaDonChiTiet.setCreateDate(LocalDateTime.now());
        hoaDonChiTiet.setLastModifiedDate(LocalDateTime.now());
        return hoaDonChiTietRepository.save(hoaDonChiTiet);
    }

    @Override
    public HoaDonChiTiet deleteHDCT(UUID id) {
        hoaDonChiTietRepository.deleteById(id);
        return null;
    }

    @Override
    public HoaDonChiTiet updateHDCT(HoaDonChiTiet hoaDonChiTiet, UUID id) {
        Optional<HoaDonChiTiet>  exitingHDCT = hoaDonChiTietRepository.findById(id);
        if(exitingHDCT.isPresent()){
            HoaDonChiTiet hdctToUpdate = exitingHDCT.get();
            hdctToUpdate.setSoLuong(hoaDonChiTiet.getSoLuong());
            hdctToUpdate.setDonGia(hoaDonChiTiet.getDonGia());
            hdctToUpdate.setGiaBan(hoaDonChiTiet.getGiaBan());
            hdctToUpdate.setGiamGiaKhuyenMai(hoaDonChiTiet.getGiamGiaKhuyenMai());
            hoaDonChiTietRepository.save(hoaDonChiTiet);
            return hdctToUpdate;
        }else {
            return hoaDonChiTiet;
        }
    }

    @Override
    public HoaDonChiTiet getOne(UUID id) {
        return hoaDonChiTietRepository.findById(id).orElse(null);
    }

    @Override
    public Page<HoaDonChiTiet> getListHDCT(Pageable pageable) {
        return hoaDonChiTietRepository.findAll(pageable);
    }

}
