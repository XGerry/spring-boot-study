package x.gerry.service.user.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import x.gerry.annotation.SelfMethod;
import x.gerry.service.user.IUserInfoService;

/**
 * @author:Gerry
 * @description:
 * @date: Created in 2019/1/16
 */
@Service
public class UserInfoServiceImpl implements IUserInfoService {
    private final static Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Override
    @SelfMethod
    public String addUserInfo(String name) {
        logger.info("新增的用户姓名是：" + name);
        return name + "U";
    }
}
