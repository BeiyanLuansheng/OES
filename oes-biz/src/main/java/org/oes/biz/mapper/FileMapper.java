package org.oes.biz.mapper;

import org.apache.ibatis.annotations.Param;
import org.oes.biz.entity.File;

import java.util.List;

public interface FileMapper {

    /**
     * 新建文件
     *
     * @param file 文件信息
     * @return 影响行数
     */
    int insert(@Param("file") File file);

    /**
     * 查找文件
     *
     * @param file 查询条件
     * @return 文件列表
     */
    List<File> findFileList(@Param("file") File file);

    /**
     * 查找所有Id对应的文件
     * @param fileIds ID列表
     * @return 文件列表
     */
    List<File> findFileListById(List<Long> fileIds);
}
