package com.example.demo.entities;


import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @UuidGenerator
    private String id;
    private String name;
    private String image;
    private LocalDate birthday;
    private String address;
    private String phone;
    private String email;
    private String provider;
    private String keycode;

    @OneToMany(mappedBy="customer")
    private List<Order> orders;
}
