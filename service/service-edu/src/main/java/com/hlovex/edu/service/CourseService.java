package com.hlovex.edu.service;

import com.hlovex.edu.dto.CourseInfoDTO;
import com.hlovex.edu.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author hlovex
 * @since 2021-02-16
 */
public interface CourseService extends IService<Course> {

    void saveCourseInfo(CourseInfoDTO courseInfoDTO);
}
