package org.oes.biz.service;

import org.oes.biz.entity.File;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {

    /**
     * 文件上传服务
     *
     * @param file 文件
     * @param bucket 存储桶
     * @param fileInfo 存储记录
     * @return file 文件信息
     */
    File uploadFile(MultipartFile file, String bucket, File fileInfo);

    List<File> findFileList(File file);

    List<File> findFileList(List<Long> fileIds);
}
