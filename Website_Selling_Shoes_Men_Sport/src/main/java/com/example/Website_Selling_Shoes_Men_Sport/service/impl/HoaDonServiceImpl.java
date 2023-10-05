package com.example.Website_Selling_Shoes_Men_Sport.service.impl;

import com.example.Website_Selling_Shoes_Men_Sport.entity.HoaDon;
import com.example.Website_Selling_Shoes_Men_Sport.repository.HoaDonRepository;
import com.example.Website_Selling_Shoes_Men_Sport.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HoaDonServiceImpl implements HoaDonService {

    @Autowired
    private HoaDonRepository hoaDonRepository;
    @Override
    public List<HoaDon> getListHD() {
        return hoaDonRepository.findAll();
    }

    @Override
    public HoaDon insertHD(HoaDon hoaDon) {
        hoaDon.setCreateDate(LocalDateTime.now());
        hoaDon.setLastModifiedDate(LocalDateTime.now());
        hoaDon.setNgayTao(LocalDateTime.now());
        hoaDon.setNgayThanhToan(LocalDateTime.now());
        hoaDon.setNgayShip(LocalDateTime.now());
        hoaDon.setNgayNhan(LocalDateTime.now());
        return hoaDonRepository.save(hoaDon);
    }

    @Override
    public HoaDon deleteHD(UUID id) {
        HoaDon hoaDon = hoaDonRepository.findById(id).get();
        if(hoaDon.getId() != null){
            hoaDon.setTrangThai(1);
            hoaDonRepository.save(hoaDon);
        }
        return hoaDon;
    }

    @Override
    public HoaDon updateHD(HoaDon hoaDon, UUID id) {
        Optional<HoaDon> exitingHoaDon = hoaDonRepository.findById(id);
        if(exitingHoaDon.isPresent()){
            HoaDon hoaDonToUpdate = exitingHoaDon.get();
            hoaDonToUpdate.setMaHD(hoaDon.getMaHD());
            hoaDonToUpdate.setNgayTao(hoaDon.getNgayTao());
            hoaDonToUpdate.setNgayThanhToan(hoaDon.getNgayThanhToan());
            hoaDonToUpdate.setNgayNhan(hoaDon.getNgayNhan());
            hoaDonToUpdate.setNgayShip(hoaDon.getNgayShip());
            hoaDonToUpdate.setDiaChi(hoaDon.getDiaChi());
            hoaDonToUpdate.setHinhThucThanhToan(hoaDon.getHinhThucThanhToan());
            hoaDonToUpdate.setHinhThucGiaoHang(hoaDon.getHinhThucGiaoHang());
            hoaDonToUpdate.setSdtNguoiNhan(hoaDon.getSdtNguoiNhan());
            hoaDonToUpdate.setSdtNguoiShip(hoaDon.getSdtNguoiShip());
            hoaDonToUpdate.setTenNguoiNhan(hoaDon.getTenNguoiNhan());
            hoaDonToUpdate.setCreateDate(hoaDon.getCreateDate());
            hoaDonToUpdate.setLastModifiedDate(hoaDon.getLastModifiedDate());
            hoaDonToUpdate.setTrangThai(hoaDon.getTrangThai());
            hoaDonRepository.save(hoaDonToUpdate);
            return hoaDonToUpdate;
        }else {
            return hoaDon;
        }
    }

    @Override
    public HoaDon getOne(UUID id) {
        return hoaDonRepository.findById(id).orElse(null);
    }

    @Override
    public Page<HoaDon> getListHoaDon(Pageable pageable) {
        return hoaDonRepository.findAll(pageable);
    }

    @Override
    public Page<HoaDon> searchHD(String keyword, Pageable pageable) {
        return hoaDonRepository.searchHoaDon(keyword, pageable);
    }
}
