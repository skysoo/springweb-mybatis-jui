package com.chart.jui.dto;

import com.google.gson.Gson;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ControlChartInfoDTO  {
    private String id;
    private Integer sampleCycle;
    private Integer sampleCnt;
    private Float xbarUcl;
    private Float xbarCl;
    private Float xbarLcl;
    private Float rUcl;
    private Float rCl;
    private Float rLcl;
    private String createTm;

    @Builder
    public ControlChartInfoDTO(String id, Integer sampleCycle, Integer sampleCnt, Float xbarUcl, Float xbarCl, Float xbarLcl, Float rUcl, Float rCl, Float rLcl, String createTm) {
        this.id = id;
        this.sampleCycle = sampleCycle;
        this.sampleCnt = sampleCnt;
        this.xbarUcl = xbarUcl;
        this.xbarCl = xbarCl;
        this.xbarLcl = xbarLcl;
        this.rUcl = rUcl;
        this.rCl = rCl;
        this.rLcl = rLcl;
        this.createTm = createTm;
    }

    public String print(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
