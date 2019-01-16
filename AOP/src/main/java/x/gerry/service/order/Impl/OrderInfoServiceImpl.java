package x.gerry.service.order.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import x.gerry.service.order.IOrderInfoService;

/**
 * @author:Gerry
 * @description:
 * @date: Created in 2019/1/16
 */

@Service
public class OrderInfoServiceImpl implements IOrderInfoService {
    private final static Logger logger = LoggerFactory.getLogger(OrderInfoServiceImpl.class);

    @Override
    public String addOrderInfo(String name) {
        logger.info("新增的订单名称是：" + name);
        return name + "O";
    }
}
