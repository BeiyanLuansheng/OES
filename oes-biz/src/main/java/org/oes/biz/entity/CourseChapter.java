package org.oes.biz.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 课程章节实体类
 *
 * @author XuJian
 * @since 2022/03/09
 */
public class CourseChapter implements Serializable {

    private static final long serialVersionUID = -6351728355887806410L;

    /**
     * 记录唯一 ID
     */
    private Long courseChapterId;

    /**
     * 课程ID
     */
    private Long courseId;

    /**
     * 章节ID，用于排序
     */
    private Long chapterId;

    /**
     * 章节名
     */
    private Long chapterName;

    /**
     * 章节信息创建时间
     */
    private Date gmtCreate;

    /**
     * 章节信息修改时间
     */
    private Date gmtModified;

    /**
     * 用于传递查询条件
     */
    private Date gmtCreateFrom;
    private Date gmtCreateTo;
    private Date gmtModifiedFrom;
    private Date gmtModifiedTo;

    public Long getCourseChapterId() {
        return courseChapterId;
    }

    public void setCourseChapterId(Long courseChapterId) {
        this.courseChapterId = courseChapterId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getChapterId() {
        return chapterId;
    }

    public void setChapterId(Long chapterId) {
        this.chapterId = chapterId;
    }

    public Long getChapterName() {
        return chapterName;
    }

    public void setChapterName(Long chapterName) {
        this.chapterName = chapterName;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Date getGmtCreateFrom() {
        return gmtCreateFrom;
    }

    public void setGmtCreateFrom(Date gmtCreateFrom) {
        this.gmtCreateFrom = gmtCreateFrom;
    }

    public Date getGmtCreateTo() {
        return gmtCreateTo;
    }

    public void setGmtCreateTo(Date gmtCreateTo) {
        this.gmtCreateTo = gmtCreateTo;
    }

    public Date getGmtModifiedFrom() {
        return gmtModifiedFrom;
    }

    public void setGmtModifiedFrom(Date gmtModifiedFrom) {
        this.gmtModifiedFrom = gmtModifiedFrom;
    }

    public Date getGmtModifiedTo() {
        return gmtModifiedTo;
    }

    public void setGmtModifiedTo(Date gmtModifiedTo) {
        this.gmtModifiedTo = gmtModifiedTo;
    }
}
