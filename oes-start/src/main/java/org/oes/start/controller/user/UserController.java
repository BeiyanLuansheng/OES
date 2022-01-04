package org.oes.start.controller.user;

import org.oes.biz.config.OesBizConfig;
import org.oes.biz.entity.User;
import org.oes.biz.service.FileService;
import org.oes.biz.service.UserService;
import org.oes.common.constans.OesConstant;
import org.oes.common.constans.Strings;
import org.oes.common.constans.URIs;
import org.oes.common.entity.OesHttpResponse;
import org.oes.common.utils.Base64Utils;
import org.oes.common.utils.DateUtils;
import org.oes.common.utils.MD5Utils;
import org.oes.common.utils.StringUtils;
import org.oes.start.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 用户控制
 *
 * @author XuJian
 * @since 2021/12/09
 */
@RestController
@RequestMapping(URIs.USER)
public class UserController extends BaseController {

    @Resource
    private UserService userService;
    @Resource
    private FileService fileService;
    @Resource
    private OesBizConfig oesBizConfig;

    @RequestMapping(path = "password", method = RequestMethod.PUT)
    public OesHttpResponse updatePassword(@RequestParam("oldPwd") String oldPwd,
                                          @RequestParam("newPwd") String newPwd,
                                          HttpServletRequest request) {
        User user = getCurrentUser();
        if (StringUtils.isNotEquals(MD5Utils.encrypt(user.getPhone(), oldPwd), user.getPassword())) {
            return OesHttpResponse.getFailure("原密码不正确");
        }
        userService.updatePassword(user.getPhone(), newPwd);
        return OesHttpResponse.getSuccess();
    }

    /**
     * 按照 用户ID/date 的形式组成文件名
     * 文件名用 Base64 编码
     *
     * @param file 头像文件
     * @return 头像链接
     */
    @RequestMapping(path = URIs.AVATAR, method = RequestMethod.POST)
    public OesHttpResponse updateAvatar(MultipartFile file) {
        String userId = this.getCurrentUser().getId();
        String time = DateUtils.getStringInFormat(new Date(), DateUtils.YYYY_MM_DD_HH_MM_SS);
        String fileName = userId + Strings.SLASH + Base64Utils.encode(time);
        fileService.uploadFile(file, fileName, OesConstant.AVATARS_BUCKET);
        String avatar = OesConstant.AVATARS_BUCKET + Strings.SLASH + fileName;
        userService.updateAvatar(this.getCurrentUser().getEmail(), avatar);
        return OesHttpResponse.getSuccess().data(oesBizConfig.getMinioEndpoint() + Strings.SLASH + avatar);
    }
}
