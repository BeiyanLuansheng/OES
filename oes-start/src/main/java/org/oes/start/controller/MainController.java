package org.oes.start.controller;

import org.oes.biz.entity.Course;
import org.oes.biz.service.CourseService;
import org.oes.common.constans.LogFileNameConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(LogFileNameConstant.OES);
    private static final Logger LOG = LoggerFactory.getLogger(MainController.class);

    @Resource
    CourseService courseService;

    @GetMapping("/log")
    public String log() {
        logger.error("Test logger in MainController");
        LOG.error("TEST MainController LOG");
        return "log success";
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
}
