package org.oes.start.config;

import org.oes.biz.config.OesBizConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * 由于 oes-biz 模块无法直接取到 oes-start 模块下的配置，
 * 所以这个类用于加载配置到其他模块中
 *
 * @author XuJian
 * @since 2022/01/04
 */
@Component
public class OesConfig {

    @Value("${spring.mail.username}")
    private String username;
    @Value("${oes.minio.endpoint}")
    private String minioEndpoint;

    @Resource
    private OesBizConfig oesBizConfig;

    @PostConstruct
    public void oesConfig() {
        oesBizConfig.setMailFrom(username);
        oesBizConfig.setMinioEndpoint(minioEndpoint);
    }
}
