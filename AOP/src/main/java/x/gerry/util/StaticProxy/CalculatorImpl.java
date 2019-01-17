package x.gerry.util.StaticProxy;

/**
 * @author: Gerry
 * @description: 静态代理：接口实现类
 * @date: Created in 2019/1/17
 */
public class CalculatorImpl implements Calculator {
    @Override
    public int add(int a, int b) {
        System.out.println("doing a+b=" + (a + b));
        return a + b;
    }

    @Override
    public int div(int a, int b) {
        System.out.println("doing a/b=" + (a / b));
        return a / b;
    }
}
