package org.oes.biz.service.impl;

import org.oes.biz.entity.Course;
import org.oes.biz.entity.UserCourse;
import org.oes.biz.mapper.UserCourseMapper;
import org.oes.biz.service.CourseService;
import org.oes.biz.service.OrderService;
import org.oes.biz.service.UserCourseService;
import org.oes.common.exception.OesServiceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserCourseServiceImpl implements UserCourseService {

    @Resource
    private UserCourseMapper userCourseMapper;
    @Resource
    private CourseService courseService;
    @Resource
    private OrderService orderService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void joinCourse(UserCourse userCourse) {
        Course course = new Course();
        course.setCourseId(userCourse.getCourseId());
        course = courseService.getCourseInfo(course);
        if ("Y".equals(course.getIsFree()) ||
                orderService.isPurchase(userCourse.getUserId(), userCourse.getCourseId())) {
            userCourseMapper.insert(userCourse);
        } else {
            throw new OesServiceException("请先购买课程！");
        }
    }

    @Override
    public List<Course> getJoinCourse(Long userId) {
        return userCourseMapper.findUserJoinedCourse(userId);
    }
}
