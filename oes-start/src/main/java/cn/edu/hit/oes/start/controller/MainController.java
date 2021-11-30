package cn.edu.hit.oes.start.controller;

import cn.edu.hit.oes.biz.entity.Course;
import cn.edu.hit.oes.biz.service.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
public class MainController {

    @Resource
    CourseService courseService;

    @GetMapping("/test")
    public String getStr() {
        return "Test";
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
