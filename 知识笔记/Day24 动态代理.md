# Day 24 动态代理
1. Spring原理
```java
public class ProxyFactoryBean {
    private Object mTarget;
    private Advice mAdvice;

    //* 新建委托类
    //* 实现InvocationHandler接口，这是负责连接代理类和委托类的中间类必须实现的接口
    //* 通过Proxy类新建代理类对象。
    public Object getProxy(){
        Object proxy = Proxy.newProxyInstance(
                mTarget.getClass().getClassLoader(),
                mTarget.getClass().getInterfaces(),
                mHandler
        );
        return proxy;
    }

    private InvocationHandler mHandler = new InvocationHandler() {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            mAdvice.beforeMethod(method);
            Object result = method.invoke(mTarget, args);
            mAdvice.afterMethod(method);
            return result;
        }
    };

    public void setTarget(Object target) {
        mTarget = target;
    }

    public void setAdvice(Advice advice) {
        mAdvice = advice;
    }

    public Object getTarget() {
        return mTarget;
    }

    public Advice getAdvice() {
        return mAdvice;
    }
}

public class BeanFactory {
    Properties mProperties = new Properties();
    public BeanFactory(InputStream in){
        try {
            mProperties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object getBean(String name){
        String classname = mProperties.getProperty(name);
        Object bean = null;
        try {
            Class clazz = Class.forName(classname);
            bean = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (bean instanceof ProxyFactoryBean){
            Object proxy = null;
            ProxyFactoryBean factoryBean = (ProxyFactoryBean) bean;
            Advice advice = null;
            try {
                advice = (Advice) Class.forName(mProperties.getProperty(name+".advice")).newInstance();
                Object target = Class.forName(mProperties.getProperty(name+".target")).newInstance();
                factoryBean.setAdvice(advice);
                factoryBean.setTarget(target);
                proxy = factoryBean.getProxy();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return proxy;
        }
        return bean;
    }
}
```
```java
public interface Advice {
    void beforeMethod(Method method);
    void afterMethod(Method method);
}
```
```java
public class AopFrameworkTest {
    public static void main(String[] args) throws Exception {
        InputStream ips = AopFrameworkTest.class.getResourceAsStream("config.properties");
        Object bean = new BeanFactory(ips).getBean("xxx");
        System.out.println(bean.getClass().getName());
        ((Collection)bean).clear();
    }
}
```

2. 应用场景
Java 提供了动态代理的实现方式，可以在运行时刻动态生成代理类。这种代理方式的一大好处是可以方便对代理类的函数做统一或特殊处理，如记录所有函数执行时间、所有函数执行前添加验证判断、对某个特殊函数进行特殊操作，而不用像静态代理方式那样需要修改每个函数。
```
InvocationHandler接口中invoke()方法的三个参数：
* Object proxy：代表动态代理对象
* Method method：代表正在执行的方法
* Object[] args：代表调用目标方法时传入的实参
```
![](Day%2024%20%E5%8A%A8%E6%80%81%E4%BB%A3%E7%90%86/20161022121714416.png)


3. 线程池
* 线程池的原理
* 几种线程池的创建方法
* 线程池的优化

#code/Java