package com.hlovex.edu.controller;


import com.hlovex.commonutils.R;
import com.hlovex.edu.dto.CourseInfoDTO;
import com.hlovex.edu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author hlovex
 * @since 2021-02-16
 */
@RestController
@RequestMapping("/eduservice/course")
@CrossOrigin
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public R add(@RequestBody CourseInfoDTO courseInfoDTO) {
        courseService.saveCourseInfo(courseInfoDTO);
        return R.ok();
    }

}

