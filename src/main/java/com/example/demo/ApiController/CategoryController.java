package com.example.demo.ApiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CategoryDto;
import com.example.demo.services.Category.CategoryService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping(value = "/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CategoryDto>> findAll() {
        log.info("Info level log message");
        List<CategoryDto> listDto = categoryService.getAll();
        return ResponseEntity.ok(listDto);

    }

    @GetMapping(value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoryDto> findByName(@PathVariable String name) {

        CategoryDto categoryDto = categoryService.findByName(name);

        return ResponseEntity.ok(categoryDto);
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {

        CategoryDto savedCategoryDto = categoryService.save(categoryDto);

        return ResponseEntity.ok(savedCategoryDto);
    }

    @PutMapping(value = "/edit/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoryDto> editCategory(
            @PathVariable String id, @RequestBody CategoryDto categoryDto) {

        CategoryDto findCategoryDto = categoryService.findById(id);
        if (findCategoryDto != null) {
            categoryDto.setId(id);
            CategoryDto savedCategoryDto = categoryService.save(categoryDto);

            return ResponseEntity.ok(savedCategoryDto);

        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable String id) {
        CategoryDto findCategoryDto = categoryService.findById(id);
        if (findCategoryDto != null) {
            boolean deleted = categoryService.delete(id);
            if (deleted) {
                return ResponseEntity.ok("Category deleted successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete the category.");
            }
        }
        return ResponseEntity.notFound().build();
    }

}
