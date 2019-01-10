package x.gerry;

import jodd.util.NameValue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import x.gerry.utils.NameValueUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

/**
 * @author:Gerry
 * @description:
 * @date: Created in 2019/1/9
 */
@SpringBootApplication
@EnableAutoConfiguration
public class App {
    static {
        Properties properties = new Properties();
        try {
            properties.load(App.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        properties.forEach((k, v) -> System.setProperty(k.toString(), v.toString()));
    }

    public static void main(String... args) {
/*        for (String arg : args) {
            NameValue<String, String> nameValue = NameValueUtil.of(arg);
            System.setProperty(nameValue.name(), nameValue.value());
        }*/
        SpringApplication.run(App.class, args);
/*        ApplicationContext ctx = SpringApplication.run(App.class, args);
        System.out.println("Let's inspect the beans provided by Spring Boot:");
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }*/
    }
}
