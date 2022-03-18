package org.oes.common.constans;

/**
 * 项目常量
 *
 * @author XuJian
 * @since 2021/12/14
 */
public interface OesConstant {

    /**
     * oes 线程池名称
     */
    String OES_THREAD_POOL = "OesThreadPool";

    /**
     * 手机验证码存储前缀
     */
    String VERIFICATION_PREFIX = "VERIFICATION_";

    /**
     * MinIO 的照片存储桶
     */
    String AVATARS_BUCKET = "avatars";
    /**
     * MinIO 的课程文件存储桶
     */
    String COURSE_BUCKET = "course";

    /* ===================== 配置常量 ================ */
    String ENABLE_REDIS_CACHE = "oes.enable-redis-cache";
}
