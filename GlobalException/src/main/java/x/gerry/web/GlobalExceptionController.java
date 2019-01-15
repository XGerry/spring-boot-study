package x.gerry.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import x.gerry.exception.ErrorMassage;
import x.gerry.exception.MineException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: Gerry
 * @description: 创建全局异常处理类：通过使用@ControllerAdvice定义统一的异常处理类，而不是在每个Controller中逐个定义。
 * @ControllerAdvice统一定义不同Exception映射到不同错误处理页面
 * @date: Created in 2019/1/15
 */
@ControllerAdvice
public class GlobalExceptionController {
    /**
     * 在@ControllerAdvice类中，根据抛出的具体Exception类型匹配@ExceptionHandler中配置的异常类型来匹配错误映射和处理
     */

    public static final String DEFAULT_ERROR_VIEW = "error";

    /**
     * 捕获自定义异常，返回json信息
     */
    @ExceptionHandler(value = MineException.class)
    @ResponseBody
    public ErrorMassage<Object> ErrorHandle(HttpServletRequest request, MineException ex) {
        ErrorMassage<Object> errorMassage = new ErrorMassage<>();
        errorMassage.setCode(404);
        errorMassage.setMessage("Not Found Exception...");
        errorMassage.setUrl(request.getRequestURL().toString());
        errorMassage.setData("");
        return errorMassage;
    }

    @ExceptionHandler(value = ArithmeticException.class)
    @ResponseBody
    public ErrorMassage<Object> ErrorHandle(HttpServletRequest request, ArithmeticException ex) {
        ErrorMassage<Object> errorMassage = new ErrorMassage<>();
        errorMassage.setCode(405);
        errorMassage.setMessage("java.lang.ArithmeticException: / by zero");
        errorMassage.setUrl(request.getRequestURL().toString());
        errorMassage.setData(ex);
        return errorMassage;
    }

    /**
     * @ExceptionHandler用来定义函数针对的异常类型，最后将Exception对象和请求URL映射到error.html中
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView ErrorHandle(HttpServletRequest request, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        ErrorMassage<Object> errorMassage = new ErrorMassage<>();
        errorMassage.setCode(400);
        errorMassage.setMessage("系统异常");
        errorMassage.setUrl(request.getRequestURI());
        errorMassage.setData(ex);
        modelAndView.addObject(errorMassage);
        modelAndView.setViewName(DEFAULT_ERROR_VIEW);
        return modelAndView;
    }

}
