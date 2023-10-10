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
@Table(name = "HoaDon")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class HoaDon {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "MaHD")
    @NotBlank(message = "Không để trống")
    private String maHD;

    @Column(name = "NgayTao")
    private LocalDateTime ngayTao;

    @Column(name = "NgayThanhToan")
    private LocalDateTime ngayThanhToan;

    @Column(name = "NgayNhan")
    private LocalDateTime ngayNhan;

    @Column(name = "NgayShip")
    private LocalDateTime ngayShip;

    @Column(name = "DiaChi")
    @NotBlank(message = "Không để trống")
    private String diaChi;

    @Column(name = "HinhThucThanhToan")
    @NotNull(message = "Không để trống")
    private Integer hinhThucThanhToan;

    @Column(name = "HinhThucGiaoHang")
    @NotNull(message = "Không để trống")
    private Integer hinhThucGiaoHang;

    @Column(name = "SDTNguoiNhan")
    @NotBlank(message = "Không để trống")
    private String sdtNguoiNhan;

    @Column(name = "SDTNguoiShip")
    @NotBlank(message = "Không để trống")
    private String sdtNguoiShip;

    @Column(name = "TenNguoiNhan")
    @NotBlank(message = "Không để trống")
    private String tenNguoiNhan;

    @Column(name = "CreateDate")
    private LocalDateTime createDate;

    @Column(name = "LastModifiledDate")
    private LocalDateTime lastModifiedDate;

    @Column(name = "TrangThai")
    @NotNull(message = "Không để trống")
    private Integer trangThai;

    @ManyToOne
    @JoinColumn(name = "IdND")
    private NguoiDung nguoiDung;

}
