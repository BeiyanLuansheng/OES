package org.oes.biz.service.impl;

import org.oes.biz.entity.Category;
import org.oes.biz.mapper.CategoryMapper;
import org.oes.biz.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createCategory(Category category) {
        if (category.getParentId() == null) {
            category.setParentId(0L); // 顶级分类父ID设为0
        }
        categoryMapper.insert(category);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteCategory(Category category) {
        categoryMapper.deleteById(category.getCategoryId());
    }

    @Override
    public List<Category> findCategoryList(Category category) {
        return categoryMapper.findCategoryList(category);
    }
}
