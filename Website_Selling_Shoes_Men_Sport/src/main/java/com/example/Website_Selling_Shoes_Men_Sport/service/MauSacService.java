package com.example.Website_Selling_Shoes_Men_Sport.service;

import com.example.Website_Selling_Shoes_Men_Sport.entity.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface MauSacService {
    List<MauSac> GetAllMauSac();
    MauSac AddMauSac(MauSac mauSac);
    MauSac UpdateMauSac(MauSac mauSac, UUID id);
    MauSac DeleteMauSac(UUID id);
    MauSac GetMauSacById(UUID id);
    Page<MauSac> getListMauSac(Pageable pageable);

    Page<MauSac> searchMauSac(String keyword, Pageable pageable);
}
