package org.oes.biz.service;

import org.oes.biz.entity.File;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    /**
     * 文件上传服务
     *
     * @param file 文件
     * @param bucket 存储桶
     * @param fileInfo 存储记录
     * @return fileId
     */
    Long uploadFile(MultipartFile file, String bucket, File fileInfo);
}
