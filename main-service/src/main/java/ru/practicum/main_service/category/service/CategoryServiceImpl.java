package ru.practicum.main_service.category.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.practicum.main_service.category.dto.CategoryDto;
import ru.practicum.main_service.category.dto.NewCategoryDto;
import ru.practicum.main_service.category.mapper.CategoryMapper;
import ru.practicum.main_service.category.model.Category;
import ru.practicum.main_service.category.repository.CategoryRepository;
import ru.practicum.main_service.exception.BadRequestException;
import ru.practicum.main_service.exception.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    @Transactional
    public CategoryDto create(NewCategoryDto newCategoryDto) {
        log.info("Добавление новой категории {}", newCategoryDto);
        if (newCategoryDto.getName().length() > 50) {
            throw new BadRequestException("more then 50 chars");
        }
        return categoryMapper.toCategoryDto(categoryRepository.save(categoryMapper.newCategoryDtoToCategory(newCategoryDto)));
    }

    @Override
    @Transactional
    public CategoryDto patch(Long catId, CategoryDto categoryDto) {
        log.info("Обновление категории с id {} новыми параметрами {}", catId, categoryDto);

        categoryRepository.findById(catId)
                .orElseThrow(() -> new NotFoundException("Категории с таким id не существует."));
        if (categoryDto.getName().length() > 50) {
            throw new BadRequestException("more then 50 chars");
        }
        categoryDto.setId(catId);
        return categoryMapper.toCategoryDto(categoryRepository.save(categoryMapper.categoryDtoToCategory(categoryDto)));
    }

    @Override
    public List<CategoryDto> getAll(Pageable pageable) {
        log.info("Вывод всех категорий с пагинацией {}", pageable);

        return categoryRepository.findAll(pageable).stream()
                .map(categoryMapper::toCategoryDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto getById(Long catId) {
        log.info("Вывод категории с id {}", catId);

        Category category = categoryRepository.findById(catId)
                .orElseThrow(() -> new NotFoundException("Категории с таким id не существует."));

        return categoryMapper.toCategoryDto(category);
    }

    @Override
    public Category getCategoryById(Long catId) {
        log.info("Вывод категории с id {}", catId);

        return categoryRepository.findById(catId)
                .orElseThrow(() -> new NotFoundException("Категории с таким id не существует."));
    }

    @Override
    @Transactional
    public void deleteById(Long catId) {
        log.info("Удаление категории с id {}", catId);

        categoryRepository.findById(catId)
                .orElseThrow(() -> new NotFoundException("Категории с таким id не существует."));

        categoryRepository.deleteById(catId);
    }
}
