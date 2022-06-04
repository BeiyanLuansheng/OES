package org.oes.biz.service.impl;

import org.oes.biz.entity.Banner;
import org.oes.biz.mapper.BannerMapper;
import org.oes.biz.service.BannerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

    @Resource
    private BannerMapper bannerMapper;

    @Override
    public void createBanner(Banner banner) {

    }

    @Override
    public void deleteBannerById(Banner banner) {

    }

    @Override
    public void updateBannerById(Banner banner) {

    }

    @Override
    public List<Banner> getBanner(Banner banner) {
        return null;
    }
}
