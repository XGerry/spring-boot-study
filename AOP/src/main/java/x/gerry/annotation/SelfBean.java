package x.gerry.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author: Gerry
 * @description: 自定义注解类
 * @date: Created in 2019/1/16
 */

/**
 * @Target用于设定注解使用的范围,使用ElementType来指定注解使用范围的枚举集合
 * METHOD 可用于方法上;TYPE 可用于类或者接口上;
 * CONSTRUCTOR 可用于构造方法上; FIELD 可用于域上
 */

/**
 * @Retention定义被它所注解的注解保留多久
 * RetentionPolicy.SOURCE被编译器忽略
 * RetentionPolicy.CLASS注解将会保留在注解中，但在运行时并不会被VM保留。这是默认的行为，即使没有该注解，也默认使用该注解
 * RetentionPolicy.RUNTIME注解将会保留在运行时。所以我们可以通过反射去获取注解信息
 */

/**
 * @Documented 注解表明这个注解应该被 javadoc工具记录
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface SelfBean {
    String value() default "";
}
