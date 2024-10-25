package com.example.demo.Category.IntegrationTest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.example.demo.dto.CategoryDto;
import com.example.demo.services.Category.CategoryService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

@Log4j2
@WebMvcTest
public class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService categoryService;

    @Test
    public void testFindByName() throws Exception {

        log.info("INTEGRATION TEST");
        CategoryDto categoryDto = new CategoryDto("1", "Electronics", true);
        when(categoryService.findByName("Electronics")).thenReturn(categoryDto);
        mockMvc.perform(get("/api/category/name/Electronics"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Electronics"));
    }
}