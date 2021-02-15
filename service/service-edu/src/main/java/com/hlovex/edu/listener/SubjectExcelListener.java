package com.hlovex.edu.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hlovex.edu.entity.Subject;
import com.hlovex.edu.service.SubjectService;
import com.hlovex.edu.vo.excel.SubjectData;
import com.hlovex.servicebase.exception.ServiceException;

/**
 * Created by hlovex on 2021/2/15 15:13
 */
public class SubjectExcelListener extends AnalysisEventListener<SubjectData> {

    // 因为SubjectExcelListener不能交给spring进行管理，需要自己new，不能注入其他对象
    public SubjectService subjectService;

    public SubjectExcelListener() {
    }

    public SubjectExcelListener(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @Override
    public void invoke(SubjectData subjectData, AnalysisContext analysisContext) {
        if (subjectData == null) {
            throw new ServiceException(50000, "文件数据为空");
        }

        Subject existOneSubject = this.existOneSubject(subjectData.getOneSubjectName());
        if (existOneSubject == null) {
            existOneSubject = new Subject();
            existOneSubject.setParentId(0L);
            existOneSubject.setTitle(subjectData.getOneSubjectName());
            subjectService.save(existOneSubject);
        }

        Subject existTwoSubject = this.existTwoSubject(subjectData.getTwoSubjectName(), existOneSubject.getId());
        if (existTwoSubject == null) {
            existTwoSubject = new Subject();
            existTwoSubject.setParentId(existOneSubject.getId());
            existTwoSubject.setTitle(subjectData.getTwoSubjectName());
            subjectService.save(existTwoSubject);
        }
    }

    private Subject existOneSubject(String name) {
        return subjectService.getOne(new QueryWrapper<Subject>().lambda().eq(Subject::getTitle, name)
                .eq(Subject::getParentId, 0));
    }

    private Subject existTwoSubject(String name, Long parentId) {
        return subjectService.getOne(new QueryWrapper<Subject>().lambda().eq(Subject::getTitle, name)
                .eq(Subject::getParentId, parentId));
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
