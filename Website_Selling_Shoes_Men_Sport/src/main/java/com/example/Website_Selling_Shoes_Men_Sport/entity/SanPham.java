package com.example.Website_Selling_Shoes_Men_Sport.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Sanpham")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    UUID id;

    @Column(name = "Masanpham")
    @NotBlank(message = "Không để trống")
    String maSanPham;

    @Column(name = "Tensanpham")
    @NotBlank(message = "Không để trống")
    String tenSanPham;

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

}

