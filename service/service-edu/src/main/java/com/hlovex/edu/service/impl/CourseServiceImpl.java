package com.hlovex.edu.service.impl;

import com.hlovex.edu.convert.CourseConvert;
import com.hlovex.edu.dto.CourseInfoDTO;
import com.hlovex.edu.entity.Course;
import com.hlovex.edu.entity.CourseDescription;
import com.hlovex.edu.mapper.CourseMapper;
import com.hlovex.edu.service.CourseDescriptionService;
import com.hlovex.edu.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hlovex.servicebase.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author hlovex
 * @since 2021-02-16
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Autowired
    public CourseConvert courseConvert;

    @Autowired
    private CourseDescriptionService courseDescriptionService;

    @Override
    public void saveCourseInfo(CourseInfoDTO courseInfoDTO) {
        Course course = courseConvert.courseInfoDTOToCourse(courseInfoDTO);
        int insert = baseMapper.insert(course);
        if (insert == 0) {
            throw new ServiceException(50000, "添加失败");
        }

        CourseDescription description = new CourseDescription();
        description.setId(course.getId());
        description.setDescription(courseInfoDTO.getDescription());
        courseDescriptionService.save(description);
    }
}
