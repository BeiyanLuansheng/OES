package org.oes.gateway.controller;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.oes.biz.entity.Course;
import org.oes.biz.service.CourseService;
import org.oes.common.constans.LogFileNameConstant;
import org.oes.common.entity.OesHttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author XuJian
 * @since 2021/12/08
 */
@RestController
public class CourseController {

    private static final Logger logger = LoggerFactory.getLogger(LogFileNameConstant.OES);

    @Resource
    private CourseService courseService;

//    @RequiresPermissions("course:add")
    public OesHttpResponse addCourse(Course course) { // 必要时可以加 @Valid 校验参数
        this.courseService.createCourse(course);
        return OesHttpResponse.getSuccess();
    }

    @GetMapping("/course/create")
    public Course createCourse() {
        Course course = new Course();
        course.setGmtCreate(new Date());
        course.setCategoryId(0L);
        course.setGmtModified(new Date());
        course.setGmtStart(new Date());
        course.setGmtEnd(new Date());
        course.setIsFree("Y");
        course.setTeacherId(0L);
        course.setStatus("1");
        courseService.createCourse(course);
        return course;
    }

    @GetMapping("/log")
    public String log() {
        logger.error("Test logger in CourseController");
        return "log success";
    }

}
