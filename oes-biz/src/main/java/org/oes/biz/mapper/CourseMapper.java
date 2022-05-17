package org.oes.biz.mapper;

import org.oes.biz.entity.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author XuJian
 * @since 2021/11/30
 */
public interface CourseMapper {

    /**
     * 添加课程
     * @param course 课程信息
     * @return 行数1
     */
    int insert(@Param("course") Course course);

    /**
     * 删除课程
     * @param course 条件
     * @return 行数1
     */
    int deleteById(@Param("course") Course course);

    /**
     * 增量更新课程信息
     * @param course 条件
     * @return 行数1
     */
    int updateById(@Param("course") Course course);

    /**
     * 全量更新课程信息
     * @param course 条件
     * @return 行数1
     */
    int fullUpdateById(@Param("course") Course course);

    /**
     * 查找符合条件的课程
     * @param course 条件
     * @return 课程列表
     */
    List<Course> findCourseList(@Param("course") Course course);
}
