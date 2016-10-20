package com.sven.exercise;

/**
 * 结构模式：代理模式
 * Created by sven on 2016/10/19.
 */
//proxy
class ProxyObject implements Object{
    Object obj;
    public ProxyObject(){
        System.out.println("this is proxy class");
        obj = new ObjectImpl();
    }
    public void action(){
        System.out.println("proxy start");
        obj.action();
        System.out.println("proxy end");
    }

}

interface Object{
    public void action();
}

class ObjectImpl implements Object{
    @Override
    public void action() {
        System.out.println("======");
        System.out.println("======");
        System.out.println("this is  proxyed class");
        System.out.println("======");
        System.out.println("======");
    }
}
public class ProxyMode {
    public static void main(String[] args){
        Object obj = new ProxyObject();
        obj.action();
    }
}
