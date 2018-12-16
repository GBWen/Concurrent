package com.gbw.concurrent.singleton;

import com.gbw.concurrent.annotation.NotThreadSafe;

/**
 * 懒汉 同步锁双层检测机制
 * 类使用的时候创建
 */
@NotThreadSafe
public class LanhanPlus2 {
    // 私有构造函数
    private LanhanPlus2() {
    }

    // 单例对象
    public static LanhanPlus2 instance = null;

    // 静态工厂方法
    public static LanhanPlus2 getInstance() {
        if (instance == null) {  // B
            synchronized (LanhanPlus2.class) {
                if (instance == null) {
                    instance = new LanhanPlus2(); // A - 3
                }
            }
        }
        return instance;
    }

    // 1. memory = allocate() 分配内存空间
    // 2. ctorInstance() 初始化对象
    // 3. instance = memory 设置instance指向刚分配的内存
    // JVM和cpu优化 发生指令重排
    // 132的顺序的话，再看上面，A到了3，B发现不是null 但是还没初始化对象
}
