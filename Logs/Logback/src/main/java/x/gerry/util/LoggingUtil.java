package x.gerry.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author:Gerry
 * @description:
 * @date: Created in 2019/1/11
 */
public class LoggingUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingUtil.class);

    public static void createLogging() {
        LOGGER.info("----------info----------");
        LOGGER.debug("----------debug----------");
        LOGGER.error("----------error----------");
    }
}
