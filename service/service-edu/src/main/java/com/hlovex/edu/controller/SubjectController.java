package com.hlovex.edu.controller;


import com.hlovex.commonutils.R;
import com.hlovex.edu.convert.SubjectConvert;
import com.hlovex.edu.service.SubjectService;
import com.hlovex.edu.vo.SubjectVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author hlovex
 * @since 2021-02-15
 */
@RestController
@RequestMapping("/eduservice/subject")
@CrossOrigin
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private SubjectConvert subjectConvert;

    @PostMapping
    public R add(MultipartFile file) {
        subjectService.save(file);
        return R.ok();
    }

    @GetMapping("/tree")
    public R<List<SubjectVo>> getTree() {
        return R.ok(subjectConvert.subjectToSubjectVo(subjectService.getTree()));
    }

}

