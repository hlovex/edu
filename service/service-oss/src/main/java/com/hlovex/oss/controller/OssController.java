package com.hlovex.oss.controller;

import com.hlovex.commonutils.R;
import com.hlovex.oss.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by hlovex on 2021/2/14 17:24
 */
@RestController
@RequestMapping("/eduoss")
@CrossOrigin
public class OssController {

    @Autowired
    private OssService ossService;

    @PostMapping("/upload/avatar")
    public R<String> upload(MultipartFile file) {
        String url = ossService.uploadAvatar(file);
        return R.ok(url);
    }
}
