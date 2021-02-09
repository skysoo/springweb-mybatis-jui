package com.chart.jui.service;


import com.chart.jui.dto.XBarRDTO;
import com.chart.jui.mapper.XBarRMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class XBarRServiceImpl implements CommonService<XBarRDTO>{
    private final XBarRMapper xBarRMapper;

    public XBarRServiceImpl(XBarRMapper xBarRMapper) {
        this.xBarRMapper = xBarRMapper;
    }

    @Transactional(readOnly = true) // 트랜잭션 범위는 유지하되, 조회 기능만 남겨두어 조회 속도가 개선된다.
    @Override
    public List<XBarRDTO> selectByAll() {
        return xBarRMapper.selectByAll();
    }

    @Override
    public List<XBarRDTO> selectById(String id) {
        return xBarRMapper.selectById(id);
    }

    @Transactional
    @Override
    public Integer insertData(XBarRDTO o) throws Exception {
        return xBarRMapper.insertData(o);
    }

    @Override
    public void deleteDataByAll() {
        xBarRMapper.deleteDataByAll();
    }

}
