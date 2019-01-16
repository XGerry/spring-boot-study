package x.gerry.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author:Gerry
 * @description:
 * @date: Created in 2019/1/16
 */
public class DateUtil {
    public static String now() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return format.format(date);
    }
}
