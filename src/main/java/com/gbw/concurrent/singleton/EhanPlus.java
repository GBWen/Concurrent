package com.gbw.concurrent.singleton;

import com.gbw.concurrent.annotation.ThreadSafe;

/**
 * 饿汉
 * 类装载的时候创建
 */
@ThreadSafe
public class EhanPlus {
    // 私有构造函数
    private EhanPlus() {
    }

    // 单例对象
    public static EhanPlus instance = null;

    // 静态代码块要放在静态域后面！不然instance是null了
    static {
        instance = new EhanPlus();
    }

    // 静态工厂方法
    public static EhanPlus getInstance() {
        return instance;
    }
}
