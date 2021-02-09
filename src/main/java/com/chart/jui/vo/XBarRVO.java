package com.chart.jui.vo;

import com.chart.jui.dto.XBarRDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

@Getter
@EqualsAndHashCode
public class XBarRVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String id;
    private final float rangeAverage;
    private final float valueAverage;
    private final String createTm;

    public XBarRVO(XBarRDTO dto) {
        this.id = dto.getId();
        this.rangeAverage = dto.getRangeAverage();
        this.valueAverage = dto.getValueAverage();
        this.createTm = dto.getCreateTm();
    }
}
