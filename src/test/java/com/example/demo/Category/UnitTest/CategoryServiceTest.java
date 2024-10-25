package com.example.demo.Category.UnitTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import com.example.demo.dto.CategoryDto;
import com.example.demo.entities.Category;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.services.Category.CategoryServiceImpl;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAll() {
        log.info("UNIT TEST");

        // Arrange
        Category category1 = new Category("1", "Electronics", true, null);
        Category category2 = new Category("2", "Books", true, null);
        when(categoryRepository.findAll()).thenReturn(Arrays.asList(category1, category2));

        CategoryDto categoryDto1 = new CategoryDto("1", "Electronics", true);
        CategoryDto categoryDto2 = new CategoryDto("2", "Books", true);
        when(modelMapper.map(category1, CategoryDto.class)).thenReturn(categoryDto1);
        when(modelMapper.map(category2, CategoryDto.class)).thenReturn(categoryDto2);

        // Act
        List<CategoryDto> categories = categoryService.getAll();

        // Assert
        assertEquals(2, categories.size());
        assertEquals("Electronics", categories.get(0).getName());
        assertEquals("Books", categories.get(1).getName());
    }

    @Test
    void testFindByName() {
        // Arrange
        String name = "Electronics";
        Category category = new Category("1", name, true, null);
        CategoryDto categoryDto = new CategoryDto("1", name, true);
        when(categoryRepository.findByName(name)).thenReturn(Optional.of(category));
        when(modelMapper.map(category, CategoryDto.class)).thenReturn(categoryDto);

        // Act
        CategoryDto result = categoryService.findByName(name);

        // Assert
        assertNotNull(result);
        assertEquals(name, result.getName());
    }

    @Test
    void testFindById() {
        // Arrange
        String id = "1";
        Category category = new Category(id, "Electronics", true, null);
        CategoryDto categoryDto = new CategoryDto(id, "Electronics", true);
        when(categoryRepository.findById(id)).thenReturn(Optional.of(category));
        when(modelMapper.map(category, CategoryDto.class)).thenReturn(categoryDto);

        // Act
        CategoryDto result = categoryService.findById(id);

        // Assert
        assertNotNull(result);
        assertEquals(id, result.getId());
    }

    @Test
    void testSave() {
        // Arrange
        CategoryDto dto = new CategoryDto("1", "Electronics", true);
        Category category = new Category("1", "Electronics", true, null);
        when(modelMapper.map(dto, Category.class)).thenReturn(category);
        when(categoryRepository.save(category)).thenReturn(category);
        when(modelMapper.map(category, CategoryDto.class)).thenReturn(dto);

        // Act
        CategoryDto result = categoryService.save(dto);

        // Assert
        assertNotNull(result);
        assertEquals(dto.getName(), result.getName());
    }

    @Test
    void testDelete() {
        // Arrange
        String id = "1";
        doNothing().when(categoryRepository).deleteById(id);

        // Act
        boolean result = categoryService.delete(id);

        // Assert
        assertTrue(result);
        verify(categoryRepository, times(1)).deleteById(id);
    }
}
