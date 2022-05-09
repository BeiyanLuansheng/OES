package org.oes.biz.entity;


import java.io.Serializable;
import java.util.Date;

public class CourseComment implements Serializable {

    private static final long serialVersionUID = 8247470022772224812L;

    /**
     * 评论ID
     */
    private Long commentId;

    /**
     * 回复评论 ID
     */
    private Long referenceId;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论课程ID
     */
    private Long courseId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 评论创建时间
     */
    private Date gmtCreate;

    /**
     * 评论修改时间
     */
    private Date gmtModified;

    /**
     * 用于传递查询条件
     */
    private Date gmtCreateFrom;
    private Date gmtCreateTo;
    private Date gmtModifiedFrom;
    private Date gmtModifiedTo;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Long referenceId) {
        this.referenceId = referenceId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
