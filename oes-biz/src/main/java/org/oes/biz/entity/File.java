package org.oes.biz.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 文件实体类
 *
 * @author XuJian
 * @since 2022/03/09
 */
public class File implements Serializable {

    private static final long serialVersionUID = 2909106019603395506L;

    /**
     * 文件唯一 ID
     */
    private Long fileId;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 文件类型
     */
    private String fileType;

    /**
     * 文件链接
     */
    private String fileURL;

    /**
     * 文件信息创建时间
     */
    private Date gmtCreate;

    /**
     * 文件信息修改时间
     */
    private Date gmtModified;

    /**
     * 文件描述
     */
    private String description;

    /**
     * 用于传递查询条件
     */
    private Date gmtCreateFrom;
    private Date gmtCreateTo;
    private Date gmtModifiedFrom;
    private Date gmtModifiedTo;

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileURL() {
        return fileURL;
    }

    public void setFileURL(String fileURL) {
        this.fileURL = fileURL;
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
