package org.oes.biz.mapper;

import org.apache.ibatis.annotations.Param;
import org.oes.biz.entity.CourseFile;

import java.util.List;

/**
 * @author XuJian
 * @since 2022/03/18
 */
public interface CourseFileMapper {

    /**
     * 新建关联
     * @param courseFile 信息
     * @return 影响行数
     */
    int insert(@Param("courseFile")CourseFile courseFile);

    /**
     * 删除
     * @param courseFile 条件
     * @return 影响行数
     */
    int deleteById(@Param("courseFile")CourseFile courseFile);

    /**
     * 增量更新
     * @param courseFile 条件
     * @return 影响行数
     */
    int updateById(@Param("courseFile")CourseFile courseFile);

    /**
     * 全量更新
     * @param courseFile 条件
     * @return 影响行数
     */
    int fullUpdateById(@Param("courseFile")CourseFile courseFile);

    /**
     * 查找
     * @param courseFile 条件
     * @return 对应信息
     */
    List<CourseFile> findCourseFileList(@Param("courseFile")CourseFile courseFile);
}
