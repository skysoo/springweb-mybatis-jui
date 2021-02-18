package com.chart.jui.controller;


import com.chart.jui.dto.ControlChartInfoDTO;
import com.chart.jui.dto.XBarRDTO;
import com.chart.jui.service.CommonService;
import com.chart.jui.vo.ControlChartInfoVO;
import com.chart.jui.vo.XBarRVO;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainController {

    private final CommonService<ControlChartInfoDTO> chartInfoService;
    private final CommonService<XBarRDTO> xBarRService;
    private Gson gson = new Gson();
    private String jsonData = "";

    public MainController(CommonService<ControlChartInfoDTO> chartInfoService, CommonService<XBarRDTO> xBarRService) {
        this.chartInfoService = chartInfoService;
        this.xBarRService = xBarRService;
    }

    @GetMapping("/")
    public ModelAndView main(Model model) {
        ModelAndView mv = new ModelAndView("main");
        List<ControlChartInfoVO> chartInfoVOList = chartInfoService.selectByAll().stream()
                .map(ControlChartInfoVO::new)
                .collect(Collectors.toList());
        mv.addObject("chartInfoVOList", chartInfoVOList);
        return mv;
    }

    @GetMapping("/dataRedirect")
    public String dataRedirect(@RequestParam String data){
        this.jsonData = data;
        return "draw";
    }

    @ResponseBody
    @GetMapping("/draw")
    public ModelAndView draw(ModelAndView mv){
        String data = this.jsonData;
        Gson gson = new Gson();
        ControlChartInfoDTO dto = gson.fromJson(data, ControlChartInfoDTO.class);
        if (dto!=null && dto.getId()!=null){
            System.out.println(dto.print());
            List<XBarRVO> xBarRVOList = xBarRService.selectById(dto.getId()).stream()
                    .map(XBarRVO::new)
                    .collect(Collectors.toList());
            mv.setViewName("draw");
            mv.addObject("dto",dto);
            mv.addObject("xBarRVOList",xBarRVOList);
        }
        return mv;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/xBarR")
    public @ResponseBody String xBarR(){
        String data = this.jsonData;
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
    // TODO: 2021-02-15 @RequestBody 로 넘어오는 dto에서 rUcl,rCl,rLcl 이 null로 넘어온다. jsonStr 에는 값이 있음
}
