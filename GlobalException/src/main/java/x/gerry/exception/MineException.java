package x.gerry.exception;


import lombok.Getter;
import lombok.Setter;

/**
 * @author: Gerry
 * @description: 自定义异常
 * @date: Created in 2019/1/15
 */
public class MineException extends RuntimeException {

    private static final long serialVersionUID = -1104674993657790702L;

    /**
     * 生成序列异常时
     */
    public static final MineException DB_GET_SEQ_NEXT_VALUE_ERROR = new MineException(10040007, "序列生成超时");

    @Getter
    @Setter
    protected int code; //错误码

    @Getter
    @Setter
    protected String message; //异常描述


    public MineException(String message) {
        super(message);
    }

    public MineException(int code, String msgFormat, Object... args) {
        super(String.format(msgFormat, args));
        this.code = code;
        this.message = String.format(msgFormat, args);
    }

    public MineException(String message, Throwable cause) {
        super(message, cause);
    }

    public MineException(Throwable cause) {
        super(cause);
    }

    /**
     * 实例化异常
     *
     * @param msgFormat
     * @param args
     * @return
     */
    public MineException newInstance(String msgFormat, Object... args) {
        return new MineException(this.code, msgFormat, args);
    }
}
