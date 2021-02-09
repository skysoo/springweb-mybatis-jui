package com.chart.jui.service;


import com.chart.jui.dto.ControlChartInfoDTO;
import com.chart.jui.mapper.ControlChartInfoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ControlChartInfoServiceImpl implements CommonService<ControlChartInfoDTO>{
    private final ControlChartInfoMapper controlChartInfoMapper;

    public ControlChartInfoServiceImpl(ControlChartInfoMapper controlChartInfoMapper) {
        this.controlChartInfoMapper = controlChartInfoMapper;
    }

    @Transactional(readOnly = true) // 트랜잭션 범위는 유지하되, 조회 기능만 남겨두어 조회 속도가 개선된다.
    @Override
    public List<ControlChartInfoDTO> selectByAll() {
        return controlChartInfoMapper.selectByAll();
    }

    @Override
    public List<ControlChartInfoDTO> selectById(String id) {
        return controlChartInfoMapper.selectById(id);
    }

    @Transactional
    @Override
    public Integer insertData(ControlChartInfoDTO o) throws Exception {
        return controlChartInfoMapper.insertData(o);
    }

    @Override
    public void deleteDataByAll() {
        controlChartInfoMapper.deleteDataByAll();
    }

}
