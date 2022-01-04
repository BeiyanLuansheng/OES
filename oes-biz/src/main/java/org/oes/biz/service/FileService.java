package org.oes.biz.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    /**
     *
     * @param file
     * @param fileName
     */
    void uploadFile(MultipartFile file, String fileName);
}
