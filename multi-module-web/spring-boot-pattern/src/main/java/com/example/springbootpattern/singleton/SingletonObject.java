package com.example.springbootpattern.singleton;

/**
 * @author CREATED BY L.C.Y on 2019-2-18
 */
public class SingletonObject {
    //让构造函数为 private，这样该类就不会被实例化
    private SingletonObject() {}

    //创建 SingleObject 的一个对象
    private static SingletonObject instance = new SingletonObject();

    //获取唯一可用的对象
    public static SingletonObject getInstance() {
        return instance;
    }

    public void showMessage() {
        System.out.println("Singleton : Hello World");
    }
}
