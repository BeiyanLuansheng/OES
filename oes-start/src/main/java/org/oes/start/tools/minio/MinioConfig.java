package org.oes.start.tools.minio;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import org.oes.common.constans.OesConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Shiro 配置类
 *
 * @author XuJian
 * @since 2022/01/03
 */
@Configuration(proxyBeanMethods = false)
public class MinioConfig {

    private static final Logger logger = LoggerFactory.getLogger(MinioConfig.class);

    @Value("${oes.minio.endpoint}")
    private String endpoint;
    @Value("${oes.minio.root-user}")
    private String accessKey;
    @Value("${oes.minio.root-password}")
    private String secretKey;

    @Bean
    public MinioClient minioClient() {
        try {
            MinioClient minioClient =  MinioClient.builder().endpoint(endpoint).credentials(accessKey, secretKey).build();
            boolean isExist = minioClient.bucketExists(BucketExistsArgs.builder().bucket(OesConstant.AVATARS_BUCKET).build());
            if(isExist) {
                logger.info("avatar 桶已存在，跳过创建");
            } else {
                // 创建一个名为avatars的存储桶，用于存储照片文件
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(OesConstant.AVATARS_BUCKET).build());
            }
            return  minioClient;
        } catch (Exception e) {
            logger.error("创建 MinioClient 失败", e);
            return null;
        }
    }

}
