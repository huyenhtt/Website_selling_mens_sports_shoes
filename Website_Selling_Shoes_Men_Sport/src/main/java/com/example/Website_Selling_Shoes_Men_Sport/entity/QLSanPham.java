package com.example.Website_Selling_Shoes_Men_Sport.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "ChiTietSanPham")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QLSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    UUID id;

    @ManyToOne()
    @JoinColumn(name = "Idsp")
    SanPham sanPham;

    @ManyToOne()
    @JoinColumn(name = "Idmausac")
    @NotNull(message = "Mời chọn màu sắc")
    MauSac mauSac;

    @ManyToOne()
    @JoinColumn(name = "Idtheloai")
    @NotNull(message = "Mời chọn thể loại")
    LoaiGiay loaiGiay;

    @ManyToOne()
    @JoinColumn(name = "Idkichco")
//    @NotNull(message = "Mời chọn kích cỡ")
    KichCo kichCo;

    @ManyToOne()
    @JoinColumn(name = "Idchatlieu")
    @NotNull(message = "Mời chọn chất liệu")
    ChatLieu chatLieu;

    @ManyToOne()
    @JoinColumn(name = "Iddegiay")
    @NotNull(message = "Mời chọn đế giầy")
    DeGiay deGiay;


    @Column(name = "MaCTSP")
    String maCTSP;


    @Column(name = "Giaban")
    @NotNull(message = "không để trống")
    Double giaBan;

    @Column(name = "Soluong")
    @NotNull(message = "không để trống")
    Integer soLuong;

    @Column(name = "MoTaCT")
    @NotBlank(message = "không để trống")
    String moTaCT;

    @Column(name = "Createdate")
//    @NotNull(message = "Không để trống")
//    @DateTimeFormat(pattern = "dd/MM/yyyy")
    LocalDateTime createDate;

    @Column(name = "Lastmodifileddate")
//    @NotNull(message = "Không để trống")
//    @DateTimeFormat(pattern = "dd/MM/yyyy")
    LocalDateTime lastModifiedDate;

    @Column(name = "Trangthai")
    @NotNull(message = "Không để trống")
    Integer trangThai;
    //hinh anh
    @OneToOne(mappedBy = "ctsp")
    HinhAnh hinhAnhs;
    @Override
    public String toString() {
        return sanPham.getTenSanPham();
    }

    public void loadFromDomainModel(ChiTietSanPham domain) {
        this.setChatLieu(domain.getChatLieu());
        this.setDeGiay(domain.getDeGiay());
        this.setGiaBan(domain.getGiaBan());
        this.setKichCo(domain.getKichCo());
        this.setSanPham(domain.getSanPham());
        this.setTrangThai(domain.getTrangThai());
        this.setMoTaCT(domain.getMoTaCT());
        this.setSoLuong(domain.getSoLuong());
        this.setLoaiGiay(domain.getLoaiGiay());
        this.setMauSac(domain.getMauSac());
    }
}
