package com.chart.jui.service;

import java.util.List;

public interface CommonService<D> {
    List<D> selectByAll();
    List<D> selectById(String id);
    Integer insertData(D d) throws Exception;
    void deleteDataByAll();
}
