package com.example.Website_Selling_Shoes_Men_Sport.service;

import com.example.Website_Selling_Shoes_Men_Sport.entity.HoaDon;
import com.example.Website_Selling_Shoes_Men_Sport.entity.HoaDonChiTiet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface HoaDonChiTietService {

    List<HoaDonChiTiet> getListHDCT();

    HoaDonChiTiet insertHDCT(HoaDonChiTiet hoaDonChiTiet);

    HoaDonChiTiet deleteHDCT(UUID id);

    HoaDonChiTiet updateHDCT(HoaDonChiTiet hoaDonChiTiet, UUID id);

    HoaDonChiTiet getOne(UUID id);

    Page<HoaDonChiTiet> getListHDCT(Pageable pageable);

}
