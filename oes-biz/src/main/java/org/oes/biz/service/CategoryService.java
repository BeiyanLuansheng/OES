package org.oes.biz.service;

import org.oes.biz.entity.Category;

import java.util.List;

public interface CategoryService {

    void createCategory(Category category);

    void deleteCategory(Category category);

    List<Category> findCategoryList(Category category);
}
