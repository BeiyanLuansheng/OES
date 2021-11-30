package cn.edu.hit.oes.biz.mapper;

import cn.edu.hit.oes.biz.entity.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {

    int insert(@Param("course") Course course);

//    int delete(Course course);
//
//    int update(Course course);
//
//    List<Course> select(Course course);
//
//        <delete id="delete" parameterType="" >
//    </delete>
//    <update id="update" parameterType="" >
//    </update>
//    <select id="select" parameterType="" resultType="java.lang.Integer" >
//    </select>
}
