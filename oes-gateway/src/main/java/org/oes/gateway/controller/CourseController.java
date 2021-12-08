package org.oes.gateway.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.oes.biz.entity.Course;
import org.oes.biz.service.CourseService;
import org.oes.common.entity.OesResponse;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author XuJian
 * @since 2021/12/08
 */
@RestController
public class CourseController {

    @Resource
    private CourseService courseService;

    @RequiresPermissions("course:add")
    public OesResponse addCourse(Course course) { // 必要时可以加 @Valid 校验参数
        this.courseService.createCourse(course);
        return new OesResponse().success();
    }

}
