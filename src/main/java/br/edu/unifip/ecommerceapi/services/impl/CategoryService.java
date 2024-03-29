package br.edu.unifip.ecommerceapi.services;

import br.edu.unifip.ecommerceapi.models.Category;
import br.edu.unifip.ecommerceapi.repositories.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {

    final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Optional<Category> findById(UUID id) {
        return categoryRepository.findById(id);
    }

    @Transactional
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Transactional // você garante que eles vão ser executados dentro um contexto transacional e o rollback
    // será feito caso ocorra algum erro
    public void delete(Category category) {
        categoryRepository.delete(category);
    }

    public Category partialUpdate(Category category, Map<Object, Object> objectMap) {
        objectMap.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Category.class, (String) key);
            field.setAccessible(true);

            try {
                value = BigDecimal.valueOf((double) value);
            } catch (ClassCastException ignored) {
            }
            ReflectionUtils.setField(field, category, value);
        });
        return categoryRepository.save(category);
    }

    public List<Category> findByActiveTrue() {
        return categoryRepository.findByActiveTrue();
    }
}