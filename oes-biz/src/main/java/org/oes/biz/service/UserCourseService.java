package org.oes.biz.service;

import org.oes.biz.entity.UserCourse;

import java.util.List;

public interface UserCourseService {

    void joinCourse(UserCourse userCourse);

    List<UserCourse> getJoinCourse(Long userId);
}
