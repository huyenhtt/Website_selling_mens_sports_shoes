package com.example.Website_Selling_Shoes_Men_Sport.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "GioHangChiTiet")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class GioHangChiTiet {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "DonGia")
    private Double donGia;

    @Column(name = "DonGiaKhiGiam")
    private Double donGiaKhiGiam;

    @ManyToOne()
    @JoinColumn(name = "IdGioHang")
    private GioHang gioHang;

    @ManyToOne()
    @JoinColumn(name = "IdChiTietSP")
    private ChiTietSanPham ctsp;

}
