package org.oes.biz.mapper;

import org.apache.ibatis.annotations.Param;
import org.oes.biz.entity.Exam;

import java.util.List;

public interface ExamMapper {

    int insert(@Param("exam")Exam exam);

    int deleteById(@Param("exam")Exam exam);

    int updateById(@Param("exam")Exam exam);

    int fullUpdateById(@Param("exam")Exam exam);

    List<Exam> findExamList(@Param("exam")Exam exam);
}
