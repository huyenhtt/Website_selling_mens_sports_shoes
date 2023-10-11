package com.example.Website_Selling_Shoes_Men_Sport.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "MauSac")
public class MauSac {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;
    @NotBlank(message = "không để trống")
    public String ma;
    @NotBlank(message = "không để trống")
    public String tenMau;
    public LocalDateTime createDate;
    public LocalDateTime lastModifiledDate;
    @NotNull(message = "không để trống")
    public Integer trangThai;

    public MauSac(){}

    public MauSac(UUID id, String ma, String tenMau, LocalDateTime createDate, LocalDateTime lastModifiledDate, Integer trangThai) {
        this.id = id;
        this.ma = ma;
        this.tenMau = tenMau;
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

    public String getTenMau() {
        return tenMau;
    }

    public void setTenMau(String tenMau) {
        this.tenMau = tenMau;
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
