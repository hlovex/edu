package com.hlovex.edu.convert;

import com.hlovex.edu.dto.CourseInfoDTO;
import com.hlovex.edu.entity.Course;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by hlovex on 2021/2/16 0:38
 */
@Mapper(componentModel = "spring")
@Component
public interface CourseConvert {
    Course courseInfoDTOToCourse(CourseInfoDTO dto);
}
