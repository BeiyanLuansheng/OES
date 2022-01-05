package org.oes.biz.service;

import org.oes.biz.entity.Course;

/**
 * @author XuJian
 * @since 2021/11/30
 */
public interface CourseService {

    void createCourse(Course course);

    void deleteCourse(Course course);

    void updateCourseById(Course course, boolean fullUpdate);
}
