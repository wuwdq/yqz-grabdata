package com.yqz.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 数据处理工具
 *
 * @author td
 * @version $Id: DataUtils.java, v 0.1 2018年5月9日 下午10:13:59 td Exp $
 */
public class DataUtils {
    
    /**
     * 取出字符串中数字部分
     *
     * @param star
     * @return
     */
    public static String getStringNum(String data) {
        String stringNum = "";
        String reg = "[0-9]+";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(data);
        if (matcher.find()) {
            stringNum = matcher.group();
        }
        return stringNum;
    }

    
    /**
     * 去空格
     *
     * @param data
     * @return
     */
    public static String removeEmpty(String data){
        if(data == null){
            return "";
        }
        return data.trim();
    }
}
