package x.gerry.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author:Gerry
 * @description:自定义属性与加载:只需要使用@Component注解将类注册到容器内就可以方便使用
 * @date: Created in 2019/1/10
 */
@Component
public class DefinitionConfig implements Serializable {
    @Value("XGerry")
    private String name;

    @Value("Spring Boot Study")
    private String title;

    @Value("${x.gerry.name} 2019 is going to better.")
    private String desc;

    @Value("${x.gerry.value}")
    private String value;

    @Override
    public String toString() {
        return "DefinitionConfig [name=" + name + ", title=" + title + ", desc=" + desc + ", value=" + value + "]";
    }
}
