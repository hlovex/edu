package com.hlovex.demo.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.Map;

/**
 * Created by hlovex on 2021/2/15 14:47
 */
public class ExcelListener extends AnalysisEventListener<DemoData> {

    // 一行一行的读取excel内容
    @Override
    public void invoke(DemoData demoData, AnalysisContext analysisContext) {

    }

    // 读取表头内容
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        super.invokeHeadMap(headMap, context);
    }

    // 读取完之后
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
