package com.example.springbootpattern.template;

/**
 * @author CREATED BY L.C.Y on 2019-3-7
 */
public class IosPM extends AbstractPM {
    /**
     * 需求分析
     */
    @Override
    protected void analyze() {
        System.out.println("IOS需求分析");
    }

    /**
     * 设计
     */
    @Override
    protected void design() {
        System.out.println("IOS功能设计");

    }

    /**
     * 开发
     */
    @Override
    protected void develop() {
        System.out.println("IOS功能开发");
    }

    /**
     * 测试
     */
    @Override
    protected void test() {
        System.out.println("IOS功能测试");
    }

    /**
     * 发布
     */
    @Override
    protected void release() {
        System.out.println("IOS版本发布");
    }
}
