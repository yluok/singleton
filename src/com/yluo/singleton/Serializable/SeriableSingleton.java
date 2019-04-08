package com.yluo.singleton.Serializable;
import java.io.Serializable;

/**
 * 测试用例：单例之饿汉式
 */
public class SeriableSingleton implements Serializable {

    private SeriableSingleton(){}

    private static final SeriableSingleton hungry;
    static {
        hungry = new SeriableSingleton();
    }
    public static SeriableSingleton getInstance() {
        return hungry;
    }
}
