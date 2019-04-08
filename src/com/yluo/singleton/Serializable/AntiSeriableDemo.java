package com.yluo.singleton.Serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 防序列化破坏单例demo
 * 测试结果为：
 原始单例为：com.yluo.singleton.Serializable.SeriableSingletonAntiSeriable@4554617c
 通过序列化后是：com.yluo.singleton.Serializable.SeriableSingletonAntiSeriable@4554617c
 * 表明：readResolve方法是可以预防序列化破坏单例的
 */
public class AntiSeriableDemo {
    public static void main(String[] args) {
        //获取一个实例对象
        SeriableSingletonAntiSeriable s1 = SeriableSingletonAntiSeriable.getInstance();
        System.out.println("原始单例为：" + s1);
        try{
            //将实例对象s1写入文件SeriableSingleton.obj中----序列化
            FileOutputStream fos = new FileOutputStream("SeriableSingletonAntiSeriable.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s1);
            oos.close();
            fos.close();
            //从文件中读取该对象内容出来，重新组建成对象-----反序列化
            FileInputStream fis = new FileInputStream("SeriableSingletonAntiSeriable.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            SeriableSingletonAntiSeriable s2 = (SeriableSingletonAntiSeriable)ois.readObject();
            ois.close();
            fis.close();
            System.out.println("通过序列化后是：" + s2);
        }catch(Exception exception) {
        }
    }
}
