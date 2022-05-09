package org.oes.biz.service;

import org.oes.biz.entity.CourseComment;

import java.util.List;

public interface CourseCommentService {

    void comment(CourseComment courseComment);

    List<CourseComment> getComment(Long courseId);
}
