package com.yluo.singleton.Serializable;
import java.io.Serializable;

/**
 * 测试用例：单例之饿汉式
 */
public class SeriableSingletonAntiSeriable implements Serializable {

    private SeriableSingletonAntiSeriable(){}

    private static final SeriableSingletonAntiSeriable hungry;
    static {
        hungry = new SeriableSingletonAntiSeriable();
    }
    public static SeriableSingletonAntiSeriable getInstance() {
        return hungry;
    }

    //添加方法，可以防序列化破坏单例
    private Object readResolve(){
        return hungry;
    }

}
