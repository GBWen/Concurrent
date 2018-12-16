package com.gbw.concurrent.singleton;

import com.gbw.concurrent.annotation.NotThreadSafe;

/**
 * 懒汉
 * 类使用的时候创建
 */
@NotThreadSafe
public class Lanhan {
    // 私有构造函数
    private Lanhan() {
    }

    // 单例对象
    public static Lanhan instance = null;

    // 静态工厂方法
    public static Lanhan getInstance() {
        if (instance == null) {
            instance = new Lanhan();
        }
        return instance;
    }
}
