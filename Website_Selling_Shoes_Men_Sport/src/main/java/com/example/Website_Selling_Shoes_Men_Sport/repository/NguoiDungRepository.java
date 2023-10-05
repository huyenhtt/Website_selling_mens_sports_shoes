package com.example.Website_Selling_Shoes_Men_Sport.repository;

import com.example.Website_Selling_Shoes_Men_Sport.entity.Account;
import com.example.Website_Selling_Shoes_Men_Sport.entity.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface NguoiDungRepository extends JpaRepository<NguoiDung, UUID> {
    @Query("select nd from NguoiDung nd where nd.account.id = ?1")
    NguoiDung findNguoiDungByAccount(UUID id);
}
