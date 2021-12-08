package org.oes.biz.entity;

import java.util.Date;

/**
 * @author XuJian
 * @since 2021/11/30
 */
public class Course {

    /**
     * 课程ID
     */
    private Long courseId;
    /**
     * 课程创建时间
     */
    private Date gmtCreate;
    /**
     * 课程修改时间
     */
    private Date gmtModified;
    /**
     * 课程分类 ID
     */
    private Long categoryId;
    /**
     * 开课教师 ID
     */
    private Long teacherId;
    /**
     * 开课时间
     */
    private Date gmtStart;
    /**
     * 结课时间
     */
    private Date gmtEnd;
    /**
     * 课程状态
     */
    private String status;
    /**
     * 是否免费
     */
    private String isFree;
    /**
     * 收费价格
     */
    private Long price;

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Date getGmtStart() {
        return gmtStart;
    }

    public void setGmtStart(Date gmtStart) {
        this.gmtStart = gmtStart;
    }

    public Date getGmtEnd() {
        return gmtEnd;
    }

    public void setGmtEnd(Date gmtEnd) {
        this.gmtEnd = gmtEnd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsFree() {
        return isFree;
    }

    public void setIsFree(String isFree) {
        this.isFree = isFree;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
