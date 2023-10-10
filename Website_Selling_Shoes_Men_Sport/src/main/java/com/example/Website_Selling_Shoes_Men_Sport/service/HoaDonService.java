package com.example.Website_Selling_Shoes_Men_Sport.service;

import com.example.Website_Selling_Shoes_Men_Sport.entity.ChatLieu;
import com.example.Website_Selling_Shoes_Men_Sport.entity.HoaDon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface HoaDonService {

    List<HoaDon> getListHD();

    HoaDon insertHD(HoaDon hoaDon);

    HoaDon deleteHD(UUID id);

    HoaDon updateHD(HoaDon hoaDon, UUID id);

    HoaDon getOne(UUID id);

    Page<HoaDon> getListHoaDon(Pageable pageable);

    Page<HoaDon> searchHD(String keyword, Pageable pageable);

}
