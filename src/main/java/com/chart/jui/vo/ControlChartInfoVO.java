package com.chart.jui.vo;

import com.chart.jui.dto.ControlChartInfoDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

@Getter
@EqualsAndHashCode
public class ControlChartInfoVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String id;
    private final Integer sampleCycle;
    private final Integer sampleCnt;
    private final Float xbarUcl;
    private final Float xbarCl;
    private final Float xbarLcl;
    private final Float rUcl;
    private final Float rCl;
    private final Float rLcl;
    private final String createTm;

    public ControlChartInfoVO(ControlChartInfoDTO dto) {
        this.id = dto.getId();
        this.sampleCycle = dto.getSampleCycle();
        this.sampleCnt = dto.getSampleCnt();
        this.xbarUcl = dto.getXbarUcl();
        this.xbarCl = dto.getXbarCl();
        this.xbarLcl = dto.getXbarLcl();
        this.rUcl = dto.getRUcl();
        this.rCl = dto.getRCl();
        this.rLcl = dto.getRLcl();
        this.createTm = dto.getCreateTm();
    }
}
