package org.oes.gateway.controller;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.oes.biz.entity.Course;
import org.oes.biz.service.CourseService;
import org.oes.common.constans.LogFileNameConstant;
import org.oes.common.constans.URIConstant;
import org.oes.common.entity.OesHttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author XuJian
 * @since 2021/12/08
 */
@RestController
@RequestMapping(URIConstant.COURSE)
public class CourseController {

    private static final Logger logger = LoggerFactory.getLogger(LogFileNameConstant.OES);

    @Resource
    private CourseService courseService;

    @RequestMapping(path = "/view", method = RequestMethod.GET)
    public OesHttpResponse viewCourse() {
        return OesHttpResponse.getSuccess();
    }

    @RequestMapping(method = RequestMethod.POST)
//    @RequiresPermissions("course:add")
    public OesHttpResponse createCourse(@RequestBody Course course) { // 必要时可以加 @Valid 校验参数
        courseService.createCourse(course);
        return OesHttpResponse.getSuccess(course);
    }
}
