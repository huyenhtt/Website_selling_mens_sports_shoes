package com.example.Website_Selling_Shoes_Men_Sport.service.impl;

import com.example.Website_Selling_Shoes_Men_Sport.entity.ChiTietSanPham;
import com.example.Website_Selling_Shoes_Men_Sport.entity.KichCo;
import com.example.Website_Selling_Shoes_Men_Sport.entity.LoaiGiay;
import com.example.Website_Selling_Shoes_Men_Sport.repository.ChiTietSanPhamRepo;
import com.example.Website_Selling_Shoes_Men_Sport.service.ChiTietSanPhamService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService {
    @Autowired
    ChiTietSanPhamRepo repo;
    @Autowired
    HttpServletRequest request;

    @Override
    public List<ChiTietSanPham> getList() {
        return repo.findAll();
    }

    @Override
    public Page<ChiTietSanPham> getListSP(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public void addKC(ChiTietSanPham qlSanPham) {
        Random random = new Random();
        qlSanPham.setMaCTSP("CTSP" + random.nextInt());
        repo.save(qlSanPham);
    }

    @Override
    public void deleteSP(UUID id) {
        repo.deleteById(id);
    }

    @Override
    public Page<ChiTietSanPham> searchByMau(UUID idMau, Pageable pageable) {
        return repo.searchByMau(idMau, pageable);
    }

    @Override
    public Page<ChiTietSanPham> searchKichCo(UUID idKC, Pageable pageable) {
        return repo.searchByKichCo(idKC, pageable);
    }

    @Override
    public Page<ChiTietSanPham> searchDeGiay(UUID idDe, Pageable pageable) {
        return repo.searchByDeGiay(idDe, pageable);
    }



    @Override
    public Page<ChiTietSanPham> searchCL(UUID idCL, Pageable pageable) {
        return repo.searchByChatLieu(idCL, pageable);
    }

    @Override
    public Page<ChiTietSanPham> searchLoaiGiay(UUID idLG, Pageable pageable) {
        return repo.searchByLG(idLG, pageable);
    }

    @Override
    public ChiTietSanPham getOne(UUID id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Page<ChiTietSanPham> searchCTSP(String keyword, Pageable pageable) {
        return repo.searchCTSP(keyword, pageable);
    }

    @Override
    public List<LoaiGiay> search2(String keyword) {
        return repo.search(keyword);
    }

    @Override
    public List<KichCo> search2KC(Integer size) {
        return repo.search2KC(size);
    }

    @Override
    public List<KichCo> getListKC() {
        return repo.listKC();
    }
}
