package com.example.springbootpattern.singleton;

/**
 * 2、懒汉式，线程安全 === 不建议使用（加锁影响效率）
 * 是否 Lazy 初始化：是
 * 是否多线程安全：是
 * 实现难度：易
 * 描述：这种方式具备很好的 lazy loading，能够在多线程中很好的工作，但是，效率很低，99% 情况下不需要同步。
 * 优点：第一次调用才初始化，避免内存浪费。
 * 缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率。
 * getInstance() 的性能对应用程序不是很关键（该方法使用不太频繁）。
 * @author CREATED BY L.C.Y on 2019-2-18
 */
public class Singleton2 {
    private Singleton2() {}

    private static Singleton2 instance;

    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }

        return instance;
    }

    public void showMessage() {
        System.out.println("2、懒汉式，线程安全 === 不建议使用");
    }
}
