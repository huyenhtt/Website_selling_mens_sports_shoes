package com.example.Website_Selling_Shoes_Men_Sport.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
@Entity
@Table(name = "HinhAnh")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HinhAnh {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCTSP", referencedColumnName = "id")
    ChiTietSanPham ctsp;

    @Column(name = "Tenanh")
    String tenanh;

    @Column(name = "DuongDan1")
    String duongdan1;

    @Column(name = "DuongDan2")
    String duongdan2;

    @Column(name = "DuongDan3")
    String duongdan3;

    @Column(name = "Trangthai")
    int trangthai;
}
