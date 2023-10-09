package com.example.Website_Selling_Shoes_Men_Sport.repository;

import com.example.Website_Selling_Shoes_Men_Sport.entity.ChiTietSanPham;
import com.example.Website_Selling_Shoes_Men_Sport.entity.HinhAnh;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HinhAnhRepository extends JpaRepository<HinhAnh, UUID> {

    @Query(value = "select h from HinhAnh h where h.id = ?1")
    HinhAnh findId(UUID id);


    @Query("select ctsp from ChiTietSanPham ctsp")
    List<ChiTietSanPham> getAllCSP();

    @Query(value = "select ctsp.id from ChiTietSanPham ctsp where ctsp.id LIKE :keyword", nativeQuery = true)
    List<ChiTietSanPham> searchCTSP(UUID keyword);

    @Query(value = "select h.Id from ChiTietSanPham ct join HinhAnh h on h.IdCTSP=ct.Id where ct.Id= ?1", nativeQuery = true)
    UUID getIdHinhAnh(UUID keyword);

    @Query(value = "select h from HinhAnh h")
    Page<HinhAnh> listHinhAnh(Pageable pageable);

    @Query(value = "select ctsp.id from HinhAnh h join ChiTietSanPham ctsp on ctsp.id=h.IdCTSP where h.id=?1", nativeQuery = true)
    UUID getIdCTSP(UUID id);
}
