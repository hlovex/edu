package com.hlovex.oss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by hlovex on 2021/2/14 17:25
 */
public interface OssService {

    /**
     * 上传头像
     * @param file
     * @return
     */
    String uploadAvatar(MultipartFile file);
}
