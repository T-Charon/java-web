package com.blb.thread02;

/**
 * @Author Charon
 * @Date 2022/7/28
 **/

/**
 * 饿汉式单例(代码更加简洁)
 */
public class HungrySingleton {
    //2.定义静态的实例
    private static HungrySingleton instance = new HungrySingleton();
    //1.构造方法私有化
    private HungrySingleton(){
        System.out.println("创建对象");
    };

    //3.静态方法返回实例
    public static HungrySingleton getInstance(){
        return instance;
    };
}
