package org.example.handler;

import org.example.util.ServiceTools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ServiceConfigurationError;

public class MyInvocationHandler implements InvocationHandler {

    //定义目标（SomeServiceImpl1）类的对象
    //在创建MyInvocationHandler实现类的对象时，目标类的对象引用作为构造方法的参数赋值给target
    private Object target;

    //目标类对象赋值给引用类型target
    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    //先创建了handler对象
    //随后在创建代理对象时，也创建了一个Method类的method对象，该对象包含目标类实现的接口的要执行的方法名
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行了invoke方法 " + method );
        //通过代理对象执行方法时，会调用执行invoke实现方法
        String methodName = method.getName();

        Object res = null;

        if ("doSome".equals(methodName)){
            ServiceTools.doLog();
            //执行目标类的方法，通过Method类实现,target就是目标对象
            //需要一个target目标对象参数，因为代理对象创建时并没有直接传入目标对象的引用
            //只是确定了目标类是哪个(接口的哪一个实现类)
            //args是目标对象方法（doSome、doOther）的参数

            //Method类的invoke方法需要target这个参数来确定要执行的是目标类实现的接口下面哪一个实现类（即目标类）的方法(X)

            //也可能只是需要该目标类对象作为引用数据类型参数，以获取对象内部的属性等要素(√)
            //需要知道是这个目标类new出来的哪一个对象
            //而Proxy.newProxyInstance通过类加载器参数(反射机制)就知道对应的是哪个实现类(目标类/接口的哪一个实现类)了
            //*显然后者更加靠谱，target只是确定了是目标类的哪一个对象,因为目标类可能new了不止一个对象出来
            //创建handler对象时，invoke方法中的target参数就已确定，随后将handler对象作为参数传入新创建的代理对象
            res = method.invoke(target,args);
            ServiceTools.doTrans();
        }else {
            res = method.invoke(target,args);
        }

        //返回目标方法执行结果
        return res;
    }
}
