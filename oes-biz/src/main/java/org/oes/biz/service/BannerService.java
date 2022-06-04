package org.oes.biz.service;

import org.oes.biz.entity.Banner;

import java.util.List;

public interface BannerService {

    void createBanner(Banner banner);

    void deleteBannerById(Banner banner);

    void updateBannerById(Banner banner);

    List<Banner> getBanner(Banner banner);
}
