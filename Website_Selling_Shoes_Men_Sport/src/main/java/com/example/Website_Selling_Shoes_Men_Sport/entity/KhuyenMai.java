package com.example.Website_Selling_Shoes_Men_Sport.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "KhuyenMai")
public class KhuyenMai {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;
    public String maKhuyenMai;
    public String tenKhuyenMai;
    public Float giaTri;
    public String loaiKhuyenMai;
    public LocalDate ngayBatDau;
    public LocalDate ngayKetThuc;
    public LocalDateTime createDate;
    public LocalDateTime lastModifiledDate;
    public Integer trangThai;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(String maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }

    public String getTenKhuyenMai() {
        return tenKhuyenMai;
    }

    public void setTenKhuyenMai(String tenKhuyenMai) {
        this.tenKhuyenMai = tenKhuyenMai;
    }

    public Float getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(Float giaTri) {
        this.giaTri = giaTri;
    }

    public String getLoaiKhuyenMai() {
        return loaiKhuyenMai;
    }

    public void setLoaiKhuyenMai(String loaiKhuyenMai) {
        this.loaiKhuyenMai = loaiKhuyenMai;
    }

    public LocalDate getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(LocalDate ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public LocalDate getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(LocalDate ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
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

    public KhuyenMai(){}

    public KhuyenMai(UUID id, String maKhuyenMai, String tenKhuyenMai, Float giaTri, String loaiKhuyenMai, LocalDate ngayBatDau, LocalDate ngayKetThuc, LocalDateTime createDate, LocalDateTime lastModifiledDate, Integer trangThai) {
        this.id = id;
        this.maKhuyenMai = maKhuyenMai;
        this.tenKhuyenMai = tenKhuyenMai;
        this.giaTri = giaTri;
        this.loaiKhuyenMai = loaiKhuyenMai;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.createDate = createDate;
        this.lastModifiledDate = lastModifiledDate;
        this.trangThai = trangThai;
    }
}