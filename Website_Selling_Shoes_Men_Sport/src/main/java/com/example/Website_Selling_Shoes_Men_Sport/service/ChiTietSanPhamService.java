package com.example.Website_Selling_Shoes_Men_Sport.service;

import com.example.Website_Selling_Shoes_Men_Sport.entity.ChiTietSanPham;
import com.example.Website_Selling_Shoes_Men_Sport.entity.KichCo;
import com.example.Website_Selling_Shoes_Men_Sport.entity.LoaiGiay;
import com.example.Website_Selling_Shoes_Men_Sport.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ChiTietSanPhamService {
    List<ChiTietSanPham> getList();

    Page<ChiTietSanPham> getListSP(Pageable pageable);

    void addCTSP(ChiTietSanPham qlSanPham);

    void deleteSP(UUID id);

    //seacrchByMau
    Page<ChiTietSanPham> searchByMau(UUID idMau, Pageable pageable);

    Page<ChiTietSanPham> searchKichCo(UUID idKC, Pageable pageable);

    Page<ChiTietSanPham> searchDeGiay(UUID idDe, Pageable pageable);

    Page<ChiTietSanPham> searchCL(UUID idCL, Pageable pageable);

    Page<ChiTietSanPham> searchLoaiGiay(UUID idLG, Pageable pageable);


    ChiTietSanPham getOne(UUID id);

    Page<ChiTietSanPham> searchCTSP(String keyword, Pageable pageable);

    List<LoaiGiay> search2(String keyword);
    //search sp
    List<SanPham> search2SP(String keyword);

    List<KichCo> search2KC(Integer size);

    List<KichCo> getListKC();

    // v3 updatectsp modal
    UUID getOneToAddModal(UUID id);

    Page<ChiTietSanPham> listCTSP(UUID id, Pageable pageable);
}
