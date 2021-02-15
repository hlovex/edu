package com.hlovex.oss.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by hlovex on 2021/2/14 17:16
 */
@Component
public class ConstantPropertiesUtil implements InitializingBean {

    // 读取配置文件内容
    @Value("${oss.file.endpoint}")
    private String endpoint;

    @Value("${oss.file.accessKey}")
    private String accessKey;

    @Value("${oss.file.secretKey}")
    private String secretKey;

    @Value("${oss.file.bucketName}")
    private String bucketName;

    // 定义一些公开的静态常量
    public static String END_POINT;
    public static String ACCESS_KEY;
    public static String SECRET_KEY;
    public static String BUCKET_NAME;

    /**
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() {
        END_POINT = endpoint;
        ACCESS_KEY = accessKey;
        SECRET_KEY = secretKey;
        BUCKET_NAME = bucketName;
    }
}
