package com.hlovex.edu.service.impl;

import com.alibaba.excel.EasyExcel;
import com.google.common.collect.Lists;
import com.hlovex.edu.entity.Subject;
import com.hlovex.edu.listener.SubjectExcelListener;
import com.hlovex.edu.mapper.SubjectMapper;
import com.hlovex.edu.service.SubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hlovex.edu.vo.excel.SubjectData;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author hlovex
 * @since 2021-02-15
 */
@Service
@Slf4j
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {

    @Override
    public void save(MultipartFile file) {
        try {
            EasyExcel.read(file.getInputStream(), SubjectData.class, new SubjectExcelListener(this)).sheet().doRead();
        } catch (IOException e) {
            log.error("保存失败，原因：", e);
        }
    }

    @Override
    public List<Subject> getTree() {
        List<Subject> all = baseMapper.selectList(null);
        return listToTree(all);
    }

    public List<Subject> listToTree(List<Subject> list) {
        if (CollectionUtils.isEmpty(list)) return Lists.newArrayList();

        List<Subject> treeList = Lists.newArrayList();
        for (Subject tree : list) {
            //找到根
            if (tree.getParentId() == 0) {
                treeList.add(tree);
            }
            //找到子
            for (Subject treeNode : list) {
                if (Objects.equals(treeNode.getParentId(), tree.getId())) {
                    if (tree.getChildren() == null) {
                        tree.setChildren(Lists.newArrayList());
                    }
                    tree.getChildren().add(treeNode);
                }
            }
        }
        return treeList;
    }
}
