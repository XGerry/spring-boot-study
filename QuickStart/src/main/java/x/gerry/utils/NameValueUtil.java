package x.gerry.utils;

import jodd.util.NameValue;

/**
 * @author:Gerry
 * @description:
 * @date: Created in 2019/1/10
 */
public class NameValueUtil {
    public static NameValue<String, String> of(String val, String split) {
        String[] result = val.split(split);
        return new NameValue<>(result[0].replace("-", ""), result[1]);
    }

    public static NameValue<String, String> of(String val) {
        return of(val, "=");
    }
}
