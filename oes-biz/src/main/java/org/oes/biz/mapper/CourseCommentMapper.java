package org.oes.biz.mapper;

import org.apache.ibatis.annotations.Param;
import org.oes.biz.entity.CourseComment;

import java.util.List;

public interface CourseCommentMapper {

    /**
     * 新建评论
     *
     * @param courseComment 评论信息
     * @return 影响行数
     */
    int insert(@Param("courseComment") CourseComment courseComment);

    /**
     * 查询评论
     *
     * @param courseComment 查询条件
     * @return 评论列表
     */
    List<CourseComment> select(CourseComment courseComment);
}
