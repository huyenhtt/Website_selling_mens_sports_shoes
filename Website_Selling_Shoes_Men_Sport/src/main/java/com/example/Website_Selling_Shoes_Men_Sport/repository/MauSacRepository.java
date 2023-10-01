package com.example.Website_Selling_Shoes_Men_Sport.repository;

import com.example.Website_Selling_Shoes_Men_Sport.entity.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface MauSacRepository extends JpaRepository<MauSac, UUID> {
    @Query("select l from MauSac l where l.ma like %?1% or l.tenMau like %?1% or ?1 is null")
    Page<MauSac> searchMauSac(String keyword, Pageable pageable);
}
