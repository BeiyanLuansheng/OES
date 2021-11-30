package cn.edu.hit.oes.biz.service.impl;

import cn.edu.hit.oes.biz.entity.Course;
import cn.edu.hit.oes.biz.mapper.CourseMapper;
import cn.edu.hit.oes.biz.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CourseServiceImpl implements CourseService {

    @Resource
    private CourseMapper courseMapper;

    public int createCourse(Course course) {
        courseMapper.insert(course);
        return 1;
    }
}
