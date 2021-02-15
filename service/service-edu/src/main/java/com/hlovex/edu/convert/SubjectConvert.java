package com.hlovex.edu.convert;

import com.hlovex.edu.entity.Subject;
import com.hlovex.edu.vo.SubjectVo;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by hlovex on 2021/2/15 23:28
 */
@Component
@Mapper(componentModel = "spring")
public interface SubjectConvert {
    List<SubjectVo> subjectToSubjectVo(List<Subject> subjectList);
}
