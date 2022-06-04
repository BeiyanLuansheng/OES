package org.oes.start.controller.course;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.oes.biz.entity.Course;
import org.oes.biz.entity.CourseChapter;
import org.oes.biz.entity.CourseFile;
import org.oes.biz.entity.Exam;
import org.oes.biz.entity.File;
import org.oes.biz.entity.Notice;
import org.oes.biz.service.CourseChapterService;
import org.oes.biz.service.CourseFileService;
import org.oes.biz.service.CourseService;
import org.oes.biz.service.ExamService;
import org.oes.biz.service.FileService;
import org.oes.common.constans.LogFileNames;
import org.oes.common.constans.OesConstant;
import org.oes.common.constans.Strings;
import org.oes.common.constans.URIs;
import org.oes.common.entity.OesHttpResponse;
import org.oes.common.enums.FileTypeEnum;
import org.oes.common.exception.OesControllerException;
import org.oes.common.utils.Base64Utils;
import org.oes.common.utils.DateUtils;
import org.oes.start.controller.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author XuJian
 * @since 2021/12/08
 */
@RestController
@RequestMapping(URIs.COURSE)
public class CourseController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(LogFileNames.OES);

    @Resource
    private CourseService courseService;
    @Resource
    private CourseChapterService courseChapterService;
    @Resource
    private FileService fileService;
    @Resource
    private CourseFileService courseFileService;
    @Resource
    private ExamService examService;

    // 课程基础信息
    @RequestMapping(method = RequestMethod.GET)
    public OesHttpResponse viewCourse(@RequestBody Course course) {
        Course courseInfo = courseService.getCourseInfo(course);
        return OesHttpResponse.getSuccess(courseInfo);
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
    public OesHttpResponse viewChapter(@RequestBody Course course) {
        List<CourseChapter> chapterList = courseChapterService.findCourseChapterList(course.getCourseId());
        return OesHttpResponse.getSuccess(chapterList);
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

    @RequestMapping(value = URIs.CHAPTER, method = RequestMethod.DELETE)
    @RequiresPermissions("course:delete")
    public OesHttpResponse deleteChapter(@RequestBody CourseChapter courseChapter) {
        courseChapterService.deleteChapter(courseChapter);
        return OesHttpResponse.getSuccess();
    }

    // 课程文件信息
    @RequestMapping(value = URIs.FILE, method = RequestMethod.GET)
    public OesHttpResponse getChapterFileList(@RequestBody CourseChapter courseChapter) {
        List<File> files = courseFileService.findChapterFiles(courseChapter);
        return OesHttpResponse.getSuccess(files);
    }

    @RequestMapping(value = URIs.FILE, method = RequestMethod.DELETE)
    @RequiresPermissions("course:delete")
    public OesHttpResponse deleteChapterFile(@RequestBody CourseFile courseFile) {
        courseFileService.deleteFileOfCourse(courseFile);
        return OesHttpResponse.getSuccess();
    }

    @RequestMapping(value = URIs.FILE, method = RequestMethod.POST)
    @RequiresPermissions("course:update")
    public OesHttpResponse uploadVideo(@RequestParam("file") MultipartFile file, Long courseChapterId,
                                       String description, String type) {
        File f = new File();
        String time = DateUtils.getStringInFormat(new Date(), DateUtils.YYYY_MM_DD_HH_MM_SS);
        String fileName = Base64Utils.encode(time + Strings.UNDERLINE + file.getOriginalFilename());
        f.setFileName(file.getOriginalFilename());
        f.setFileURL(courseChapterId + Strings.SLASH + fileName);
        f.setUserId(this.getCurrentUser().getUserId());
        f.setDescription(description);
        f.setGmtCreate(new Date());
        f.setGmtModified(new Date());

        if (FileTypeEnum.VIDEO.getType().equals(type) || FileTypeEnum.DOCUMENT.getType().equals(type)
                || FileTypeEnum.PICTURE.getType().equals(type)) {
            f.setFileType(type);
        } else {
            f.setFileType(FileTypeEnum.OTHER.getType());
        }

        f = fileService.uploadFile(file, OesConstant.COURSE_BUCKET, f);
        courseFileService.addCourseFile(courseChapterId, f.getFileId());
        return OesHttpResponse.getSuccess();
    }

    // 课程习题，题库
    @RequestMapping(value = URIs.EXAM, method = RequestMethod.GET)
    public OesHttpResponse getExamOfChapter(@RequestBody Exam exam) {
        List<Exam> examList;
        if (exam.getCourseChapterId() != null) {
            examList = examService.getExamOfChapter(exam.getCourseChapterId());
        } else if (exam.getCourseId() != null) {
            examList = examService.getExamOfCourse(exam.getCourseId());
        } else {
            throw new OesControllerException("习题参数不合法");
        }
        return OesHttpResponse.getSuccess(examList);
    }

    @RequestMapping(value = URIs.EXAM, method = RequestMethod.POST)
    public OesHttpResponse addExamOfChapter(@RequestBody Exam exam) {
        examService.addExam(exam);
        return OesHttpResponse.getSuccess();
    }

    @RequestMapping(value = URIs.EXAM, method = RequestMethod.DELETE)
    public OesHttpResponse removeExamOfChapter(@RequestBody Exam exam) {
        examService.deleteExam(exam);
        return OesHttpResponse.getSuccess();
    }

    @RequestMapping(value = URIs.EXAM, method = RequestMethod.PUT)
    public OesHttpResponse updateExamOfChapter(@RequestBody Exam exam) {
        examService.fullUpdateExam(exam);
        return OesHttpResponse.getSuccess();
    }

    // 课程公告
    @RequestMapping(value = URIs.NOTICE, method = RequestMethod.GET)
    public OesHttpResponse getNotice(@RequestBody Notice notice) {
        return OesHttpResponse.getSuccess();
    }

    @RequestMapping(value = URIs.NOTICE, method = RequestMethod.POST)
    public OesHttpResponse addNotice(@RequestBody Notice notice) {
        return OesHttpResponse.getSuccess();
    }
    @RequestMapping(value = URIs.NOTICE, method = RequestMethod.PATCH)
    public OesHttpResponse updateNotice(@RequestBody Notice notice) {
        return OesHttpResponse.getSuccess();
    }
}
