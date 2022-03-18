package org.oes.biz.service.impl;

import org.oes.biz.entity.CourseFile;
import org.oes.biz.mapper.CourseFileMapper;
import org.oes.biz.service.CourseFileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CourseFileServiceImpl implements CourseFileService {

    @Resource
    private CourseFileMapper courseFileMapper;

    @Override
    public void addCourseFile(Long courseChapterId, Long fileId) {
    CourseFile courseFile = new CourseFile();
        courseFile.setFileId(fileId);
        courseFile.setCourseChapterId(courseChapterId);
        courseFileMapper.insert(courseFile);
    }
}
