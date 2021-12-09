package org.oes.common.utils;

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
}
