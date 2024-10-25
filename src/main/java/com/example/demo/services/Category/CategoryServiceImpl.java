package com.example.demo.services.Category;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CategoryDto;
import com.example.demo.entities.Category;
import com.example.demo.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CategoryDto> getAll() {
        List<Category> listCategory = categoryRepository.findAll();

        return listCategory.stream()
                .map(category -> modelMapper.map(category, CategoryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto findByName(String name) {
        Optional<Category> category = categoryRepository.findByName(name);
        return category.map(cat -> modelMapper.map(cat, CategoryDto.class)).orElse(null);
    }

    @Override
    public CategoryDto findById(String id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.map(cat -> modelMapper.map(cat, CategoryDto.class)).orElse(null);
    }

    @Override
    public CategoryDto save(CategoryDto dto) {
        Category category = modelMapper.map(dto, Category.class);

        Category savedCategory = categoryRepository.save(category);
        CategoryDto savedCategoryDto = modelMapper.map(savedCategory,
                CategoryDto.class);
        return savedCategoryDto;
    }

    @Override
    public boolean delete(String id) {
        try {
            categoryRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
