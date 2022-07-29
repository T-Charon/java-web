package com.blb.thread02;

/**
 * @Author Charon
 * @Date 2022/7/28
 **/

/**
 * 懒汉式单例（懒汉式更加节约内存）
 */
public class LazySingleton {
    //2.定义静态的实例
    private static volatile LazySingleton instance = null;

    //1.构造方法私有化
   private LazySingleton(){
       System.out.println("创建实例");
       try {
           Thread.sleep(10);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
   };

    //3.静态方法返回实例
   public static LazySingleton getInstance(){
       //双检锁
       if(instance == null){
           synchronized (LazySingleton.class){
               if(instance == null){
                   instance = new LazySingleton();
               }
           }
       }

       return instance;
   };
//    public static LazySingleton getInstance(){
//        if(instance == null){
//            instance = new LazySingleton();
//        }
//        return instance;
//    };
}
