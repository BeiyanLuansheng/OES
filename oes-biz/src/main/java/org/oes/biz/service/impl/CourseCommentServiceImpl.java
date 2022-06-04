package org.oes.biz.service.impl;

import org.oes.biz.entity.CourseComment;
import org.oes.biz.mapper.CourseCommentMapper;
import org.oes.biz.service.CourseCommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CourseCommentServiceImpl implements CourseCommentService {

    @Resource
    private CourseCommentMapper courseCommentMapper;

    @Override
    public void comment(CourseComment courseComment) {

    }

    @Override
    public List<CourseComment> getComment(Long courseId) {
        return null;
    }
}
