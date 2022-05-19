package org.oes.biz.service.impl;

import org.oes.biz.entity.CourseChapter;
import org.oes.biz.entity.CourseFile;
import org.oes.biz.entity.File;
import org.oes.biz.mapper.CourseFileMapper;
import org.oes.biz.service.CourseFileService;
import org.oes.biz.service.FileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseFileServiceImpl implements CourseFileService {

    @Resource
    private CourseFileMapper courseFileMapper;
    @Resource
    private FileService fileService;

    @Override
    public void addCourseFile(Long courseChapterId, Long fileId) {
        CourseFile courseFile = new CourseFile();
        courseFile.setFileId(fileId);
        courseFile.setCourseChapterId(courseChapterId);
        courseFileMapper.insert(courseFile);
    }

    @Override
    public List<File> findChapterFiles(CourseChapter courseChapter) {
        CourseFile courseFile = new CourseFile();
        courseFile.setCourseChapterId(courseChapter.getCourseChapterId());
        List<CourseFile> courseFileList = courseFileMapper.findCourseFileList(courseFile);
        List<Long> fileIdList = courseFileList.stream().map(CourseFile::getFileId).collect(Collectors.toList());
        return fileService.findFileList(fileIdList);
    }

    @Override
    public void deleteFileOfCourse(CourseFile courseFile) {
        courseFileMapper.deleteByChapterIdAndFileId(courseFile);
    }
}
