package x.gerry.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:Gerry
 * @description:第一个SpringBoot程序
 * @date: Created in 2019/1/9
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello()
    {
        return "Hello,SpringBoot!";
    }
}
