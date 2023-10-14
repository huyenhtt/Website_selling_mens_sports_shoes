package com.example.Website_Selling_Shoes_Men_Sport.repository;

import com.example.Website_Selling_Shoes_Men_Sport.entity.HoaDonChiTiet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.UUID;

@Repository
public interface HoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, UUID> {
//    @Query(value = "select hdct from HoaDonChiTiet hdct where hdct.giaBan )
//    Page<HoaDonChiTiet> searchHDCT(String keyword, Pageable pageable);
}
