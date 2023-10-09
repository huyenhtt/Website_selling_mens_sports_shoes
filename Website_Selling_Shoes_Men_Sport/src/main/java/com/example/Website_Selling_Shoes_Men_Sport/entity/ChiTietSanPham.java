package com.example.Website_Selling_Shoes_Men_Sport.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ChiTietSanPham")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChiTietSanPham {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
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

    //hinh anh
    @OneToOne(mappedBy = "ctsp")
    HinhAnh hinhAnhs;

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

    public void loadFromViewModel(QLSanPham vm) {
//        this.setHinhAnh(vm.getHinhAnh());
        this.setChatLieu(vm.getChatLieu());
        this.setDeGiay(vm.getDeGiay());

        this.setGiaBan(vm.getGiaBan());
        this.setKichCo(vm.getKichCo());
        this.setSanPham(vm.getSanPham());
        this.setTrangThai(vm.getTrangThai());
        this.setMoTaCT(vm.getMoTaCT());
        this.setSoLuong(vm.getSoLuong());
        this.setLoaiGiay(vm.getLoaiGiay());
        this.setMauSac(vm.getMauSac());
    }

//    public ChiTietSanPham(SanPham sanPham, ChatLieu chatLieu, DeGiay deGiay, LoaiGiay loaiGiay, Double donGia, MultipartFile hinhAnh, KichCo kichCo, MauSac mauSac, String moTaCT, Double donGia1) {
//    }

}
