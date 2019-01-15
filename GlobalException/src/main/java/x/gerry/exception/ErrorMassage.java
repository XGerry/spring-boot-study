package x.gerry.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: Gerry
 * @description: 错误消息Model
 * @date: Created in 2019/1/15
 */
public class ErrorMassage<T> {
    public static final Integer OK = 0;
    public static final Integer ERROR = 100;

    @Getter
    @Setter
    private Integer code;
    @Getter
    @Setter
    private String message;
    @Getter
    @Setter
    private String url;
    @Getter
    @Setter
    private T data;

}
