package com.chart.jui.mapper;


import com.chart.jui.dto.XBarRDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface XBarRMapper {
    List<XBarRDTO> selectByAll();
    List<XBarRDTO> selectById(String id);
    Integer insertData(XBarRDTO o) throws Exception;
    void deleteDataByAll();
}
