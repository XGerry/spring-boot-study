package x.gerry.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import x.gerry.service.CommonService;
import x.gerry.service.order.IOrderInfoService;
import x.gerry.service.user.IUserInfoService;
import x.gerry.util.CommonUtil;

import javax.annotation.Resource;

/**
 * @author:Gerry
 * @description:
 * @date: Created in 2019/1/16
 */
@RestController
public class IndexController {
    private final static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Resource
    CommonService commonService;
    @Resource
    IOrderInfoService orderInfoService;
    @Resource
    IUserInfoService userInfoService;

    @GetMapping("/")
    public Long index() {
        logger.info("\n=======================spring aop========================\n");
        int i = 1;
        i = CommonUtil.add(i);
        i = commonService.add(i);
        logger.info("\n====================处理结果为:" + i + "====================\n");
        String name = "#####";
        name = orderInfoService.addOrderInfo(name);
        name = userInfoService.addUserInfo(name);
        logger.info("\n====================名称为\t" + name + "====================\n");
        return System.currentTimeMillis();
    }
}
