package edu.miu.cs545.project.onlinestore.service;

import edu.miu.cs545.project.onlinestore.domain.Category;

import java.util.Collection;
import java.util.Optional;

public interface ICategoryService {
    Collection<Category> getAll();

    Optional<Category> getCategoryById(Long id);

    Optional<Category> getCategoryByName(String name);

    void createCategory(Category category);
}
