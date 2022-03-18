package org.oes.biz.service.impl;

import org.oes.biz.entity.CourseChapter;
import org.oes.biz.mapper.CourseChapterMapper;
import org.oes.biz.service.CourseChapterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author XuJian
 * @since 2022/03/18
 */
@Service
public class CourseChapterServiceImpl implements CourseChapterService {

    @Resource
    private CourseChapterMapper courseChapterMapper;

    @Override
    public void addChapter(CourseChapter courseChapter){
        courseChapterMapper.insert(courseChapter);
    }

    // TODO
    @Override
    public void deleteChapter(CourseChapter courseChapter){
    }

    //TODO
    @Override
    public void updateChapterById(CourseChapter courseChapter, boolean fullUpdate){
    }
}
