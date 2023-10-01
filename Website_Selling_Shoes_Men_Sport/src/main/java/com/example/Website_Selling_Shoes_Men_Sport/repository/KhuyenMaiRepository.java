package com.example.Website_Selling_Shoes_Men_Sport.repository;

import com.example.Website_Selling_Shoes_Men_Sport.entity.KhuyenMai;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface KhuyenMaiRepository extends JpaRepository<KhuyenMai, UUID> {
    @Query("select l from KhuyenMai l where l.maKhuyenMai like %?1% or l.tenKhuyenMai like %?1% or ?1 is null")
    Page<KhuyenMai> searchKhuyenMai(String keyword, Pageable pageable);
}
