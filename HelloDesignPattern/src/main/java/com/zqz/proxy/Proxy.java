package com.zqz.proxy;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 * @created 2020-04-04 20:59
 * @changeRecord
 */
public class Proxy extends Subject {

    RealSubject realSubject;

    @Override
    public void request() {
        if(realSubject == null){
            realSubject = new RealSubject();
        }
        realSubject.request();
    }
}
