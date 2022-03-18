package org.oes.start.controller.course;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.oes.biz.entity.Course;
import org.oes.biz.entity.CourseChapter;
import org.oes.biz.entity.File;
import org.oes.biz.service.CourseChapterService;
import org.oes.biz.service.CourseFileService;
import org.oes.biz.service.CourseService;
import org.oes.biz.service.FileService;
import org.oes.common.constans.LogFileNames;
import org.oes.common.constans.OesConstant;
import org.oes.common.constans.URIs;
import org.oes.common.entity.OesHttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author XuJian
 * @since 2021/12/08
 */
@RestController
@RequestMapping(URIs.COURSE)
public class CourseController {

    private static final Logger logger = LoggerFactory.getLogger(LogFileNames.OES);

    @Resource
    private CourseService courseService;
    @Resource
    private CourseChapterService courseChapterService;
    @Resource
    private FileService fileService;
    @Resource
    private CourseFileService courseFileService;

    // 课程基础信息
    @RequestMapping(method = RequestMethod.GET)
    public OesHttpResponse viewCourse() {
        return OesHttpResponse.getSuccess();
    }

    @RequestMapping(method = RequestMethod.POST)
    @RequiresPermissions("course:add")
    public OesHttpResponse createCourse(@RequestBody Course course) { // 必要时可以加 @Valid 校验参数
        courseService.createCourse(course);
        return OesHttpResponse.getSuccess(course);
    }

    @RequestMapping(method = RequestMethod.PATCH)
    @RequiresPermissions("course:update")
    public OesHttpResponse updateCourse(@RequestBody Course course) { // 必要时可以加 @Valid 校验参数
        courseService.updateCourseById(course, false);
        return OesHttpResponse.getSuccess(course);
    }

    // 课程章节信息
    @RequestMapping(value = URIs.CHAPTER, method = RequestMethod.GET)
    public OesHttpResponse viewChapter() {
        return OesHttpResponse.getSuccess();
    }

    @RequestMapping(value = URIs.CHAPTER, method = RequestMethod.POST)
    @RequiresPermissions("course:update")
    public OesHttpResponse createChapter(@RequestBody CourseChapter courseChapter) { // 必要时可以加 @Valid 校验参数
        courseChapterService.addChapter(courseChapter);
        return OesHttpResponse.getSuccess(courseChapter);
    }

    @RequestMapping(value = URIs.CHAPTER, method = RequestMethod.PATCH)
    @RequiresPermissions("course:update")
    public OesHttpResponse updateChapter(@RequestBody CourseChapter courseChapter) { // 必要时可以加 @Valid 校验参数
        courseChapterService.updateChapterById(courseChapter, false);
        return OesHttpResponse.getSuccess(courseChapter);
    }

    // 课程文件信息
    @RequestMapping(value = URIs.FILE, method = RequestMethod.POST)
    @RequiresPermissions("course:update")
    public OesHttpResponse uploadVideo(@RequestParam("file") MultipartFile file, Long courseChapterId) {
        File f = new File();
        f.setFileName(file.getOriginalFilename());

        Long fileId = fileService.uploadFile(file, OesConstant.COURSE_BUCKET, f);
        courseFileService.addCourseFile(courseChapterId, fileId);
        return OesHttpResponse.getSuccess();
    }
}
