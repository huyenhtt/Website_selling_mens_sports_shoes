package com.example.Website_Selling_Shoes_Men_Sport.service;

import com.example.Website_Selling_Shoes_Men_Sport.entity.DeGiay;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface DeGiayService {
    List<DeGiay> GetAllDeGiay();
    DeGiay AddDeGiay(DeGiay deGiay);
    DeGiay UpdateDeGiay(DeGiay deGiay, UUID id);
    DeGiay DeleteDeGiay(UUID id);
    DeGiay GetDeGiayById(UUID id);
    Page<DeGiay> getListDeGiay(Pageable pageable);

    Page<DeGiay> searchDeGiay(String keyword, Pageable pageable);

}
