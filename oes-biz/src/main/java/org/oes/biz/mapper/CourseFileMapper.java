package org.oes.biz.mapper;

import org.apache.ibatis.annotations.Param;
import org.oes.biz.entity.CourseChapter;
import org.oes.biz.entity.CourseFile;

import java.util.List;

/**
 * @author XuJian
 * @since 2022/03/18
 */
public interface CourseFileMapper {

    int insert(@Param("courseFile")CourseFile courseFile);

    List<CourseFile> select(CourseChapter courseChapter);
}
