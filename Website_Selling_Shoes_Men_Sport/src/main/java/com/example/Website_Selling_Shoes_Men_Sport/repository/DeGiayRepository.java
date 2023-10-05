package com.example.Website_Selling_Shoes_Men_Sport.repository;

import com.example.Website_Selling_Shoes_Men_Sport.entity.DeGiay;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface DeGiayRepository extends JpaRepository<DeGiay, UUID> {
    @Query("select l from DeGiay l where l.ma like %?1% or l.loaiDe like %?1% or ?1 is null")
    Page<DeGiay> searchDeGiay(String keyword, Pageable pageable);
    @Query(value = "select d from DeGiay d where d.ma = ?1")
    DeGiay findByMa(String ma);
}
