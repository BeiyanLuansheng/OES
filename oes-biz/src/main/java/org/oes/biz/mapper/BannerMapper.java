package org.oes.biz.mapper;

import org.apache.ibatis.annotations.Param;
import org.oes.biz.entity.Banner;

import java.util.List;

public interface BannerMapper {

    int insert(@Param("banner") Banner banner);

    int deleteById(Long bannerId);

    int updateById(@Param("banner") Banner banner);

    List<Banner> findBannerList(@Param("banner") Banner banner);
}
