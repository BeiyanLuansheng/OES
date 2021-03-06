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
import org.oes.common.constans.ShiroPerms;
import org.oes.common.constans.Strings;
import org.oes.common.constans.URIs;
import org.oes.common.entity.OesHttpResponse;
import org.oes.common.enums.FileTypeEnum;
import org.oes.common.exception.OesControllerException;
import org.oes.common.utils.Base64Utils;
import org.oes.common.utils.DateUtils;
import org.oes.common.utils.URLUtils;
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
import java.io.UnsupportedEncodingException;
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

    // ??????????????????
    @RequestMapping(method = RequestMethod.GET)
    public OesHttpResponse viewCourse(@RequestBody Course course) {
        Course courseInfo = courseService.getCourseInfo(course);
        return OesHttpResponse.getSuccess(courseInfo);
    }

    @RequestMapping(method = RequestMethod.POST)
    @RequiresPermissions(ShiroPerms.COURSE_ADD)
    public OesHttpResponse createCourse(@RequestBody Course course) { // ?????????????????? @Valid ????????????
        if (course.getTeacherId() == null) {
            course.setTeacherId(this.getCurrentUser().getUserId());
        }
        courseService.createCourse(course);
        return OesHttpResponse.getSuccess(course);
    }

    @RequestMapping(method = RequestMethod.PATCH)
    @RequiresPermissions(ShiroPerms.COURSE_UPDATE)
    public OesHttpResponse updateCourse(@RequestBody Course course) { // ?????????????????? @Valid ????????????
        courseService.updateCourseById(course, false);
        return OesHttpResponse.getSuccess(course);
    }

    // ??????????????????
    @RequestMapping(value = URIs.CHAPTER, method = RequestMethod.GET)
    public OesHttpResponse viewChapter(@RequestBody Course course) {
        List<CourseChapter> chapterList = courseChapterService.findCourseChapterList(course.getCourseId());
        return OesHttpResponse.getSuccess(chapterList);
    }

    @RequestMapping(value = URIs.CHAPTER, method = RequestMethod.POST)
    @RequiresPermissions(ShiroPerms.COURSE_UPDATE)
    public OesHttpResponse createChapter(@RequestBody CourseChapter courseChapter) { // ?????????????????? @Valid ????????????
        courseChapterService.addChapter(courseChapter);
        return OesHttpResponse.getSuccess(courseChapter);
    }

    @RequestMapping(value = URIs.CHAPTER, method = RequestMethod.PATCH)
    @RequiresPermissions(ShiroPerms.COURSE_UPDATE)
    public OesHttpResponse updateChapter(@RequestBody CourseChapter courseChapter) { // ?????????????????? @Valid ????????????
        courseChapterService.updateChapterById(courseChapter, false);
        return OesHttpResponse.getSuccess(courseChapter);
    }

    @RequestMapping(value = URIs.CHAPTER, method = RequestMethod.DELETE)
    @RequiresPermissions(ShiroPerms.COURSE_UPDATE)
    public OesHttpResponse deleteChapter(@RequestBody CourseChapter courseChapter) {
        courseChapterService.deleteChapter(courseChapter);
        return OesHttpResponse.getSuccess();
    }

    // ??????????????????
    @RequestMapping(value = URIs.FILE, method = RequestMethod.GET)
    public OesHttpResponse getChapterFileList(@RequestBody CourseChapter courseChapter) {
        List<File> files = courseFileService.findChapterFiles(courseChapter);
        return OesHttpResponse.getSuccess(files);
    }

    @RequestMapping(value = URIs.FILE, method = RequestMethod.DELETE)
    @RequiresPermissions(ShiroPerms.COURSE_UPDATE)
    public OesHttpResponse deleteChapterFile(@RequestBody CourseFile courseFile) {
        courseFileService.deleteFileOfCourse(courseFile);
        return OesHttpResponse.getSuccess();
    }

    @RequestMapping(value = URIs.FILE, method = RequestMethod.POST)
    @RequiresPermissions(ShiroPerms.COURSE_UPDATE)
    public OesHttpResponse uploadVideo(@RequestParam("file") MultipartFile file, Long courseChapterId,
                                       String description, String type, String fileName) {
        File f = new File();
        String time = DateUtils.getStringInFormat(new Date(), DateUtils.YYYY_MM_DD_HH_MM_SS);
        f.setFileName(fileName);
        try {
            String fileUrl = URLUtils.encode(Base64Utils.encode(time + Strings.UNDERLINE + fileName));
            f.setFileURL(courseChapterId + Strings.SLASH + fileUrl);
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
        } catch (UnsupportedEncodingException e) {
            throw new OesControllerException(e.getMessage());
        }
        return OesHttpResponse.getSuccess();
    }

    // ?????????????????????
    @RequestMapping(value = URIs.EXAM, method = RequestMethod.GET)
    public OesHttpResponse getExamOfChapter(@RequestBody Exam exam) {
        List<Exam> examList;
        if (exam.getCourseChapterId() != null) {
            examList = examService.getExamOfChapter(exam.getCourseChapterId());
        } else if (exam.getCourseId() != null) {
            examList = examService.getExamOfCourse(exam.getCourseId());
        } else {
            throw new OesControllerException("?????????????????????");
        }
        return OesHttpResponse.getSuccess(examList);
    }

    @RequestMapping(value = URIs.EXAM, method = RequestMethod.POST)
    @RequiresPermissions(ShiroPerms.COURSE_UPDATE)
    public OesHttpResponse addExamOfChapter(@RequestBody Exam exam) {
        examService.addExam(exam);
        return OesHttpResponse.getSuccess();
    }

    @RequestMapping(value = URIs.EXAM, method = RequestMethod.DELETE)
    @RequiresPermissions(ShiroPerms.COURSE_UPDATE)
    public OesHttpResponse removeExamOfChapter(@RequestBody Exam exam) {
        examService.deleteExam(exam);
        return OesHttpResponse.getSuccess();
    }

    @RequestMapping(value = URIs.EXAM, method = RequestMethod.PUT)
    @RequiresPermissions(ShiroPerms.COURSE_UPDATE)
    public OesHttpResponse updateExamOfChapter(@RequestBody Exam exam) {
        examService.fullUpdateExam(exam);
        return OesHttpResponse.getSuccess();
    }

    // ????????????
    @RequestMapping(value = URIs.NOTICE, method = RequestMethod.GET)
    public OesHttpResponse getNotice(@RequestBody Notice notice) {
        return OesHttpResponse.getSuccess();
    }

    @RequestMapping(value = URIs.NOTICE, method = RequestMethod.POST)
    @RequiresPermissions(ShiroPerms.COURSE_UPDATE)
    public OesHttpResponse addNotice(@RequestBody Notice notice) {
        return OesHttpResponse.getSuccess();
    }

    @RequestMapping(value = URIs.NOTICE, method = RequestMethod.PATCH)
    @RequiresPermissions(ShiroPerms.COURSE_UPDATE)
    public OesHttpResponse updateNotice(@RequestBody Notice notice) {
        return OesHttpResponse.getSuccess();
    }
}
