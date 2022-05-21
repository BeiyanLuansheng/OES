package org.oes.biz.service;

import org.oes.biz.entity.Exam;

import java.util.List;

/**
 * 习题服务
 */
public interface ExamService {

    void addExam(Exam exam);

    void deleteExam(Exam exam);

    void fullUpdateExam(Exam exam);

    List<Exam> getExamOfChapter(Long courseChapterId);

    List<Exam> getExamOfCourse(Long courseId);
}
