package org.oes.biz.config;

import org.springframework.stereotype.Component;

@Component
public class OesBizConfig {

    /**
     * 邮件发件邮箱
     */
    private String mailFrom;

    /**
     * Minio 服务器
     */
    private String minioEndpoint;

    public String getMailFrom() {
        return mailFrom;
    }

    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom;
    }

    public String getMinioEndpoint() {
        return minioEndpoint;
    }

    public void setMinioEndpoint(String minioEndpoint) {
        this.minioEndpoint = minioEndpoint;
    }
}
