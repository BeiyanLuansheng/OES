package org.oes.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author XuJian
 * @since 2021/12/02
 */
public class DateUtils {

    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static String getStringInFormat(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static Date getDateFromString(String dateStr, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(dateStr);
    }

    public static void main(String[] args) throws Exception{
        String time = "2021-12-13 21:39:43";
        long time1 = getDateFromString(time, YYYY_MM_DD_HH_MM_SS).getTime();
        System.out.println(time1);
        System.out.println(new Date(time1));
        time = "2021-12-13 21:40:43";
        time1 = getDateFromString(time, YYYY_MM_DD_HH_MM_SS).getTime();
        System.out.println(time1);
        System.out.println(new Date(time1));
    }
}
