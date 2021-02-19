package com.chart.jui.controller;

import com.chart.jui.dto.ControlChartInfoDTO;
import com.chart.jui.dto.XBarRDTO;
import com.chart.jui.service.CommonService;
import com.chart.jui.vo.XBarRVO;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class RealTimeController {

    @Autowired
    private CommonService<XBarRDTO> xBarRService;

    @GetMapping("/realtime")
    public String realRimeChart(Model model){
        return "/basic/realtime";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/xbarRealtime")
    public @ResponseBody
    String xbarRealTimeChart(){
        String data = "{\"id\":\"epozen01\",\"sampleCycle\":\"1\",\"sampleCnt\":\"5\",\"xbarUcl\":\"0.11956\",\"xbarCl\":\"0.00254\",\"xbarLcl\":\"-0.11448\",\"rUcl\":\"0.42895\",\"rCl\":\"0.20281\",\"rLcl\":\"0.0\",\"createTm\":\"20210209:042455\"}";
        Gson gson = new Gson();
        ControlChartInfoDTO dto = gson.fromJson(data, ControlChartInfoDTO.class);
        if (dto!=null && dto.getId()!=null){
            List<XBarRVO> xBarRVOList = xBarRService.selectById(dto.getId()).stream()
                    .map(XBarRVO::new)
                    .collect(Collectors.toList());
            return gson.toJson(xBarRVOList);
        }
        return null;
    }
}
