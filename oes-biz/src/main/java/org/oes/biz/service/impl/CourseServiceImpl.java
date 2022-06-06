package org.oes.biz.service.impl;

import org.oes.biz.entity.Course;
import org.oes.biz.mapper.CourseMapper;
import org.oes.biz.service.CourseService;
import org.oes.common.exception.OesServiceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author XuJian
 * @since 2021/11/30
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Resource
    private CourseMapper courseMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createCourse(Course course) {
        course.setGmtCreate(new Date());
        course.setGmtModified(new Date());
        courseMapper.insert(course);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteCourse(Course course) {
        courseMapper.deleteById(course);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateCourseById(Course course, boolean fullUpdate) {
        course.setGmtModified(new Date());
        if (fullUpdate) {
            courseMapper.updateById(course);
        } else {
            courseMapper.fullUpdateById(course);
        }
    }

    @Override
    public Course getCourseInfo(Course course) {
        List<Course> courseList = courseMapper.findCourseList(course);
        if (courseList != null && courseList.get(0) != null) {
            return courseList.get(0);
        }
        throw new OesServiceException("未找到相关课程信息");
    }
}
