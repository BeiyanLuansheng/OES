package org.oes.biz.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author XuJian
 * @since 2021/11/30
 */
public class Course implements Serializable {

    private static final long serialVersionUID = 5411412654120570466L;

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
    /**
     * 课程名
     */
    private String courseName;
    /**
     * 课程简介
     */
    private String description;

    // 传递查询条件
    private Date gmtCreateFrom;
    private Date GmtCreateTo;
    private Date gmtModifiedFrom;
    private Date gmtModifiedTo;
    private Date gmtStartFrom;
    private Date gmtStartTo;
    private Date gmtEndFrom;
    private Date gmtEndTo;
    private Long priceFrom;
    private Long priceTo;

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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getGmtCreateFrom() {
        return gmtCreateFrom;
    }

    public void setGmtCreateFrom(Date gmtCreateFrom) {
        this.gmtCreateFrom = gmtCreateFrom;
    }

    public Date getGmtCreateTo() {
        return GmtCreateTo;
    }

    public void setGmtCreateTo(Date gmtCreateTo) {
        GmtCreateTo = gmtCreateTo;
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

    public Date getGmtStartFrom() {
        return gmtStartFrom;
    }

    public void setGmtStartFrom(Date gmtStartFrom) {
        this.gmtStartFrom = gmtStartFrom;
    }

    public Date getGmtStartTo() {
        return gmtStartTo;
    }

    public void setGmtStartTo(Date gmtStartTo) {
        this.gmtStartTo = gmtStartTo;
    }

    public Date getGmtEndFrom() {
        return gmtEndFrom;
    }

    public void setGmtEndFrom(Date gmtEndFrom) {
        this.gmtEndFrom = gmtEndFrom;
    }

    public Date getGmtEndTo() {
        return gmtEndTo;
    }

    public void setGmtEndTo(Date gmtEndTo) {
        this.gmtEndTo = gmtEndTo;
    }

    public Long getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(Long priceFrom) {
        this.priceFrom = priceFrom;
    }

    public Long getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(Long priceTo) {
        this.priceTo = priceTo;
    }
}
