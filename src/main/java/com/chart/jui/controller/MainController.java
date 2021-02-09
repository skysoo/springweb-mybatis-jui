package com.chart.jui.controller;


import com.chart.jui.dto.ControlChartInfoDTO;
import com.chart.jui.dto.XBarRDTO;
import com.chart.jui.service.CommonService;
import com.chart.jui.vo.ControlChartInfoVO;
import com.chart.jui.vo.XBarRVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainController {

    private final CommonService<ControlChartInfoDTO> chartInfoService;
    private final CommonService<XBarRDTO> xBarRService;

    public MainController(CommonService<ControlChartInfoDTO> chartInfoService, CommonService<XBarRDTO> xBarRService) {
        this.chartInfoService = chartInfoService;
        this.xBarRService = xBarRService;
    }

    @GetMapping("/")
    public ModelAndView main(Model model){
        ModelAndView mv = new ModelAndView("main");
        List<ControlChartInfoVO> chartInfoVOList = chartInfoService.selectByAll().stream()
                .map(ControlChartInfoVO::new)
                .collect(Collectors.toList());
        mv.addObject("chartInfoVOList",chartInfoVOList);
        return mv;
    }

    @PostMapping("/controlChart")
    public ModelAndView savePosts(@RequestBody ControlChartInfoDTO dto) throws Exception {
        ModelAndView mv = new ModelAndView("controlChart");
        List<XBarRVO> xBarRVOList = xBarRService.selectById(dto.getId()).stream()
                .map(XBarRVO::new)
                .collect(Collectors.toList());
        mv.addObject("xBarRVOList",xBarRVOList);
        return mv;
    }
}
