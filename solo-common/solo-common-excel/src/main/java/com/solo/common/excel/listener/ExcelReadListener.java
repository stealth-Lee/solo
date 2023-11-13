package com.solo.common.excel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 作者：周瑜大都督
 */

@Slf4j
@Component
public class ExcelReadListener<T> implements ReadListener<T> {

//    private final M dao;

    private final ThreadLocal<ArrayList<T>> dataList = ThreadLocal.withInitial(ArrayList::new);
    private static AtomicInteger count = new AtomicInteger(1);
    private static final int batchSize = 10000;

//    public ExcelReadListener(M dao) {
//        this.dao = dao;
//    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void invoke(T data, AnalysisContext context) {
        dataList.get().add(data);
        if (dataList.get().size() >= batchSize) {
            saveData();
//            asyncSaveData();
        }
    }

    public void saveOne(T data){
//        save(data);
        log.info("第" + count.getAndAdd(1) + "次插入1条数据");
    }

    public void saveData() {
        if (!dataList.get().isEmpty()) {
//            dao.insertBatch(dataList.get(), dataList.get().size());
            log.info("第" + count.getAndAdd(1) + "次插入" + dataList.get().size() + "条数据");
            dataList.get().clear();
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void doAfterAllAnalysed(AnalysisContext context) {
        log.info("一个Sheet全部处理完");
        saveData();
    }

}
