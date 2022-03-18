package org.oes.biz.mapper;

import org.apache.ibatis.annotations.Param;
import org.oes.biz.entity.File;

import java.util.List;

public interface FileMapper {

    /**
     * 新建章节
     *
     * @param file 章节信息
     * @return 影响行数
     */
    int insert(@Param("file") File file);

    /**
     * 查询章节
     *
     * @param file 查询条件
     * @return 章节列表
     */
    List<File> select(File file);
}
