package x.gerry.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author:Gerry
 * @description:
 * @date: Created in 2019/1/16
 */
public class CommonUtil {
    private final static Logger logger = LoggerFactory.getLogger(CommonUtil.class);

    public static int add(int i) {
        i = i + 1;
        logger.info("CommonUtil 的处理结果为：" + i);
        return i;
    }
}
