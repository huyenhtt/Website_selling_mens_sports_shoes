package com.example.Website_Selling_Shoes_Men_Sport.repository;

import com.example.Website_Selling_Shoes_Men_Sport.entity.HoaDon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface HoaDonRepository extends JpaRepository<HoaDon, UUID> {
    @Query(value = "select hd from HoaDon  hd where hd.maHD like %?1% ")
    Page<HoaDon> searchHoaDon(String keyword, Pageable pageable);
}
