package org.oes.biz.mapper;

import org.apache.ibatis.annotations.Param;
import org.oes.biz.entity.Category;

import java.util.List;

public interface CategoryMapper {

    int insert(@Param("category") Category category);

    int deleteById(Long categoryId);

    List<Category> findCategoryList(@Param("category") Category category);
}
