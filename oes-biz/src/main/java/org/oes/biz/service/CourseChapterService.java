package org.oes.biz.service;

import org.oes.biz.entity.CourseChapter;

import java.util.List;

/**
 * @author XuJian
 * @since 2022/03/18
 */
public interface CourseChapterService {

    /**
     * 新建章节
     *
     * @param courseChapter 章节信息
     */
    void addChapter(CourseChapter courseChapter);

    /**
     * 删除章节
     * @param courseChapter 条件
     */
    void deleteChapter(CourseChapter courseChapter);

    /**
     * 更新章节信息
     * @param courseChapter 更新信息
     * @param fullUpdate 全量更新/增量更新
     */
    void updateChapterById(CourseChapter courseChapter, boolean fullUpdate);

    /**
     * 查找课程章节信息
     * @param courseId 课程ID
     * @return 章节列表
     */
    List<CourseChapter> findCourseChapterList(Long courseId);
}
