package org.oes.biz.entity;

import java.io.Serializable;

/**
 * 课程文件实体类
 *
 * @author XuJian
 * @since 2022/03/09
 */
public class CourseFile implements Serializable {

    private static final long serialVersionUID = -5290740524158790441L;

    /**
     * 课程视频ID
     */
    private Long courseFileId;

    /**
     * 章节记录唯一 ID
     */
    private Long courseChapterId;

    /**
     * 文件唯一 ID
     */
    private Long fileId;

    public Long getCourseFileId() {
        return courseFileId;
    }

    public void setCourseFileId(Long courseFileId) {
        this.courseFileId = courseFileId;
    }

    public Long getCourseChapterId() {
        return courseChapterId;
    }

    public void setCourseChapterId(Long courseChapterId) {
        this.courseChapterId = courseChapterId;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }
}
