// package com.example.demo.Category.JPATest;

// import static org.assertj.core.api.Assertions.*;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
// import com.example.demo.entities.Category;
// import com.example.demo.repositories.CategoryRepository;

// import lombok.extern.log4j.Log4j2;

// @DataJpaTest // sử dụng cơ sở dữ liệu NHÚNG mặc định h2,HSQLDB cho kiểm thử kết hợp
//              // transaction rollback (mục đích kiểm thử jpa repository)
// @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // vô hiệu hóa cơ sở dữ liệu nhúng
//                                                                              // h2,HSQLDB và sử
//                                                                              // dụng cấu hình cơ sở dữ liệu thực là
//                                                                              // InnoDB của Mysql
// @Log4j2
// class CategoryJPATest {

//     @Autowired
//     private CategoryRepository categoryRepository;

//     @Test
//     void testFindByName() {

//         log.info("JPA TEST");

//         // Arrange
//         Category category = new Category();
//         category.setName("NameForTest");
//         category.setStatus(true);
//         categoryRepository.save(category);

//         // Act
//         Category foundCategory = categoryRepository.findByName("NameForTest").orElse(null);

//         // Assert
//         assertThat(foundCategory).isNotNull();
//         assertThat(foundCategory.getName()).isEqualTo("NameForTest");
//     }

//     @Test
//     void testSaveAndFindById() {
//         // Arrange
//         Category category = new Category();
//         category.setName("Electronics");
//         category.setStatus(true);
//         categoryRepository.save(category);

//         // Act
//         Category foundCategory = categoryRepository.findById(category.getId()).orElse(null);

//         // Assert
//         assertThat(foundCategory).isNotNull();
//         assertThat(foundCategory.getName()).isEqualTo("Electronics");
//         assertThat(foundCategory.isStatus()).isTrue();
//     }
// }
