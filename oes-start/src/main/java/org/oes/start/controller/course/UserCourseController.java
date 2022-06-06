package org.oes.start.controller.course;

import org.oes.biz.entity.CourseComment;
import org.oes.biz.entity.UserCourse;
import org.oes.biz.service.CourseCommentService;
import org.oes.biz.service.UserCourseService;
import org.oes.common.constans.URIs;
import org.oes.common.entity.OesHttpResponse;
import org.oes.start.controller.BaseController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author XuJian
 * @since 2022/03/21
 */
@RestController
@RequestMapping(URIs.COURSE)
public class UserCourseController extends BaseController {

    @Resource
    private UserCourseService userCourseService;
    @Resource
    private CourseCommentService courseCommentService;

    @RequestMapping(value = URIs.JOIN, method = RequestMethod.GET)
    public OesHttpResponse getJoinCourse() {
        return OesHttpResponse.getSuccess(userCourseService.getJoinCourse(this.getCurrentUser().getUserId()));
    }

    @RequestMapping(value = URIs.JOIN, method = RequestMethod.POST)
    public OesHttpResponse joinCourse(@RequestBody UserCourse userCourse) {
        userCourse.setUserId(this.getCurrentUser().getUserId());
        userCourseService.joinCourse(userCourse);
        return OesHttpResponse.getSuccess();
    }

    @RequestMapping(value = URIs.COMMENT, method = RequestMethod.GET)
    public OesHttpResponse getComment(Long courseId) {
        return OesHttpResponse.getSuccess(courseCommentService.getComment(courseId));
    }

    @RequestMapping(value = URIs.COMMENT, method = RequestMethod.POST)
    public OesHttpResponse commentCourse(@RequestBody CourseComment courseComment) {
        courseCommentService.comment(courseComment);
        return OesHttpResponse.getSuccess();
    }
}
