package com.ty.acctservice.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User:lfm
 * Date:2018/3/13 0013
 * <p>
 * 日期相关的工具集
 */
public class DateUtils {

    public static String dataToStr1(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

}
