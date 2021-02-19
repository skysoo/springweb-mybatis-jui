package com.chart.jui;

import com.chart.jui.dto.XBarRDTO;
import com.chart.jui.service.CommonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;


@SpringBootTest
class JuiApplicationTests {

    @Autowired
    private CommonService<XBarRDTO> xBarRDTOCommonService;
    Random random = new Random();

    @Test
    void randomCreate() {

        for (int i = 0; i < 10; i++) {
            float range = (float) (random.nextFloat() * 0.4);
            float value = (float) (Math.random() * 0.15723 - 0.0523);

            System.out.printf("range + %.5f%n",range);
            System.out.printf("value + %.5f%n",value);
        }
    }

    @Test
    void contextLoads() throws Exception {

        for (int i = 0; i < 2; i++) {
            float range = (float) (random.nextFloat() * 0.4);
            float value = (float) (Math.random() * 0.15723 - 0.0523);

            XBarRDTO xBarRDTO = XBarRDTO.builder()
                    .infoId("epozen01")
                    .rangeAverage(Float.parseFloat(String.format("%.5f",range)))
                    .valueAverage(Float.parseFloat(String.format("%.5f",value)))
                    .build();
            xBarRDTOCommonService.insertData(xBarRDTO);
        }



    }

}
