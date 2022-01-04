package org.oes.biz.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    /**
     * 文件上传服务
     *
     * @param file 文件
     * @param fileName 存储文件名（包含目录路径）
     * @param bucket 存储桶
     */
    void uploadFile(MultipartFile file, String fileName, String bucket);
}
