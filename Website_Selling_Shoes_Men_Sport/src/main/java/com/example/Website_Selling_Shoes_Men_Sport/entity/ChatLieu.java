package com.example.Website_Selling_Shoes_Men_Sport.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "ChatLieu")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ChatLieu {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "MaChatLieu")
    @NotBlank(message = "Không để trống")
    private String maChatLieu;

    @Column(name = "TenChatLieu")
    @NotBlank(message = "Không để trống")
    private String tenChatLieu;

    @Column(name = "CreateDate")
    private LocalDateTime createDate;

    @Column(name = "LastModifiledDate")
    private LocalDateTime lastModifiedDate;

    @Column(name = "TrangThai")
    @NotNull(message = "Không để trống")
    private Integer trangThai;

}
