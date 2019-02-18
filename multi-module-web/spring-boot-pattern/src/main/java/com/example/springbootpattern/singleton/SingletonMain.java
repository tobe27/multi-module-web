package com.example.springbootpattern.singleton;

/**
 * 创建型模式-单例模式
 * 注意：
 * 1、单例类只能有一个实例。
 * 2、单例类必须自己创建自己的唯一实例。
 * 3、单例类必须给所有其他对象提供这一实例。
 *
 * 介绍：
 * 意图：保证一个类仅有一个实例，并提供一个访问它的全局访问点。
 * 主要解决：一个全局使用的类频繁地创建与销毁。
 * 何时使用：当您想控制实例数目，节省系统资源的时候。
 * 如何解决：判断系统是否已经有这个单例，如果有则返回，如果没有则创建。
 * 关键代码：构造函数是私有的。
 *
 * @author CREATED BY L.C.Y on 2019-2-18
 */
public class SingletonMain {
    public static void main(String[] args) {
        //不合法的构造函数
        //编译时错误：构造函数 SingleObject() 是不可见的
        //SingletonObject object = new SingletonObject();

        //获取唯一可用的对象
        SingletonObject instance = SingletonObject.getInstance();
        instance.showMessage();

        // m枚举方式
        Singleton6 singleton6 = Singleton6.INSTANCE;
        singleton6.showMessage();
    }
}
