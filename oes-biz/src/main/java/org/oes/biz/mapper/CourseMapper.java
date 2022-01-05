package org.oes.biz.mapper;

import org.oes.biz.entity.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author XuJian
 * @since 2021/11/30
 */
public interface CourseMapper {

    int insert(@Param("course") Course course);

    int deleteById(@Param("course") Course course);

    int updateById(@Param("course") Course course);

    int fullUpdateById(@Param("course") Course course);

    List<Course> select(Course course);
}
