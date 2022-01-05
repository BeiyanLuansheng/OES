package org.oes.biz.service.impl;

import org.oes.biz.entity.Course;
import org.oes.biz.mapper.CourseMapper;
import org.oes.biz.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author XuJian
 * @since 2021/11/30
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Resource
    private CourseMapper courseMapper;

    @Override
    public void createCourse(Course course) {
        courseMapper.insert(course);
    }

    @Override
    public void deleteCourse(Course course) {
        courseMapper.deleteById(course);
    }

    @Override
    public void updateCourseById(Course course, boolean fullUpdate) {
        if (fullUpdate) {
            courseMapper.updateById(course);
        } else {
            courseMapper.fullUpdateById(course);
        }
    }
}
