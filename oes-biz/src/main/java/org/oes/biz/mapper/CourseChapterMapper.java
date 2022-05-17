package org.oes.biz.mapper;

import org.apache.ibatis.annotations.Param;
import org.oes.biz.entity.CourseChapter;

import java.util.List;

public interface CourseChapterMapper {

    /**
     * 新建章节
     *
     * @param courseChapter 章节信息
     * @return 影响行数
     */
    int insert(@Param("courseChapter")CourseChapter courseChapter);

    /**
     * 删除
     * @param courseChapter 条件
     */
    void deleteById(CourseChapter courseChapter);

    /**
     * 更新
     * @param courseChapter 条件
     */
    void updateById(CourseChapter courseChapter);

    /**
     * 全量更新
     * @param courseChapter 条件
     */
    void fullUpdateById(CourseChapter courseChapter);

    /**
     * 查询章节
     *
     * @param courseChapter 查询条件
     * @return 章节列表
     */
    List<CourseChapter> findCourseChapterList(CourseChapter courseChapter);
}
