package x.gerry.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import x.gerry.util.LoggingUtil;

/**
 * @author:Gerry
 * @description:
 * @date: Created in 2019/1/11
 */
@RestController
public class LogsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogsController.class);

    @GetMapping("/logback")
    public Long createLogs() {
        LOGGER.info("-------------------------INFO");
        LOGGER.debug("-------------------------DEBUG");
        LOGGER.error("-------------------------ERROR");
        LoggingUtil.createLogging();
        return System.currentTimeMillis();
    }
}
