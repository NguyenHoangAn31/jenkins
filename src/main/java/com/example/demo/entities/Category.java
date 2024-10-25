package com.example.demo.entities;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    @Id
    @UuidGenerator
    private String id;
    private String name;
    private boolean status;
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
