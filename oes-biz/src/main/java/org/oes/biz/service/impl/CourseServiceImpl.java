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

    public int createCourse(Course course) {
        return courseMapper.insert(course);
    }
}
