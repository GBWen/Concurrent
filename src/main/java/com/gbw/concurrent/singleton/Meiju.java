package com.gbw.concurrent.singleton;

import com.gbw.concurrent.annotation.Recommend;
import com.gbw.concurrent.annotation.ThreadSafe;

/**
 * 枚举模式，最安全
 */
@ThreadSafe
@Recommend
public class Meiju {
    private Meiju() {
    }

    public static Meiju getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;

        private Meiju singleton;

        // JVM保证这个方法绝对只调用一次
        Singleton() {
            singleton = new Meiju();
        }

        public Meiju getInstance() {
            return singleton;
        }
    }
}
