package com.example.Website_Selling_Shoes_Men_Sport.repository;

import com.example.Website_Selling_Shoes_Men_Sport.entity.HoaDonChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.UUID;

public interface HoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, UUID> {
}
