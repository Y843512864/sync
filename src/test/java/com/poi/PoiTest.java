package com.poi;

import com.dodo.sync.utils.ExcelUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class PoiTest {
    @Test
    public void poitest() throws IOException, InvalidFormatException {
        List<String> s = ExcelUtils.readExcel("D://deal.xlsx", 1);
        int i = 0;
        for (String x : s) {
            String flag = "";
            try {
                flag = x.split(",")[11];
            } catch (Exception e) {
            }
            if ("是".equals(flag)) {
                System.out.print(flag);
                System.out.print(x.split(",")[1]);
                System.out.print(x.split(",")[2]);
                System.out.print(x.split(",")[3]);
                i++;
            }
        }
        System.out.println(i);
        // s = s.stream().filter(x->x.split(",")[6].equals("否")).collect(Collectors.toList());
        // s.forEach(x -> System.out.println(x));

    }
}
