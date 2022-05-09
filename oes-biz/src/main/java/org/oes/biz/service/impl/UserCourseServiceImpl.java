package org.oes.biz.service.impl;

import org.oes.biz.entity.UserCourse;
import org.oes.biz.mapper.UserCourseMapper;
import org.oes.biz.service.UserCourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserCourseServiceImpl implements UserCourseService {

    @Resource
    private UserCourseMapper userCourseMapper;

    @Override
    public void joinCourse(UserCourse userCourse) {
        userCourseMapper.insert(userCourse);
    }

    @Override
    public List<UserCourse> getJoinCourse(Long userId) {
        return null;
    }
}
