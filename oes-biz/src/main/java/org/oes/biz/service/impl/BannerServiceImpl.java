package org.oes.biz.service.impl;

import org.oes.biz.entity.Banner;
import org.oes.biz.mapper.BannerMapper;
import org.oes.biz.service.BannerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

    @Resource
    private BannerMapper bannerMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createBanner(Banner banner) {
        bannerMapper.insert(banner);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBannerById(Banner banner) {
        bannerMapper.deleteById(banner.getBannerId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateBannerById(Banner banner) {
        bannerMapper.updateById(banner);
    }

    @Override
    public List<Banner> getBannerList() {
        return bannerMapper.findBannerList(new Banner());
    }
}
