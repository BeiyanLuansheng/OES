package org.oes.biz.service;

import org.oes.biz.entity.CourseChapter;

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

    void deleteChapter(CourseChapter courseChapter);

    void updateChapterById(CourseChapter courseChapter, boolean fullUpdate);
}
