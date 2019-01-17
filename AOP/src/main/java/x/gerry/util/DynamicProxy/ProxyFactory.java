package x.gerry.util.DynamicProxy;

import x.gerry.util.StaticProxy.Calculator;
import x.gerry.util.StaticProxy.CalculatorImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: Gerry
 * @description: JDK动态代理实现类
 * @date: Created in 2019/1/17
 */
public class ProxyFactory implements InvocationHandler {
    private Class<?> target;
    private Object real;

    //委托类class
    private ProxyFactory(Class<?> target) {
        this.target = target;
    }

    //实际执行类bind
    private Object bind(Object real) {
        this.real = real;
        //利用JDK提供的Proxy实现动态代理
        return Proxy.newProxyInstance(target.getClassLoader(), new Class[]{target}, this);
    }

    /**
     * JDK代理总结
     * 1.JDK动态代理只能代理有接口的类,并且是能代理接口方法,不能代理一般的类中的方法
     * 2.提供了一个使用InvocationHandler作为参数的构造方法。在代理类中做一层包装,业务逻辑在invoke方法中实现
     * 3.重写了Object类的equals、hashCode、toString，它们都只是简单的调用了InvocationHandler的invoke方法，
     * 即可以对其进行特殊的操作，也就是说JDK的动态代理还可以代理上述三个方法
     * 4.在invoke方法中我们甚至可以不用Method.invoke方法调用实现类就返回。这种方式常常用在RPC框架中,在invoke方法中发起通信调用远端的接口等
     */

    /**
     * 执行代理时会执行的方法
     *
     * @param proxy  代理类
     * @param method 代理对象：使用java反射调用真实的实现类的方法
     * @param args   代理参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //代理环绕
        System.out.println("begin");
        //执行实际的方法
        Object invoke = method.invoke(real, args);
        System.out.println("end");
        return invoke;
    }

    public static void main(String[] args) {
        Calculator proxy = (Calculator) new ProxyFactory(Calculator.class).bind(new CalculatorImpl());
        proxy.add(1, 2);
        proxy.div(1, 2);
    }
}
