package org.oes.start.controller.admin;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.oes.biz.entity.Banner;
import org.oes.biz.entity.File;
import org.oes.biz.service.BannerService;
import org.oes.biz.service.FileService;
import org.oes.common.constans.OesConstant;
import org.oes.common.constans.ShiroPerms;
import org.oes.common.constans.Strings;
import org.oes.common.constans.URIs;
import org.oes.common.entity.OesHttpResponse;
import org.oes.common.enums.FileTypeEnum;
import org.oes.common.utils.Base64Utils;
import org.oes.common.utils.DateUtils;
import org.oes.start.controller.BaseController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping(value = URIs.BANNER)
public class BannerController extends BaseController {

    @Resource
    private BannerService bannerService;
    @Resource
    private FileService fileService;

    @RequestMapping(method = RequestMethod.PUT)
    @RequiresPermissions(ShiroPerms.BANNER_ADD)
    public OesHttpResponse uploadBannerPicture(MultipartFile file) {
        String userId = this.getCurrentUser().getId();
        String time = DateUtils.getStringInFormat(new Date(), DateUtils.YYYY_MM_DD_HH_MM_SS);
        String fileName = Base64Utils.encode(time);
        File f = new File();
        f.setFileName(fileName);
        String fileURL = "banner" + Strings.SLASH + fileName;
        f.setFileURL(fileURL);
        f.setFileType(FileTypeEnum.PICTURE.getType());
        f.setUserId(Long.parseLong(userId));
        f = fileService.uploadFile(file, OesConstant.COURSE_BUCKET, f);
        return OesHttpResponse.getSuccess(f.getFileURL());
    }

    @RequestMapping(method = RequestMethod.POST)
    @RequiresPermissions(ShiroPerms.BANNER_ADD)
    public OesHttpResponse addBanner(@RequestBody Banner banner) {
        bannerService.createBanner(banner);
        return OesHttpResponse.getSuccess();
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @RequiresPermissions(ShiroPerms.BANNER_DEL)
    public OesHttpResponse deleteBanner(@RequestBody Banner banner) {
        bannerService.deleteBannerById(banner);
        return OesHttpResponse.getSuccess();
    }

    @RequestMapping(method = RequestMethod.PATCH)
    @RequiresPermissions(ShiroPerms.BANNER_UPDATE)
    public OesHttpResponse updateBanner(@RequestBody Banner banner) {
        bannerService.updateBannerById(banner);
        return OesHttpResponse.getSuccess();
    }

    @RequestMapping(method = RequestMethod.GET)
    public OesHttpResponse getBanner() {
        return OesHttpResponse.getSuccess(bannerService.getBannerList());
    }
}
