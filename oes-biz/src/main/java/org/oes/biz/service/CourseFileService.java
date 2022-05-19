package org.oes.biz.service;

import org.oes.biz.entity.CourseChapter;
import org.oes.biz.entity.CourseFile;
import org.oes.biz.entity.File;

import java.util.List;

public interface CourseFileService {

    void addCourseFile(Long courseChapterId, Long fileId);

    List<File> findChapterFiles(CourseChapter courseChapter);

    void deleteFileOfCourse(CourseFile courseFile);
}
