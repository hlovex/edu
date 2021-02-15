package com.hlovex.edu.service;

import com.hlovex.edu.entity.Subject;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author hlovex
 * @since 2021-02-15
 */
public interface SubjectService extends IService<Subject> {

    void save(MultipartFile file);

    List<Subject> getTree();
}
