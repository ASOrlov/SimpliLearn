package com.example.sportyshoes.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "purchases")
public class PurchaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(nullable = false)
    private UserEntity user;

    @OneToOne
    @JoinColumn(nullable = false)
    private ProductEntity product;

    private Double price;

    @Column(nullable = false)
    private Long amount;

    private Double summa;

    private LocalDateTime date;
}
