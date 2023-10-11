package com.example.Website_Selling_Shoes_Men_Sport.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "NguoiDung")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class NguoiDung {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID id;

    @ManyToOne()
    @JoinColumn(name = "IdTaiKhoan")
    private Account account;

    @NotBlank(message = "không để trống")
    @Column(name = "Ma")
    private String ma;

    @NotBlank(message = "không để trống")
    @Column(name = "Ho")
    private String ho;

    @Column(name = "TenDem")
    @NotBlank(message = "không để trống")
    private String tenDem;

    @NotBlank(message = "không để trống")
    @Column(name = "Ten")
    private String ten;


    @Column(name = "GioiTinh")
    @NotNull(message = "không để trống")
    private Boolean gioiTinh = true;

    @Column(name = "NgaySinh")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @NotNull(message = "Không để trống")
    private Date ngaySinh;

    @Column(name = "DiaChi")
    @NotBlank(message = "không để trống")
    private String diaChi;

    @Column(name = "SoDienThoai")
    @NotBlank(message = "không để trống")
    private String soDienThoai;

    @Column(name = "Email")
    @NotBlank(message = "không để trống")
    private String email;

    @Column(name = "CreateDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date createDate;

    @Column(name = "LastModifiledDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date lastModifiedDate;

    @Column(name = "TrangThai")
    @NotNull(message = "không để trống")
    private Integer trangThai;
}