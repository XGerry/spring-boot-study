package x.gerry.web;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.*;
import x.gerry.model.vo.DemoInfo;
import x.gerry.service.IDemoInfoService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author:Gerry
 * @description:
 * @date: Created in 2019/1/10
 */
@RestController
public class RESTfulAPIController {
    @Resource
    IDemoInfoService service;

    /**
     * GET（SELECT）：从服务器取出资源（一项或多项）;
     * POST（CREATE）：在服务器新建一个资源;
     * PUT（UPDATE）：在服务器更新资源（客户端提供改变后的完整资源）;
     * PATCH（UPDATE）：在服务器更新资源（客户端提供改变的属性）;
     * DELETE（DELETE）：从服务器删除资源。
     */

    @GetMapping("/demos")
    //@RequestMapping(value = { "/demos", "/" }, method = RequestMethod.GET)
    public List<DemoInfo> findAll()
    {
        return service.findAll();
    }

    @RequestMapping(value = { "/demo" }, method = RequestMethod.POST)
   // @PostMapping("/demo")
    public List<DemoInfo> addDemoInfo(@ModelAttribute DemoInfo demo) {
        // POST请求，用来创建DemoInfo
        // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
        System.out.println(JSON.toJSONString(demo));
        return service.insertDemoInfo(demo);
    }

    @RequestMapping(value = "/demo/{id}", method = RequestMethod.GET)
    public DemoInfo findDemoInfo(@PathVariable Integer id) {
        // GET请求，用来获取信息
        // url中的id可通过@PathVariable绑定到函数的参数中
        return service.findDemoInfo(id);
    }

    @RequestMapping(value = "/demo/{id}", method = RequestMethod.PUT)
    public List<DemoInfo> updateDemoInfo(@PathVariable Integer id) {
        // PUT请求，用来更新信息
        DemoInfo demo = new DemoInfo();
        demo.setId(id);
        demo.setDesc("我是第" + id + "ST");
        demo.setName("TS__" + id);
        return service.updateDemoInfo(demo);
    }

    @RequestMapping(value = "/demo/{id}", method = RequestMethod.DELETE)
    public List<DemoInfo> deleteDemoInfo(@PathVariable Integer id) {
        // DELETE请求，用来删除信息
        DemoInfo demo = new DemoInfo();
        demo.setId(id);
        return service.deleteDemoInfo(demo);
    }
}
