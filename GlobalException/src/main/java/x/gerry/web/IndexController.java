package x.gerry.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import x.gerry.exception.MineException;

/**
 * @author:Gerry
 * @description:
 * @date: Created in 2019/1/15
 */
@RestController
public class IndexController {
    private final static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("/")
    public String hello(ModelMap map) {
        logger.info("访问到了 hello ...");
        map.addAttribute("index", "一起尝试 spring boot 全局异常捕获吧...");
        return "index";
    }

    @RequestMapping("/anyone")
    public String anyone(ModelMap map) throws Exception {
        logger.info("访问到了 index ...");
        throw new Exception();
    }

    @RequestMapping("/mine")
    public String mine(ModelMap map) {
        logger.info("访问到了 tmine ...");
        Throwable throwable = new Throwable();
        throw new MineException("我们访问到了 mine ...", throwable);
    }

    @ResponseBody
    @RequestMapping("/sum")
    public String sum(ModelMap map) throws ArithmeticException {
        logger.info("访问到了 sum ...");
        int i = 1 / 0;
        return "" + i;
    }
}
