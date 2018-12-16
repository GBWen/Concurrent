package com.gbw.concurrent.singleton;

import com.gbw.concurrent.annotation.ThreadSafe;

/**
 * 懒汉 同步锁双层检测机制 + volatile
 * 类使用的时候创建
 */
@ThreadSafe
public class LanhanPlus2_Plus {
    // 私有构造函数
    private LanhanPlus2_Plus() {
    }

    // 单例对象
    // volatile 解决指令重排的问题
    public volatile static LanhanPlus2_Plus instance = null;

    // 静态工厂方法
    public static LanhanPlus2_Plus getInstance() {
        if (instance == null) {
            synchronized (LanhanPlus2_Plus.class) {
                if (instance == null) {
                    instance = new LanhanPlus2_Plus();
                }
            }
        }
        return instance;
    }
}
