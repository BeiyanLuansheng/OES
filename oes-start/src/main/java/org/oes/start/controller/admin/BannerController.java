package org.oes.start.controller.admin;

import org.oes.biz.entity.Banner;
import org.oes.biz.service.BannerService;
import org.oes.common.constans.URIs;
import org.oes.common.entity.OesHttpResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = URIs.BANNER)
public class BannerController {

    @Resource
    private BannerService bannerService;

    @RequestMapping(method = RequestMethod.POST)
    public OesHttpResponse addBanner(@RequestBody Banner banner) {
        return OesHttpResponse.getSuccess();
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public OesHttpResponse deleteBanner(@RequestBody Banner banner) {
        return OesHttpResponse.getSuccess();
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public OesHttpResponse updateBanner(@RequestBody Banner banner) {
        return OesHttpResponse.getSuccess();
    }

    @RequestMapping(method = RequestMethod.GET)
    public OesHttpResponse getBanner() {
        return OesHttpResponse.getSuccess();
    }
}
