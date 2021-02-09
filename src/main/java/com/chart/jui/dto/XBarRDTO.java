package com.chart.jui.dto;

import com.google.gson.Gson;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class XBarRDTO {

    private String id;
    private float rangeAverage;
    private float valueAverage;
    private String infoId;
    private String createTm;

    @Builder
    public XBarRDTO(String id, float rangeAverage, float valueAverage, String infoId, String createTm) {
        this.id = id;
        this.rangeAverage = rangeAverage;
        this.valueAverage = valueAverage;
        this.infoId = infoId;
        this.createTm = createTm;
    }

    public String print(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
