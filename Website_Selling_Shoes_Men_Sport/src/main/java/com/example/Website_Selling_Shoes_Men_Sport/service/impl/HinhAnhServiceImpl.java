package com.example.Website_Selling_Shoes_Men_Sport.service.impl;

import com.example.Website_Selling_Shoes_Men_Sport.entity.ChiTietSanPham;
import com.example.Website_Selling_Shoes_Men_Sport.entity.HinhAnh;
import com.example.Website_Selling_Shoes_Men_Sport.repository.ChiTietSanPhamRepo;
import com.example.Website_Selling_Shoes_Men_Sport.repository.HinhAnhRepository;
import com.example.Website_Selling_Shoes_Men_Sport.service.HinhAnhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HinhAnhServiceImpl implements HinhAnhService {

    @Autowired
    HinhAnhRepository repository;

    @Autowired
    ChiTietSanPhamRepo chiTietSanPhamRepo;

    @Value("${image.upload.path}")
    private String imageUploadPath;

    // Các phương thức khác trong dịch vụ
    @Override
    public String getImageUploadPath() {
        return imageUploadPath;
    }

    @Override
    public Page<HinhAnh> listHinhAnh(Pageable pageable) {
        return repository.listHinhAnh(pageable);
    }

    @Override
    public UUID getIdHinhAnh(UUID keyword) {
        return repository.getIdHinhAnh(keyword);
    }

    @Override
    public List<HinhAnh> getAll() {
        return repository.findAll();
    }

    @Override
    public List<ChiTietSanPham> getAllCTSP() {
        return chiTietSanPhamRepo.findAll();
    }

    @Override
    public List<ChiTietSanPham> searchCTSP(UUID keyword) {
        return repository.searchCTSP(keyword);
    }

    @Override
    public HinhAnh findById(UUID id) {
        return repository.findId(id);
    }

}
