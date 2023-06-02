package ru.practicum.main_service.category.service;

import org.springframework.data.domain.Pageable;
import ru.practicum.main_service.category.dto.CategoryDto;
import ru.practicum.main_service.category.dto.NewCategoryDto;
import ru.practicum.main_service.category.model.Category;

import java.util.List;

public interface CategoryService {

    CategoryDto create(NewCategoryDto newCategoryDto);

    CategoryDto patch(Long catId, CategoryDto categoryDto);

    List<CategoryDto> getAll(Pageable pageable);

    CategoryDto getById(Long catId);

    Category getCategoryById(Long catId);

    void deleteById(Long catId);
}
