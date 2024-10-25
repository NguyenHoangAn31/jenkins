package com.example.demo.entities;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="iphones")

public class Iphone {
    @Id
    @UuidGenerator
    private String id;
    private int ram;
    private int capacity;
    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
}
