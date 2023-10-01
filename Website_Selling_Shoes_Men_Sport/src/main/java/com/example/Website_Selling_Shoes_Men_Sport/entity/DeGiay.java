package com.example.Website_Selling_Shoes_Men_Sport.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "DeGiay")
public class DeGiay {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;
    public String ma;
    public String loaiDe;
    public String moTa;
    public LocalDateTime createDate;
    public LocalDateTime lastModifiledDate;
    public Integer trangThai;

    public DeGiay(){}
    public DeGiay(UUID id, String ma, String loaiDe, String moTa, LocalDateTime createDate, LocalDateTime lastModifiledDate, Integer trangThai) {
        this.id = id;
        this.ma = ma;
        this.loaiDe = loaiDe;
        this.moTa = moTa;
        this.createDate = createDate;
        this.lastModifiledDate = lastModifiledDate;
        this.trangThai = trangThai;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getLoaiDe() {
        return loaiDe;
    }

    public void setLoaiDe(String loaiDe) {
        this.loaiDe = loaiDe;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getLastModifiledDate() {
        return lastModifiledDate;
    }

    public void setLastModifiledDate(LocalDateTime lastModifiledDate) {
        this.lastModifiledDate = lastModifiledDate;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }
}
