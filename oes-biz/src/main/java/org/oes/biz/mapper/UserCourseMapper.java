package org.oes.biz.mapper;

import org.apache.ibatis.annotations.Param;
import org.oes.biz.entity.Course;
import org.oes.biz.entity.UserCourse;

import java.util.List;

public interface UserCourseMapper {

    int insert(@Param("userCourse") UserCourse userCourse);

    List<Course> findUserJoinedCourse(Long userId);
}
