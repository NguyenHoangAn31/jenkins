package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Iphone;

public interface IphoneRepository extends JpaRepository<Iphone , String> {
    
}
