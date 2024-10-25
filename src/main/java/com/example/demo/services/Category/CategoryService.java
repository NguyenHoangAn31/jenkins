package com.example.demo.services.Category;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.CategoryDto;

@Service
public interface CategoryService {
    public List<CategoryDto> getAll();

    public CategoryDto findById(String id);

    public CategoryDto findByName(String name);

    public CategoryDto save(CategoryDto dto);

    public boolean delete(String id);
}
