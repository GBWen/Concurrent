package com.gbw.concurrent.singleton;

import com.gbw.concurrent.annotation.ThreadSafe;

/**
 * 懒汉synchronized
 * 类使用的时候创建
 */
@ThreadSafe
public class LanhanPlus1 {
    // 私有构造函数
    private LanhanPlus1() {
    }

    // 单例对象
    public static LanhanPlus1 instance = null;

    // 静态工厂方法
    public static synchronized LanhanPlus1 getInstance() {
        if (instance == null) {
            instance = new LanhanPlus1();
        }
        return instance;
    }
}
