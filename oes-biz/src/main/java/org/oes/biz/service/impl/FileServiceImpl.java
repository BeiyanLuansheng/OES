package org.oes.biz.service.impl;

import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import org.oes.biz.entity.File;
import org.oes.biz.mapper.FileMapper;
import org.oes.biz.service.FileService;
import org.oes.common.exception.OesServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Service
public class FileServiceImpl implements FileService {

    private static final Logger logger = LoggerFactory.getLogger(FileService.class);

    @Resource
    private MinioClient minioClient;
    @Resource
    private FileMapper fileMapper;

    @Override
    public Long uploadFile(MultipartFile file, String bucket, File fileInfo) {
        save(file, fileInfo.getFileURL(), bucket);
        fileMapper.insert(fileInfo);
        // TODO fileId
        return null;
    }

    private void save(MultipartFile file, String fileName, String bucket) {
        try {
            minioClient.putObject(
                    PutObjectArgs.builder().bucket(bucket)
                            .object(fileName)
                            .stream(file.getInputStream(), file.getSize(), -1)
                            .contentType(file.getContentType())
                            .build());
        } catch (Exception e) {
            logger.error("上传失败", e);
            throw new OesServiceException("文件上传失败，请尝试重新上传！");
        }
    }
}
