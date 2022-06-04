package org.oes.start.controller.user;

import org.oes.biz.config.OesBizConfig;
import org.oes.biz.entity.File;
import org.oes.biz.entity.User;
import org.oes.biz.service.FileService;
import org.oes.biz.service.UserService;
import org.oes.common.constans.OesConstant;
import org.oes.common.constans.Strings;
import org.oes.common.constans.URIs;
import org.oes.common.entity.OesHttpResponse;
import org.oes.common.enums.FileTypeEnum;
import org.oes.common.exception.OesControllerException;
import org.oes.common.utils.Base64Utils;
import org.oes.common.utils.DateUtils;
import org.oes.common.utils.MD5Utils;
import org.oes.common.utils.StringUtils;
import org.oes.start.controller.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
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

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;
    @Resource
    private FileService fileService;
    @Resource
    private OesBizConfig oesBizConfig;

    @RequestMapping(path = URIs.PASSWORD, method = RequestMethod.PUT)
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
        String fileName = Base64Utils.encode(time);
        File f = new File();
        f.setFileName(fileName);
        String fileURL = userId + Strings.SLASH + fileName;
        f.setFileURL(fileURL);
        f.setFileType(FileTypeEnum.PICTURE.getType());
        f.setUserId(Long.parseLong(userId));
        f = fileService.uploadFile(file, OesConstant.AVATARS_BUCKET, f);
        userService.updateAvatar(f.getUserId(), f.getFileURL());
        return OesHttpResponse.getSuccess().data(oesBizConfig.getMinioEndpoint() + f.getFileURL());
    }

    /**
     * 更新用户信息
     *
     * @param user 新用户信息
     */
    @RequestMapping(path = URIs.INFO, method = RequestMethod.POST)
    public OesHttpResponse updateInfo(@RequestBody User user) {
        user.setUserId(this.getCurrentUser().getUserId());
        userService.updateById(user);
        return OesHttpResponse.getSuccess();
    }

    /**
     * 获取用户个人信息
     */
    @RequestMapping(path = URIs.INFO, method = RequestMethod.GET)
    public  OesHttpResponse getInfo() {
        User info = userService.getById(this.getCurrentUser().getUserId());
        return OesHttpResponse.getSuccess(info);
    }
}
