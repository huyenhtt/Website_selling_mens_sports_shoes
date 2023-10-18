package com.example.Website_Selling_Shoes_Men_Sport.repository;

import com.example.Website_Selling_Shoes_Men_Sport.entity.LoaiGiay;
import com.example.Website_Selling_Shoes_Men_Sport.service.LoaiGiayService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LoaiGiayRepo extends JpaRepository<LoaiGiay, UUID> {
    @Query("select l from LoaiGiay l where l.ma like %?1% or l.tenTheLoai like %?1% or ?1 is null")
    Page<LoaiGiay> searchLG(String keyword, Pageable pageable);

}
