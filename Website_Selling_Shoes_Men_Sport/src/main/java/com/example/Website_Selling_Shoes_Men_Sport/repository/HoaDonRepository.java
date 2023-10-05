package com.example.Website_Selling_Shoes_Men_Sport.repository;

import com.example.Website_Selling_Shoes_Men_Sport.entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HoaDonRepository extends JpaRepository<HoaDon, UUID> {

}
