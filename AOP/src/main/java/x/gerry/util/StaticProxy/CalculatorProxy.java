package x.gerry.util.StaticProxy;

/**
 * @author: Gerry
 * @description: 静态代理类的实现
 * @date: Created in 2019/1/17
 */
public class CalculatorProxy implements Calculator {

    private Calculator calculator;

    private CalculatorProxy(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int add(int a, int b) {
        //执行一些操作
        System.out.println("begin ");
        int result = calculator.add(a, b);
        System.out.println("end ");
        return result;
    }

    @Override
    public int div(int a, int b) {
        return a / b;
    }

    public static void main(String[] args) {
        CalculatorProxy calculatorProxy = new CalculatorProxy(new CalculatorImpl());
        calculatorProxy.add(1, 2);
    }
}
