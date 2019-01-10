package x.gerry.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import x.gerry.conf.DefinitionConfig;
import x.gerry.conf.DubboConfig;

import javax.annotation.Resource;

/**
 * @author:Gerry
 * @description:
 * @date: Created in 2019/1/10
 */
@RestController
public class ConfController {
    @Resource
    DefinitionConfig config;

    @Resource
    DubboConfig dubbo;

    /**
     * 测试自定义配置属性加载
     * @return
     */
    @RequestMapping("/config")
    public String getConfig() {
        return config.toString();
    }

    /**
     * 测试自定义的额外文件的配置信息
     * @return
     */
    @RequestMapping("/dubbo")
    public String dubboConfig() {
        return dubbo.toString();
    }
}
