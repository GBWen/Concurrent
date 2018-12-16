package com.gbw.concurrent.singleton;

import com.gbw.concurrent.annotation.ThreadSafe;

/**
 * 饿汉
 * 类装载的时候创建
 */
@ThreadSafe
public class Ehan {
    // 私有构造函数
    private Ehan() {
    }

    // 单例对象
    public static Ehan instance = new Ehan();

    // 静态工厂方法
    public static Ehan getInstance() {
        return instance;
    }
}
