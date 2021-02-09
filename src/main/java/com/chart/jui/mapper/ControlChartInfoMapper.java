package com.chart.jui.mapper;


import com.chart.jui.dto.ControlChartInfoDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ControlChartInfoMapper {
    List<ControlChartInfoDTO> selectByAll();
    List<ControlChartInfoDTO> selectById(String id);
    Integer insertData(ControlChartInfoDTO o) throws Exception;

    void deleteDataByAll();
}
