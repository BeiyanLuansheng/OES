package org.oes.biz.service.impl;

import org.oes.biz.entity.Exam;
import org.oes.biz.mapper.ExamMapper;
import org.oes.biz.service.ExamService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

    @Resource
    private ExamMapper examMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addExam(Exam exam) {
        examMapper.insert(exam);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteExam(Exam exam) {
        examMapper.deleteById(exam);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void fullUpdateExam(Exam exam) {
        examMapper.fullUpdateById(exam);
    }

    @Override
    public List<Exam> getExamOfChapter(Long courseChapterId) {
        Exam exam = new Exam();
        exam.setCourseChapterId(courseChapterId);
        return examMapper.findExamList(exam);
    }

    @Override
    public List<Exam> getExamOfCourse(Long courseId) {
        Exam exam = new Exam();
        exam.setCourseId(courseId);
        return examMapper.findExamList(exam);
    }
}
