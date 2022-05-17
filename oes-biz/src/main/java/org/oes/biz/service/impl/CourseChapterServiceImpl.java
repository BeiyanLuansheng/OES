package org.oes.biz.service.impl;

import org.oes.biz.entity.CourseChapter;
import org.oes.biz.mapper.CourseChapterMapper;
import org.oes.biz.service.CourseChapterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author XuJian
 * @since 2022/03/18
 */
@Service
public class CourseChapterServiceImpl implements CourseChapterService {

    @Resource
    private CourseChapterMapper courseChapterMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addChapter(CourseChapter courseChapter){
        courseChapterMapper.insert(courseChapter);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteChapter(CourseChapter courseChapter){
        courseChapterMapper.deleteById(courseChapter);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateChapterById(CourseChapter courseChapter, boolean fullUpdate){
        if (fullUpdate) {
            courseChapterMapper.updateById(courseChapter);
        } else {
            courseChapterMapper.fullUpdateById(courseChapter);
        }
    }

    @Override
    public List<CourseChapter> findCourseChapterList(Long courseId) {
        CourseChapter chapter = new CourseChapter();
        chapter.setCourseId(courseId);
        return courseChapterMapper.findCourseChapterList(chapter);
    }
}
