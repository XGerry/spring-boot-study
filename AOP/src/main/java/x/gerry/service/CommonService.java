package x.gerry.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import x.gerry.annotation.SelfBean;

/**
 * @author:Gerry
 * @description:
 * @date: Created in 2019/1/16
 */
@Service
@SelfBean
public class CommonService {
    private final static Logger logger = LoggerFactory.getLogger(CommonService.class);

    public int add(int i) {
        i++;
        logger.info("CommonService 的处理结果为：" + i);
        return i;
    }
}
