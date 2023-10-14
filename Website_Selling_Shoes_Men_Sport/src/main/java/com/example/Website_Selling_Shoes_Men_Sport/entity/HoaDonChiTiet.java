package com.example.Website_Selling_Shoes_Men_Sport.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "HoaDonChiTiet")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class HoaDonChiTiet {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "SoLuong")
    @NotNull(message = "Không để trống")
    private Integer soLuong;

    @Column(name = "DonGia")
    @NotNull(message = "Không để trống")
    private Float donGia;

    @Column(name = "GiaBan")
    @NotNull(message = "Không để trống")
    private Float giaBan;

    @Column(name = "GiamGiaKhuyenMai")
    @NotNull(message = "Không để trống")
    private Double giamGiaKhuyenMai;

    @Column(name = "CreateDate")
    private LocalDateTime createDate;

    @Column(name = "LastModifiledDate")
    private LocalDateTime lastModifiedDate;


//    @ManyToOne
//    @JoinColumn(name = "IdHoaDon")
//    private HoaDon hoaDon;
//
//    @ManyToOne
//    @JoinColumn(name = "IdChiTietSP")
//    private ChiTietSanPham chiTietSanPham;

}
