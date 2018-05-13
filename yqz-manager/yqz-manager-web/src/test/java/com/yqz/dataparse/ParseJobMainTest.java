package com.yqz.dataparse;

import org.junit.Test;

import com.yqz.schedule.ParseDataJob;

public class ParseJobMainTest {
    @Test
    public void dataParseTest() {
        ParseDataJob parseJobMain = new ParseDataJob();
        long start = System.currentTimeMillis();
        try {
            parseJobMain.excute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("采集数据总共花的时间为：" + (double)(end - start)/1000 + "秒");
    }
}
