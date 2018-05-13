package com.yqz.dataparse;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class DataTansTest {
    
    @Test
    public void dataMacherTest() {
        String str = "https://movie.douban.com/subject/27018285/sadas?page=10&total=20";
        String reg = "[0-9]+";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            String fqdnId = matcher.group();
            System.out.println(fqdnId);
        }
    }
}
