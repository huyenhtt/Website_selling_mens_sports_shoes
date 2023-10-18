package com.example.Website_Selling_Shoes_Men_Sport.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "GioHang")
public class GioHang {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IdND", referencedColumnName = "id")
    private NguoiDung nguoiDung;

    @Column(name = "Createdate")

    private LocalDateTime createDate;

    @Column(name = "Lastmodifileddate")

    private LocalDateTime lastModifiedDate;

    @Column(name = "Ghichu")
    private String ghiChu;

    @Column(name = "Trangthai")
    @NotNull(message = "Không để trống")
    private Integer trangThai;

    @OneToMany(mappedBy = "gioHang")
    private List<GioHangChiTiet> gioHangChiTiet;

}
