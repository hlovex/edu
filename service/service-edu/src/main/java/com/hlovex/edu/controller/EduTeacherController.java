package com.hlovex.edu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hlovex.commonutils.R;
import com.hlovex.commonutils.dto.PageInfo;
import com.hlovex.edu.entity.EduTeacher;
import com.hlovex.edu.service.EduTeacherService;
import com.hlovex.edu.vo.TeacherQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author hlovex
 * @since 2021-02-12
 */
@Api(tags = "讲师管理")
@RestController
@RequestMapping("/eduservice/teacher")
@CrossOrigin
public class EduTeacherController {

    @Resource
    private EduTeacherService eduTeacherService;

    @ApiOperation("所有列表")
    @GetMapping("/findAll")
    public R<List<EduTeacher>> findAll() {
        return R.ok(eduTeacherService.list(null));
    }

    @ApiOperation("逻辑删除")
    @DeleteMapping("/{id}")
    public R<Boolean> remove(@ApiParam(name = "id", value = "讲师id", required = true) @PathVariable Long id) {
        return R.ok(eduTeacherService.removeById(id));
    }

    @ApiOperation("分页查询")
    @GetMapping("/page/{current}/{size}")
    public R<PageInfo<EduTeacher>> page(@ApiParam(name = "current", value = "当前页", required = true) @PathVariable Integer current
            , @ApiParam(name = "size", value = "每页记录数", required = true) @PathVariable Integer size) {
        Page<EduTeacher> pageTeacher = new Page<>(current, size);
        eduTeacherService.page(pageTeacher, null);

        PageInfo<EduTeacher> pageInfo = new PageInfo<>(pageTeacher.getTotal(), pageTeacher.getRecords());
        return R.ok(pageInfo);
    }

    @ApiOperation("根据条件，分页查询")
    @GetMapping("/page/condition/{current}/{size}")
    public R<PageInfo<EduTeacher>> pageCondition(@ApiParam(name = "current", value = "当前页", required = true) @PathVariable Integer current
            , @ApiParam(name = "size", value = "每页记录数", required = true) @PathVariable Integer size
            , TeacherQuery teacherQuery) {
        Page<EduTeacher> pageTeacher = new Page<>(current, size);
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        wrapper.lambda().like(StringUtils.isNotBlank(teacherQuery.getName()), EduTeacher::getName, teacherQuery.getName())
                .eq(Objects.nonNull(teacherQuery.getLevel()), EduTeacher::getLevel, teacherQuery.getLevel())
                .ge(StringUtils.isNotBlank(teacherQuery.getBegin()), EduTeacher::getGmtCreate, teacherQuery.getBegin())
                .le(StringUtils.isNotBlank(teacherQuery.getEnd()), EduTeacher::getGmtCreate, teacherQuery.getEnd())
                .orderByDesc(EduTeacher::getGmtCreate);
        eduTeacherService.page(pageTeacher, wrapper);

        PageInfo<EduTeacher> pageInfo = new PageInfo<>(pageTeacher.getTotal(), pageTeacher.getRecords());
        return R.ok(pageInfo);
    }

    @ApiOperation("添加")
    @PostMapping
    public R<Boolean> add(@RequestBody EduTeacher eduTeacher) {
        return R.ok(eduTeacherService.save(eduTeacher));
    }

    @ApiOperation(("根据id查询"))
    @GetMapping("/{id}")
    public R<EduTeacher> getById(@PathVariable Long id) {
        return R.ok(eduTeacherService.getById(id));
    }

    @ApiOperation("修改")
    @PutMapping
    public R<Boolean> update(@RequestBody EduTeacher eduTeacher) {
        return R.ok(eduTeacherService.updateById(eduTeacher));
    }
}

