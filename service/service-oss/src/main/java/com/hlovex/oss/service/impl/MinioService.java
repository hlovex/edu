package com.hlovex.oss.service.impl;

import cn.hutool.core.util.IdUtil;
import com.hlovex.oss.service.OssService;
import com.hlovex.oss.utils.ConstantPropertiesUtil;
import com.hlovex.servicebase.exception.ServiceException;
import io.minio.*;
import io.minio.http.Method;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.TimeUnit;

/**
 * Created by hlovex on 2021/2/14 17:25
 */
@Slf4j
@Service
public class MinioService implements OssService {

    @Override
    public String uploadAvatar(MultipartFile file) {
        String filePath = IdUtil.simpleUUID() + "/" + file.getOriginalFilename();

        String endpoint = ConstantPropertiesUtil.END_POINT;
        String accessKey = ConstantPropertiesUtil.ACCESS_KEY;
        String secretKey = ConstantPropertiesUtil.SECRET_KEY;
        String bucketName = ConstantPropertiesUtil.BUCKET_NAME;

        try {
            MinioClient minioClient =
                    MinioClient.builder()
                            .endpoint(endpoint)
                            .credentials(accessKey, secretKey)
                            .build();
            boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
            if (!found) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
            }
            minioClient.putObject(PutObjectArgs.builder()
                    .bucket(bucketName)
                    .object(filePath)
                    .stream(file.getInputStream(), file.getSize(), ObjectWriteArgs.MIN_MULTIPART_SIZE)
                    .build());
            return getPresignedObjectUrl(endpoint, accessKey, secretKey, bucketName, filePath);
        } catch (Exception e) {
            log.error("文件上传失败，原因：", e);
            throw new ServiceException(50000, "文件上传失败");
        }
    }

    String getPresignedObjectUrl(String endpoint, String accessKey, String secretKey, String bucketName, String objectName) {
        try {
            MinioClient minioClient =
                    MinioClient.builder()
                            .endpoint(endpoint)
                            .credentials(accessKey, secretKey)
                            .build();
            return minioClient.getPresignedObjectUrl(
                    GetPresignedObjectUrlArgs.builder()
                            .method(Method.GET)
                            .bucket(bucketName)
                            .object(objectName)
                            .expiry(2, TimeUnit.DAYS)
                            .build());
        } catch (Exception e) {
            log.error("获取文件地址失败，原因：", e);
            throw new ServiceException(50000, "获取文件地址失败");
        }
    }
}
