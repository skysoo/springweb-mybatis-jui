package com.chart.jui.dto;

import com.google.gson.Gson;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@NoArgsConstructor
public class ControlChartInfoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank
    private String id;
    @NotNull
    private Integer sampleCycle;
    @NotNull
    private Integer sampleCnt;
    @NotNull
    private Float xbarUcl;
    @NotNull
    private Float xbarCl;
    @NotNull
    private Float xbarLcl;
    @NotNull
    private Float rUcl;
    @NotNull
    private Float rCl;
    @NotNull
    private Float rLcl;
    @NotBlank
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
