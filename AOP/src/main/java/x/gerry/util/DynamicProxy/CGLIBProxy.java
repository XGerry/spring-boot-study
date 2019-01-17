package x.gerry.util.DynamicProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import x.gerry.util.StaticProxy.Calculator;
import x.gerry.util.StaticProxy.CalculatorImpl;


/**
 * @author: Gerry
 * @description: CGLIB动态代理
 * @date: Created in 2019/1/17
 */
public class CGLIBProxy {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Calculator.class);
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            Object invoke = null;
            try {
                before();
                invoke = methodProxy.invoke(new CalculatorImpl(), objects);
                after();
            } catch (Exception e) {
                exception();
            } finally {
                beforeReturning();
            }
            return invoke;
        });
        enhancer.setCallbackFilter(method -> {
            //返回的下标和在Callback数组中的下标对应,下面表达的是reduce方法绑定MethodInterceptor
            if(method.getName().equals("reduce")) return 1;
            return 0;
        });
        Calculator proxy = (Calculator) enhancer.create();
        // proxy.add(1, 2);
        proxy.div(1, 2);
    }

    private static void before() {
        System.out.println("before method invoke");
    }

    private static void after() {
        System.out.println("after method invoke");
    }

    private static void exception() {
        System.out.println("method invoke exception");
    }

    private static void beforeReturning() {
        System.out.println("before returning");
    }

}
