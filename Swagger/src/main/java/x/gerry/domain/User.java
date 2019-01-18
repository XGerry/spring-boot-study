package x.gerry.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author:Gerry
 * @description:
 * @date: Created in 2019/1/18
 */
public class User {
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Integer age;
}
